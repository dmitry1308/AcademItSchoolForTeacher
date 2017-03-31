package ru.academits.schepin.range;

public class Main {
    public static void main(String[] args) {

        Range range1 = new Range(2, 5);
        System.out.println("Интервал 1: " + range1.length());

        Range range2 = new Range(-23, 56);
        System.out.println("Интервал 2: " + range2.length());


        System.out.println(range1.isInside(6));
        System.out.println(range2.isInside(2));
    }
}
