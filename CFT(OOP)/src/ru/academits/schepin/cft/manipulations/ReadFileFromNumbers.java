package ru.academits.schepin.cft.manipulations;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class ReadFileFromNumbers {
    public static ArrayList<Integer> readFile(String sourcePath){

        try (Scanner scanner = new Scanner(new FileInputStream(sourcePath))) {

            ArrayList<Integer> listOfNumbers = new ArrayList<>(); // Создаю пустой список интеджеров:
            while (scanner.hasNextInt()) {
                listOfNumbers.add(scanner.nextInt());
            }
            return listOfNumbers;
        } catch (FileNotFoundException e) {
            System.out.println("Не найден путь к файлу: " + sourcePath);
        }
        return null;
    }
}
