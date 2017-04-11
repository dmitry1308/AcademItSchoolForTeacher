package ru.academits.schepin.cft;

import ru.academits.schepin.cft.manipulations.WorkOnFile;

public class Main {
    public static void main(String[] args) {
        if (args.length != 4) {
            System.out.println("Недостаточно переданных параметров!" + System.lineSeparator() +
                    "Help!" + System.lineSeparator() +
                    " - колличество параметров должно быть:  4;" + System.lineSeparator() +
                    " - параметр №1: путь к обрабатываемому файлу;" + System.lineSeparator() +
                    " - параметр №2: путь для записи данных в файл;" + System.lineSeparator() +
                    " - параметр №3 (тип данных): цифры(-i) или строки (-s);" + System.lineSeparator() +
                    " - параметр №4 (сортировка): возростание(-a) или убывание (-d);");
            return;
        }

        String sourcePath = args[0];
        String outPutPath = args[1];
        String ascendingOrDecrease = args[2];
        String dataType = args[3];

        WorkOnFile file1 = new WorkOnFile(sourcePath, outPutPath, ascendingOrDecrease, dataType);
        file1.sortAndRecord();
    }
}
