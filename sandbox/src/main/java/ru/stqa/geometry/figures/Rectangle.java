package ru.stqa.geometry.figures;

public class Rectangle {
    public static void PrinnRectangelArea(double a, double b) {
        System.out.println("Площадь прямоугольника со сторонами "+a+" "+ " и "+ b+" = "+ rectangleArea(a, b));
    }

    public static double rectangleArea(double a, double b) {
        return a * b;
    }
}
