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
        ListItem<T> t = head;       //получаем ссылку на первый элемент
        while (t != null)           //пока элемент существуе
        {
            System.out.print(t.data + " "); //печатаем его данные
            t = t.next;                     //и переключаемся на следующий
        }
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
        if (index < 0 && index > size) {
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


}
