package ru.stqa.geometry.figures;

public class Square {
    public static void PrintSquareArea(double a)
    {
        System.out.println("Площадь квадрата со стороной "+a+" = "+ area(a));
    }

    public static double area(double a) {
        return a * a;
    }

    public static double squarePerimetr(double a) {
        return a*4;
    }
}
