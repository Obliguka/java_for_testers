package ru.stqa.geometry.figures;


import java.util.Objects;

import static java.lang.Math.sqrt;

public record Triangle(double a, double b, double c) {

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triangle triangle = (Triangle) o;
        return (Double.compare(triangle.a, this.a) == 0 && Double.compare(triangle.b, this.b) == 0 && Double.compare(triangle.c, this.c) == 0)
                || (Double.compare(triangle.a, this.b) == 0 && Double.compare(triangle.b, this.c) == 0 && Double.compare(triangle.c, this.a) == 0)
                || (Double.compare(triangle.a, this.c) == 0 && Double.compare(triangle.b, this.a) == 0 && Double.compare(triangle.c, this.b) == 0)
                || (Double.compare(triangle.a, this.a) == 0 && Double.compare(triangle.b, this.c) == 0 && Double.compare(triangle.c, this.b) == 0)
                || (Double.compare(triangle.a, this.c) == 0 && Double.compare(triangle.b, this.b) == 0 && Double.compare(triangle.c, this.a) == 0)
                || (Double.compare(triangle.a, this.b) == 0 && Double.compare(triangle.b, this.a) == 0 && Double.compare(triangle.c, this.c) == 0);
    }

    @Override
    public int hashCode() {
        return 1;
    }

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
