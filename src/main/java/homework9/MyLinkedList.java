package homework9;

import java.util.Objects;

public class MyLinkedList<E> {
    private Node<E> first;
    private Node<E> last;
    private int size;

    class Node<E>{
        E item;
        Node<E> prev;
        Node<E> next;

        public Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }

    public MyLinkedList(){
    }

    public void add(E element) {
        if (first == null) {
            Node<E> newNode = new Node<>(null, element, null);
            first = last = newNode;
            size++;
        }
        else {
            Node<E> lastNode = last;
            Node<E> newNode = new Node<>(lastNode, element, null);
            last = newNode;
            if (lastNode == null) {
                first = newNode;
            }
            else {
                lastNode.next = newNode;
            }
            size++;
        }
    }

    public Node<E> searchNode(int index) {
        Objects.checkIndex(index, size);
        Node<E> currentNode = first;
        int k = 0;
        while (k < index){
            currentNode = currentNode.next;
            k++;
        }
        System.out.println("index = " + index + "; item = " + currentNode.item);
        return currentNode;

    }

    public E remove(int index) {
        Node<E> toRemove = searchNode(index);
        E element = toRemove.item;
        Node<E> prev = toRemove.prev;
        Node<E> next = toRemove.next;

        if (prev == null) {
            first = next;
        }
        else {
            prev.next = next;
            toRemove.prev = null;
        }

        if (next == null) {
            last = prev;
        }
        else {
            next.prev = prev;
            toRemove.next = null;
        }

        toRemove.item = null;
        size--;
        return element;
    }

    public E get(int index) {
        return searchNode(index).item;
    }

    public void clear(){
        first = last = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        if (first == null) {
            return "LinkedList is empty";
        }
        else {
            Node<E> current = first;
            while (current != null){
                stringBuilder.append(current.item + " ");
                current = current.next;
            }
            return "[" + stringBuilder.toString().trim().replace(" ", ", ") + "]";
        }
    }

}
