package com.nisc586;

import java.util.Scanner;

public class Day02 {
    public static String part1(String input) {
        Scanner sc = new Scanner(input);

        int count = 0;
        while (sc.hasNextLine()) {
            Scanner report = new Scanner(sc.nextLine());
            boolean isSafe = true;
            Boolean isDecreasing = null;
            int level = report.nextInt();
            while (report.hasNextInt()) {
                int nextLevel = report.nextInt();
                int difference = level - nextLevel;
                if (isDecreasing == null) {isDecreasing = Boolean.valueOf(difference > 0);};
                if (!isDecreasing) {difference = -difference;};
                isSafe = (1 <= difference) & (difference <= 3);
                if (!isSafe) break;
                level = nextLevel;
            }
            count += isSafe? 1 : 0;
            report.close();
        }
        sc.close();
        return String.valueOf(count);
    }

    public static String part2(String input) {
        return "";
    }
}