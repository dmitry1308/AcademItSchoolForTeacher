package ru.academits.schepin.arraylist;


import java.util.Arrays;

public class MyArray {
    private Integer[] items = new Integer[3];
    private int length;

    public int size() {
        return length;
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public Integer get(int index) {
        if (index > items.length - 1) {
            throw new IllegalArgumentException("Необходмо ввести индекс меньше ");
        }
        return items[index];
    }

    public void set(int index, Integer obj) {
        if (index > items.length - 1) {
            throw new IllegalArgumentException("Необходмо ввести индекс меньше ");
        }
        items[index] = obj;
    }


    public String toString() {
        return Arrays.toString(items);
    }

    public void add(Integer obj) {
        if (length >= items.length) {
            increaseCapacity();
        }
        items[length] = obj;
        ++length;
    }

    private void increaseCapacity() {
        Integer[] old = items;
        items = new Integer[old.length * 2];
        System.arraycopy(old, 0, items, 0, old.length);
    }

    //Удаление элемента:
    public void remove(int index) {
        if (index >= length) {
            throw new IllegalArgumentException("Необходмо ввести индекс меньше " + length);
        }
        if (index < length - 1) {
            int numMoved = length - index - 1;
            System.arraycopy(items, index + 1, items, index, numMoved);
        }
        items[--length] = null;
    }

    //Вставка элемента:
    public void insert(int index, Integer obj) {
        if (index > length - 1) {
            throw new IllegalArgumentException("Необходмо ввести индекс меньше ");
        }
        if (length >= items.length) {
            increaseCapacity();
        }

        int numMoved = length - index;
        System.arraycopy(items, index, items, index + 1, numMoved);
        items[index] = obj;
        ++length;
    }

    public void trimToSize(){
        Integer[] array = new Integer[length];
        System.arraycopy(items,0,array,0,length);
        items=array;
    }
}
