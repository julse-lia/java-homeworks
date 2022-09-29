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

    public void push(E value)  {
        Node<E> newNode = new Node<E>();
        newNode.value = value;
        newNode.link = top;
        top = newNode;
        size++;
    }

    public E peek(){
        if(top == null){
            throw new EmptyStackException();
        }
        return top.value;
    }

    public E pop(){
        if(top == null){
            throw new EmptyStackException();
        }
        E topValue = this.peek();
        top = top.link;
        size--;
        return topValue;
    }

    public void clear()  {
        top = null;
        size = 0;
    }

    public int size(){
        return size;
    }

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
