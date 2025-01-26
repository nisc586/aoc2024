package com.nisc586;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.tuple.Pair;


public class Day10 {
    static {
        
    }
    

    public static String part1(String input) {
        List<List<Character>> topography = Utils.get2DArray(input);
        int result = 0;

        for(int r=0; r < topography.size(); r++){
            for(int c=0; c < topography.size(); c++){
                if (topography.get(r).get(c).equals('0')){
                    Set<Pair<Integer,Integer>> targets = searchTrail(r, c, topography);
                    result += targets.size();
                }
            }
        }

        return String.valueOf(result);
    }
    public static String part2(String input) {
        return "";
    }


    public static Set<Pair<Integer, Integer>> searchTrail(int row, int col, List<List<Character>> M){
        /*Return all "9" positions, that can be reached with given position parameters.*/
        final Integer[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // cardinal directions up, down, left, right
        final int N = M.size();

        int height = Character.getNumericValue(M.get(row).get(col));

        Set<Pair<Integer, Integer>> targetPositions = new HashSet<Pair<Integer, Integer>>();

        // Return early, if
        if (height == 9)  {
            // End of trail
            targetPositions.add(Pair.of(row, col));
            return targetPositions;
        } 
        
        int rr, cc, hh;
        for (Integer[]dir:DIRECTIONS) {
            // Continue search in all directions
            rr = row + dir[0];
            cc = col + dir[1];
            
            // Assert bounds and height
            hh = Character.getNumericValue(M.get(rr).get(cc));
            if (0 <= rr && rr < N && 0 <= cc && cc < N) {
                if (hh == height+1) {targetPositions.addAll(searchTrail(rr, cc, M));}
            }
        }

        return targetPositions;
    }
}
