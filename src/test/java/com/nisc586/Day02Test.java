package com.nisc586;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class Day02Test extends AbstractDayTest{
        
    static {
        dayNumber = 2;
    }

    @BeforeAll
    static void initAll() {
        baseInitAll();
    }
    
    @Test
    public void testPart1() {
        baseTestPart1("2");
    }

    @Test
    public void testPart2() {
        baseTestPart2("4");
    }

    @Test
    public void extraTestPart2() {
        assertEquals("1", Day02.part2("5 1 7 8 9"));
        assertEquals("1", Day02.part2("1 6 7 8 9"));
    }
}
