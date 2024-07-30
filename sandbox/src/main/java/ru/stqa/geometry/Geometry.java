package ru.stqa.geometry;

import ru.stqa.geometry.figures.Rectangle;
import ru.stqa.geometry.figures.Square;

public class Geometry {
    public static void main(String[] args) {
        Square.PrintSquareArea(7.);
        Square.PrintSquareArea(.5);
        Square.PrintSquareArea(.3);
        Rectangle.PrinnRectangelArea(3.0,5.);
        Rectangle.PrinnRectangelArea(9.,4.);
        }

}
