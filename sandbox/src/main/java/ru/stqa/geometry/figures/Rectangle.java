package ru.stqa.geometry.figures;

import java.util.Objects;

public record Rectangle(double a, double b) {
    public Rectangle{
        if (a<0 || b<0){
            throw new IllegalArgumentException("Rectangle side should be non-negative");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rectangle rectangle = (Rectangle) o;
        return (Double.compare(rectangle.a, this.a) == 0 && Double.compare(rectangle.b, this.b) == 0)
                || (Double.compare(rectangle.a, this.b) == 0 && Double.compare(rectangle.b, this.a) == 0);
    }

    @Override
    public int hashCode() {
        return 1;
    }

    public static void PrinnRectangelArea(double a, double b) {
        System.out.println("Площадь прямоугольника со сторонами "+a+" "+ " и "+ b+" = "+ rectangleArea(a, b));
    }

    public static double rectangleArea(double a, double b) {
        return a * b;
    }
}
