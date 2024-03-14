package com.dennis.api.product;


import org.junit.jupiter.api.Assertions;
import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Test;

class ItemTest {

    @org.junit.jupiter.api.Test
    void systemOut() {
            Item s = new Item();
            String s3 = s.systemOut();
        System.out.println("-->" + s3);
            String s2 = "Hello";
        Assertions.assertEquals(s.systemOut(), s2);
    }

    @Test
    void add() {
        Item i = new Item();
        int result = i.add(1,2);
        Assertions.assertEquals(3, result);
    }
}