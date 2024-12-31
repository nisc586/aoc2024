package com.nisc586;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

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
        Scanner sc = new Scanner(input);

        int count = 0;
        while (sc.hasNextLine()) {
            boolean isDampened = false;
            Scanner line = new Scanner(sc.nextLine());
            List<Integer> report = new ArrayList<>();
            while (line.hasNextInt()) {
                report.add(line.nextInt());
            }

            if (isSafeReport(report)) {
                count += 1;
            } else if (!isDampened) {
                boolean anySafe = false;
                for (int i=0; i < report.size(); i++) {
                    List<Integer> dampened = new ArrayList<>(report);
                    dampened.remove(i);
                    anySafe = anySafe || isSafeReport(dampened);
                }
                count += anySafe? 1 : 0;
            }
            line.close();
            

        }
        sc.close();
        return String.valueOf(count);
    }

    private static boolean isSafeReport(List<Integer> report) {
        Set<Integer> vals = new HashSet<>(report);
        boolean uniqueVals = vals.size() == report.size();
        List<Integer> sorted = new ArrayList<>(report);
        sorted.sort(null);
        boolean monoAsc = report.equals(sorted);
        boolean monoDesc = report.equals(sorted.reversed());
        int maxDist = 1;
        for (int i=1; i<report.size();i++){
            maxDist = Math.max(Math.abs(report.get(i-1) - report.get(i)), maxDist);
        }
        boolean smallSteps = maxDist <= 3;

        return uniqueVals && (monoAsc  || monoDesc) && smallSteps;
    }
}
