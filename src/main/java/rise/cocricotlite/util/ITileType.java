package rise.cocricotlite.util;

public interface ITileType<T extends Comparable<T>, V extends T> {

    V getType();

    void setType(V type);

}
