package ru.academits.schepin.vector;


public class Main {
    public static void main(String[] args) {

        //Сумма:
        double[] array1 = {1, 6, 3, 9, 7, 2};
        double[] array2 = {5, 8, 9, 6, 8, 7, 1, 2};


        Vector a = new Vector(array1);
        Vector b = new Vector(array2);
        System.out.println("a = " + a);
        System.out.println("b = " + b);


        //Создать копию вектора:
        Vector copyOfA = new Vector(a);
        System.out.println("Копия вектора а: " + copyOfA);

        System.out.println("Размер вектора a= " + a.getSize());
        System.out.println("Размер вектора b= " + b.getSize());

        System.out.println("Сложение векторов:");
        Vector c = Vector.sum(a, b);
        System.out.println("c = a + b");
        System.out.println("c = " + c);
        System.out.println("a = " + a);
        System.out.println("Прибавление вектора:");

        System.out.println("a+  = a + b");
        System.out.println("a+ = " + a.addition(b));
        System.out.println("a = " + a);

        System.out.println("Вычитание вектора:");
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        System.out.println("Вычитание: ");
        Vector e = Vector.sub(a, b);
        System.out.println("a - b = " + e);
        System.out.println("a = " + a);
        System.out.println("Вычитание из а вектора b: ");
        System.out.println("a - = " + a.subtraction(b));
        System.out.println("a- = " + a);



        System.out.println("Умножение вектора на скаляр:");
        double[] array4 = {4, 8, 7, 9, 6, 1};
        Vector m = new Vector(array4);
        System.out.println("m = " + m);
        System.out.println("m * 2 = " + m.scale(2));


        System.out.println("Разворот вектора:");
        System.out.println("-c = " + c.invert());

        System.out.println("Получение длины вектора:");
        System.out.println("|a| = " + a.norma());

        System.out.println("Получение и установка длины вектора по индексу: ");
        System.out.println("a= " + a);
        System.out.println("c= " + c);
        System.out.println("Замена 2-го индекса вектора с на 0-ой индекс вектора а");
        c.setByIndex(2, a.getByIndex(0));
        System.out.println("c = " + c);


        System.out.println("Скалярное произведение векторов:");
        double scalarP = Vector.scalarMultiply(c, a);
        System.out.println("c*d = " + scalarP);


        System.out.println("Сравнение векторов a и b:");
        System.out.println(a + " и " + b);
        if (a.equals(b)) {
            System.out.println("a равен b");
        } else {
            System.out.println("a не равен b");
        }

        System.out.println("Хэш коды: ");
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        System.out.println("c = " + c);

        System.out.println("hash(a) = " + a.hashCode());
        System.out.println("hash(b) = " + b.hashCode());
        System.out.println("hash(c) = " + c.hashCode());
    }
}
