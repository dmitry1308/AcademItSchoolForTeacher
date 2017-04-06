package ru.academits.shepin.myArrayList;

public class Main {

    public static void main(String[] args) {


        MyArrayList<String> listOfString = new MyArrayList<>();
        System.out.println(listOfString.isEmpty());

        for (int i = 0; i < 20; i++) {

            listOfString.add(String.valueOf(i));
            System.out.printf("Size: %d  Capacity: %d%n", listOfString.getSize(), listOfString.getCapacity());
        }
        System.out.println("**********************************************************************************");
        for (int i = 0; i < listOfString.getSize(); i++) {

            System.out.println(listOfString.get(i));
        }
        System.out.println("**********************************************************************************");


        System.out.printf("Size: %d  Capacity: %d%n", listOfString.getSize(), listOfString.getCapacity());
        System.out.println("**********************************************************************************");

        listOfString.set(1, "Hello");
        System.out.println(listOfString);
        System.out.println("**********************************************************************************");

        listOfString.remove(2);
        System.out.println("Removing...");
        System.out.println("**********************************************************************************");

        for (int i = 0; i < listOfString.getSize(); i++) {

            System.out.printf("%s%n", listOfString.get(i));
        }
        System.out.format("Size: %d  Capacity: %d%n", listOfString.getSize(), listOfString.getCapacity());
        listOfString.insert(1, "Bye.");
        System.out.println(listOfString);

        listOfString.trimToSize();
        System.out.println(listOfString);
    }

}
