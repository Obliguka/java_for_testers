package ru.stqa.geometry.figures;

public record Square (double side) {

    public static void PrintSquareArea(Square s)
    {
        String text=String.format("Площадь квадрата со стороной %f = %f", s.side, s.area());
        System.out.println(text);
    }



    public double area() {
        return this.side*this.side;
    }

    public double squarePerimetr() {
        return 4*this.side;
    }
}
