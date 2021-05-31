package com.company;

import java.nio.BufferUnderflowException;

public class BinaryHeap<AnyType extends Comparable<? super AnyType>> {
    private static final int DEFAULT_CAPACITY = 10;

    private int currentSize;      // Number of elements in heap
    private AnyType[] array; // The heap array
    private int children;

    public BinaryHeap() {
        this(2);
    }

    public BinaryHeap(int children) throws IllegalArgumentException {
        if (children < 2)
            throw new IllegalArgumentException("parameter children to dheap must be > 1");
        this.children = children;
        currentSize = 0;
        array = (AnyType[]) new Comparable[DEFAULT_CAPACITY + 1];
    }

    public BinaryHeap(AnyType[] items) {
        currentSize = items.length;
        array = (AnyType[]) new Comparable[(currentSize + 2) * 11 / 10];
        int i = 1;
        for (AnyType item : items)
            array[i++] = item;
        buildHeap();
    }

    public void insert(AnyType x) {
        if (currentSize == array.length - 1)
            enlargeArray(array.length * 2 + 1);

        // Percolate up
        int hole = ++currentSize;
        array[0] = x;
        for (array[0] = x; parentIndex(hole) > 0 && x.compareTo(parent(hole)) < 0; hole = parentIndex(hole))
            array[hole] = parent(hole);
        array[hole] = x;
    }

    private void enlargeArray(int newSize) {
        AnyType[] old = array;
        array = (AnyType[]) new Comparable[newSize];
        for (int i = 0; i < old.length; i++)
            array[i] = old[i];
    }

    public AnyType findMin() {
        if (isEmpty())
            throw new BufferUnderflowException();
        return array[1];
    }

    public AnyType deleteMin() {
        if (isEmpty())
            throw new BufferUnderflowException();
        AnyType minItem = findMin();
        array[1] = array[currentSize];
        currentSize--;
        percolateDown(1);
        return minItem;
    }


    private void percolateDown(int hole) {
        AnyType tmp = array[hole];
        for (; minChildIndex(hole) <= currentSize && tmp.compareTo(minChild(hole)) >= 0; hole = minChildIndex(hole))
            array[hole] = minChild(hole);
        array[hole] = tmp;
    }

    public int parentIndex(int child) throws IllegalArgumentException {
        int parent = (child + children - 2) / children;
        if (parent < 1)
            return 0;
        return parent;
    }

    public AnyType parent(int child) {
        return array[parentIndex(child)];
    }

    public int firstChildIndex(int parent) throws IllegalArgumentException {
        int child = (parent - 1) * children + 2;
        if (child < 2) //lägsta möjliga barn
            throw new IllegalArgumentException();
        return child;
    }

    private int minChildIndex(int parent) {
        int firstChildIndex = firstChildIndex(parent);
        if (firstChildIndex > currentSize)
            return Integer.MAX_VALUE;
        AnyType minChild = array[firstChildIndex];
        int minChildIndex = firstChildIndex;
        for (int i = 1; i < children; i++) {
            if (firstChildIndex + i <= currentSize) {
                AnyType compareWith = array[firstChildIndex + i];
                if (compareWith != null && minChild.compareTo(compareWith) > 0) {
                    minChildIndex = firstChildIndex + i;
                    minChild = compareWith;
                }
            }
        }
        return minChildIndex;
    }

    private AnyType minChild(int parent) {
        return get(minChildIndex(parent));
    }

    public int size() {
        return currentSize;
    }

    public AnyType get(int index) {
        return array[index];
    }

    private void buildHeap() {
        for (int i = currentSize / 2; i > 0; i--)
            percolateDown(i);
    }

    public boolean isEmpty() {
        return currentSize == 0;
    }

    public void makeEmpty() {
        currentSize = 0;
    }
}