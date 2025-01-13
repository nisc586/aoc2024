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
        List<List<Character>> map = Utils.get2DArray(input);
        final int rMax = map.size();
        final int cMax = map.get(0).size();

        // Encode obstacle positions as a Set of integers
        // like:  row * colMax + col
        Set<Integer> obstacles = new HashSet<>();
        int startRow = -1, startCol = -1;
        for (int row=0; row < rMax; row++) {
            for(int col=0; col < cMax; col++) {
                Character c = map.get(row).get(col);
                if (c == '#')
                        obstacles.add(encode(row, col, cMax));
                else if (c == '^') {
                    startRow = row;
                    startCol = col;
                }
            }
        }


        int loopOptions = 0;
        for (int oRow=0; oRow<rMax; oRow++) {
            for(int oCol=0; oCol<cMax; oCol++) {
                // Encode position
                int oEnc = encode(oRow, oCol, cMax);
                
                if (obstacles.contains(oEnc)) continue;  // Skip if obstacle already exists

                // Simulate with one extra obstacle
                obstacles.add(oEnc);
                boolean hasNoLoop = simulatePath(startRow, startCol, rMax, cMax, obstacles, null);
                obstacles.remove(oEnc);
                
                // Increase count if there was a loop
                if (!hasNoLoop) {
                    loopOptions++;
                }
            }
        }

        return String.valueOf(loopOptions);
    }

    private static boolean simulatePath(int startRow, int startCol, int rMax, int cMax, Set<Integer>obstacles, Set<Integer> visitedStorage) {
        /*Simulate a guard walking and return true if there is no loop.*/
        int[][] deltas = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        int dir = 0;  // Direction at the start is always 'up'

        // Track encoded position and direction
        Set<Integer> visited = new HashSet<>();
        int r = startRow, c = startCol;

        while ((r >= 0 && r < rMax) && (c >= 0 && c < cMax)) {
            int state = encode(r, c, dir, cMax);

            // Detect loop, return early when visiting the same state
            if (visited.contains(state)) return false;

            visited.add(state);
        
            int rr = r + deltas[dir][0];
            int cc = c + deltas[dir][1];

            // Check bounds before considering the next position
            if (rr < 0 || rr >= rMax || cc < 0 || cc >= cMax) {
                break; // Exit the loop if the next position is out of bounds
            }

            // Check obstacle
            if (obstacles.contains(encode(rr, cc, cMax))) {
                // Turn right
                dir = (dir + 1) % 4;
            } else {
                // Step
                r = rr;
                c = cc;
            }
        }

        if (visitedStorage != null) {
            visitedStorage.addAll(visited);
        }

        return true;
    }

    private static int encode(int r, int c, int cMax) {
        return r * cMax + c;
    }

    private static int encode(int r, int c, int d, int cMax) {
        return (r * cMax + c) * 4 + d;
    }

}
