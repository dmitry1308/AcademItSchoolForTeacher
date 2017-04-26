package ru.academits.schepin.singlyLinkedList;

import java.util.Objects;

public class SinglyLinkedList<T> {
    private ListItem<T> head;
    private int size;

    public int size() {
        return size;
    }

    public ListItem<T> getHead() {
        return head;
    }

    public void printList() {
        StringBuilder s = new StringBuilder();
        s.append("Список: ");
        for (ListItem<T> t = head; t != null; t = t.next) {
            s.append(t.data);
            s.append(" ");
        }
        System.out.println(s.toString());
    }

    public void addFront(T data) {
        ListItem<T> p = new ListItem<>(data, head);

        if (head == null) {
            head = p;
        } else {
            head = p;
        }
        size++;
    }


    public ListItem<T> getData(int index) {
        if (head == null) {
            throw new UnsupportedOperationException("Список пустой");
        }

        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Некорректный индекс");
        }
        ListItem<T> p = head;
        for (int i = 0; i < size; i++) {
            if (i == index) {
                return p;
            }
            p = p.next;
        }
        return null;
    }

    //Вставка узла по индексу:
    public void addData(int index, T data) {
        if (head == null) {
            throw new UnsupportedOperationException("Список пустой");
        }

        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Некорректный индекс");
        }

        ListItem<T> p = getData(index - 1);
        ListItem<T> q = new ListItem<>(data);
        q.next = p.next;
        p.next = q;
        size++;
    }

    public T getValue(int index) {
        if (head == null) {
            throw new UnsupportedOperationException("Список пустой");
        }

        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Некорректный индекс");
        }
        ListItem<T> p = getData(index);
        return p.data;
    }

    public T changeValue(int index, T data) {
        if (head == null) {
            throw new UnsupportedOperationException("Список пустой");
        }

        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Некорректный индекс");
        }

        ListItem<T> p = getData(index);
        T temp = p.data;
        p.data = data;
        return temp;
    }

    public T remove(int index) {
        if (head == null) {
            throw new UnsupportedOperationException("Список пустой");
        }

        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Некорректный индекс");
        }

        ListItem<T> p = getData(index - 1);
        ListItem<T> q;
        q = p.next;
        p.next = p.next.next;
        size--;
        return q.data;
    }


    public void remove(T data) {
        if (head == null) {
            System.out.println("Нет элемента " + data + " т.к. список пустой");
        } else {

            for (ListItem<T> p = head; p != null; p = p.next) {
                if (head.data.equals(data)) {
                    head = p.next;
                    size--;
                    break;
                }

                if (p.next.data.equals(data)) {
                    p.next = p.next.next;
                    size--;
                    break;
                }
            }
        }
    }

    public T removeHead() {
        T temp = head.data;
        head = head.next;
        size--;

        return temp;
    }


    public void reverse() {
        ListItem<T> current = head;
        ListItem<T> prev = null;

        for (ListItem<T> i = head; i != null; ) {
            i = i.next;
            current.next = prev;
            prev = current;
            current = i;
        }
        head = prev;
    }

    public void removeAfterData(T data) {
        for (ListItem<T> p = head; p != null; p = p.next) {
            if (data.equals(p.data)) {
                p.next = p.next.next;
            }
        }
    }

    public void addAfterData(T data, T newData) {
        ListItem<T> q = new ListItem<>(newData);

        for (ListItem<T> p = head; p != null; p = p.next) {

            if (Objects.equals(p.data, data)) {
                q.next = p.next;
                p.next = q;
                size++;
            }
        }
    }

    public SinglyLinkedList<T> copy() {
        SinglyLinkedList<T> copyOfList = new SinglyLinkedList<>();

        copyOfList.addFront(head.data);

        ListItem<T> current = copyOfList.getHead();

        for (ListItem<T> p = head.next; p != null; p = p.next) {
            ListItem<T> item = new ListItem<>(p.data);
            current.next = item;
            current = item;
        }
        return copyOfList;
    }
}