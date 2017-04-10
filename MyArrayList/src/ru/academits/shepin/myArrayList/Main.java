package ru.academits.shepin.myArrayList;

public class Main {

    public static void main(String[] args) {


        MyArrayList<String> listOfString = new MyArrayList<>();
        System.out.println(listOfString.isEmpty());

        for (int i = 0; i < 20; i++) {

            listOfString.add(String.valueOf(i));
            System.out.printf("Size: %d  Capacity: %d%n", listOfString.size(), listOfString.getCapacity());
        }
        System.out.println("**********************************************************************************");
        for (int i = 0; i < listOfString.size(); i++) {

            System.out.println(listOfString.get(i));
        }
        System.out.println("**********************************************************************************");


        System.out.printf("Size: %d  Capacity: %d%n", listOfString.size(), listOfString.getCapacity());
        System.out.println("**********************************************************************************");

        // listOfString.set(1, "Hello");
        System.out.println(listOfString);
        System.out.println("**********************************************************************************");

        listOfString.remove(2);
        System.out.println("Removing...");
        System.out.println("**********************************************************************************");

        for (int i = 0; i < listOfString.size(); i++) {

            System.out.printf("%s%n", listOfString.get(i));
        }
        System.out.format("Size: %d  Capacity: %d%n", listOfString.size(), listOfString.getCapacity());
        listOfString.insert(1, "Bye.");
        System.out.println(listOfString);

        listOfString.trimToSize();
        System.out.println(listOfString);


        MyArrayList<Integer> listOfNumbers = new MyArrayList<>(2);
        listOfNumbers.add(4);
        listOfNumbers.add(2);
        listOfNumbers.add(5);

        System.out.println(listOfNumbers);
        System.out.println(listOfNumbers.size());

        listOfNumbers.add(7);
        listOfNumbers.trimToSize();
        System.out.println(listOfNumbers);

        System.out.println(listOfNumbers.indexOf(5));

       // System.out.println(listOfNumbers.lastIndex(5));

        //  listOfNumbers.removeElement(5);
        System.out.println(listOfNumbers);
        listOfNumbers.clear();

        listOfNumbers.add(5);
        listOfNumbers.add(4);
        listOfNumbers.add(6);
        listOfNumbers.add(6);
        listOfNumbers.add(6);
        listOfNumbers.add(6);
        listOfNumbers.add(6);
        listOfNumbers.add(6);
        listOfNumbers.add(6);

        System.out.println(listOfNumbers);


        System.out.println(listOfNumbers.size());
        System.out.println(listOfNumbers.contains(5));
        System.out.println(listOfNumbers.getCapacity());





    }

}
