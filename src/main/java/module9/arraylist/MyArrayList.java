package module9.arraylist;

import java.util.Arrays;

@SuppressWarnings("unchecked")
public class MyArrayList<T> {

    /*
     * An ArrayList implementation
     * add(Object value) - add element to the end
     * clear() - clear collection
     * size() - return size of collection
     * remove(int index) - delete element per specified index
     * get(int index) -  return element per specified index
     */

    private static final int DEFAULT_CAPACITY = 0;
    private T[] values;
    private final int size;

    public MyArrayList() {
        this(DEFAULT_CAPACITY);
    }

    public MyArrayList(int capacity) {
        values = (T[]) new Object[capacity];
        size = 0;
    }

    public void add(T value) {
        values = Arrays.copyOf(values, values.length + 1);
        values[values.length - 1] = value;
    }

    public void remove(int index) {
        if (values.length - 1 - index >= 0)
            System.arraycopy(values, index + 1, values, index,
                    values.length - 1 - index);
        values = Arrays.copyOf(values, values.length - 1);
    }

    public void clear() {
        values = Arrays.copyOf(values, 0);
    }

    public int size() {
        return values.length;
    }

    public T get(int index) {
        return values[index];
    }

    @Override
    public String toString() {
        return Arrays.toString(values);
    }

}
