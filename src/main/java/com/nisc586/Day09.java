package com.nisc586;

import java.util.ArrayList;
import java.util.List;

public class Day09 {
    public static String part1(String input) {
        Integer[] blocks = parseDiskMap(input).toArray(new Integer[0]);
        int leftIdx = 0;
        int rightIdx = blocks.length-1;

        while(leftIdx < rightIdx) {
            // Set right pointer to rightmost non-null block
            while(blocks[rightIdx] == null) {
                rightIdx--;
                continue;
            }

            if (blocks[leftIdx] == null) {
                // swap empty bit
                blocks[leftIdx] = blocks[rightIdx];
                blocks[rightIdx] = null;                
            } else {
                // move left pointer forward
                leftIdx++;
            }
        }

        long checkSum = 0;
        for(int i=0; i<blocks.length; i++) {
            if(blocks[i] == null) break;
            checkSum += i * blocks[i];
        }

        return String.valueOf(checkSum);
    }
    
    public static String part2(String input) {
        return "";
    }

    public static List<Integer> parseDiskMap(String line) {
        List<Integer>blocks = new ArrayList<>();
        Integer id=0;
        for(int i=0; i<line.length(); i++){
            char digitChar = line.charAt(i);
            if (!Character.isDigit(digitChar)) continue;
            final int N = Character.getNumericValue(digitChar);
            // translate each number of the code into blocks
            if (i % 2 == 0) {
                for (int j = 0; j < N; j++) {
                        blocks.add(id);
                }
                id++;
            } else {
                for (int j = 0; j < N; j++) {
                    blocks.add(null);
                }
            }
        };
        return blocks;
    }
}
