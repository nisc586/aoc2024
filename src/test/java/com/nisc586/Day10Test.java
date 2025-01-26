package com.nisc586;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class Day10Test extends AbstractDayTest {

    static {
        dayNumber = 10;
    }

    @BeforeAll
    static void initAll() {
        baseInitAll();
    }
    
    @Test
    public void testPart1() {
        baseTestPart1("36");
    }

    @Test
    public void testPart2() {
        baseTestPart2("");
    }
}
