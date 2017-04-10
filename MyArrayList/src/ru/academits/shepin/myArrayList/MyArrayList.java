package ru.academits.shepin.myArrayList;

import java.util.*;

public class MyArrayList<T> implements List {
    private T[] innerArray;
    private int innerSize;

    private static final int START_CAPACITY = 10;

    public MyArrayList() {
        innerArray = (T[]) (new Object[START_CAPACITY]);
    }

    public MyArrayList(int InitialCap) {
        innerArray = (T[]) (new Object[InitialCap]);
    }

    @Override
    public int size() {
        return innerSize;
    }

    public int getCapacity() {
        return innerArray.length;
    }

    @Override
    public String toString() {
        T[] array = Arrays.copyOf(innerArray, innerSize);
        return Arrays.toString(array);
    }

    @Override
    public boolean isEmpty() {
        return innerSize == 0;
    }

    @Override
    public boolean contains(Object object) {
        for (int i = 0; i < innerSize; ++i) {
            if (!(innerArray[i].equals(object))) {
                continue;
            }
            return true;
        }
        return false;
    }

    @Override
    // TODO: 10.04.2017
    public Iterator iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(innerArray, innerSize);
    }

    @Override
    public boolean add(Object object) {
        if (innerSize == innerArray.length) {

            ensureCapacity(innerArray.length * 2);
        }

        innerArray[innerSize] = (T) object;
        ++innerSize;
        return false;
    }

    @Override
    public boolean remove(Object object) {
        for (int i = 0; i < innerArray.length; ++i) {
            if (!(innerArray[i].equals(object))) {
                continue;
            }
            int numMoved = innerSize - i - 1;
            System.arraycopy(innerArray, i + 1, innerArray, i, numMoved);

            innerArray[innerSize - 1] = null;
            innerSize--;

            return true;
        }
        return false;
    }

    // TODO: 10.04.2017
    @Override
    public boolean addAll(Collection c) {

        return false;
    }

    // TODO: 10.04.2017
    @Override
    public boolean addAll(int index, Collection c) {
        return false;
    }

    @Override
    public void clear() {
        if (innerArray[0] != null) {
            for (int i = 0; i < innerSize; ++i) {
                innerArray[i] = null;
            }
            innerSize = 0;
        }
    }

    @Override
    public Object get(int index) {
        if (index < 0 || index > innerSize - 1) {
            throw new IllegalStateException("Введите корректный индекс вставки.");
        }
        return innerArray[index];
    }

    @Override
    public Object set(int index, Object object) {
        if (index < 0 || index > innerSize - 1) {

            throw new IllegalStateException("Введите корректный индекс вставки.");
        }
        innerArray[index] = (T) object;
        return object;
    }

    public void ensureCapacity(int newCap) {
        if (newCap > innerArray.length) {
            T[] innerArray2 = (T[]) new Object[newCap];
            System.arraycopy(innerArray, 0, innerArray2, 0, innerSize);
            innerArray = innerArray2;
        }
    }

    @Override
    public void add(int index, Object object) {
        if (innerSize == innerArray.length) {
            ensureCapacity(innerArray.length * 2);
        }

        innerArray[innerSize] = (T) object;
        ++innerSize;
    }

    @Override
    public Object remove(int index) {
        if (index < 0 || index > innerSize - 1) {
            throw new IllegalArgumentException("Некорректный индекс в операции удаления!");
        }
        if (index < innerSize - 1) {
            int numMoved = innerSize - index - 1;
            System.arraycopy(innerArray, index + 1, innerArray, index, numMoved);
        }

        innerArray[innerSize - 1] = null;
        innerSize--;

        return innerArray;
    }

    @Override
    public int indexOf(Object object) {
        for (int i = 0; i < innerArray.length; ++i) {
            if (!(innerArray[i].equals(object))) {
                continue;
            }
            return 1;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object object) {
        int lastIndex = -1;
        int i;
        for (i = 0; i < innerArray.length; ++i) {
            if (!(innerArray[i].equals(object))) {
                continue;
            }
            lastIndex = i;
        }
        if (lastIndex == -1) {
            return -1;
        } else {
            return lastIndex;
        }
    }

    // TODO: 10.04.2017
    @Override
    public ListIterator listIterator() {
        return null;
    }

    // TODO: 10.04.2017
    @Override
    public ListIterator listIterator(int index) {
        return null;
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        return null;
    }

    // TODO: 10.04.2017
    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    // TODO: 10.04.2017
    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    // TODO: 10.04.2017
    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public Object[] toArray(Object[] a) {
        return Arrays.copyOf(innerArray, innerSize);
    }

    public void insert(int index, T object) {
        if (index < 0 || index > innerSize - 1) {
            throw new IllegalArgumentException("Некорректный индекс в операции вставки.");
        }
        if (innerSize == innerArray.length) {
            ensureCapacity(innerArray.length * 2);
        }

        int numMoved = innerSize - index;
        System.arraycopy(innerArray, index, innerArray, index + 1, numMoved);

        innerArray[index] = object;
        innerSize++;
    }

    public void trimToSize() {
        if (innerArray.length > innerSize) {

            innerArray = Arrays.copyOf(innerArray, innerSize);
        }
    }


}
