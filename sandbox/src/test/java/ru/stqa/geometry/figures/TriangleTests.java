package ru.stqa.geometry.figures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TriangleTests {
    @Test
    void canCaculateArea(){
        var s=new Triangle(16.0, 12.0, 20.0);
        var result = s.triangleArea();
        Assertions.assertEquals(96.0,result);
    }

    @Test
    void canCaculatePerimitr(){

        Assertions.assertEquals(48.0,new Triangle(16.0, 12.0, 20.0).trianglePerimetr());
    }

    @Test
    void cannotCreateTriangleWithNegativeSide(){
        try{
            new Triangle(-5.0, -3.0, -1.0);
            Assertions.fail();
        }catch(IllegalArgumentException exception){

        }
    }

    @Test
    void cannotCreateTriangleWithIncorrectSumSides(){
        try{
            new Triangle(5.0, 3.0, 1.0);
            Assertions.fail();
        }catch(IllegalArgumentException exception){

        }
    }

    @Test
    void testEquals(){
        var s1=new Triangle(4.0, 5.0, 6.0);
        var s2=new Triangle(5.0, 6.0, 4.0);
        Assertions.assertEquals(s1, s2);
    }

    @Test
    void testNotEquals(){
        var s1=new Triangle(5.0, 6.0, 4.0);
        var s2=new Triangle(8.0, 6.0, 4.0);
        Assertions.assertNotEquals(s1, s2);
    }

    @Test
    void testPass(){
        var s1=new Triangle(4.0, 5.0, 6.0);
        var s2=new Triangle(5.0, 6.0, 4.0);
        Assertions.assertTrue(s1.equals(s2));
    }

}
