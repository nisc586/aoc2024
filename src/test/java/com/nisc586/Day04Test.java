package com.nisc586;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class Day04Test {
    @Test
    public void testPart1() {
        String input = Utils.getInputText("src\\test\\resources\\day04.txt");
        assertEquals("18", Day04.part1(input));
    }

    @Test
    public void testPart2() {
        String input = Utils.getInputText("src\\test\\resources\\day04.txt");
        assertEquals("9", Day04.part1(input));
    }
}
