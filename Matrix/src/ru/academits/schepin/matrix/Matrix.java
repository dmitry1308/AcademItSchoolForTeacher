package ru.academits.schepin.matrix;

import java.util.Vector;

public class Matrix {

    private Vector[] data;

    public Matrix(int n, int m) {
        data = new Vector[n];

        for (int i = 0; i < n; i++) {

            data[i] = new Vector(m);
            for (int j = 0; j < m; j++) {
                data[i].add(0);
            }
        }
    }

    public Matrix(Matrix matrix) {
        data = new Vector[matrix.data.length];

        for (int i = 0; i < data.length; i++) {
            data[i] = new Vector(matrix.data[0].size());

            for (int j = 0; j < matrix.data[i].size(); j++) {
                data[i].add(matrix.data[i].get(j));
            }
        }
    }

    public Matrix(double[][] m) {
        data = new Vector[m.length];
        for (int i = 0; i < data.length; i++) {
            data[i] = new Vector(m[0].length);

            for (int j = 0; j < m[i].length; j++) {
                data[i].add(m[i][j]);
            }
        }
    }

    public Matrix(Vector[] rows) {
        int columns = rows[0].size();
        data = new Vector[rows. length];

        for (int i = 0; i < data.length; i++) {
            data[i] = new Vector(columns);

            for (int j = 0; j < columns; j++) {
                data[i].add((rows[i].get(j)));
            }
        }
    }

    public int[] getDimensions() {
        int[] dims = {data.length, data[0].size()};
        return dims;
    }

    public Vector getRowCopy(int index) {
        if (index < 0 || index >= data.length) {
            throw new IllegalArgumentException("Индекс строки  некорректен!");
        }

        Vector newRow = new Vector(data[index]);

        return newRow;
    }

    public void setRow(int index, Vector newRow) {
        if (index < 0 || index >= data.length) {
            throw new IllegalArgumentException("Индекс строки некорректен!");
        }

        if (newRow.size() != data[0].size()) {
            throw new IllegalArgumentException("Размер новой строки некорректен!");
        }

        data[index] = newRow;
    }

    public double[] getColumnCopy(int index) {
        if (index < 0 || index >= data[0].size()) {
            throw new IllegalArgumentException("Индекс столбца некорректен!");
        }

        double[] newColumn = new double[data.length];

        for (int i = 0; i < newColumn.length; i++) {
            newColumn[i] = (Double) data[i].get(index);
        }
        return newColumn;
    }


    private double get(int i, int j) {
        return (Double) data[i].get(j);
    }


    private void set(int i, int j, double d) {
        data[i].set(j, d);
    }


    public void transpose() {
        if (data.length != data[0].size()) {
            throw new IllegalStateException("Транспонирование неквадратных матриц не определено!");
        }

        for (int i = 1; i < data.length; i++) {

            for (int j = 0; j < i; j++) {
                double t = get(i, j);
                set(i, j, get(j, i));
                set(j, i, t);
            }
        }
    }

    public void multiplyByScalar(double k) {
        for (int i = 0; i < data.length; i++) {

            for (int j = 0; j < data[0].size(); j++) {
                set(i, j, get(i, j) * k);
            }
        }
    }

