package ru.academits.shepin.myArrayList;

import java.util.Arrays;
import java.util.Iterator;
import java.util.ListIterator;

public class Main {

    public static void main(String[] args) {

        MyArrayList<Integer> listOfNumbers = new MyArrayList<>(10);
        listOfNumbers.add(4);
        listOfNumbers.add(2);
        listOfNumbers.add(5);
        listOfNumbers.add(null);

        System.out.println("listOfNumbers = " + listOfNumbers);
        System.out.println();
        System.out.println("size listOfNumbers = " + listOfNumbers.size());
        System.out.println();

        System.out.println("Удаление элемента из списка: ");
        System.out.println("listOfNumbers = " + listOfNumbers);
        boolean a = listOfNumbers.remove(null);
        System.out.println(a);
        System.out.println("listOfNumbers = " + listOfNumbers);
        System.out.println();


        System.out.println("add(int index, T object) и удалить этот индекс");
        System.out.println("listOfNumbers = " + listOfNumbers);
        listOfNumbers.add(1, 256);
        Integer g = listOfNumbers.remove(1);
        System.out.println(g);
        System.out.println("listOfNumbers = " + listOfNumbers);


        System.out.println("toArray(): ");
        System.out.println("listOfNumbers = " + listOfNumbers);
        Object[] array8 = listOfNumbers.toArray();
        System.out.println(Arrays.toString(array8));
        System.out.println();


        System.out.println("addAll(Collection<? extends T> c)  ");
        MyArrayList<Integer> listOfNumbers2 = new MyArrayList<>(5);
        listOfNumbers2.add(1);
        listOfNumbers2.add(9);
        listOfNumbers2.add(25);
        System.out.println("listOfNumbers2 = " + listOfNumbers2);
        System.out.println("listOfNumbers = " + listOfNumbers);
        System.out.println(listOfNumbers.addAll(listOfNumbers2));
        System.out.println("listOfNumbers = " + listOfNumbers);

        System.out.println("addAll(index ,Collection<? extends T> c)  ");
        System.out.println(listOfNumbers.addAll(2, listOfNumbers2));
        System.out.println("listOfNumbers = " + listOfNumbers);
        System.out.println();


        System.out.println("containsAll(Collection c) ");
        MyArrayList<Integer> listOfNumbers4 = new MyArrayList<>();
        listOfNumbers4.add(5);
        listOfNumbers4.add(3);
        listOfNumbers4.add(4);
        listOfNumbers4.add(2);
        System.out.println("listOfNumbers4 = " + listOfNumbers4);


        MyArrayList<Integer> listOfNumbers5 = new MyArrayList<>();
        listOfNumbers5.add(5);
        listOfNumbers5.add(3);
        listOfNumbers5.add(2);
        listOfNumbers5.add(4);
        listOfNumbers5.add(4);
        System.out.println("listOfNumbers5 = " + listOfNumbers5);
        System.out.println(listOfNumbers4.containsAll(listOfNumbers5));
        System.out.println();


        System.out.println(" listOfNumbers4 retain all listOfNumbers5:");
        System.out.println("listOfNumbers4 = " + listOfNumbers4);
        System.out.println("listOfNumbers5 = " + listOfNumbers5);
        System.out.println(listOfNumbers4.retainAll(listOfNumbers5));
        System.out.println();


        for (Iterator<Integer> i = listOfNumbers4.iterator(); i.hasNext(); ) {
            Integer text = i.next();
            System.out.println(text + " ");
        }
        System.out.println();

        System.out.println("Получение индекса по значению 4");

        int index = listOfNumbers5.indexOf(4);
        System.out.println("listOfNumbers5 = " + listOfNumbers5);
        System.out.printf("index = %d%n%n", index);


        System.out.println("listIterator.next");
        ListIterator<Integer> listIterator = listOfNumbers5.listIterator();
        while (listIterator.hasNext()) {
            Integer b = listIterator.next();
            System.out.print(b + " ");
        }
        System.out.println("");
        System.out.println();

        System.out.println("listIterator.hasPrevious");
        while (listIterator.hasPrevious()) {
            Integer n = listIterator.previous();
            System.out.print(n + " ");
        }
        System.out.println("");
        System.out.println();


        System.out.println("listIterator.nextIndex");
        while (listIterator.hasNext()) {
            Integer b = listIterator.nextIndex();
            System.out.print(b + " ");
        }
        System.out.println("");
        System.out.println();


        System.out.println("listIterator.previousIndex");
        while (listIterator.hasPrevious()) {
            Integer b = listIterator.previousIndex();
            System.out.print(b + " ");
        }
        System.out.println("");
        System.out.println();


        System.out.println("listIterator.add(5)");
        System.out.println("listOfNumbers5 = " + listOfNumbers5);
        listIterator.add(5);
        System.out.println("listOfNumbers5 = " + listOfNumbers5);
        System.out.println();


        System.out.println("Использование listIterator и умножение кажд элемента на 2");
        System.out.println("listOfNumbers5 = " + listOfNumbers5);
        while (listIterator.hasNext()) {
            Integer r = listIterator.next();
            listIterator.set(r * 2);
        }
        System.out.println("listOfNumbers5(*2) : " + listOfNumbers5);
        System.out.println();

        System.out.println("Включает ли listOfNumbers4 значение 2: ");
        Integer p = 2;
        System.out.println(listOfNumbers4.indexOf(p));
        System.out.println(listOfNumbers4.contains(2));
        System.out.println();


        System.out.println("removeAll(collection)");
        MyArrayList<Integer> listOfNumbers6 = new MyArrayList<>();
        listOfNumbers6.add(1);
        listOfNumbers6.add(2);
        listOfNumbers6.add(3);
        listOfNumbers6.add(4);
        listOfNumbers6.add(4);
        System.out.println("listOfNumbers6 = " + listOfNumbers6);

        MyArrayList<Integer> listOfNumbers7 = new MyArrayList<>();
        listOfNumbers7.add(1);
        listOfNumbers7.add(2);
        listOfNumbers7.add(3);
        listOfNumbers7.add(4);
        System.out.println("listOfNumbers7 = " + listOfNumbers7);
        System.out.println(listOfNumbers6.removeAll(listOfNumbers7));
        System.out.println("listOfNumbers6 = " + listOfNumbers6);
        System.out.println();


        System.out.println("toArray(Object[] a)");
        Integer[] array = new Integer[3];
        System.out.println("listOfNumbers7 = " + listOfNumbers6);
        Object[] array1 = listOfNumbers7.toArray(array);
        System.out.println("array1= ");
        for (Object c: array1) {
            System.out.print(c+" ");
        }
        System.out.println("Стереть весь список: ");
        System.out.println("listOfNumbers5 = " + listOfNumbers5);
        listOfNumbers5.clear();
        System.out.println("listOfNumbers5 = " + listOfNumbers5);
    }


}
