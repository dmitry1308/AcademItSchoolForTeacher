package ru.academits.schepin.InsertionSort;

import ru.academits.schepin.InsertionSort.Exceptions.WrongTransferredFileException;
import ru.academits.schepin.InsertionSort.comparators.IntegerComparator;
import ru.academits.schepin.InsertionSort.comparators.StringComparator;
import ru.academits.schepin.InsertionSort.manipulations.ReadFileFromNumbers;
import ru.academits.schepin.InsertionSort.manipulations.ReadFileFromStrings;
import ru.academits.schepin.InsertionSort.manipulations.Sort;

import java.util.ArrayList;

import static ru.academits.schepin.InsertionSort.manipulations.RecordToFile.recordInFile;


public class Main {
    public static void main(String[] args) {
        if (args.length != 4) {
            System.out.println("Недостаточно переданных параметров!" + System.lineSeparator() +
                    "Help!" + System.lineSeparator() +
                    " - колличество параметров должно быть:  4;" + System.lineSeparator() +
                    " - параметр №1: путь к обрабатываемому файлу;" + System.lineSeparator() +
                    " - параметр №2: путь для записи данных в файл;" + System.lineSeparator() +
                    " - параметр №3 (сортировка): возростание(-a) или убывание (-d);" + System.lineSeparator() +
                    " - параметр №4 (тип данных): цифры(-i) или строки (-s);");
            return;
        }

        String sourcePath = args[0];
        String outputPath = args[1];
        String ascendingOrDecrease = args[2];
        String dataType = args[3];

        String numbers = "-i";
        String letters = "-s";

        String ascending = "-a";
        String decrease = "-d";

        try {

            boolean isNumbers;
            if (dataType.equals(numbers)) {
                isNumbers = true;
            } else if (dataType.equals(letters)) {
                isNumbers = false;
            } else {
                throw new IllegalArgumentException("Введен неправильный тип данных(аргумент №4)." + System.lineSeparator() +
                        "Должен быть -i или -s.");
            }

            boolean isAscending;
            if (ascendingOrDecrease.equals(ascending)) {
                isAscending = true;
            } else if (ascendingOrDecrease.equals(decrease)) {
                isAscending = false;
            } else {
                throw new IllegalArgumentException("Введен неправильный аргумент возростания-убывания(аргумент №3)." + System.lineSeparator() +
                        "Должен быть -a  или -d.");
            }


            if (isNumbers) {
                ArrayList<Integer> listFromNumbers = ReadFileFromNumbers.readFile(sourcePath);
                if (listFromNumbers == null) {
                    throw new WrongTransferredFileException("Ошибка из-за переданного файла");
                }

                if (isAscending) {
                    Sort.sort(listFromNumbers, new IntegerComparator());
                } else {
                    Sort.sort(listFromNumbers, new IntegerComparator().reversed());
                }
                recordInFile(listFromNumbers, outputPath);

            } else {

                ArrayList<String> listFromStrings = ReadFileFromStrings.readFile(sourcePath);
                if (listFromStrings == null) {
                    throw new WrongTransferredFileException("Ошибка из-за переданного файла");
                }

                if (isAscending) {
                    Sort.sort(listFromStrings, new StringComparator());
                } else {
                    Sort.sort(listFromStrings, new StringComparator().reversed());
                }
                recordInFile(listFromStrings, outputPath);
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e);
        } catch (WrongTransferredFileException e) {
            System.out.println("Файл содержит недопустимую информацию(поменяйте содержимое файла)!!!");
        }
    }
}
