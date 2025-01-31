package com.nisc586;

import java.util.Map;

import org.apache.commons.lang3.tuple.Pair;

import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;


public class Day11 {
    public static Map<Pair<Long, Integer>, Long> memory = new HashMap<>();

    public static String part1(String input){
        List<Long> nums = Utils.getLongList(input);
        
        int total = 0;
        int reps = 25;
        for (Long n:nums) {
            total += simSteps(n, reps);
        }

        return String.valueOf(total);
    }

    public static String part2(String input){
        List<Long> nums = Utils.getLongList(input);
        
        long total = 0;
        int reps = 75;
        for (Long n:nums) {
            total += simSteps(n, reps);
        }

        return String.valueOf(total);
    }

    public static Long simSteps(long n, int steps) {
        Pair<Long, Integer> params = Pair.of(n, steps);

        if (memory.containsKey(params)) return memory.get(params);
        if (steps == 0) return 1L;

        long result = 0;

        if(n == 0L) {
            // Rule 1: Replace 0 with 1
            result = simSteps(1L, steps-1);
        } else {
            int length = (n > 0) ? (int) (Math.log10(n) + 1) : 1;

            if (length % 2 == 0) {
                // Rule 2: Split n
                long divisor = (long) Math.pow(10, length / 2);
                long a = n / divisor;
                long b = n % divisor;
                result = simSteps(a, steps-1) + simSteps(b, steps-1);
                
            } else {
                // Rule 3: Replace n with n*2024
                result = simSteps(n * 2024L, steps-1);
            }
        }
        memory.put(params, result);
        return result;
    }
        
    public static void modifyList(List<Long> nums) {
        ListIterator<Long> numsIterator = nums.listIterator(nums.size());
        while(numsIterator.hasPrevious()) {
            Long n = numsIterator.previous();

            if (n == 0) {
                // Rule 1: Replace 0 with 1
                numsIterator.set(1L);
            } else {
                int length = (n > 0) ? (int) (Math.log10(n) + 1) : 1;

                if (length % 2 == 0) {
                    numsIterator.remove();

                    long divisor = (long) Math.pow(10, length / 2);
                    long a = n / divisor;  
                    long b = n % divisor;

                    numsIterator.add(a);
                    numsIterator.add(b);

                    numsIterator.previous();
                    numsIterator.previous();
                } else {
                    // Rule 3: Replace n with n*2024
                    numsIterator.set(n * 2024);
                }
            }
        }
    }
}
