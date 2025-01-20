package com.nisc586;

import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

public abstract class AbstractDayTest {
    protected static int dayNumber;
    protected static String filePath;
    protected static String className;
    protected static Class<?> dayClass;
    protected static Method part1, part2;

    static void baseInitAll() {
        filePath = String.format("src\\test\\resources\\day%1$02d.txt", dayNumber);
        className = String.format("com.nisc586.Day%1$02d", dayNumber);
        try {
            dayClass = Class.forName(className);
            part1 = dayClass.getMethod("part1", String.class);
            part2 = dayClass.getMethod("part2", String.class);
        } catch (ClassNotFoundException e) {
            System.out.println("Class" + className + "not found.");
        } catch (NoSuchMethodException e) {
            System.out.println("Method not found in class" + className + ".");
        }
    }

    public void baseTestPart1(String expectedResult) {
        String input = Utils.getInputText(filePath);
        try {
            assertEquals(expectedResult, part1.invoke(null, input));
        } catch (Exception e) {
            fail("Exception occured while invoking part1.\n" + e.getMessage());
        }
    }

    public void baseTestPart2(String expectedResult) {
        String input = Utils.getInputText(filePath);
        try {
            assertEquals(expectedResult, part2.invoke(null, input));
        } catch (Exception e) {
            fail("Exception occured while invoking part2.\n" + e.getMessage());
        }
    }
}
