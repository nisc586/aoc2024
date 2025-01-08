package com.nisc586;

import java.io.File;
import java.lang.reflect.Method;


public class App {
    public static void main(String[] args){
        int day = 6;
        if (args.length != 0) {
            day = Integer.valueOf(args[0]);
        }
        
        String filePath = String.format("src%1$smain%1$sresources%1$sday%2$02d.txt", File.separator, day);
        String text = Utils.getInputText(filePath);
        
        /*Use reflection to dynamically load the class name for the given day number*/
        String className = String.format("com.nisc586.Day%1$02d", day);
        try {
            Class<?> dayClass = Class.forName(className);
            Method part1Method = dayClass.getMethod("part1", String.class);
            Method part2Method = dayClass.getMethod("part2", String.class);

            System.out.println(part1Method.invoke(null, text));
            System.out.println();
            System.out.println(part2Method.invoke(null, text));

        } catch (ClassNotFoundException e) {
            System.out.println("Class" + className + "not found.");
        } catch (NoSuchMethodException e) {
            System.out.println("Method not found in class " + className);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}