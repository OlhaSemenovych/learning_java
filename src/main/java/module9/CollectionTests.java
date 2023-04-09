package module9;

import module9.arraylist.MyArrayList;
import module9.hashmap.MyHashMap;
import module9.linkedlist.MyLinkedListOneNode;
import module9.linkedlist.MyLinkedListTwoNodes;
import module9.queue.MyQueue;
import module9.stack.MyStack;

public class CollectionTests {

    public static void main(String[] args) {

        //ArrayList
        MyArrayList arr = new MyArrayList();
        arr.add("one");
        arr.add(1);
        arr.add("two");
        System.out.println(arr.toString());
        System.out.println(arr.size());
        System.out.println(arr.get(2).toString());
        arr.remove(2);
        arr.remove(1);
        System.out.println(arr);
        arr.add("three");
        arr.clear();
        System.out.println(arr);

        //LinkedList single node
        MyLinkedListOneNode<String> singleNode = new MyLinkedListOneNode<>();
        singleNode.add("one");
        singleNode.add("two");
        singleNode.add("three");
        singleNode.add("four");
        System.out.println(singleNode.toString());
        System.out.println(singleNode.get(1));
        System.out.println(singleNode.size());
        singleNode.remove(2);
        singleNode.add("fifth");
        System.out.println(singleNode.toString());
        singleNode.clear();
        System.out.println("[" + singleNode + "]");

        //LinkedList two nodes
        MyLinkedListTwoNodes<String> twoNodes = new MyLinkedListTwoNodes<>();
        twoNodes.add("one");
        twoNodes.add("two");
        twoNodes.add("three");
        twoNodes.add("four");
        System.out.println(twoNodes.toString());
        System.out.println(twoNodes.get(1));
        System.out.println(twoNodes.size());
        twoNodes.remove(2);
        twoNodes.add("fifth");
        System.out.println(twoNodes.toString());
        twoNodes.clear();
        System.out.println("[" + twoNodes + "]");

        //Queue
        MyQueue<String> q = new MyQueue<>();
        q.add("1");
        q.add("2");
        q.add("3");
        System.out.println(q.toString());
        System.out.println(q.peek());
        System.out.println(q.size());
        System.out.println(q.poll());
        System.out.println(q.toString());
        q.clear();
        System.out.println("[" + q + "]");

        //Stack
        MyStack<String> stack = new MyStack<>();
        stack.push("1");
        stack.push("2");
        stack.push("3");
        stack.push("4");
        System.out.println(stack);
        System.out.println(stack.peek());
        System.out.println(stack.size());
        System.out.println(stack.pop());
        System.out.println(stack.toString());
        stack.remove(2);
        System.out.println(stack);
        stack.clear();
        System.out.println("[" + stack + "]");

        //HashMap
        MyHashMap<String, String> map = new MyHashMap<>();
        map.put("1", "test");
        map.put("2", "test2");
        map.put("3", "test3");
        System.out.println(map.toString());
        map.remove("2");
        System.out.println(map.toString());
        System.out.println(map.size());
        System.out.println(map.get("1"));
        map.clear();
        System.out.println(map.toString());
    }

}