    public double determinant() {
        if (data.length != data[0].size()) {
            throw new IllegalStateException("Определитель неквадратных матриц не существует!");
        }


        if (data.length == 1) {
            return get(0, 0);
        }

        if (data.length == 2) {
            return get(0, 0) * get(1, 1) - get(1, 0) * get(0, 1);
        }

        if (data.length == 3) {
            return get(0, 0) * get(1, 1) * get(2, 2) + get(0, 1) * get(1, 2) * get(2, 0) + get(1, 0) * get(2, 1) * get(0, 2) -
                    get(2, 0) * get(1, 1) * get(0, 2) - get(0, 0) * get(2, 1) * get(1, 2) - get(1, 0) * get(0, 1) * get(2, 2);
        } else {

            double result = 0;
            for (int i = 0; i < data.length; i++) {

                Matrix m = new Matrix(data.length - 1, data.length - 1);
                int step = 0;

                for (int j = 0; j < data.length; j++) {

                    if (j == i) {
                        step = 1;
                        continue;
                    }

                    for (int k = 1; k < data.length; k++) {
                        m.set(j - step, k - 1, get(j, k));
                    }
                }
                double d = m.determinant();

                result += get(i, 0) * d * Math.pow(-1, i);
            }
            return result;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("{");
        for (int i = 0; i < data.length; i++) {

            sb.append("{");
            for (int j = 0; j < data[0].size(); j++) {
                sb.append(data[i].get(j));
                if (j < data[0].size() - 1) sb.append(" ");
            }

            sb.append("}");
            if (i < data.length - 1) sb.append(",");
        }
        sb.append("}");

        return sb.toString();
    }

    public Vector<Double> multiplyByVector(Vector<Double> vector) {
        if (vector.size() != data[0].size()) {

            throw new IllegalArgumentException("Длина вектора должна совпадать с длиной строки матрицы!");
        }

        Vector<Double> result = new Vector<>(data.length);
        for (int i = 0; i < data.length; i++) {
            double sum = 0;

            for (int j = 0; j < data[i].size(); j++) {
                sum += get(i, j) * vector.get(j);
            }
            result.add(sum);
        }
        return result;
    }

    public void add(Matrix m) {

        if (m.data.length != data.length || m.data[0].size() != data[0].size()) {

            throw new IllegalArgumentException("Сложение матриц разного размера запрещено!");
        }
        for (int i = 0; i < data.length; i++) {

            for (int j = 0; j < data[i].size(); j++) {

                set(i, j, get(i, j) + m.get(i, j));
            }
        }
    }


    public void subtraction(Matrix m) {

        if (m.data.length != data.length || m.data[0].size() != data[0].size()) {

            throw new IllegalArgumentException("Сложение матриц разного размера запрещено!");
        }
        for (int i = 0; i < data.length; i++) {

            for (int j = 0; j < data[i].size(); j++) {

                set(i, j, get(i, j) - m.get(i, j));
            }
        }
    }


    public static Matrix add(Matrix a, Matrix b) {

        if (a.data.length != b.data.length || a.data[0].size() != b.data[0].size()) {

            throw new IllegalArgumentException("Сложение матриц разного размера запрещено!");
        }

        Matrix c = new Matrix(a.data.length, a.data[0].size());

        for (int i = 0; i < a.data.length; i++) {

            for (int j = 0; j < a.data[i].size(); j++) {

                c.set(i, j, a.get(i, j) + b.get(i, j));
            }
        }

        return c;
    }


    public static Matrix subtraction(Matrix a, Matrix b) {

        if (a.data.length != b.data.length || a.data[0].size() != b.data[0].size()) {

            throw new IllegalArgumentException("Сложение матриц разного размера запрещено!");
        }

        Matrix c = new Matrix(a.data.length, a.data[0].size());

        for (int i = 0; i < a.data.length; i++) {

            for (int j = 0; j < a.data[i].size(); j++) {

                c.set(i, j, a.get(i, j) - b.get(i, j));
            }
        }

        return c;
    }


    public static Matrix multiplication(Matrix a, Matrix b) {

        if (a.data.length != b.data.length || a.data[0].size() != b.data[0].size()) {

            throw new IllegalArgumentException("Сложение матриц разного размера запрещено!");
        }

        Matrix c = new Matrix(a.data.length, a.data[0].size());

        for (int i = 0; i < a.data.length; i++) {

            for (int j = 0; j < a.data[i].size(); j++) {

                c.set(i, j, a.get(i, j) * b.get(i, j));
            }
        }

        return c;
    }

}

































