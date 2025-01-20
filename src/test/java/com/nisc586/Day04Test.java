package com.nisc586;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class Day04Test extends AbstractDayTest {
    
    static {
        dayNumber = 4;
    }

    @BeforeAll
    static void initAll() {
        baseInitAll();
    }
    
    @Test
    public void testPart1() {
        baseTestPart1("18");
    }

    @Test
    public void testPart2() {
        baseTestPart2("9");
    }
}
