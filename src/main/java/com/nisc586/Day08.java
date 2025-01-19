package com.nisc586;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.List;
import org.apache.commons.lang3.tuple.Pair;

public class Day08 {
    public static String part1(String input) {
        final int N = input.split("\\n")[0].length();
        Map<Character, List<Integer[]>> antennas = Utils.get2DReverseMap(input);
        Set<Character> antennaTypes = antennas.keySet();

        Set<Pair<Integer, Integer>> antinodes = new HashSet<>();
        for (Character a : antennaTypes) {
            List<Integer[]> positions = antennas.get(a);
            for(int i=0; i < positions.size(); i++) {
                for (int j=i+1; j < positions.size(); j++) {
                    // get row and column of antenna A
                    int ra = positions.get(i)[0];
                    int ca = positions.get(i)[1];

                    // get row and column of antenna B
                    int rb = positions.get(j)[0];
                    int cb = positions.get(j)[1];

                    // calculate distance
                    int dr = rb - ra;
                    int dc = cb - ca;

                    // calculate antinode for antenna A
                    int rra = ra - dr;
                    int cca = ca - dc;
                    if (0 <= rra && rra < N && 0 <= cca && cca < N) {
                        antinodes.add(Pair.of(rra, cca));
                    }

                    // calculate antinode for antenna B
                    int rrb = rb + dr;
                    int ccb = cb + dc;
                    if (0 <= rrb && rrb < N && 0 <= ccb && ccb < N) {
                        antinodes.add(Pair.of(rrb, ccb));
                    }
                }
            }
        }

        return String.valueOf(antinodes.size());
    }

    public static String part2(String input) {
        final int N = input.split("\\n")[0].length();
        Map<Character, List<Integer[]>> antennas = Utils.get2DReverseMap(input);
        Set<Character> antennaTypes = antennas.keySet();

        Set<Pair<Integer, Integer>> antinodes = new HashSet<>();
        for (Character a : antennaTypes) {
            List<Integer[]> positions = antennas.get(a);
            for(int i=0; i < positions.size(); i++) {
                for (int j=i+1; j < positions.size(); j++) {
                    // get row and column of antenna A
                    int ra = positions.get(i)[0];
                    int ca = positions.get(i)[1];

                    // get row and column of antenna B
                    int rb = positions.get(j)[0];
                    int cb = positions.get(j)[1];

                    // calculate distance
                    int dr = rb - ra;
                    int dc = cb - ca;

                    // calculate antinodes along the line created by A and B
                    int limit = Math.max(N / dr, N / dc);
                    for(int n=0; n<=limit; n++) {
                        // positive direction
                        int rr = ra + n * dr;
                        int cc = ca + n * dc;
                        if (0 <= rr && rr < N && 0 <= cc && cc < N) {
                            antinodes.add(Pair.of(rr, cc));
                        }

                        // negative direction
                        rr = ra - n * dr;
                        cc = ca - n * dc;
                        if (0 <= rr && rr < N && 0 <= cc && cc < N) {
                            antinodes.add(Pair.of(rr, cc));
                        }
                    }
                }
            }
        }

        return String.valueOf(antinodes.size());
    }
}
