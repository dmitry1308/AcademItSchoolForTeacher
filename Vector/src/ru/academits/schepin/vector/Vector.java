package ru.academits.schepin.vector;

import java.util.Arrays;


class Vector {
    private double[] vector;

    Vector(double[] vector) {
        double[] array = new double[vector.length];
        System.arraycopy(vector, 0, array, 0, vector.length);
        this.vector = array;
    }


    //Создание конструктора, где размерность вектора равна n :
    public Vector(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("Неправильная размерность вектора");
        }
        vector = new double[n];
    }

    // Создание  копии вектора:
    Vector(Vector v) {
        double[] array = new double[v.getSize()];
        System.arraycopy(v.vector, 0, array, 0, v.getSize());
        this.vector = array;
    }


    //Создание копии вектора, где передается размерность n и  массив:
    public Vector(int sizeOfVector, double[] v) {
        if (sizeOfVector <= 0) {
            throw new IllegalArgumentException("Неправильная размерность вектора");
        }

        vector = new double[sizeOfVector];
        if (sizeOfVector < v.length) {
            System.arraycopy(v, 0, vector, 0, sizeOfVector);
        } else {
            System.arraycopy(v, 0, vector, 0, v.length);
        }
    }


    // Получение размерности вектора:
    int getSize() {
        return vector.length;
    }


    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(Arrays.toString(vector));
        s.setCharAt(0, '{');
        s.setCharAt(s.length() - 1, '}');
        return s.toString();
    }

    //todo Операции с векторами:

    //Прибавление к вектору другого вектора:
    Vector addition(Vector b) {
        if (this.getSize() >= b.getSize()) {
            this.sum(b);
            return this;
        } else {
            double[] array = new double[b.getSize()];
            System.arraycopy(this.vector, 0, array, 0, this.getSize());
            vector = array;
            this.sum(b);
            return this;
        }
    }

    //Метод для сложения векторов:
    private void sum(Vector b) {
        for (int i = 0; i < b.getSize(); i++) {
            this.vector[i] += b.vector[i];
        }
    }

    //Сложение векторов:
    static Vector sum(Vector a, Vector b) {
        Vector copyOfA = new Vector(a);
        return copyOfA.addition(b);
    }


    //Вычитание из вектора другого вектора:
     Vector subtraction(Vector b) {
        if (this.getSize() >= b.getSize()) {
            this.sub(b);
            return this;
        } else {
            double[] array = new double[b.getSize()];
            System.arraycopy(this.vector, 0, array, 0, this.getSize());
            vector = array;
            this.sub(b);
            return this;
        }
    }

    //Метод для вычитания векторов:
    private void sub(Vector b) {
        for (int i = 0; i < b.getSize(); i++) {
            this.vector[i] -= b.vector[i];
        }
    }

    //Вычитание векторов:
    static Vector sub(Vector a, Vector b) {
        Vector copyOfA = new Vector(a);
        return copyOfA.subtraction(b);
    }


    // Умножение на скаляр:
    Vector scale(double k) {

        for (int i = 0; i < this.vector.length; i++) {
            this.vector[i] *= k;
        }
        return this;
    }

    //Разворот вектора:
    Vector invert() {
        this.scale(-1);
        return this;
    }

    // Получение длины вектора:
    double norma() {
        double sum = 0;
        for (double aVector : vector) {
            sum += Math.pow(aVector, 2);
        }
        return Math.sqrt(sum);
    }


    //Получение компоненты вектора по нидексу:
    double getByIndex(int index) {
        return this.vector[index];
    }

    //Установка компоненты вектора по нидексу:
    void setByIndex(int index, double value) {
        this.vector[index] = value;
    }

    //Скалярное произведение векторов:
    static double scalarMultiply(Vector a, Vector b) {
        double result = 0;
        int n = Math.min(a.getSize(), b.getSize());

        for (int i = 0; i < n; i++) {
            result += a.vector[i] * b.vector[i];
        }

        return result;
    }


    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if ((o == null) || (o.getClass() != this.getClass())) {
            return false;
        }

        Vector v = (Vector) o;
        if (this.vector.length != v.vector.length) {
            return false;
        } else {
            for (int i = 0; i < this.vector.length; i++) {
                if (this.vector[i] != v.vector[i]) {
                    return false;
                }
            }
            return true;
        }
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(vector);
    }


}