package ru.academits.schepin.singlyLinkedList;

public class Main {
    public static void main(String[] args) {
        SinglyLinkedList<Integer> p = new SinglyLinkedList<>();
        p.addFront(10);
        p.addFront(5);
        p.addFront(7);

        p.printList();

        System.out.println(" ");

        ListItem head = p.getHead();
        System.out.println(head);


        p.addData(2, 6);
        p.printList();

        ListItem f= p.getData(2);
        System.out.println(f);


    }
}
