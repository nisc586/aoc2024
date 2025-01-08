package com.nisc586;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Day06 {
    public static String part1(String input) {
        List<List<Character>> map = Utils.get2DArray(input);
        int rowMax = map.size();
        int colMax = map.get(0).size();

        // Encode obstacle positions as a Set of integers
        // like:  row * colMax + col
        Set<Integer> obstacles = new HashSet<>();
        int startRow = -1, startCol = -1;
        for (int row=0; row < rowMax; row++) {
            for(int col=0; col < colMax; col++) {
                Character c = map.get(row).get(col);
                if (c == '#')
                        obstacles.add(row * colMax + col);
                else if (c == '^') {
                    startRow = row;
                    startCol = col;
                }
            }
        }

        int[][] deltas = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        int dir = 0;

        Set<Integer> visited = new HashSet<>();
        

        int [] pos = {startRow, startCol};
        while (pos[0] < rowMax && pos[1] < colMax && pos[0] >= 0 && pos[1] >= 0) {
            visited.add(pos[0] * colMax + pos[1]);
            int nextRow= pos[0] + deltas[dir][0];
            int nextCol= pos[1] + deltas[dir][1];
            // check obstacle
            if (obstacles.contains(nextRow *colMax + nextCol)) {
                // turn
                dir = (dir + 1) % deltas.length;
                continue;
            } else {
                // step
                pos[0] = nextRow;
                pos[1] = nextCol;
            }
        }

        return String.valueOf(visited.size());
    }


    public static String part2(String input) {
        return "";
    }
}
