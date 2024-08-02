package ru.stqa.geometry.figures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SquareTests {

    @Test
    void canCaculateArea(){
        var s=new Square(4.0);
        var result = s.area();
       // Assertions.assertEquals(25.0,result);
        if (result!=25){
            throw new AssertionError(String.format("Expected %f, actual %f",25.0,result));
        }
    }

    @Test
    void canCaculatePerimitr(){
        Assertions.assertEquals(20.0,new Square(5.).squarePerimetr());
    }

    @Test
    void cannotCreateSquareWithNegativeSide(){
        try{
            new Square(-5.0);
            Assertions.fail();
        }catch(IllegalArgumentException exception){

        }
    }
}
