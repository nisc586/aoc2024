package com.nisc586;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        Set<String> ruleSet = new HashSet<>();
        for (int[] rule : rules) {
            ruleSet.add(rule[0] + "," + rule[1]);
        }
        
        List<Integer> sorted = new ArrayList<>();

        for (int num : update) {
            int idxPos = sorted.size();  // Default to adding at the end.

            for (int i=0; i<sorted.size(); i++) {
                int current = sorted.get(i);

                if (ruleSet.contains(num + "," + current)) {
                    // num should be after current
                    idxPos = Math.min(i, idxPos);
                } else if (ruleSet.contains(current + "," + num)) {
                    // current should be before num
                    idxPos = Math.max(i+1, idxPos);
                }
                
            }
            sorted.add(idxPos, num);
        }
        return sorted.stream().mapToInt(x -> (int) x).toArray();
    }

}
