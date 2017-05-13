package ru.academits.schepin.hashtable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class HashTable<T> implements Collection<T> {
    private ArrayList<T>[] arrayOfLists;
    private int innerSize;
    final static int DEFAULT_CAP = 117;


    public HashTable() {
        arrayOfLists = new ArrayList[DEFAULT_CAP];
    }

    public HashTable(int cap) {
        arrayOfLists = new ArrayList[cap];
    }


    @Override
    public int size() {
        return innerSize;
    }

    private int getHashCode(Object o) {
        return Math.abs(o.hashCode() % arrayOfLists.length);
    }

    @Override
    public boolean add(T t) {
        int indexOfArray = getHashCode(t);

        if (arrayOfLists[indexOfArray] == null) {
            ArrayList<T> list = new ArrayList<>(5);
            arrayOfLists[indexOfArray] = list;
        } else {
            for (int i = 0; i < arrayOfLists[i].size(); i++) {
                if (arrayOfLists[i].get(i).equals(t)) {
                    return false;
                }
            }
        }
        arrayOfLists[indexOfArray].add(t);
        innerSize++;
        return true;
    }


    @Override
    public boolean remove(Object o) {
        int indexOfArray = getHashCode(o);
        if (arrayOfLists[indexOfArray] == null) {
            return false;
        } else {
            for (int i = 0; i < arrayOfLists[i].size(); i++) {
                if (arrayOfLists[indexOfArray].get(i).equals(o)) {
                    arrayOfLists[indexOfArray].remove(i);
                    innerSize--;
                    return true;
                }
            }
        }
        return false;
    }


    public void print() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < arrayOfLists.length; i++) {
            s.append(i);
            s.append(") ");
            if (arrayOfLists[i] != null) {
                for (int j = 0; j < arrayOfLists[i].size(); j++) {
                    s.append(arrayOfLists[i].get(j));
                    s.append(" ");
                }

            }
            s.append("\n");
        }
        System.out.println(s.toString());
    }


    @Override
    public boolean isEmpty() {
        return innerSize == 0;
    }


    @Override
    public boolean contains(Object o) {
        int indexOfArray = getHashCode(o);
        if (arrayOfLists[indexOfArray] != null) {
            for (int i = 0; i < arrayOfLists[i].size(); i++) {
                if (arrayOfLists[indexOfArray].get(i).equals(o)) {
                    return true;
                }
            }
        }
        return false;
    }


    @Override
    public boolean removeAll(Collection<?> c) {
        T[] array = (T[]) c.toArray(new Object[c.size()]);
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            int indexOfArray = getHashCode(array[i]);
            for (int j = 0; j < arrayOfLists[indexOfArray].size(); j++) {
                if (arrayOfLists[indexOfArray].get(j).equals(array[i])) {
                    arrayOfLists[indexOfArray].remove(j);
                    count++;
                    break;
                }
            }
        }
        return count > 0;
    }

    @Override
    public void clear() {
        for (int i = 0; i < arrayOfLists.length; i++) {
            if (arrayOfLists[i] != null) {
                arrayOfLists[i].clear();
            }
        }
        innerSize = 0;
    }


    @Override
    public boolean retainAll(Collection<?> c) {
        boolean isSuccess = false;
        for (int i = 0; i < arrayOfLists.length; i++) {
            if (arrayOfLists[i] != null) {
                while (true) {
                    boolean isFound = false;
                    for (int j = 0; j < arrayOfLists[i].size(); j++) {
                        if (!c.contains(arrayOfLists[i].get(j))) {
                            arrayOfLists[i].remove(j);
                            isSuccess = true;
                            isFound = true;
                            break;
                        }
                    }
                    if (!isFound) {
                        break;
                    }
                }
            }

        }
        return isSuccess;
    }


    @Override
    public boolean addAll(Collection<? extends T> c) {
        T[] array = (T[]) c.toArray(new Object[c.size()]);

        for (int i = 0; i < array.length; i++) {
            int indexOfArray = getHashCode(array[i]);

            if (arrayOfLists[indexOfArray] == null) {
                ArrayList<T> list = new ArrayList<>(5);
                arrayOfLists[indexOfArray] = list;
                arrayOfLists[indexOfArray].add(array[i]);
                innerSize++;
            } else {
                for (int j = 0; j < arrayOfLists[indexOfArray].size(); j++) {
                    if (arrayOfLists[indexOfArray].get(j).equals(array[i])) {
                        break;
                    }
                    arrayOfLists[indexOfArray].add(array[i]);
                    innerSize++;
                }
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {







        return false;
    }

    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //


    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }





}
