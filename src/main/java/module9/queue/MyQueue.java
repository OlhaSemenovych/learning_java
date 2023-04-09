package module9.queue;

public class MyQueue<T> implements Queue<T> {

    /*
    * A Queue implementation with single node - FIFO (first-in-first-out)
    * add(Object value) - add element to the end
    * clear() - clear collection
    * size() - return size of collection
    * peek() - return first element in queue
    * poll() - return first element in queue and delete it from collection
    */

    private static class Node<T> {

        private T element;
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

    private Node<T> begin;
    private Node<T> end;
    private int size;

    public void add(T element) {
        Node<T> newNode = Node.valueOf(element);
        if (begin == null) {
            begin = end = newNode;
        } else {
            end.next = newNode;
            end = newNode;
        }
        size++;
    }

    public void clear() {
        begin = end = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public T peek() {
        T element;
        if (begin != null) {
            element = begin.element;
        } else {
            return null;
        }
        return element;
    }

    public T poll() {
        T element;
        if (begin != null) {
            element = begin.element;
            begin = begin.next;
            if (begin == null) {
                end = null;
            }
            size--;
            return element;
        } else {
            return null;
        }
    }

    @Override
    public String toString() {
        StringBuilder listBuilder = new StringBuilder();
        Node currentNode = begin;
        while (currentNode != null) {
            listBuilder.append(currentNode).append(" ");
            currentNode = currentNode.next;
        }
        return listBuilder.toString();
    }

}
