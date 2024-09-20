package ru.stqa.geometry;

import ru.stqa.geometry.figures.Square;

import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class Geometry {
    public static void main(String[] args) {
        Supplier<Square> randomSquere=()->new Square(new Random().nextDouble(100));
        //var squares= List.of(new Square(7.0), new Square(5.), new Square(3.));
        var squares= Stream.generate(randomSquere).limit(5);
        /*for (Square square : squares) {
            Square.PrintSquareArea(square);
        }*/

        //Consumer<Square> print=(square)->{Square.PrintSquareArea(square);}; //длинный способ

        Consumer<Square> print=Square::PrintSquareArea; //короткий спосок если одна переменная и тело состоит и вызова другой функции
        squares.peek(Square::PrintSquareArea).forEach(Square::squarePerimetr);

        //squares.forEach(Square::PrintSquareArea);

        //Rectangle.PrinnRectangelArea(3.0,5.);
        //Rectangle.PrinnRectangelArea(9.,4.);
        }

}
