package rise.cocricotlite.asm;

import net.minecraft.launchwrapper.IClassTransformer;
import net.minecraftforge.fml.common.asm.transformers.deobf.FMLDeobfuscatingRemapper;
import org.objectweb.asm.*;

public class MaxMetadataTransformer implements IClassTransformer, Opcodes {

    private static final String TARGET_CLASS_NAME = "net.minecraftforge.registries.GameData";

    @Override
    public byte[] transform(String name, String transformedName, byte[] basicClass)
    {
        if(!transformedName.equals(TARGET_CLASS_NAME))
        {
            return basicClass;
        }

        try
        {
            CorePlugin.logger.info("Start transforming GameData Class. :: " + TARGET_CLASS_NAME);
            ClassReader classReader = new ClassReader(basicClass);
            ClassWriter classWriter = new ClassWriter(1);
            classReader.accept(new CustomVisitor(name, classWriter), 8);
            return classWriter.toByteArray();
        }
        catch (Exception e)
        {
            throw new RuntimeException("Failed to loading MaxMetadataTransformer.", e);
        }
    }

    class CustomVisitor extends ClassVisitor {
        String owner;

        CustomVisitor(String owner, ClassVisitor cv)
        {
            super(Opcodes.ASM4, cv);
            this.owner = owner;
        }

        final String TARGET_METHOD_NAME = unmapClassName("onAdd");

        @Override
        public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions)
        {
            // onUpdateメソッドの書き換え
            if (TARGET_METHOD_NAME.equals(FMLDeobfuscatingRemapper.INSTANCE.mapMethodName(owner, name, desc)))
            {
                CorePlugin.logger.info("Transforming onAdd method");
                return new CustomMethodVisitor(this.api, super.visitMethod(access, name, desc, signature, exceptions));
            }
            return super.visitMethod(access, name, desc, signature, exceptions);
        }
    }

    private static String unmapClassName(String name)
    {
        return FMLDeobfuscatingRemapper.INSTANCE.unmap(name.replace('.','/')).replace('/', '.');
    }

    class CustomMethodVisitor extends MethodVisitor
    {
        CustomMethodVisitor(int api, MethodVisitor methodVisitor)
        {
            super(api, methodVisitor);
        }

        boolean check = false;

        public void visitFieldInsn(int opcode, String owner, String name, String desc)
        {
            if(opcode == GETFIELD && desc.equals("I") && !check)
            {
                check = true;
                CorePlugin.logger.info("onAdd method changed. meta in [0 - 63]");
                super.visitVarInsn(ALOAD, 0);

                super.visitVarInsn(ALOAD, 0);
                // この２つはペア
                super.visitVarInsn(ALOAD, 0);
                super.visitFieldInsn(GETFIELD, TARGET_CLASS_NAME, unmapClassName("onAdd"), "I");
                // ここで、スタックに数字が１つスタックされる。
                // 256をスタック
                super.visitIntInsn(SIPUSH, 64);
                // スタックされた２つの数字を加算する
                super.visitInsn(IADD);
                // 加算された数字がスタックされる。
                // もう一度256をスタック
                super.visitIntInsn(SIPUSH, 64);
                // スタックされている２つの数字のうち、あとの数字で最初の数字の剰余をとる
                super.visitInsn(IREM);
                // 剰余がスタックされる。
                // スタックされた数字をフィールドに代入する
                super.visitFieldInsn(PUTFIELD, TARGET_CLASS_NAME, unmapClassName("onAdd"), "I");
            }
        }
    }
}
