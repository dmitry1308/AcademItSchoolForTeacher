package ru.academits.schepin.InsertionSort.manipulations;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import java.util.InputMismatchException;
import java.util.Scanner;


public class ReadFileFromNumbers {
    public static ArrayList <Integer> readFile(String sourcePath) {

        //todo Создание сканера:

        try (Scanner scanner = new Scanner(new FileInputStream(sourcePath))) {
            //todo Чтение файла из сканера
            ArrayList<Integer> listOfNumbers = new ArrayList<>(); // Создаю пустой список интеджеров:
            while (scanner.hasNextInt()) {
                listOfNumbers.add(scanner.nextInt());
            }
            return listOfNumbers;
        } catch (FileNotFoundException e) {
            System.out.println("Не найден файл: " + sourcePath);
        }catch (InputMismatchException e){
            System.out.println("Файл содержит недопустимую информацию(поменяйте содержимое файла)!!!");
        }
        return null;
    }
}
