package homework9;

import java.util.Arrays;

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
        if (initialCapacity > 0) {
            this.elementData = new Object[initialCapacity]; // new object creation
        } else if (initialCapacity == 0) {
            this.elementData = EMPTY_ELEMENTDATA;
        } else {
            throw new IllegalArgumentException("Illegal Capacity: "+
                    initialCapacity);
        }
    }

    // Appends the specified element to the end of this list.
    public boolean add(E e) {
        ensureCapacity(size + 1);
        elementData[size++] = e;
        return true;
    }

    // Increases the capacity of this ArrayList instance,
    // if necessary, to ensure that it can hold at least the number
    // of elements specified by the minimum capacity argument.
    private void ensureCapacity(int minCapacity)
    {
        if (elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA) {
            minCapacity = Math.max(DEFAULT_CAPACITY, minCapacity);
        }

        // overflow-conscious code
        if (minCapacity - elementData.length > 0) {
            grow(minCapacity);
        }
    }

    // Expands the size of the list.
    private void grow(int minCapacity)
    {
        int oldCapacity = elementData.length;
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        if (newCapacity - minCapacity < 0)
            newCapacity = minCapacity;
        elementData = Arrays.copyOf(elementData, newCapacity);
    }

    // Removes the element at the specified position in this list.
    // Shifts any subsequent elements to the left (subtracts one from their indices).
    public E remove(int index){
        if (index < 0 | index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size " + index);
        }
        int numMoved = size - index - 1;
        E elementToRemove = (E) elementData[index];
        System.arraycopy(elementData, index + 1, elementData, index, numMoved);
        elementData[--size] = null;
        return elementToRemove;
    }

    // Returns the number of elements in this list.
    public int size() {
        return size;
    }

    // Returns the element at the specified position in this list.
    public E get(int index){
        if (index >= size || index < 0){
            throw new IndexOutOfBoundsException("Index: " + index + ", Size " + index);
        }
        return (E) elementData[index];
    }

    // Removes all the elements from this list.
    public void clear() {
        for (int i = 0; i < size; i++) {
            elementData[i] = null;
        }
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
