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
                            };
                        }
                        count += valid ? 1 : 0;
                    }
                }
            }
        }

        return String.valueOf(count);
    }

    
    public static String part2(String input) {
        List<List<Character>> wordSearch = Utils.get2DArray(input);
        int nRows = wordSearch.size();
        int nCols = wordSearch.get(0).size();

        int[][] xPattern = { { -1, 1 }, { 1, 1 } }; // diagonal cross
        int count = 0;

        for (int i = 0; i < nRows; i++) {
            for (int j = 0; j < nCols; j++) {
                if (wordSearch.get(i).get(j) == 'A') {

                    boolean valid = true;
                    for (int[] direction : xPattern) {
                        int dx = direction[0];
                        int dy = direction[1];

                        int ni = i + dx;
                        int nj = j + dy;
                        boolean nInbound = ni >= 0 && ni < nRows && nj >= 0 && nj < nCols;

                        int mi = i - dx;
                        int mj = j - dy;
                        boolean mInbound = mi >= 0 && mi < nRows && mj >= 0 && mj < nCols;

                        if (nInbound && mInbound) {
                            char c1 = wordSearch.get(ni).get(nj);
                            char c2 = wordSearch.get(mi).get(mj);
                            valid = ((c1 == 'M') && (c2 == 'S')) || ((c1 == 'S') && (c2 == 'M'));
                        } else {
                            valid = false;
                        }
                        if (!valid)
                            break;
                    }
                    count += valid ? 1 : 0;
                }
            }
        }

        return String.valueOf(count);
    }
}
