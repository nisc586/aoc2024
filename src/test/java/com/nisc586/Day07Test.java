package com.nisc586;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class Day07Test extends AbstractDayTest{

    static {
        dayNumber = 7;
    }
    
    @BeforeAll
    static void initAll() {
        baseInitAll();
    }
    
    @Test
    public void testPart1() {
        baseTestPart1("3749");
    }

    @Test
    public void testPart2() {
        baseTestPart2("11387");
    }

    @Test
    public void testCheckEquationLastNumIsZero() {
        List<Long> nums = List.of(19L, 1L);
        assertEquals(true, Day07.checkEquation(10L, 190L, nums));
    }

    @Test
    public void testCheckEquation2ConcatAllNums() {
        List<Long> nums = List.of(1L,1L,1L);
        assertEquals(true, Day07.checkEquation2(1L, 1111L, nums));
    }

    @Test
    public void testConcatOperation() {
        assertEquals(1234L, Day07.concat(12L, 34L));
        assertEquals(1230L, Day07.concat(123L, 0L));
        assertEquals(123L, Day07.concat(0L, 123L));
        assertEquals(11L, Day07.concat(1L, 1L));
        assertEquals(0L, Day07.concat(0L, 0L));
    }
}
