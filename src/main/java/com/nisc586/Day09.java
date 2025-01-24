package com.nisc586;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;

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

        return String.valueOf(checkSum(blocks));
    }
    
    public static String part2(String input) {
        Integer[] blocks = parseDiskMap(input).toArray(new Integer[0]);

        /*
         * Attempt to move whole blocks to the leftmost free span that could fit the
         * file.
         * Attempt to move each block exactly once.
         * Go from the hightest ID to the lowest ID.
         */

        Integer id = 0;
        // Get the hightest id
        for (int x=blocks.length-1; x >= 0; x--){
            if (blocks[x] != null) {
                id = blocks[x];
                break;
            }    
        }

        int blockStart, blockEnd, blockSize;

        while(id>0) {

            blockStart = ArrayUtils.indexOf(blocks, id);
            blockEnd = ArrayUtils.lastIndexOf(blocks, id);
            blockSize = blockEnd - blockStart + 1;
            
            for (int i=0; i < blockStart; i++){
                Integer spanStart = -1;
                if(blocks[i] == null && spanStart==-1) {
                    // Start of a free space
                    spanStart = i;

                    // Check if the block could fit
                    boolean blockFits = true;
                    for (int j=1; j < blockSize; j++){
                        blockFits = blockFits && (blocks[i+j]==null);
                    }
                    
                    // If yes, move the block and break the loop
                    if (blockFits) {
                        for (int k=0; k<blockSize; k++){
                            blocks[i+k] = id;
                            blocks[blockStart+k] = null;
                        }
                        break;
                    }
                
                } else if (blocks[i] != null && spanStart != -1) {
                    // End of a free space
                    spanStart = -1;
                }
            }
            
            id--;
        }

        return String.valueOf(checkSum(blocks));
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

    public static long checkSum(Integer[] blocks) {
        long total = 0;
        for(int i=0; i<blocks.length; i++) {
            if(blocks[i] == null) continue;
            total += i * blocks[i];
        }
        return total;
    }
}
