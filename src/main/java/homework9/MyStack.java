package homework9;

import java.util.EmptyStackException;

public class MyStack<E> {
    private Node<E> top;
    private int size;
    private class Node<E> {
        E value;
        Node<E> link;
    }

    MyStack() {
    }

    // Pushes an item onto the top of this stack.
    public void push(E value)  {
        Node<E> newNode = new Node<E>();
        newNode.value = value;
        newNode.link = top;
        top = newNode;
        size++;
    }

    // Looks at the object at the top of this stack
    // without removing it from the stack.
    public E peek(){
        if(top == null){
            throw new EmptyStackException();
        }
        return top.value;
    }

    // Removes the object at the top of this stack and
    // returns that object as the value of this function.
    public E pop(){
        if(top == null){
            throw new EmptyStackException();
        }
        E topValue = this.peek();
        top = top.link;
        size--;
        return topValue;
    }

    // Removes all the elements from this stack.
    public void clear()  {
        Node<E> current = top;
        while (current != null) {
            Node<E> next = current.link;
            current.value = null;
            current.link = null;
            current = next;
        }

        top = null;
        size = 0;
    }

    // Returns the number of elements in this stack.
    public int size(){
        return size;
    }

    // Removes the element at the specified position in this stack.
    public E remove(int index) {
        if (index < 0 | index >= size){
            throw new IndexOutOfBoundsException();
        }
        if (top == null){
            System.out.println("Stack is empty");
        }
        else {
            if (index == (size-1)){
                E toRemove = top.value;
                this.pop();
                return toRemove;
            }
            Node<E> current = top;
            int k = size-1;
            while (current.link != null){
                if ((k-1) == index) {
                    E toRemove = current.link.value;
                    current.link = current.link.link;
                    size--;
                    return toRemove;
                }
                k--;
                current = current.link;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        if (top == null) {
            return "Stack is empty";
        }
        else {
            Node<E> temp = top;
            while (temp != null){
                stringBuilder.append(temp.value + "->");
                temp = temp.link;
            }
            return stringBuilder.toString();
        }
    }

}
