package com.nisc586;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class Day05Test {
    @Test
    public void testPart1() {
        String input = Utils.getInputText("src\\test\\resources\\day05.txt");
        assertEquals("143", Day05.part1(input));
    }

    @Test
    public void testPart2() {
        String input = Utils.getInputText("src\\test\\resources\\day05.txt");
        assertEquals("123", Day05.part2(input));
    }
}
