package ru.academits.schepin.hashtable;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        HashTable hashTable1 = new HashTable(21);
        for (int i = 0; i < 20; i++) {
            hashTable1.add(i);
        }
        hashTable1.print();
        System.out.println();


        System.out.println("Проверка, что хэштаблица пустая: " + hashTable1.isEmpty());
        System.out.println();


        System.out.println("Выполнение метода removeAll:");
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(25, 3));
        boolean c = hashTable1.removeAll(list);
        System.out.println(c);
        hashTable1.print();

        System.out.println("Удаление содержимово хэштаблицы: ");
        hashTable1.clear();
        hashTable1.print();

        for (int i = 0; i < 20; i++) {
            hashTable1.add(i);
        }
        System.out.println();

        System.out.println("Выполнение метода retainAll:");
        ArrayList<Integer> list1 = new ArrayList<>(Arrays.asList(0, 5, 3));
        boolean s = hashTable1.retainAll(list1);
        System.out.println(s);
        hashTable1.print();


        System.out.println("Выполнение метода addAll");
        HashTable hashTable2 = new HashTable(21);
        hashTable2.add(0);
        hashTable2.add(4);
        hashTable2.add(2);
        hashTable2.add(9);
        hashTable2.print();

        hashTable2.addAll(list1);
        hashTable2.print();


    }
}
