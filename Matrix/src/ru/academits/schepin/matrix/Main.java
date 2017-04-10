package ru.academits.schepin.matrix;

public class Main {
    public static void main(String[] args) {

        Matrix a = new Matrix(5, 6);
        System.out.println(a);

        double[][] b = {{5, 4, 8, 9, 6, 3}, {5, 8, 7, 9, 6}};
        Matrix c = new Matrix(b);
        System.out.println(c);

        double[][] d = new double[2][3];
        d[0] = new double[]{8, 548, 78};
        d[1] = new double[]{5, 6, 9};
        Matrix e = new Matrix(d);
        System.out.printf("Матрица e: ( %s)%n ",e);

        double x = d[1][2];
        System.out.println(x);


    }
}
