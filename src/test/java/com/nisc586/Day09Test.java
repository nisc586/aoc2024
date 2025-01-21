package com.nisc586;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class Day09Test extends AbstractDayTest {

    static {
        dayNumber = 9;
    }

    @BeforeAll
    static void initAll() {
        baseInitAll();
    }
    
    @Test
    public void testPart1() {
        baseTestPart1("1928");
    }

    @Test
    public void testPart2() {
        baseTestPart2("");
    }

    @Test
    public void testParseDiskMap() {
        assertEquals(Arrays.asList(0, null, 1),Day09.parseDiskMap("111"));
        assertEquals(Arrays.asList(0, 1),Day09.parseDiskMap("101"));
        assertEquals(Arrays.asList(0, 0, null, 1, 1),Day09.parseDiskMap("212"));
    }
}

