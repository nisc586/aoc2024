package com.nisc586;

import java.util.List;

public class Day04 {
    public static String part1(String input) {
        List<List<Character>> wordSearch = Utils.get2DArray(input);
        int nRows = wordSearch.size();
        int nCols = wordSearch.get(0).size();

        int[][] directions = {
                { -1, 0 }, // up
                { -1, 1 }, // diagonal up-right
                { 0, 1 }, // right
                { 1, 1 }, // diagonal down-right
                { 1, 0 }, // down
                { 1, -1 }, // diagonal down-left
                { 0, -1 }, // left
                { -1, -1 } // diagonal up-left
        };
        int count = 0;

        for (int i = 0; i < nRows; i++) {
            for (int j = 0; j < nCols; j++) {
                if (wordSearch.get(i).get(j) == 'X') {

                    for (int[] direction : directions) {
                        int dx = direction[0];
                        int dy = direction[1];

                        boolean valid = true;
                        for (int step = 1; step < 4; step++) {
                            int ni = i + dx * step;
                            int nj = j + dy * step;
                            char c = "MAS".charAt(step-1);

                            if (ni < 0 || ni >= nRows || nj < 0 || nj >= nCols ||
                                    wordSearch.get(ni).get(nj) != c) {
                                valid = false;
                                break;
                            }
                            ;
                        }
                        count += valid ? 1 : 0;
                    }
                }
            }
        }

        return String.valueOf(count);
    }

    public static String part2(String input) {
        return "";
    }
}
