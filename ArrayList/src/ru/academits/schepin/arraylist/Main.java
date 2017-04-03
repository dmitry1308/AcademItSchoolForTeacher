package ru.academits.schepin.arraylist;

public class Main {
    public static void main(String[] args) {
        MyArray numbers = new MyArray();
        numbers.add(895);
        numbers.add(2365);
        numbers.add(51);
        numbers.add(25);
        numbers.add(89);
        numbers.set(2, 69);

        System.out.println("Список = " + numbers);

        int a = numbers.get(0);
        System.out.println("Элемент под индексом 0 = " + a);

        System.out.println(numbers.isEmpty());

        System.out.println("Кол-во элементов в списке = " + numbers.size());


        numbers.insert(4, 14);
        System.out.println(numbers);
        numbers.insert(5, 45);
        System.out.println(numbers);
        numbers.remove(6);
        System.out.println(numbers);

        System.out.println(numbers.size());

        numbers.trimToSize();
        System.out.println(numbers);


    }
}
