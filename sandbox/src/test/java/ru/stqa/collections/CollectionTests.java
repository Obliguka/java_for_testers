package ru.stqa.collections;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class CollectionTests {

    @Test
    void arrayTests()
    {
        var array = new String[]{"a","b","c"};
        Assertions.assertEquals(3,array.length);
        Assertions.assertEquals("a",array[0]);

        array[0]="d";
        Assertions.assertEquals("d",array[0]);
    }

    @Test
    void listTests()
    {
        var list= new ArrayList<String>();
        var list1= new ArrayList(List.of("1","b","c","a"));
        Assertions.assertEquals(0,list.size());
        list.add("a");
        list.add("b");
        list.add("c");
        Assertions.assertEquals(4,list1.size());
        Assertions.assertEquals("a",list.get(0));

        list.set(0, "d");
        Assertions.assertEquals("d",list.get(0));
    }

    @Test
    void setTests()
    {
        var set= Set.copyOf(List.of("a","b","c","c"));
        Assertions.assertEquals(3,set.size());
        var element=set.stream().findAny().get();
        set.add(element);
        Assertions.assertEquals(3,set.size());

    }
}
