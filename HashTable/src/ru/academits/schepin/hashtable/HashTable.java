package ru.academits.schepin.hashtable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class HashTable<T> implements Collection<T> {
    private ArrayList<T>[] arrayOfLists;
    private int innerSize;
    private final static int DEFAULT_CAPACITY = 117;


    public HashTable() {
        //noinspection unchecked
        arrayOfLists = new ArrayList[DEFAULT_CAPACITY];
    }

    public HashTable(int capacity) {
        //noinspection unchecked
        arrayOfLists = new ArrayList[capacity];
    }


    @Override
    public int size() {
        return innerSize;
    }

    private int hashCode(Object o) {
        if (o == null) {
            return -1;
        }

        return Math.abs(37*(o.hashCode()) % arrayOfLists.length);
    }

    @Override
    public boolean add(T t) {
        int indexOfArray = hashCode(t);
        if (indexOfArray == -1) {
            return false;
        }
        ArrayList<T> neededList = arrayOfLists[indexOfArray];

        if (neededList == null) {
            ArrayList<T> list = new ArrayList<>(5);
            arrayOfLists[indexOfArray] = list;
        } else {
            return !neededList.contains(t);
        }
        arrayOfLists[indexOfArray].add(t);
        innerSize++;
        return true;
    }


    @Override
    public boolean remove(Object o) {
        int indexOfArray = hashCode(o);
        if (indexOfArray == -1) {
            return false;
        }
        ArrayList<T> neededList = arrayOfLists[indexOfArray];

        if (neededList == null) {
            return false;
        } else {
            if (neededList.contains(o)) {
                innerSize--;
                return neededList.remove(o);
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
            s.append(System.lineSeparator());
        }
        System.out.println(s.toString());
    }


    @Override
    public boolean isEmpty() {
        return innerSize == 0;
    }


    @Override
    public boolean contains(Object o) {
        int indexOfArray = hashCode(o);
        if (indexOfArray == -1) {
            return false;
        }

        ArrayList<T> neededList = arrayOfLists[indexOfArray];

        if (neededList != null) {
            return arrayOfLists[indexOfArray].contains(o);
        }
        return false;
    }


    @Override
    public boolean removeAll(Collection<?> c) {
        T[] array = (T[]) c.toArray(new Object[c.size()]);
        int count = 0;
        for (T element : array) {
            int indexOfArray = hashCode(element);

            ArrayList<T> neededList = arrayOfLists[indexOfArray];
            if (neededList.contains(element)) {
                neededList.remove(element);
                count++;
            }
        }
        return count > 0;
    }

    @Override
    public void clear() {
        for (ArrayList<T> arrayOfList : arrayOfLists) {
            if (arrayOfList != null) {
                arrayOfList.clear();
            }
        }
        innerSize = 0;
    }


    @Override
    public boolean retainAll(Collection<?> c) {
        boolean isSuccess = false;
        for (ArrayList<T> arrayOfList : arrayOfLists) {
            if (arrayOfList != null) {
                while (true) {
                    boolean isFound = false;
                    for (int j = 0; j < arrayOfList.size(); j++) {
                        if (!c.contains(arrayOfList.get(j))) {
                            arrayOfList.remove(j);
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

        for (T element : array) {
            int indexOfArray = hashCode(element);

            if (arrayOfLists[indexOfArray] == null) {
                ArrayList<T> list = new ArrayList<>(5);
                arrayOfLists[indexOfArray] = list;
                arrayOfLists[indexOfArray].add(element);
                innerSize++;
                continue;
            } else {
                if (arrayOfLists[indexOfArray].contains(element)) {
                    continue;
                }
                arrayOfLists[indexOfArray].add(element);
                innerSize++;

            }
            return true;
        }
        return false;
    }


    @Override
    public Iterator<T> iterator() {
        Iterator<T> it = new Iterator<T>() {
            private int total = 0;

            private int indexOfArray = 0;


            @Override
            public boolean hasNext() {
                return total < innerSize;
            }

            @Override
            public T next() {
                if (arrayOfLists[indexOfArray] != null) {
                    if (0 < arrayOfLists[indexOfArray].size()) {
                        total++;
                        return arrayOfLists[indexOfArray++].get(0);
                    }
                } else {
                    for (int i = indexOfArray + 1; i < arrayOfLists.length; i++) {
                        if (arrayOfLists[i] != null && arrayOfLists[i].size() > 0) {
                            indexOfArray = i;
                            indexOfArray++;
                            total++;
                            return arrayOfLists[i].get(0);
                        }
                    }
                }
                throw new NoSuchElementException("Вызывайте hasNext() до next()");
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
        return it;
    }


    @Override
    public Object[] toArray() {
        T[] newArray = (T[]) new Object[innerSize];
        int countingAddedItems = 0;
        for (ArrayList<T> arrayOfList : arrayOfLists) {

            if (arrayOfList != null) {
                T[] arrayFromList = (T[]) arrayOfList.toArray(new Object[arrayOfList.size()]);
                System.arraycopy(arrayFromList, 0, newArray, countingAddedItems, arrayFromList.length);
                countingAddedItems += arrayOfList.size();
            }
        }
        return newArray;
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
    @Override
    public <T1> T1[] toArray(T1[] array) {
        int countingOfIdenticalElements = 0;
        for (int i = 0; i < array.length; i++) {
            int indexOfArray = hashCode(array[i]);
            if (arrayOfLists[indexOfArray] != null) {
                arrayOfLists[indexOfArray].contains(array[i]);

                T1 temp = array[countingOfIdenticalElements];
                array[countingOfIdenticalElements] = array[i];
                array[i] = temp;
                countingOfIdenticalElements++;

                continue;
            }
            array[i] = null;
        }
        return array;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        T[] array = (T[]) c.toArray(new Object[c.size()]);

        for (T element : array) {
            int indexOfArray = hashCode(element);
            if (arrayOfLists[indexOfArray] == null) {
                return false;
            }

            if (arrayOfLists[indexOfArray].contains(element)) {
                continue;
            }
            return false;


        }
        return true;
    }

}






