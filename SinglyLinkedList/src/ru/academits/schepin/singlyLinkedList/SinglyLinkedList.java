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
        //получаем ссылку на первый элемент
        ListItem<T> t = head;
        StringBuilder s = new StringBuilder();
        s.append("Список: ");
        while (t != null) {
            s.append(t.data);
            s.append(" ");

            t = t.next;
        }
        System.out.println(s.toString());

    }

    public void addFront(T data) {      //добавить спереди

        ListItem<T> a = new ListItem<>(data);  //создаём новый элемент
        // указатель на следующий элемент автоматически инициализируется как null
        if (head == null) {         //если список пуст
            head = a;               //то указываем ссылки начала и конца на новый элемент
            //т.е. список теперь состоит из одного элемента
        } else {
            a.next = head;          //иначе новый элемент теперь ссылается на "бывший" первый
            head = a;               //а указатель на первый элемент теперь ссылается на новый элемент
        }
        size++;
    }

    public void addForIndex(int index, T data) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Некорректный индекс");
        }

        ListItem<T> a = new ListItem<>(data);

        //дойти до элемента index
        for (int i = 0; i < size; i++) {
            if (i == index) {

            }
        }
    }

    //Получение узла по индексу:
    public ListItem<T> getData(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Некорректный индекс");
        }

        ListItem<T> p = head;
        int count = 0;
        while (p != null) {
            if (count == index) {
                return p;
            }
            p = p.next;
            count++;
        }
        return null;
    }

    //Вставка узла по индексу:
    public ListItem<T> addData(int index, T data) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Некорректный индекс");
        }
        ListItem<T> p = head;
        int count = 0;
        while (p != null) {
            if (count == index - 1) {
                ListItem<T> q = new ListItem<T>(data);
                q.next = p.next;
                p.next = q;
                return p;
            }
            p = p.next;
            count++;
        }
        return null;
    }

    public T getValue(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Некорректный индекс");
        }

        ListItem<T> p = head;
        int count = 0;
        while (p != null) {
            if (count == index) {
                return p.data;
            }
            p = p.next;
            count++;
        }
        return null;
    }

    public void setValue(int index, T data) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Некорректный индекс");
        }

        ListItem<T> p = head;
        int count = 0;
        while (p != null) {
            if (count == index) {
                p.data = data;
            }
            p = p.next;
            count++;
        }
    }

    public T changeValue(int index, T data) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Некорректный индекс");
        }

        ListItem<T> p = head;
        int count = 0;
        while (p != null) {
            if (count == index) {
                T temp = p.data;
                p.data = data;
                return temp;
            }
            p = p.next;
            count++;
        }
        return null;
    }

    public T remove(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Некорректный индекс");
        }

        ListItem<T> p = head;
        int count = 0;
        while (p != null) {
            if (index - 1 == count) {
                ListItem<T> q;
                q = p.next;
                p.next = p.next.next;
                size--;
                return q.data;
            }
            p = p.next;
            count++;
        }
        return null;
    }

    //Не работает
//    public void remove(T data) {
//        ListItem<T> p = head;
//        while (p != null) {
//            if (p.next.data.equals(data)) {
//                p.next = p.next.next;
//
//            }
//            p = p.next;
//        }
//       size--;
//    }

    public T removeHead() {
        T temp = head.data;
        ListItem<T> p = head;
        head = p.next;
        size--;

        return temp;
    }

    //надо доделывать
    public void reversal() {
        ListItem<T> p = head;
        ListItem<T> q = head.next;
        ListItem<T> r = q.next;
        p.next = null;
        q.next = p;

    }

    public void removeAfterIndex(ListItem<T> data) {
        ListItem<T> p = head;
        while (p != null) {
            if (data.equals(p)) {
                p.next = p.next.next;
            }
            p = p.next;
        }
    }

    public void addAfterIndex(T data, T newData) {
        ListItem<T> p = head;
        ListItem<T> q = new ListItem<>(newData);
        while (p != null) {
            if (p.data.equals(data)) {
                q.next = p.next;
                p.next = q;
                size++;
            }
            p = p.next;
        }
    }

//    public SinglyLinkedList<T> copy() {
//        SinglyLinkedList<T> copyOfList = new SinglyLinkedList<T>();
//        ListItem<T> p = head;
//        while(p!=null){
//            copyOfList.add(p.data);
//        }
//        return SinglyLinkedList<T>;
//    }
//
//    private void add(T data) {
//
//        ListItem<T> a = new ListItem<>(data);
//
//        if (head == null) {
//            head = a;
//
//        } else {
//            head.next = a;
//        }
//        size++;
//    }

}

