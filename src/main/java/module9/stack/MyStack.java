package module9.stack;

import java.util.Objects;

public class MyStack<T> implements Stack<T> {

    /*
     * A Queue implementation with single node - LIFO (last-in-first-out)
     * push(Object value) - add element to the end
     * remove(int index) - delete element per specified index
     * clear() - clear collection
     * size() - return size of collection
     * peek() - return first element in stack
     * pop()  - return first element in stack and  delete it from collection
     */

    private static class Node<T> {

        private final T element;
        private Node<T> next;

        static <T> Node<T> valueOf(T element) {
            return new Node<>(element);
        }

        public Node(T element) {
            this.element = element;
        }

        @Override
        public String toString() {
            return element.toString();
        }
    }

    private Node<T> top;
    private int size;

    public void push(T element) {
        Objects.requireNonNull(element);
        Node<T> newNode = Node.valueOf(element);
        if (top != null) {
            newNode.next = top;
        }
        top = newNode;
        size++;
    }

    public void remove(int index) {
        Objects.checkIndex(index, size);
        int revertedIndex = size - index - 1;
        Objects.checkIndex(revertedIndex, size);
        if (revertedIndex == 0) {
            top = top.next;
        } else {
            Node<T> prev = getNodeByIndex(revertedIndex - 1);
            prev.next = prev.next.next;
        }
        size--;
    }

    public void clear() {
        top = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public T peek() {
        T element;
        if (top != null) {
            element = top.element;
        } else {
            return null;
        }
        return element;
    }

    public T pop() {
        if (top != null) {
            size--;
            T element = top.element;
            this.top = top.next;
            return element;
        } else {
            return null;
        }
    }

    //additional auxiliary method
    private Node<T> getNodeByIndex(int index) {
        Node<T> current = top;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    @Override
    public String toString() {
        StringBuilder listBuilder = new StringBuilder();
        Node currentNode = top;
        while (currentNode != null) {
            listBuilder.append(currentNode).append(" ");
            currentNode = currentNode.next;
        }
        return listBuilder.toString();
    }

}
