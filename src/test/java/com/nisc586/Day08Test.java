package com.nisc586;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


public class Day08Test {

    public static int dayNumber = 8;
    public static String filePath = String.format("src\\test\\resources\\day%1$02d.txt", dayNumber);
    public static String className = String.format("com.nisc586.Day%1$02d", dayNumber);
    public static Class<?> dayClass;
    public static Method part1, part2;

    @BeforeAll
    static void initAll() {
        try {
            dayClass = Class.forName(className);
            part1 = dayClass.getMethod("part1", String.class);
            part2 = dayClass.getMethod("part2", String.class);
        } catch (ClassNotFoundException e) {
            System.out.println("Class" + className + "not found.");
        } catch (NoSuchMethodException ee){
            System.out.println("Method not found in class" + className + ".");
        }

    }


    @Test
    public void testPart1() {
        String input = Utils.getInputText(filePath);
        try {
            assertEquals("14", part1.invoke(null, input));
        } catch (InvocationTargetException e) {
            fail("Method throws Exception.\n" + e.getMessage());
        } catch (IllegalAccessException e) {
            fail("Method throws Exception.\n" + e.getMessage());

        }
    }

    @Test
    public void testPart2() {
        String input = Utils.getInputText(filePath);
        try {
            assertEquals("34", part2.invoke(null, input));
        } catch (InvocationTargetException e) {
            fail("Method throws Exception.\n" + e.getMessage());
        } catch (IllegalAccessException e) {
            fail("Method throws Exception.\n" + e.getMessage());

        }
    }
}