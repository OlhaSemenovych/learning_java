package module9.linkedlist;

public interface LinkedList<T> {

    void add(T element);

    void remove(int index);

    void clear();

    int size();

    T get(int index);

}
