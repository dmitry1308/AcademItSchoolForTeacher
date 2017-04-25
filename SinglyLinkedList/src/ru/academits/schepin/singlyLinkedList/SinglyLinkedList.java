package ru.academits.schepin.singlyLinkedList;

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

    public void addFront(T data) {      //добавить спереди
        ListItem<T> p = new ListItem<>(data, head);
        p.setData(data);
        if (head == null) {
            head = p;
        } else {
            p.setNext(head);
            head = p;
        }
        size++;
    }


    public ListItem<T> getData(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Некорректный индекс");
        }

        int count = 0;
        for (ListItem<T> p = head; p != null; p = p.next) {
            if (count == index) {
                return p;
            }
            count++;
        }
        return null;
    }

    //Вставка узла по индексу:
    public ListItem<T> addData(int index, T data) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Некорректный индекс");
        }

        int count = 0;
        for (ListItem<T> p = head; p != null; p = p.next) {
            if (count == index - 1) {
                ListItem<T> q = new ListItem<>(data);
                q.next = p.next;
                p.next = q;
                return p;
            }
            count++;
        }
        return null;
    }

    public T getValue(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Некорректный индекс");
        }

        int count = 0;
        for (ListItem<T> p = head; p != null; p = p.next) {
            if (count == index) {
                return p.data;
            }
            count++;
        }
        return null;
    }

    public void setValue(int index, T data) {
        if (index < 0 || index > size || head == null) {
            throw new IndexOutOfBoundsException("Некорректный индекс");
        }


        int count = 0;
        for (ListItem<T> p = head; p != null; p = p.next) {
            if (count == index) {
                p.data = data;
            }
            count++;
        }
    }

    public T changeValue(int index, T data) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Некорректный индекс");
        }

        int count = 0;
        for (ListItem<T> p = head; p != null; p = p.next) {
            if (count == index) {
                T temp = p.data;
                p.data = data;
                return temp;
            }
            count++;
        }
        return null;
    }

    public T remove(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Некорректный индекс");
        }


        int count = 0;
        for (ListItem<T> p = head; p != null; p = p.next) {
            if (index - 1 == count) {
                ListItem<T> q;
                q = p.next;
                p.next = p.next.next;
                size--;
                return q.data;
            }
            count++;
        }
        return null;
    }


    public void remove(T data) {

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

    public T removeHead() {
        T temp = head.data;
        head = head.next;
        size--;

        return temp;
    }


    public void reversal() {
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

            if (p.data.equals(data)) {
                q.next = p.next;
                p.next = q;
                size++;
            }
        }
    }

    public SinglyLinkedList<T> copy() {
        SinglyLinkedList<T> copyOfList = new SinglyLinkedList<>();

        for (ListItem<T> p = head; p != null; p = p.next) {
            copyOfList.add(p.data);
        }
        return copyOfList;
    }

    public void add(T data) {
        ListItem<T> q = new ListItem<>(data);

        if (head == null) {
            head = q;
            size++;
        } else {
            for (ListItem<T> p = head; ; p = p.next) {
                if (p.next == null) {
                    p.next = q;
                    size++;
                    break;
                }
            }
        }
    }
}

