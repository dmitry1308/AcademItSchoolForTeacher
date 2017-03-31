package ru.academits.schepin.shapes;

import java.util.Arrays;


public class ShapeUtilities {
    public static Shape findMaximumArea(Shape[] allShapes) {
        Shape bestShape = allShapes[0];
        for (int i = 1; i < allShapes.length; ++i) {
            if (bestShape.getArea() < allShapes[i].getArea()) {
                bestShape = allShapes[i];
            }
        }
        return bestShape;
    }


    public static Shape findSecondMaximumPerimeter(Shape[] allShapes) {
        Arrays.sort(allShapes, new PerimeterComparator());
        return allShapes[1];
    }
}












