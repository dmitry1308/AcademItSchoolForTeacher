package ru.academits.schepin.singlyLinkedList;

public class Main {
    public static void main(String[] args) {
        SinglyLinkedList<Integer> p = new SinglyLinkedList<>();
//        for (int i = 0; i < 5; i++) {
//            p.addFront(ThreadLocalRandom.current().nextInt(20));
//        }

        //вставка элемента в начало:
        p.addFront(10);
        p.addFront(5);
        p.addFront(7);
        p.addFront(4);
        p.addFront(12);
        p.addFront(1);

        p.printList();
        System.out.println(" ");

        System.out.println("Копия списка:");
        SinglyLinkedList<Integer> q = p.copy();
        q.printList();
        System.out.println();

        System.out.println("Вставка узла после указанного узла:");
        p.addAfterData(10, 56);
        p.printList();
        System.out.println();

        System.out.println("Удаление узла по значению:");
        Integer x = 1;
        p.remove(x);
        p.printList();
        System.out.println();

        System.out.println("Вставка элемента по индексу 2 элемента 6:");

        p.addData(2, null);
        p.printList();
        System.out.println();

        System.out.println("Удаление узла после указанного узла:");
        p.removeAfterData(4);
        p.printList();
        System.out.println();

        System.out.println("Вставка узла после указанного узла:");
        p.addAfterData(12, 56);
        p.printList();
        System.out.println();

        System.out.println("Получение первого узла:");
        ListItem head = p.getHead();
        System.out.println(head + "\n");

        System.out.println("Вставка элемента по индексу 2 элемента 6:");
        p.addData(2, 6);
        p.printList();
        System.out.println();

        System.out.println("Получение узла по индексу 2:");
        ListItem node = p.getData(2);
        System.out.println(node + "\n");

        //Получение размера списка:
        System.out.println("p(size) = " + p.size());
        System.out.println();

        System.out.println("Получение значения по  индексу 2:");
        int value = p.getValue(2);
        System.out.println(value + "\n");


        System.out.println("Изменение значения по индексу 3 на 26:");
        p.setValue(3, 26);
        p.printList();
        System.out.println();

        System.out.println("Изменение значения по указан. индексу(выдает старое значение):");
        System.out.println(p.changeValue(5, 2) + "\n");

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
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.printList();

        list.reversal();
        list.printList();

    }
}
