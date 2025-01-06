package com.nisc586;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day05 {
    public static String part1(String input) {
        String[] parts = input.split("\n\n");
        List<int[]> rules = Utils.parseToListOfInts(parts[0], "\\|");
        List<int[]> updates = Utils.parseToListOfInts(parts[1], ",");

        int total = 0;
        for (int[] update : updates) {
            boolean valid = isValid(update, rules);
            total += valid? update[update.length / 2] : 0;
        }
        return String.valueOf(total);
    }

    public static String part2(String input) {
        String[] parts = input.split("\n\n");
        List<int[]> rules = Utils.parseToListOfInts(parts[0], "\\|");
        List<int[]> updates = Utils.parseToListOfInts(parts[1], ",");

        int total = 0;
        for (int[] update : updates) {
            boolean valid = isValid(update, rules);
            if (!valid) {
                int[] sorted = sortedUpdate(update, rules);
                total += sorted[sorted.length / 2];
            }
        }
        return String.valueOf(total);
    }

    private static int findIdx(int[] arr, int x) {
        /* Return the index of the first occurence of x in arr. Return -1 if x is not in arr. */
        for (int i=0; i < arr.length; i++) {
            if (x == arr[i]) return i;
        }
        return -1;
    }

    private static boolean isValid(int[] update, List<int[]> rules) {
        for (int[] rule : rules) {
            int idx1 = findIdx(update, rule[0]);
            int idx2 = findIdx(update, rule[1]);
            if (idx1 >= 0 && idx2 >= 0 && idx1 > idx2) {
                return false;
            }
        }
        return true;
    }

    private static int[] sortedUpdate(int[] update, List<int[]> rules) {
        List<Integer> sorted = new ArrayList<>();

        for (int num : update) {
            int idxPos = 0;
            for (int i=0; i<sorted.size(); i++) {
                for (int[] rule : rules) {
                    if (Arrays.equals(rule, new int[] {num, sorted.get(i)})) {
                        idxPos = Math.min(i, idxPos);
                        break;
                    } else if (Arrays.equals(rule, new int[] {sorted.get(i), num})) {
                        idxPos = Math.max(i+1, idxPos);
                        break;
                    }
                }
            }
            sorted.add(idxPos, num);
        }
        return sorted.stream().mapToInt(x -> (int) x).toArray();
    }

}
