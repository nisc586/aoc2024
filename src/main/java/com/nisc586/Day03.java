package com.nisc586;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Day03 {
    public static String part1(String input) {
        Pattern mulPattern = Pattern.compile("mul\\((\\d{1,3}),(\\d{1,3})\\)");
        Matcher m = mulPattern.matcher(input);
        int result = 0;
        while (m.find()) {
            result += Integer.valueOf(m.group(1)) * Integer.valueOf(m.group(2));
        } 
        return String.valueOf(result);
    }
    public static String part2(String input) {
        Pattern mulPattern = Pattern.compile("(mul\\((\\d{1,3}),(\\d{1,3})\\))|(do\\(\\))|(don't\\(\\))");
        Matcher m = mulPattern.matcher(input);
        int result = 0;
        boolean enabled = true;
        while (m.find()) {
            if (m.group(0).equals("do()")) {
                enabled = true;
            } else if (m.group(0).equals("don't()")) {
                enabled = false;
            } else {
                if (enabled) {
                    result += Integer.valueOf(m.group(2)) * Integer.valueOf(m.group(3));
                }
            }
            
        }
        return String.valueOf(result);
    }
}
