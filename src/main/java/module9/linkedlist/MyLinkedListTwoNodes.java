package module9.linkedlist;

import java.util.Objects;

public class MyLinkedListTwoNodes<T> implements LinkedList<T> {

    /*
     * A LinkedList implementation with two nodes
     * add(Object value) - add element to the end
     * clear() - clear collection
     * size() - return size of collection
     * remove(int index) - delete element per specified index
     * get(int index) -  return element per specified index
     */

    private static class Node<T> {

        private T element;
        private Node<T> next;
        private Node<T> prev;

        public Node(T element) {
            this.element = element;
        }

        @Override
        public String toString() {
            return element.toString();
        }
    }

    private Node<T> first;
    private Node<T> last;
    private int size;

    public void add(T element) {
        Node<T> newNode = new Node<>(element);
        if (size == 0) {
            first = last = newNode;
        } else {
            last.prev = last.next = newNode;
            last = newNode;
        }
        size++;
    }

    public void remove(int index) {
        Objects.checkIndex(index, size);
        if (index == 0) {
            first = first.next = first.prev;
            if (first == null) {
                last = null;
            }
        } else {
            Node<T> prev = getNodeByIndex(index - 1);
            prev.next = prev.next.next = prev.prev;
            if (index == size - 1) {
                last = prev;
            }
        }
        size--;
    }

    public void clear() {
        first = last = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public T get(int index) {
        Objects.checkIndex(index, size);
        return getNodeByIndex(index).element;
    }

    //additional auxiliary method
    private Node<T> getNodeByIndex(int index) {
        Node<T> current = first;
        for (int i = 0; i < index; i++) {
            current = current.next = current.prev;
        }
        return current;
    }


    @Override
    public String toString() {
        StringBuilder listBuilder = new StringBuilder();
        Node currentNode = first;
        while (currentNode != null) {
            listBuilder.append(currentNode).append(" ");
            currentNode = currentNode.next = currentNode.prev;
        }
        return listBuilder.toString();
    }

}
