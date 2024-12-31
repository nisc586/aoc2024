package com.nisc586;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class Day02Test {
    @Test
    public void testPart1() {
        String input = Utils.getInputText("src\\test\\resources\\day02.txt");
        assertEquals("2", Day02.part1(input));
    }

    @Test
    public void testPart2() {
        String input = Utils.getInputText("src\\test\\resources\\day02.txt");
        assertEquals("4", Day02.part2(input));
        assertEquals("1", Day02.part2("5 1 7 8 9"));
        assertEquals("1", Day02.part2("1 6 7 8 9"));
    }
}
