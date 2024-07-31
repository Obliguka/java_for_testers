package ru.stqa.geometry.figures;


import static java.lang.Math.sqrt;

public record Triangle(double a, double b, double c) {
    private static void PrintTriangleArea(Triangle s){
        String text=String.format("Площадь треугольника со сторонами %f = %f", s.a, s.TriangleArea());
        System.out.println(text);
    }

    private static void PrintTrianglePerimetr(Triangle s){
        String text=String.format("Периметр треугольника со сторонами %f %f %f = %f", s.a,s.b,s.c, s.TrianglePerimetr());
        System.out.println(text);
    }

    public double TriangleArea() {
        return sqrt(
                TrianglePerimetr()/2
                *(TrianglePerimetr()/2-this.a)
                *(TrianglePerimetr()/2-this.b)
                *(TrianglePerimetr()/2-this.c)
        );
    }

    public double TrianglePerimetr() {
        return (this.a+this.b+this.c);
    }



}
