package ru.stqa.geometry;

import ru.stqa.geometry.figures.Rectangle;
import ru.stqa.geometry.figures.Square;

public class Geometry {
    public static void main(String[] args) {
        Square.PrintSquareArea(new Square(7.0));
        Square.PrintSquareArea(new Square(5.));
        Square.PrintSquareArea(new Square(3.));
        Rectangle.PrinnRectangelArea(3.0,5.);
        Rectangle.PrinnRectangelArea(9.,4.);
        }

}
