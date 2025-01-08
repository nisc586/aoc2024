package com.nisc586;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class Day06Test {
    private int dayNumber = 6;
    private String filePath = String.format("src\\test\\resources\\day%1$02d.txt", dayNumber);
    @Test
    public void testPart1() {
        String input = Utils.getInputText(filePath);
        assertEquals("41", Day06.part1(input));
    }

    @Test
    public void testPart2() {
        String input = Utils.getInputText(filePath);
    }
}
