package ru.academits.schepin.InsertionSort;

import ru.academits.schepin.InsertionSort.Exceptions.WrongTransferredFileException;
import ru.academits.schepin.InsertionSort.comparators.IntegerComparator;
import ru.academits.schepin.InsertionSort.comparators.StringComparator;
import ru.academits.schepin.InsertionSort.manipulations.ReadFileFromNumbers;
import ru.academits.schepin.InsertionSort.manipulations.ReadFileFromStrings;
import ru.academits.schepin.InsertionSort.manipulations.Sort;

import java.util.ArrayList;
import java.util.InputMismatchException;

import static ru.academits.schepin.InsertionSort.manipulations.RecordInFile.recordInFile;


public class Main {
    public static void main(String[] args) {
        if (args.length != 4) {
            System.out.println("Недостаточно переданных параметров");
            return;
        }

        String sourcePath = args[0];
        String outputPath = args[1];
        String ascendingOrDecrease = args[2];
        String dataType = args[3];

        String numbers = "-i";
        String letters = "-s";


        boolean isNumbers;
        if (dataType.equals(numbers)) {
            isNumbers = true;
        } else if (dataType.equals(letters)) {
            isNumbers = false;
        } else {
            throw new IllegalArgumentException("Введен неправильный аргумент");
        }


        String ascending = "-a";
        String decrease = "-d";

        boolean isAscending;
        if (ascendingOrDecrease.equals(ascending)) {
            isAscending = true;
        } else if (ascendingOrDecrease.equals(decrease)) {
            isAscending = false;
        } else {
            throw new IllegalArgumentException("Введен неправильный аргумент");
        }

        try {

            if (isNumbers) {
                ArrayList<Integer> listFromNumbers = ReadFileFromNumbers.readFile(sourcePath);
                if (listFromNumbers == null) {
                    throw new WrongTransferredFileException("Ошибка из-за переданного файла");
                }
                System.out.println("Прочтенный файл: " + listFromNumbers);

                if (isAscending) {
                    Sort.sort(listFromNumbers, new IntegerComparator());
                    System.out.println("Отсортированный файл: " + listFromNumbers);
                } else {
                    Sort.sort(listFromNumbers, new IntegerComparator().reversed());
                    System.out.println("Отсортированный файл: " + listFromNumbers);
                }

                recordInFile(listFromNumbers, outputPath);

            } else {

                ArrayList<String> listFromStrings = ReadFileFromStrings.readFile(sourcePath);
                if (listFromStrings == null) {
                    throw new WrongTransferredFileException("Ошибка из-за переданного файла");
                }
                System.out.println("Прочтенный файл: " + listFromStrings);

                if (isAscending) {
                    Sort.sort(listFromStrings, new StringComparator());
                    System.out.println("Отсортированный файл: " + listFromStrings);
                } else {
                    Sort.sort(listFromStrings, new StringComparator().reversed());
                    System.out.println("Отсортированный файл: " + listFromStrings);
                }

                recordInFile(listFromStrings, outputPath);
            }
        } catch (InputMismatchException e) {
            System.out.println("Файл содержит недопустимую информацию(поменяйте содержимое файла)!!!");
        }
    }
}
