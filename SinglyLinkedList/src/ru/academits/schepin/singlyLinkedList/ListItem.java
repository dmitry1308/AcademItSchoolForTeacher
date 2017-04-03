package ru.academits.schepin.singlyLinkedList;

public class ListItem {
    int data;
    ListItem next;

    public ListItem() {
    }

    public ListItem(int data) {
        this.setData(data);
    }

    public ListItem(int data, ListItem next) {
        this.setData(data);
        this.setNext(next);
    }


    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public ListItem getNext() {
        return next;
    }

    public void setNext(ListItem next) {
        this.next = next;
    }
}
