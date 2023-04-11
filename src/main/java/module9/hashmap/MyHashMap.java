package module9.hashmap;

import java.util.Arrays;

import static java.util.Objects.requireNonNull;

public class MyHashMap<K, V> implements Map<K, V> {

    /*
     * A HashMap implementation
     * put(Object key, Object value) - add pair key + value
     * remove(Object key) - delete pair key + value
     * clear() - clear collection
     *
     * size() - return size of collection
     * get(Object key) - return value (Object value) by key
     */

    public static class Node<K, V> {
        K key;
        V value;
        Node<K, V> next;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private static final int DEFAULT_INITIAL_CAPACITY = 16;
    private static final float SIZE_THRESHOLD = 1.0f;
    private Node<K, V>[] map;
    private int size;

    public MyHashMap(int defaultCapacity) {
        if (defaultCapacity >= 0) {
            this.map = new Node[defaultCapacity];
        } else {
            throw new IllegalArgumentException("Capacity must be positive");
        }
    }

    public MyHashMap() {
        this(DEFAULT_INITIAL_CAPACITY);
    }

    public static int calculateIndex(Object key, int mapCapacity) {
        var hash = key.hashCode() ^ (key.hashCode() >> 16);
        return hash & (mapCapacity - 1);
    }

    public void put(K key, V value) {
        changeMapSize();
        putOnMap(map, key, value);
    }

    private void changeMapSize() {
        if (size / (float) map.length > SIZE_THRESHOLD) {
            resizeMap(2 * map.length);
        }
    }

    private void putOnMap(Node<K, V>[] map, K key, V value) {
        var newNode = new Node<>(requireNonNull(key), requireNonNull(value));
        var index = calculateIndex(key, map.length);
        if (map[index] == null) {
            map[index] = newNode;
        } else {
            var current = map[index];
            while (current.next != null) {
                if (current.key.equals(key)) {
                    current.value = value;
                }
                current = current.next;
            }
            current.value = value;
        }
        size++;
    }

    public V get(K key) {
        var index = calculateIndex(requireNonNull(key), map.length);
        var current = map[index];
        while (current != null) {
            if (current.key.equals(key)) {
                return current.value;
            }
            current = current.next;
        }
        return null;
    }

    public int size() {
        return size;
    }

    public void clear() {
        if (map != null && size > 0) {
            size = 0;
            Arrays.fill(map, null);
        }
    }

    public void remove(K key) {
        var index = calculateIndex(requireNonNull(key), map.length);
        var current = map[index];
        if (current != null) {
            if (current.key.equals(key)) {
                map[index] = current.next;
                size--;
            }
            while (current.next != null) {
                if (current.next.key.equals(key)) {
                    current.next = current.next.next;
                    size--;
                }
                current = current.next;
            }
        }
    }

    @Override
    public String toString() {
        var stringBuilder = new StringBuilder();
        var n = map.length;
        for (int i = 0; i < n; i++) {
            var current = map[i];
            if (current != null) {
                stringBuilder.append(current.key).append("=").append(current.value).append(" ");
            }
        }
        return stringBuilder.toString();
    }

    public void resizeMap(int newCapacity) {
        if (newCapacity >= 0) {
            Node<K, V>[] newMap = new Node[newCapacity];
            for (var head : map) {
                var current = head;
                while (current != null) {
                    putOnMap(newMap, current.key, current.value);
                    current = current.next;
                }
            }
            map = newMap;
        } else {
            throw new IllegalArgumentException("Capacity must be positive");
        }
    }

}
