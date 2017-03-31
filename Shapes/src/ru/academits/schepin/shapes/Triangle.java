package ru.academits.schepin.shapes;


public class Triangle implements Shape {
    private double x1;
    private double x2;
    private double x3;
    private double y1;
    private double y2;
    private double y3;

    public Triangle(double x1, double y1, double x2, double y2, double x3, double y3) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.x3 = x3;
        this.y3 = y3;
    }

    public double getX1() {
        return x1;
    }

    public void setX1(double x1) {
        this.x1 = x1;
    }

    public double getX2() {
        return x2;
    }

    public void setX2(double x2) {
        this.x2 = x2;
    }

    public double getX3() {
        return x3;
    }

    public void setX3(double x3) {
        this.x3 = x3;
    }

    public double getY1() {
        return y1;
    }

    public void setY1(double y1) {
        this.y1 = y1;
    }

    public double getY2() {
        return y2;
    }

    public void setY2(double y2) {
        this.y2 = y2;
    }

    public double getY3() {
        return y3;
    }

    public void setY3(double y3) {
        this.y3 = y3;
    }


    @Override
    public double getWidth() {
        double xR = Math.max(x2, x1);
        xR = Math.max(xR, x3);

        double xL = Math.min(x1, x2);
        xL = Math.min(xL, x3);

        return xR - xL;
    }

    @Override
    public double getHeight() {
        double yU = Math.max(y2, y1);
        yU = Math.max(yU, y3);

        double yD = Math.min(y1, y2);
        yD = Math.min(yD, y3);

        return yU - yD;
    }

    private static double findLengthOfSegment(double xEnd, double xStart, double yEnd, double yStart) {
        return Math.sqrt(Math.pow((xEnd - xStart), 2) + Math.pow((yEnd - yStart), 2));
    }

    @Override
    public double getArea() {
        double a = findLengthOfSegment(x2, x1, y2, y1);
        double b = findLengthOfSegment(x3, x2, y3, y2);
        double c = findLengthOfSegment(x3, x1, y3, y1);
        double p = (a + b + c) / 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    @Override
    public double getPerimeter() {
        double a = findLengthOfSegment(x2, x1, y2, y1);
        double b = findLengthOfSegment(x3, x2, y3, y2);
        double c = findLengthOfSegment(x3, x1, y3, y1);
        return a + b + c;
    }


    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o == null || o.getClass() != this.getClass()){
            return false;
        }
        Triangle t = (Triangle) o;
        return x1 == t.x1 && x2 == t.x2 && x3 == t.x3 && y1 == t.y1 && y2 == t.y2 && y3 == t.y3;
    }

    @Override
    public String toString() {
        double a = findLengthOfSegment(x2, x1, y2, y1);
        double b = findLengthOfSegment(x3, x2, y3, y2);
        double c = findLengthOfSegment(x3, x1, y3, y1);
        return String.format("Треугольник со сторонами: %.3f x %.3f x %.3f", a, b, c);
    }

    @Override
    public int hashCode() {
        return 31 * (int) x1 + 117 * (int) y1 + 31 * (int) x2 + 117 * (int) y2 + 31 * (int) x3 + 117 * (int) y3;
    }
}










