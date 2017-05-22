package ru.academits.schepin.hashtable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {

        HashTable<Integer> hashTable1 = new HashTable<>(21);
        for (int i = 0; i < 20; i++) {
            hashTable1.add(i);
        }
        hashTable1.print();
        System.out.println();


        System.out.println("Проверка, что хэштаблица пустая: " + hashTable1.isEmpty());
        System.out.println();


        System.out.println("Выполнение метода removeAll:");
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(25, 3, 4));
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
        ArrayList<Integer> list1 = new ArrayList<>(Arrays.asList(15, 16, 20, 19, 4, 5, 6, 7, 8, 9, 10));
        boolean s = hashTable1.retainAll(list1);
        System.out.println(s);
        hashTable1.print();


        System.out.println("Выполнение метода addAll");
        HashTable<Integer> hashTable2 = new HashTable<>(21);
        hashTable2.add(1);
        hashTable2.add(2);
        hashTable2.add(3);
        hashTable2.add(4);
        hashTable2.print();
        System.out.println();

        hashTable2.addAll(list1);
        hashTable2.print();
        System.out.println();


        System.out.println("Преобразование Хэштаблицы в массив:");
        Object[] array = hashTable2.toArray();
        for (Object element : array) {
            System.out.print(element + "  ");
        }
        System.out.println();
        System.out.println();


        System.out.println("Выполнение метода containAll");
        HashTable<Integer> hashTable3 = new HashTable<>(21);
        hashTable3.add(5);
        hashTable3.add(7);
        hashTable3.add(3);
        hashTable3.add(1);
        ArrayList<Integer> list2 = new ArrayList<>(Arrays.asList(5, 7, 1));
        boolean v = hashTable3.containsAll(list2);
        System.out.println(v);
        System.out.println();


        System.out.println("Выполнение метода: toArray(T[]array)");
        HashTable<Integer> hashTable4 = new HashTable<>(21);
        hashTable4.add(5);
        hashTable4.add(7);
        hashTable4.add(3);
        hashTable4.add(1);
        Integer[] a = {10, 20, 1};
        Object[] array1 = hashTable4.toArray(a);
        for (Object a1 : array1) {
            System.out.print(a1 + " ");
        }

        hashTable4.add(null);
        System.out.println();



        System.out.println("Пройтись Итератором");
        HashTable<Integer> hashTable5 = new HashTable<>(11);
        hashTable5.add(0);
        hashTable5.add(4);
        hashTable5.add(3);
        hashTable5.add(5);
        hashTable5.add(10);

        for (Iterator<Integer> i = hashTable5.iterator(); i.hasNext(); ) {
            Integer number = i.next();
            System.out.println(number);
        }
    }
}
