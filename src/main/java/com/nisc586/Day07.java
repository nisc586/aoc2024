package com.nisc586;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.MatchResult;

public class Day07 {
    public static String part1(String input) {
        List<List<Long>> equations = parse(input);

        Long total = 0L;
        for(List<Long> equation : equations) {
            Long testVal = equation.getFirst();
            List<Long> nums = equation.subList(2, equation.size());
            Long x=equation.get(1);
            if (checkEquation(x, testVal, nums)) total = total + testVal;
            }
        
        return total.toString();
    }

    public static String part2(String input) {
        return "";
    }

    public static boolean checkEquation(Long x, Long testValue, List<Long> rest) {
        if (rest.isEmpty()) {
            return x.equals(testValue);
        } else if (x.compareTo(testValue) > 0) {
            // Not all numbers were consumed, but x is already greater than testValue
            return false;
        } else {
            // Make recursive calls
            boolean multiplyResult = checkEquation(x * rest.getFirst(), testValue, rest.subList(1, rest.size()));
            boolean addResult = checkEquation(x + rest.getFirst(), testValue, rest.subList(1, rest.size()));
            return multiplyResult || addResult;
        }
    }


    private static List<List<Long>> parse(String input) {
        List<List<Long>> result = new ArrayList<>();
        Scanner lineScanner = new Scanner(input);
        while (lineScanner.hasNextLine()) {
            Scanner intScanner = new Scanner(lineScanner.nextLine());

            List<Long> numbers = intScanner.findAll("\\d+")
                .map(MatchResult::group)
                .map(Long::valueOf)
                .toList();
            result.add(numbers);

            intScanner.close();
        }
        lineScanner.close();
        return result;
    }
}
