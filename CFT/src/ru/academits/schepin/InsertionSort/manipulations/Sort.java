package ru.academits.schepin.InsertionSort.manipulations;


import java.util.Comparator;
import java.util.List;


public class Sort {
    public static <T> void sort(List<T> list, Comparator<T> comparator) {
        for (int i = 1; i < list.size(); ++i) {
            T temp = list.get(i);
            int j;
            for (j = i - 1; j >= 0 && (comparator.compare(list.get(j), temp) > 0); --j) {
                list.set(j + 1, list.get(j));

            }
            list.set(j + 1, temp);
        }

    }
}
