package ru.academits.schepin.shapes;

public class Square implements Shape {
    private double side;

    public Square(double side) {
        this.side = side;
    }

    @Override
    public double getWidth() {
        return side;
    }

    @Override
    public double getHeight() {
        return side;
    }

    @Override
    public double getArea() {
        return side * side;
    }

    @Override
    public double getPerimeter() {
        return 4 * side;
    }


    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o == null || o.getClass() != this.getClass()){
            return false;
        }
        Square s = (Square) o;
        return side == s.side;
    }

    @Override
    public String toString() {
        return "Квадрат со стороной = " + side;
    }


    @Override
    public int hashCode() {
        return 31 * (int) side;
    }
}

