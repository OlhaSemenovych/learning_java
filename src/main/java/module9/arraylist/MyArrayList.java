package module9.arraylist;

import java.util.Arrays;

public class MyArrayList {

    /*
     * A ArrayList implementation with single node
     * add(Object value) - add element to the end
     * clear() - clear collection
     * size() - return size of collection
     * remove(int index) - delete element per specified index
     * get(int index) -  return element per specified index
     */

    private Object[] values = new Object[]{};

    public void add(Object value) {
        values = Arrays.copyOf(values, values.length + 1);
        values[values.length - 1] = value;
    }

    public void remove(int index) {
        for (int i = index; i < values.length - 1; i++) {
            values[i] = values[i + 1];
        }
        values = Arrays.copyOf(values, values.length - 1);
    }

    public void clear() {
        values = Arrays.copyOf(values, 0);
    }

    public int size() {
        return values.length;
    }

    public Object get(int index) {
        return values[index];
    }

    @Override
    public String toString() {
        return Arrays.toString(values);
    }

}
