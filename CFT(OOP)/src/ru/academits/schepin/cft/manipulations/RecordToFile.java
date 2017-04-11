package ru.academits.schepin.cft.manipulations;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class RecordToFile {
    public static void record(ArrayList <?>  list, String outPutPath) {
        try (PrintWriter writer = new PrintWriter(outPutPath)) {
            list.forEach(writer::println);
        } catch (FileNotFoundException e) {
            System.out.println("Список не записан в файл(проверьте путь)");
        }
    }

}
