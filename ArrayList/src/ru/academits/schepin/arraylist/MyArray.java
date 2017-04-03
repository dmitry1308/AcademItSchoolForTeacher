package ru.academits.schepin.arraylist;


public class MyArray {
    private Object[] items = new Object[10];
    private int length;

    public int size() {
        return length;
    }

    public boolean isEmpty() {
        return length == 0;
    }
}
