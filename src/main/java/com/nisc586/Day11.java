package com.nisc586;

import java.util.List;
import java.util.ListIterator;

public class Day11 {
    public static String part1(String input){
        List<Long> nums = Utils.getLongList(input);
        
        for (int reps=0; reps < 25; reps++) {
            modifyList(nums);
        }

        return String.valueOf(nums.size());
    }

    public static String part2(String input){
        List<Long> nums = Utils.getLongList(input);
        
        for (int reps=0; reps < 75; reps++) {
            modifyList(nums);
        }

        return String.valueOf(nums.size());
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
