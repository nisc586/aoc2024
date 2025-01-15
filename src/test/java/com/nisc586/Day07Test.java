package com.nisc586;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

public class Day07Test {
    private int dayNumber = 7;
    private String filePath = String.format("src\\test\\resources\\day%1$02d.txt", dayNumber);
    @Test
    public void testPart1() {
        String input = Utils.getInputText(filePath);
        assertEquals("3749", Day07.part1(input));
    }


    @Test
    public void testPart2() {
        String input = Utils.getInputText(filePath);
        assertEquals("11387", Day07.part2(input));
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
