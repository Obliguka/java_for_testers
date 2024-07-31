package ru.stqa.geometry.figures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TriangleTests {
    @Test
    void canCaculateArea(){
        var s=new Triangle(16.0, 12.0, 20.0);
        var result = s.TriangleArea();
        Assertions.assertEquals(96.0,result);
    }

    @Test
    void canCaculatePerimitr(){

        Assertions.assertEquals(48.0,new Triangle(16.0, 12.0, 20.0).TrianglePerimetr());
    }

}
