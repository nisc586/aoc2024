package com.nisc586;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class Day05Test extends AbstractDayTest{

    static {
        dayNumber = 5;
    }

    @BeforeAll
    static void initAll() {
        baseInitAll();
    }
    
    @Test
    public void testPart1() {
        baseTestPart1("143");
    }

    @Test
    public void testPart2() {
        baseTestPart2("123");
    }

}
