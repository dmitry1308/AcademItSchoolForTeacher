package ru.academits.shepin.myArrayList;

import java.util.*;

public class MyArrayList<T> implements List<T> {
    private T[] innerArray;
    private int innerSize;

    private static final int START_CAPACITY = 10;

    public MyArrayList() {
        //noinspection unchecked
        innerArray = (T[]) (new Object[START_CAPACITY]);
    }

    public MyArrayList(int initialCap) {
        //noinspection unchecked
        innerArray = (T[]) (new Object[initialCap]);
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
        StringBuilder s = new StringBuilder();
        s.append("{");
        for (int i = 0; i < innerSize; ++i) {
            s.append(innerArray[i]);
            s.append("  ");
        }
        s.append("}");
        return s.toString();
    }


    @Override
    public boolean isEmpty() {
        return innerSize == 0;
    }


    @Override
    public boolean contains(Object object) {
        if (indexOf(object) == -1) {
            return false;
        }
        return true;
    }


    @Override
    public Iterator<T> iterator() {
        return new MyIterator();
    }

    private class MyIterator implements Iterator<T> {
        int currentIndex;

        @Override
        public boolean hasNext() {
            return (currentIndex < innerSize) && (innerArray[currentIndex] != null);
        }

        @Override
        public T next() {
            if (hasNext()) {
                return innerArray[currentIndex++];
            } else {
                throw new NoSuchElementException();
            }
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

    }


    @Override
    public Object[] toArray() {
        return Arrays.copyOf(innerArray, innerSize);
    }


    private void ensureCapacity(int newCapacity) {
        //noinspection unchecked
        T[] innerArray2 = (T[]) new Object[newCapacity];
        System.arraycopy(innerArray, 0, innerArray2, 0, innerSize);
        innerArray = innerArray2;

    }


    @Override
    public boolean add(T object) {
        if (innerSize == innerArray.length) {
            ensureCapacity(innerArray.length * 2);
        }
        innerArray[innerSize] = object;
        ++innerSize;
        return true;
    }


