package com.nisc586;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class Day01Test extends AbstractDayTest{
            
    static {
        dayNumber = 1;
    }

    @BeforeAll
    static void initAll() {
        baseInitAll();
    }
    
    @Test
    public void testPart1() {
        baseTestPart1("11");
    }

    @Test
    public void testPart2() {
        baseTestPart2("31");
    }

}
