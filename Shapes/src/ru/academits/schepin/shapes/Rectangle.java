package ru.academits.schepin.shapes;

public class Rectangle implements Shape {


    private double width;
    private double height;

    public Rectangle(double width, double height) {

        this.width = width;
        this.height = height;
    }


    @Override
    public double getWidth() {
        return width;
    }

    @Override
    public double getHeight() {
        return height;
    }

    @Override
    public double getArea() {
        return width * height;
    }

    @Override
    public double getPerimeter() {
        return 2 * (width + height);
    }


    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o == null || o.getClass() != this.getClass()){
            return false;
        }
        Rectangle r = (Rectangle) o;
        return width == r.width && height == r.height;
    }

    @Override
    public String toString() {
        return "Прямоугольник со сторонами: " + width + " x " + height;
    }

    @Override
    public int hashCode() {
        return 31 * (int) width + 117 * (int) height;
    }
}
