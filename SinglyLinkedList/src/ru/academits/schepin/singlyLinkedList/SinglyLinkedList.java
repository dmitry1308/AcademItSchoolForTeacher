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
        if (head == null) {
            head = new ListItem<>(data, null);
        } else {
            head = new ListItem<>(data, head);
        }
        size++;
    }


    public ListItem<T> getData(int index) {
        isOutSideRange(index);

        ListItem<T> p = head;
        for (int i = 0; i < size; i++) {
            if (i == index) {
                return p;
            }
            p = p.next;
        }
        return null;
    }

    public void addData(int index, T data) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Некорректный индекс");
        }

        ListItem<T> p = getData(index - 1);
        ListItem<T> q = new ListItem<>(data);
        q.next = p.next;
        p.next = q;
        size++;
    }

    public T getValue(int index) {
        isOutSideRange(index);

        ListItem<T> p = getData(index);
        return p.data;
    }

    private void isOutSideRange(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Некорректный индекс");
        }
    }


    public T setValue(int index, T data) {
        isOutSideRange(index);

        ListItem<T> p = getData(index);
        T temp = p.data;
        p.data = data;
        return temp;
    }

    public T remove(int index) {
        isOutSideRange(index);

        ListItem<T> p = head;
        if (index == 0) {
            removeHead();
            size--;
            return head.data;
        } else {
            p = getData(index - 1);
            ListItem<T> q = p.next;
            p.next = p.next.next;
            size--;
            return q.data;
        }
    }

    public boolean remove(T data) {
        if (head == null) {
            return false;
        }

        ListItem<T> p = head;

        if (head.data.equals(data)) {
            head = p.next;
            size--;
            return true;
        }

        for (p = head; p.next != null; p = p.next) {
            if (Objects.equals(p.next.data, data)) {
                p.next = p.next.next;
                size--;
                return true;
            }
        }
        return false;
    }

    public T removeHead() {
        if (size == 0) {
            throw new IllegalArgumentException("Нет такого значения т.к список пустой");
        }
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

    public void removeAfterData(ListItem<T> node) {
        node.next = node.next.next;
        size--;
    }

    public void addAfterNode(ListItem<T> node, T data) {
        ListItem<T> q = new ListItem<>(data);
        q.next = node.next;
        node.next = q;
        size++;
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