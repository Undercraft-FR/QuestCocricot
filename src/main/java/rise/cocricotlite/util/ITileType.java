package rise.cocricotlite.util;

public interface ITileType<T extends Comparable<T>> {

    T getType();

    void setType(T type);

}
