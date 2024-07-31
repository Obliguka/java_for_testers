package ru.stqa.geometry.figures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SquareTests {

    @Test
    void canCaculateArea(){
        var result = Square.area(5.);
        Assertions.assertEquals(25.0,result);
    }

    @Test
    void canCaculatePerimitr(){
        Assertions.assertEquals(20.0,Square.squarePerimetr(5.));
    }
}
