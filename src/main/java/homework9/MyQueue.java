package homework9;

public class MyQueue<E>{
    private Node<E> head, tail;
    private int size;

    class Node<E>{
        E item;
        Node<E> next;

        public Node(E value, Node<E> next) {
            this.item = value;
            this.next = next;
        }
    }

    public MyQueue(){
    }

    public void add(E element) {
        if (element == null) {
            throw new NullPointerException();
        }
        if (head == null) {
            Node<E> newNode = new Node<>(element, null);
            head = tail = newNode;
            size++;
        }
        else {
            Node<E> oldTail = tail;
            Node<E> newNode = new Node<>(element, null);
            tail = newNode;
            if (oldTail == null) {
                head = newNode;
            }
            else {
                oldTail.next = newNode;
            }
            size++;
        }
    }

    public boolean remove(E e) {
        Node<E> current = head;
        if (current.item.equals(e)){
            head = head.next;
            size--;
            return true;
        }

        while (current.next != null){
            if (current.next.item.equals(e)) {
                current.next = current.next.next;
                size--;
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public void clear(){
        head = tail = null;
        size = 0;
    }

    public int size(){
        return size;
    }

    public E peek(){
        return head.item;
    }

    public E poll(){
        if (head == null){
            return null;
        }
        Node<E> headNode = head;
        Node<E> tailNode = tail;
        E frontToRemoveValue = head.item;

        head = head.next;
        size--;
        if (headNode == tailNode){
            tail = null;
        }
        return frontToRemoveValue;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        if (head == null) {
            return "Queue is empty";
        }
        else {
            Node<E> temp = head;
            while (temp != null){
                stringBuilder.append(temp.item + " ");
                temp = temp.next;
            }
            return "[" + stringBuilder.toString().trim().replace(" ", ", ") + "]";
        }
    }

}
