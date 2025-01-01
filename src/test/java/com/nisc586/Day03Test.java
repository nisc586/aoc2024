package com.nisc586;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class Day03Test {
    @Test
    public void testPart1() {
        String input = Utils.getInputText("src\\test\\resources\\day03.txt");
        assertEquals("161", Day03.part1(input));
    }

    @Test
    public void testPart2() {
        
    }
}