    @Override
    public boolean remove(Object object) {
        for (int i = 0; i < innerArray.length; ++i) {

            if (!(Objects.equals(innerArray[i], object))) {
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


    @Override
    public boolean addAll(Collection<? extends T> c) {
        if (innerSize == innerArray.length) {
            ensureCapacity(innerArray.length * 2);
        }
        //noinspection unchecked
        T[] array = (T[]) c.toArray();

        System.arraycopy(array, 0, innerArray, innerSize, array.length);
        int newInnSize = innerSize + array.length;
        if (newInnSize != innerSize) {
            innerSize = newInnSize;
            return true;
        } else {
            return false;
        }
    }


    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        if (index < 0 || index > innerSize - 1) {
            throw new IllegalArgumentException("Некорректный индекс в операции вставки.");
        }
        if (innerSize == innerArray.length) {
            ensureCapacity(innerArray.length * 2);
        }
        //noinspection unchecked
        T[] array = (T[]) c.toArray();
        int numMoved = innerSize - index;
        System.arraycopy(innerArray, index, innerArray, index + array.length, numMoved);
        System.arraycopy(array, 0, innerArray, index, array.length);
        int newInnSize = innerSize + array.length;
        if (newInnSize != innerSize) {
            innerSize = newInnSize;
            return true;
        } else {
            return false;
        }
    }


    @Override
    public void clear() {
        for (int i = 0; i < innerSize; ++i) {
            innerArray[i] = null;
        }
        innerSize = 0;
    }


    @Override
    public T get(int index) {
        if (index < 0 || index > innerSize - 1) {
            throw new IllegalArgumentException("Введите корректный индекс вставки.");
        }
        return innerArray[index];
    }


    @Override
    public T set(int index, T object) {
        if (index < 0 || index > innerSize - 1) {

            throw new IllegalArgumentException("Введите корректный индекс вставки.");
        }
        innerArray[index] = object;
        return object;
    }


    @Override
    public void add(int index, T object) {
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

    @Override
    public T remove(int index) {
        if (index < 0 || index > innerSize - 1) {
            throw new IllegalArgumentException("Некорректный индекс в операции удаления!");
        }
        T element = innerArray[index];
        if (index < innerSize - 1) {
            int numMoved = innerSize - index - 1;
            System.arraycopy(innerArray, index + 1, innerArray, index, numMoved);
        }

        innerArray[innerSize - 1] = null;
        innerSize--;

        return element;
    }


    @Override
    public int indexOf(Object object) {
        for (int i = 0; i < innerSize; ++i) {
            if (!(Objects.equals(innerArray[i], object))) {
                continue;
            }
            return i;
        }
        return -1;
    }


    @Override
    public int lastIndexOf(Object object) {
        for (int i = innerSize - 1; i >= 0; --i) {
            if (!Objects.equals(innerArray[i], object)) {
                continue;
            }
            return i;
        }
        return -1;
    }


    @Override
    public boolean retainAll(Collection<?> c) {
        //noinspection unchecked
        T[] array = (T[]) c.toArray();
        int newInnerSize = innerSize;
        outer:
        for (int i = 0; i < innerSize; ++i) {
            for (int j = 0; j < array.length; ++j) {

                if (Objects.equals(innerArray[i], array[j])) {
                    continue outer;
                }

            }
            System.arraycopy(innerArray, i + 1, innerArray, i, innerSize - i - 1);
            newInnerSize--;


        }
        if (newInnerSize == innerSize) {
            innerSize = newInnerSize;
            return true;
        } else {
            return false;
        }
    }


    @Override
    public boolean removeAll(Collection<?> c) {
        //noinspection unchecked
        T[] array = (T[]) c.toArray();
        int newInnerSize = innerSize;
        outer:
        for (int i = 0; i < array.length; ++i) {
            for (int j = 0; j < newInnerSize; ++j) {
                if (Objects.equals(innerArray[j], array[i])) {
                    System.arraycopy(innerArray, j + 1, innerArray, j, newInnerSize - 1 - j);
                    newInnerSize--;
                    i--;
                    continue outer;
                }

            }
        }
        if (newInnerSize != innerSize) {
            innerSize = newInnerSize;
            return true;
        } else {
            return false;
        }
    }


    @Override
    public boolean containsAll(Collection c) {
        //noinspection unchecked
        T[] array = (T[]) c.toArray();
        if (size() != array.length) {
            return false;
        }

        for (int i = 0; i < size(); ++i) {
            if (Objects.equals(innerArray[i], array[i])) {
                continue;
            }
            return false;
        }
        return true;
    }


    public void trimToSize() {
        if (innerArray.length > innerSize) {

            innerArray = Arrays.copyOf(innerArray, innerSize);
        }
    }


    @Override
    public Object[] toArray(Object[] a) {
        if (innerSize <= a.length) {
            System.arraycopy(innerArray, 0, a, 0, innerSize);
            return innerArray;
        } else {
            System.arraycopy(innerArray, 0, a, 0, a.length);
            return innerArray;
        }
    }


    @Override
    public ListIterator<T> listIterator() {

        return new ListIterator<T>() {
            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return (currentIndex < innerSize) && (innerArray[currentIndex] != null);
            }

            @Override
            public T next() {
                return innerArray[currentIndex++];
            }

            @Override
            public boolean hasPrevious() {
                return (currentIndex > 0);
            }

            @Override
            public T previous() {
                return innerArray[--currentIndex];
            }

            @Override
            public int nextIndex() {
                if (hasNext()) {
                    return currentIndex++;
                } else {
                    return innerSize;
                }
            }

            @Override
            public int previousIndex() {
                if (innerArray[currentIndex - 1] != null) {
                    return --currentIndex;
                }
                return -1;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }

            @Override
            public void set(T t) {
                innerArray[--currentIndex] = t;
                ++currentIndex;
            }

            @Override
            public void add(T t) {
                innerArray[innerSize] = t;
                innerSize++;
            }
        };

    }


    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        return null;
    }


}
