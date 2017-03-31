package ru.academits.schepin.InsertionSort.manipulations;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import java.util.InputMismatchException;
import java.util.Scanner;


public class ReadFileFromStrings {
    public static ArrayList <String> readFile(String sourcePath) {
        //todo Создание сканера:

        try (Scanner scanner = new Scanner(new FileInputStream(sourcePath))) {
            ArrayList<String> listOfLetters = new ArrayList<>(); // Создаю пустой список интеджеров:
            //todo Чтение файла из сканера:
            while (scanner.hasNextLine()) {
                listOfLetters.add(scanner.nextLine());
            }
            return listOfLetters;
        } catch (FileNotFoundException e) {
            System.out.println("Не найден файл: " + sourcePath);
        } catch (InputMismatchException e){
            System.out.println("Файл содержит недопустимую информацию(поменяйте содержимое файла)!!!");
        }
        return null;
    }
}
