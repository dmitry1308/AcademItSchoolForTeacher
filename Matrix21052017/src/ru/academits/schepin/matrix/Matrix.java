package ru.academits.schepin.matrix;


public class Matrix extends Vector {
    private Vector[] lines;

    public Matrix(int numberOfLines, int numberOfColumns) {
        lines = new Vector[numberOfLines];
        for (int i = 0; i < numberOfLines; i++) {
            lines[i] = new Vector(numberOfColumns);
        }
    }


    public Matrix(Vector[] rows) {
        lines = new Vector[rows.length];
        for (int i = 0; i < lines.length; i++) {
            lines[i] = rows[i];
        }
    }


    public Matrix(double[][] m) {
        lines = new Vector[m.length];
        for (int i = 0; i < lines.length; i++) {
            lines[i] = new Vector(m[i]);
        }
    }


    public Matrix(Matrix matrix) {
        lines = new Vector[matrix.lines.length];
        for (int i = 0; i < lines.length; i++) {
            lines[i] = new Vector(matrix.lines[i]);
        }
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (int i = 0; i < lines.length; i++) {
            sb.append(lines[i]);
            if (i < lines.length - 1) sb.append(",");
        }
        sb.append("}");

        return sb.toString();
    }


    public int[] getDimensions() {
        return new int[]{lines.length, lines[0].getSize()};
    }

    public Vector getRowCopy(int index) {
        if (index < 0 || index >= lines.length) {
            throw new IllegalArgumentException("Индекс строки  некорректен!");
        }
        return new Vector(lines[index]);
    }


    public void setRow(int index, Vector newRow) {
        if (index < 0 || index >= lines.length) {
            throw new IllegalArgumentException("Индекс строки некорректен!");
        }

        if (newRow.getSize() != lines[0].getSize()) {
            throw new IllegalArgumentException("Размер новой строки некорректен!");
        }

        lines[index] = newRow;
    }

    public double[] getColumnCopy(int index) {
        if (index < 0 || index >= lines[0].getSize()) {
            throw new IllegalArgumentException("Индекс столбца некорректен!");
        }

        double[] newColumn = new double[lines.length];

        for (int i = 0; i < newColumn.length; i++) {
            newColumn[i] = lines[i].getByIndex(index);
        }
        return newColumn;
    }


    public void multiplyByScalar(double k) {
        for (Vector line : lines) {
            line.scale(k);
        }
    }


    public static Matrix subtraction(Matrix a, Matrix b) {
        if (a.lines.length != b.lines.length || a.lines[0].getSize() != b.lines[0].getSize()) {
            throw new IllegalArgumentException("Сложение матриц разного размера запрещено!");
        }

        Matrix c = new Matrix(a.lines.length, a.lines[0].getSize());
        for (int i = 0; i < a.lines.length; i++) {
            Vector copyOfVector = new Vector(a.lines[i]);
            c.lines[i] = copyOfVector.subtraction(b.lines[i]);
        }
        return c;
    }


    public static Matrix add(Matrix a, Matrix b) {
        if (a.lines.length != b.lines.length || a.lines[0].getSize() != b.lines[0].getSize()) {
            throw new IllegalArgumentException("Сложение матриц разного размера запрещено!");
        }

        Matrix c = new Matrix(a.lines.length, a.lines[0].getSize());
        for (int i = 0; i < a.lines.length; i++) {
            Vector copyOfVector = new Vector(a.lines[i]);
            c.lines[i] = copyOfVector.addition(b.lines[i]);
        }
        return c;
    }


    public void add(Matrix m) {
        if (m.lines.length != lines.length || m.lines[0].getSize() != lines[0].getSize()) {
            throw new IllegalArgumentException("Сложение матриц разного размера запрещено!");
        }

        for (int i = 0; i < lines.length; i++) {
            lines[i].addition(m.lines[i]);
        }
    }


    public void subtraction(Matrix m) {
        if (m.lines.length != lines.length || m.lines[0].getSize() != lines[0].getSize()) {
            throw new IllegalArgumentException("Сложение матриц разного размера запрещено!");
        }

        for (int i = 0; i < lines.length; i++) {
            lines[i].subtraction(m.lines[i]);
        }
    }


    private double get(int i, int j) {
        return lines[i].getByIndex(j);
    }


    private void set(int i, int j, double d) {
        lines[i].setByIndex(j, d);
    }

    public void transpose() {
        if (lines.length != lines[0].getSize()) {
            throw new IllegalStateException("Транспонирование неквадратных матриц не определено!");
        }

        for (int i = 1; i < lines.length; i++) {
            for (int j = 0; j < i; j++) {
                double t = get(i, j);
                set(i, j, get(j, i));
                set(j, i, t);
            }
        }
    }

    public Vector multiplyByVector(Vector vector) {
        if (vector.getSize() != lines[0].getSize()) {
            throw new IllegalArgumentException("Длина вектора должна совпадать с длиной строки матрицы!");
        }

        Vector result = new Vector(lines.length);
        for (int i = 0; i < lines.length; i++) {
            double sum = 0;

            for (int j = 0; j < lines[i].getSize(); j++) {
                sum += get(i, j) * vector.getByIndex(j);
            }
            result.add(sum);
        }
        return result;
    }


    public static Matrix multiplication(Matrix a, Matrix b) {
        if (a.lines.length != b.lines.length || a.lines[0].getSize() != b.lines[0].getSize()) {
            throw new IllegalArgumentException("Сложение матриц разного размера запрещено!");
        }

        Matrix c = new Matrix(a.lines.length, a.lines[0].getSize());
        for (int i = 0; i < a.lines.length; i++) {

            for (int j = 0; j < a.lines[i].getSize(); j++) {
                c.set(i, j, a.get(i, j) * b.get(i, j));
            }
        }
        return c;
    }


    public double determinant() {
        if (lines.length != lines[0].getSize()) {
            throw new IllegalStateException("Определитель неквадратных матриц не существует!");
        }


        if (lines.length == 1) {
            return get(0, 0);
        }

        if (lines.length == 2) {
            return get(0, 0) * get(1, 1) - get(1, 0) * get(0, 1);
        }

        if (lines.length == 3) {
            return get(0, 0) * get(1, 1) * get(2, 2) + get(0, 1) * get(1, 2) * get(2, 0) + get(1, 0) * get(2, 1) * get(0, 2) -
                    get(2, 0) * get(1, 1) * get(0, 2) - get(0, 0) * get(2, 1) * get(1, 2) - get(1, 0) * get(0, 1) * get(2, 2);
        } else {

            double result = 0;
            for (int i = 0; i < lines.length; i++) {
                Matrix m = new Matrix(lines.length - 1, lines.length - 1);
                int step = 0;

                for (int j = 0; j < lines.length; j++) {
                    if (j == i) {
                        step = 1;
                        continue;
                    }

                    for (int k = 1; k < lines.length; k++) {
                        m.set(j - step, k - 1, get(j, k));
                    }
                }
                double d = m.determinant();
                result += get(i, 0) * d * Math.pow(-1, i);
            }
            return result;
        }
    }

}


















































