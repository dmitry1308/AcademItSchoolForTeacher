package ru.academits.schepin.matrix;

import java.util.Vector;

public class Matrix {
    private double[][] array;

    public Matrix(int n, int m) {
        if (n < 0 && m < 0) {
            throw new IllegalArgumentException("Некорректный индекс");
        }
        array = new double[n][m];
    }

    public Matrix(double[][] vector) {
        this.array = vector;
    }

    public Matrix(Vector[] a) {
        //// TODO:
    }

    public Matrix(Matrix m) {
        double[][] array1 = new double[m.getSize()][];
        for (int i=0;i<m.getSize();++i){

        }
    }


    public int getSize(){
        return array.length;
    }

    public String toString() {
        StringBuilder a = new StringBuilder();
        for (int i = 0; i < array.length; ++i) {
            a.append("[");
            a.append(i + 1);
            a.append("]");
            a.append("[");
            a.append(array.length);
            a.append("]");
            a.append("-->  ");
            for (int j = 0; j < array[i].length; ++j) {
                a.append(array[i][j]);
                a.append(", ");
            }
            a.deleteCharAt(a.length() - 2);
            a.append("  ");
        }
        return a.toString();
    }
}
