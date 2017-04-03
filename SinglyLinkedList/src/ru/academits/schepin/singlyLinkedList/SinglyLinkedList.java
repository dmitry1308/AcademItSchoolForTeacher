package ru.academits.schepin.singlyLinkedList;

public class SinglyLinkedList {
    private ListItem head;

    void addFront(int data) {      //добавить спереди

        ListItem a = new ListItem();  //создаём новый элемент
        a.data = data;                //инициализируем данные.
                                        // указатель на следующий элемент автоматически инициализируется как null
        if (head == null) {         //если список пуст
            head = a;               //то указываем ссылки начала и конца на новый элемент
                                    //т.е. список теперь состоит из одного элемента
        } else {
            a.next = head;          //иначе новый элемент теперь ссылается на "бывший" первый
            head = a;               //а указатель на первый элемент теперь ссылается на новый элемент
        }
    }


    void printList()                //печать списка
    {
        ListItem t = head;       //получаем ссылку на первый элемент
        while (t != null)           //пока элемент существуе
        {
            System.out.print(t.data + " "); //печатаем его данные
            t = t.next;                     //и переключаемся на следующий
        }
    }

}
