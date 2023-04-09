package module9.stack;

public interface Stack<T> {

    void push(T element);

    void remove(int index);

    void clear();

    int size();

    T peek();

    T pop();

}
