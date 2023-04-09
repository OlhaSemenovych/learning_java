package module9.queue;

public interface Queue<T> {

    void add(T element);

    void clear();

    int size();

    T peek();

    T poll();

}
