package ru.stqa.geometry.figures;


import static java.lang.Math.sqrt;

public record Triangle(double a, double b, double c) {

    public Triangle{
        if (a<0 || b<0 || c<0){
            throw new IllegalArgumentException("Triangle side should be non-negative");
        }

        if (a+b<c || b+c<a || a+c<b){
            throw new IllegalArgumentException("The sum of any two sides of the triangle must not be less than the third side");
        }
    }
    private static void printTriangleArea(Triangle s){
        String text=String.format("Площадь треугольника со сторонами %f = %f", s.a, s.triangleArea());
        System.out.println(text);
    }

    private static void printTrianglePerimetr(Triangle s){
        String text=String.format("Периметр треугольника со сторонами %f %f %f = %f", s.a,s.b,s.c, s.trianglePerimetr());
        System.out.println(text);
    }

    public double triangleArea() {
        return sqrt(
                trianglePerimetr()/2
                *(trianglePerimetr()/2-this.a)
                *(trianglePerimetr()/2-this.b)
                *(trianglePerimetr()/2-this.c)
        );
    }

    public double trianglePerimetr() {
        return (this.a+this.b+this.c);
    }



}
