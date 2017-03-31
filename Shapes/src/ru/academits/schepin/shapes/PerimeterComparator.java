package ru.academits.schepin.shapes;

import java.util.Comparator;

public class PerimeterComparator implements Comparator<Shape> {
    @Override
    public int compare(Shape o1, Shape o2) {
        if (o1.getPerimeter() > o2.getPerimeter()) {
            return -1;
        } else if (o1.getPerimeter() == o2.getPerimeter()) {
            return 0;
        } else {
            return 1;
        }
    }
}
