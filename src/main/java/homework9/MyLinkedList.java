package homework9;

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

    // Appends the specified element to the end of this list.
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

    // Search node in the list by its index.
    public Node<E> searchNode(int index) {
        if (index >= size | index < 0){
            throw new IndexOutOfBoundsException("Node with this index is not present in the list");
        }
        Node<E> currentNode = first;
        int k = 0;
        while (k < index){
            currentNode = currentNode.next;
            k++;
        }
        System.out.println("index = " + index + "; item = " + currentNode.item);
        return currentNode;

    }

    //Removes the element at the specified position in this list.
    // Shifts any subsequent elements to the left (subtracts one from their indices).
    // Returns the element that was removed from the list.
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

    // Returns the element at the specified position in this list.
    public E get(int index) {
        return searchNode(index).item;
    }

    //Removes all the elements from this list.
    public void clear(){
        Node<E> current = first;
        while (current != null) {
            Node<E> next = current.next;
            current.item = null;
            current.prev = null;
            current.next = null;
            current = next;
        }

        first = last = null;
        size = 0;
    }

    // Returns the number of elements in this list.
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
