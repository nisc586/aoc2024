package com.nisc586;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

public class Day11Test extends AbstractDayTest{
        
    static {
        dayNumber = 11;
    }

    @BeforeAll
    static void initAll() {
        baseInitAll();
    }
    
    @Test
    public void testPart1() {
        baseTestPart1("55312");
    }

    @Test
    public void testSingleIteration() {
        List<Long> in = Utils.getLongList("0 1 10 99 999");
        List<Long> expected = Utils.getLongList("1 2024 1 0 9 9 2021976");

        Day11.modifyList(in);
        assertEquals(expected, in);
    }
}
