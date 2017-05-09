package ru.academits.schepin.singlyLinkedList;

public class Main {
    public static void main(String[] args) {
        SinglyLinkedList<Integer> p = new SinglyLinkedList<>();
//        for (int i = 0; i < 5; i++) {
//            p.addFront(ThreadLocalRandom.current().nextInt(20));
//        }

        //вставка элемента в начало:
        p.addFront(41);
        p.addFront(4);
        p.addFront(7);
        p.addFront(6);
        p.addFront(5);
        p.addFront(1);
        p.printList();

         p.remove(null);

        System.out.println("Получение узла по индексу 5:");
        ListItem node = p.getData(5);
        System.out.println(node + "\n");

        System.out.println("Копия списка:");
        SinglyLinkedList<Integer> q = p.copy();
        q.printList();
        System.out.println();

        System.out.println("Вставка узла после указанного узла:");
        ListItem<Integer> d = new ListItem<>(6);
        p.addAfterData(p.getData(5),d);
        p.printList();
        System.out.println();

        System.out.println("Удаление узла по значению(41):");
        Integer x = 41;
        p.remove(x);
        p.printList();
        System.out.println();

        System.out.println("Вставка по индексу 2 элемента 456:");
        p.addData(2, 456);
        p.printList();
        System.out.println();

        System.out.println("Удаление узла после  узла 4:");
        ListItem<Integer> f = p.getData(1);
        p.removeAfterData(f);
        p.printList();
        System.out.println();

        System.out.println("Получение первого узла:");
        ListItem head = p.getHead();
        System.out.println(head + "\n");

        System.out.println("Вставка элемента по индексу 2 элемента 6:");
        p.addData(2, 6);
        p.printList();
        System.out.println();


        //Получение размера списка:
        System.out.println("p(size) = " + p.size());
        System.out.println();

        System.out.println("Получение значения по  индексу 2:");
        Integer value = p.getValue(2);
        System.out.println(value + "\n");


        System.out.println("Изменение значения по индексу 5 на значение 2 (выдает старое значение):");
        p.printList();
        System.out.println(p.setValue(5, 2));
        p.printList();
        System.out.println();

        System.out.println("Удаление значения по  индексу 2(выдает старое значение):");
        System.out.println("Удаленное значение по индексу 2: " + p.remove(2));
        p.printList();
        System.out.println();

        System.out.println("Удаление первого элемента(выдает значение элемента):");
        System.out.println(p.removeHead());
        p.printList();
        System.out.println();

        System.out.println("Разворот списка за указанное время:");
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        for (int i = 0; i < 5; i++) {
            list.addFront(i);
        }
        list.addFront(null);
        list.printList();

        list.reverse();
        list.printList();


        SinglyLinkedList<Integer> list1 = new SinglyLinkedList<>();


    }
}
