package ru.academits.schepin.matrix;

import java.util.Arrays;
import java.util.Vector;
import java.util.concurrent.ThreadLocalRandom;

public class Main {

    public static void main(String[] args) {

        Vector<Double> z1 = new Vector<>();
        z1.add(2.5);
        z1.add(2.1);
        System.out.println("Вектор z1= " + z1);

        Vector<Double> z2 = new Vector<>();
        z2.add(2.2);
        z2.add(2.4);
        System.out.println("Вектор z2= " + z2);

        Vector[] arrayOfVector = {z1, z2};

        Matrix g = new Matrix(arrayOfVector);
        System.out.println("Матрица g= " + g);

        System.out.println("Умножение матрицы g на вектор z1(e = g * z1):");
        Vector e = g.multiplyByVector(z1);
        System.out.println("e= " + e);

        System.out.println("");

        Vector<Double> z3 = new Vector<>();
        z3.add(2.5);
        z3.add(2.1);
        System.out.println("Вектор z3= " + z3);

        Vector<Double> z4 = new Vector<>();
        z4.add(2.5);
        z4.add(2.1);
        System.out.println("Вектор z4= " + z4);

        Vector[] arrayOfVector1 = {z3, z4};

        Matrix g1 = new Matrix(arrayOfVector1);
        System.out.println("Матрица g1= " + g1);

        System.out.println(" ");

        System.out.println("Прибавление к матрице g1 к g");
        System.out.println("Матрица g1= " + g1);
        System.out.println("Матрица g= " + g);
        g.add(g1);
        System.out.println("Матрица g= " + g);

        System.out.println("");

        System.out.println("Сложение матриц g1 и g (g1 + g = g2)");
        System.out.println("Матрица g1= " + g1);
        System.out.println("Матрица g= " + g);
        Matrix g2 = Matrix.add(g, g1);
        System.out.println("Матрица g2= " + g2);

        System.out.println("");

        System.out.println("Вычитание из матрицы g1 матрицу g (g1 - g)");
        System.out.println("Матрица g1= " + g1);
        System.out.println("Матрица g= " + g);
        g1.subtraction(g);
        System.out.println("Матрица g= " + g1);

        System.out.println("");

        System.out.println("g - g1 = g3");
        System.out.println("Матрица g1= " + g1);
        System.out.println("Матрица g= " + g);
        Matrix g3 = Matrix.subtraction(g, g1);
        System.out.println("Матрица g3= " + g3);

        System.out.println("");

        System.out.println("g2 * g3 = g4");
        System.out.println("Матрица g3= " + g3);
        System.out.println("Матрица g2= " + g2);
        Matrix g4 = Matrix.multiplication(g2, g3);
        System.out.println("Матрица g4= " + g4);


        System.out.println(" ");
        System.out.println("Сложение матриц m1 + m2 = m3:");
        double[][] array = {{1, 0}, {2, 3}};
        double[][] array1 = {{0, 5}, {1, 8}};
        Matrix m1 = new Matrix(array);
        System.out.println("m1= " + m1);
        Matrix m2 = new Matrix(array1);
        System.out.println("m2= " + m2);

        Matrix m3 = Matrix.add(m1, m2);
        System.out.println("m3= " + m3);

        System.out.println(" ");


        Matrix m = new Matrix(4, 4);

        for (int i = 0; i < m.getDimensions()[0]; i++) {

            Vector<Double> vector = new Vector<>(4);

            for (int j = 0; j < 4; j++) {

                vector.add((double) ThreadLocalRandom.current().nextInt(10));
            }

            m.setRow(i, vector);
        }


        Matrix m4 = new Matrix(4, 4);

        for (int i = 0; i < m.getDimensions()[0]; i++) {

            Vector<Double> vector = new Vector<>(4);

            for (int j = 0; j < 4; j++) {

                vector.add((double) ThreadLocalRandom.current().nextInt(10));
            }

            m4.setRow(i, vector);
        }

        System.out.println("Сложение матриц m + m4 = m5:");
        System.out.println("m= " + m);
        System.out.println("m4= " + m4);

        Matrix m5 = Matrix.add(m, m4);

        System.out.println("m5= " + m5);

        System.out.println("\n" + "Определитель матрицы m = " + m.determinant());


        System.out.println("\n" +"Умножение матрицы m на скаляр:");
        System.out.println("m= " + m);
        m.multiplyByScalar(3);
        System.out.println("m * 3 = " + m);

        System.out.println("\n" +"Размер матицы m:");
        System.out.println("m = " + m);
        int []size = m.getDimensions();
        System.out.println("Размер m:"+ Arrays.toString(size));

        System.out.println("\n" +"Получение вектора столбца матрицы m5 по индексу 2:");
        System.out.println("m5= " + m5);
        double [] column=m5.getColumnCopy(2);
        System.out.println("Вектор столбец по индексу 2:"+ Arrays.toString(column));

        System.out.println("\n" +"Транспонирование матрицы g:");
        System.out.println("g= " + g);
        g.transpose();
        System.out.println("транспонированная матрица g  = " + g);

        System.out.println("\n" +"Задание вектора строки матрицы g по индексу 1 вектором z4:");
        System.out.println("g= " + g);
        System.out.println("z4= " + z4);
        g.setRow(1,z4);
        System.out.println("g"+ g);
    }



}
