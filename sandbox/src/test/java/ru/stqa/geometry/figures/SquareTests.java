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

    @Test
    void testEquals(){
        var s1=new Square(5.0);
        var s2=new Square(5.0);
        Assertions.assertEquals(s1, s2);
    }

    @Test
    void testNotEquals(){
        var s1=new Square(5.0);
        var s2=new Square(6.0);
        Assertions.assertNotEquals(s1, s2);
    }

    @Test
    void testFail(){
        var s1=new Square(5.0);
        var s2=new Square(5.0);
        Assertions.assertTrue(s1==s2);
    }

    @Test
    void testPass(){
        var s1=new Square(5.0);
        var s2=new Square(5.0);
        Assertions.assertTrue(s1.equals(s2));
    }

    @Test
    void testEqualsR(){
        var s1=new Rectangle(5.0, 4.0);
        var s2=new Rectangle(5.0, 4.0);
        Assertions.assertEquals(s1, s2);
    }
}
