package ru.academits.shepin.myArrayList;


import java.util.*;

public class MyArrayList<T> {

    private T[] innerArray;
    private int innerSize;

    private static final int START_CAPACITY = 8;

    public MyArrayList() {

        innerArray = (T[]) (new Object[START_CAPACITY]);
        innerSize = 0;
    }

    public MyArrayList(int iniCap) {

        innerArray = (T[]) (new Object[iniCap]);
        innerSize = 0;
    }


    public int getSize() {

        return innerSize;
    }

    public int getCapacity() {

        return innerArray.length;
    }

    public T get(int index) {

        if (index < 0 || index > innerSize - 1) {

            throw new IllegalArgumentException("Введите корректный индекс вставки.");
        }
        return innerArray[index];
    }

    public void set(int index, T obj) {

        if (index < 0 || index > innerSize - 1) {

            throw new IllegalArgumentException("Введите корректный индекс вставки.");
        }
        innerArray[index] = obj;
    }

    @Override
    public String toString() {

        return Arrays.toString(innerArray);
    }

    public void ensureCapacity(int newCap) {

        if (newCap > innerArray.length) {

            T[] innerArray2 = (T[]) new Object[newCap];

            System.arraycopy(innerArray, 0, innerArray2, 0, innerSize);

            innerArray = innerArray2;
        }
    }

    public void add(T obj) {

        if (innerSize == innerArray.length) {

            ensureCapacity(innerArray.length * 2);
        }

        innerArray[innerSize] = obj;
        ++innerSize;
    }

    public void remove(int index) {

        if (index < 0 || index > innerSize - 1) {

            throw new IllegalArgumentException("Некорректный индекс в операции удаления!");
        }
        if (index < innerSize - 1) {

            int numMoved = innerSize - index - 1;

            System.arraycopy(innerArray, index + 1, innerArray, index, numMoved);
        }

        innerArray[innerSize - 1] = null;
        innerSize--;
    }

    public void insert(int index, T obj) {

        if (index < 0 || index > innerSize - 1) {

            throw new IllegalArgumentException("Некорректный индекс в операции вставки.");
        }
        if (innerSize == innerArray.length) {

            ensureCapacity(innerArray.length * 2);
        }

        int numMoved = innerSize - index;
        System.arraycopy(innerArray, index, innerArray, index + 1, numMoved);

        innerArray[index] = obj;
        innerSize++;
    }


    public void trimToSize() {

        T[] newArray;

        newArray = Arrays.copyOf(innerArray, innerSize);

        innerArray = newArray;
    }

    public boolean isEmpty() {
        return innerSize == 0;
    }
}





















































































