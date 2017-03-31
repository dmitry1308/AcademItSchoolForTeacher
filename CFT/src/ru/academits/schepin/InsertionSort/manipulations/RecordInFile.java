package ru.academits.schepin.InsertionSort.manipulations;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class RecordInFile {
    public static void recordInFile(ArrayList list, String outPutPath) {
        try (PrintWriter writer = new PrintWriter(outPutPath)) {
            for (int i=0 ; i<list.size();++i) {
                writer.println(list.get(i));
            }
        } catch (FileNotFoundException e) {
            System.out.println("Список не записан в файл(проверьте путь)");
        }
    }

}
