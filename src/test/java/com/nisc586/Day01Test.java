package com.nisc586;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class Day01Test {
    @Test
    public void testPart1() {
        String input = Utils.getInputText("src\\test\\resources\\day01.txt");
        assertEquals("11", Day01.part1(input));
    }

    @Test
    public void testPart2() {
        String input = Utils.getInputText("src\\test\\resources\\day01.txt");
        assertEquals("31", Day01.part2(input));
    }
}
