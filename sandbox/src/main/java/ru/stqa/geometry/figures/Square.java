package ru.stqa.geometry.figures;

public class Square {
    public static void PrintSquareArea(double a)
    {
        System.out.println("Площадь квадрата со стороной "+a+" = "+ squareArea(a));
    }

    private static double squareArea(double a) {
        return a * a;
    }
}
