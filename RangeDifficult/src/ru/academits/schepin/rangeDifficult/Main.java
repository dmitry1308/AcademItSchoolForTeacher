package ru.academits.schepin.rangeDifficult;


public class Main {

    public static void main(String[] args) {
        Range r1 = new Range(-20, 15);

        Range[] allRanges = new Range[6];
        allRanges[0] = new Range(-40, 100);
        allRanges[1] = new Range(20, 40);
        allRanges[2] = new Range(0, 28);
        allRanges[3] = new Range(-50, -5);
        allRanges[4] = new Range(-10, 5);
        allRanges[5] = new Range(-20, 20);

        //Пересечение интервалов:
        for (int i = 0; i < allRanges.length; i++) {
            r1.print();
            System.out.print(" INTERSECTION ");
            allRanges[i].print();
            System.out.print(" = ");

            Range result = allRanges[i].intersection(r1);
            if (result == null) {
                System.out.print("Пересечения нет");
            } else {
                result.print();
            }
            System.out.println();
        }
        System.out.println("****************************************************************");


        //Объединение интервалов:
        for (int i = 0; i < allRanges.length; i++) {
            r1.print();
            System.out.print(" UNION ");
            allRanges[i].print();
            System.out.print(" = ");

            Range[] result = allRanges[i].union(r1);
            if (result == null) {
                System.out.print("Пересечения нет");
            } else {
                for (int j = 0; j < result.length; ++j) {
                    result[j].print();
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
        System.out.println("****************************************************************");


        //Разность интервалов:
        for (int i = 0; i < allRanges.length; i++) {
            r1.print();
            System.out.print(" SUBTRACT ");
            allRanges[i].print();
            System.out.print(" = ");

            Range[] result = allRanges[i].subtract(r1);

            for (int j = 0; j < result.length; ++j) {
                result[j].print();
                System.out.print("  ");
            }

            System.out.println();
        }
    }
}