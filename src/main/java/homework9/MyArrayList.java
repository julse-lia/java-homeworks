package homework9;

import java.util.Arrays;
import java.util.Objects;

public class MyArrayList<E> {
    private static final int DEFAULT_CAPACITY = 10;
    private static final Object[] EMPTY_ELEMENTDATA = {};
    private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};
    transient Object[] elementData;
    private int size = 0;

    // Constructs an empty list with an initial capacity of ten.
    public MyArrayList() {
        this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
    }

    // Constructs an empty list with the specified initial capacity.
    public MyArrayList(int initialCapacity) {

        if (initialCapacity < 0){
            throw new IllegalArgumentException("Illegal Capacity: "+
                    initialCapacity);
        }

        if (initialCapacity == 0) {
            this.elementData = EMPTY_ELEMENTDATA;
        }

        if (initialCapacity > 0) {
            this.elementData = new Object[initialCapacity]; // new object creation
        }
    }

    public boolean add(E e) {
        ensureCapacity(size + 1);
        elementData[size++] = e;
        return true;
    }

    private void ensureCapacity(int minCapacity)
    {
        if (elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA) {
            minCapacity = Math.max(DEFAULT_CAPACITY, minCapacity);
        }

        if (minCapacity - elementData.length > 0) {
            grow(minCapacity);
        }
    }

    private void grow(int minCapacity)
    {
        int oldCapacity = elementData.length;
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        if (newCapacity - minCapacity < 0)
            newCapacity = minCapacity;
        elementData = Arrays.copyOf(elementData, newCapacity);
    }

    public E remove(int index){
        Objects.checkIndex(index, size);
        int numMoved = size - index - 1;
        E elementToRemove = (E) elementData[index];
        System.arraycopy(elementData, index + 1, elementData, index, numMoved);
        elementData[--size] = null;
        return elementToRemove;
    }

    public int size() {
        return size;
    }

    public E get(int index){
        Objects.checkIndex(index, size);
        return (E) elementData[index];
    }

    public void clear() {
        elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
        size = 0;
    }

    @Override
    public String toString() {
        return "MyArrayList{" +
                "array=" + Arrays.toString(elementData) +
                ", size=" + size +
                '}';
    }
}
