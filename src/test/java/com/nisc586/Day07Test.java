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
    public void testCheckEquationLastNumIsZero() {
        List<Long> nums = List.of(19L, 1L);
        assertEquals(true, Day07.checkEquation(10L, 190L, nums));
    }
}
