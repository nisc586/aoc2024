package com.nisc586;

public class Day01 {
    public static String part1(String input) {

        int[] list1 = input.lines()
                .map((String s) -> s.split("\\h+")[0])
                .mapToInt(Integer::valueOf)
                .sorted()
                .toArray();

        int[] list2 = input.lines()
                .map((String s) -> s.split("\\h+")[1])
                .mapToInt(Integer::valueOf)
                .sorted()
                .toArray();
        
        int total = 0;
        for(int i=0; i < list1.length; i++) {
            total += Math.abs(list1[i] - list2[i]);
        }
        return String.valueOf(total);
    };
        
    public static String part2(String input) {
        int[] list1 = input.lines()
                .map((String s) -> s.split("\\h+")[0])
                .mapToInt(Integer::valueOf)
                .sorted()
                .toArray();

        int[] list2 = input.lines()
                .map((String s) -> s.split("\\h+")[1])
                .mapToInt(Integer::valueOf)
                .sorted()
                .toArray();
        
        int total = 0;
        for (int i=0; i < list1.length; i++) {
            int n = list1[i];
            int count = 0;
            for (int j=0; j < list2.length; j++) {
                count += n == list2[j] ? 1 : 0;
            }
            total += n * count;
        }
        return String.valueOf(total);
    }
}
