package ru.academits.schepin.InsertionSort.manipulations;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class ReadFileFromStrings {
    public static ArrayList<String> readFile(String sourcePath) {


        try (Scanner scanner = new Scanner(new FileInputStream(sourcePath))) {
            ArrayList<String> listOfLetters = new ArrayList<>();
            while (scanner.hasNextLine()) {
                listOfLetters.add(scanner.nextLine());
            }
            return listOfLetters;
        } catch (FileNotFoundException e) {
            System.out.println("Не найден файл: " + sourcePath);
        }
        return null;
    }
}
