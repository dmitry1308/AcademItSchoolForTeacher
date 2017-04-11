package ru.academits.schepin.cft.manipulations;

import ru.academits.schepin.cft.comparators.IntegerComparator;
import ru.academits.schepin.cft.comparators.StringComparator;
import ru.academits.schepin.cft.exceptions.WrongTransferredFileException;

import java.util.ArrayList;

public class WorkOnFile {
    private String sourcePath;
    private String outPutPath;
    private String dataType;
    private String ascendingOrDecrease;


    public WorkOnFile(String sourcePath, String outputPath,
                      String dataType, String ascendingOrDecrease) {
        this.sourcePath = sourcePath;
        this.outPutPath = outputPath;
        this.dataType = dataType;
        this.ascendingOrDecrease = ascendingOrDecrease;
    }

    public String toString() {
        return String.format(" Путь к файлу = %s%n Путь для записи файла = %s%n Тип данных = %s%n Возростание или убывание = %s%n", sourcePath, outPutPath, dataType, ascendingOrDecrease);
    }

    public void sortAndRecord() {
        try {
            switch (dataType) {
                case "-i":
                    ArrayList<Integer> listFromNumbers = ReadFileFromNumbers.readFile(sourcePath);
                    if (listFromNumbers == null) {
                        throw new WrongTransferredFileException("Ошибка из-за переданного файла");
                    }
                    switch (ascendingOrDecrease) {
                        case "-a":
                            Sort.sort(listFromNumbers, new IntegerComparator());
                            RecordToFile.record(listFromNumbers, outPutPath);
                            break;
                        case "-d":
                            Sort.sort(listFromNumbers, new IntegerComparator().reversed());
                            RecordToFile.record(listFromNumbers, outPutPath);
                            break;
                        default:
                            throw new IllegalArgumentException("Введен неправильный аргумент возростания-убывания(аргумент №3)." + System.lineSeparator() +
                                    "Должен быть -a  или -d.");
                    }
                    break;
                case "-s":
                    ArrayList<String> listOfStrings = ReadFileFromStrings.readFile(sourcePath);
                    if (listOfStrings == null) {
                        throw new WrongTransferredFileException("Ошибка из-за переданного файла");
                    }
                    switch (ascendingOrDecrease) {
                        case "-a":
                            Sort.sort(listOfStrings, new StringComparator());
                            RecordToFile.record(listOfStrings, outPutPath);
                            break;
                        case "-d":
                            Sort.sort(listOfStrings, new StringComparator().reversed());
                            RecordToFile.record(listOfStrings, outPutPath);
                            break;
                        default:
                            throw new IllegalArgumentException("Введен неправильный аргумент возростания-убывания(аргумент №3)." + System.lineSeparator() +
                                    "Должен быть -a  или -d.");
                    }
                    break;
                default:
                    throw new IllegalArgumentException("Введен неправильный аргумент возростания-убывания(аргумент №3)." + System.lineSeparator() +
                            "Должен быть -a  или -d.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e);
        } catch (WrongTransferredFileException e) {
            System.out.println(" " + e);
        }
    }
}
