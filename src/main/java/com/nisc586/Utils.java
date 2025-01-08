package com.nisc586;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Utils {
    public static String getInputText(String filePath) {
        Scanner scanner = null;
        String text = "";
        try {
            scanner = new Scanner(new FileReader(filePath));
            StringBuilder sb = new StringBuilder();
                while (scanner.hasNextLine()) {
                        sb.append(scanner.nextLine()+ "\n");
                }
            text = sb.toString();    
        } catch (IOException e) {
            System.out.println("An IOException occured.");
            System.out.println(e);
        } finally {
            scanner.close();
        }
        return text;
    }

    public static List<List<Character>> get2DArray(String text) {
        Scanner scanner = null;
        List<List<Character>> twoDArray = new ArrayList<>();
        
        scanner = new Scanner(text);
        while (scanner.hasNextLine()) {
            List<Character> charList = scanner.nextLine().chars()
                    .mapToObj(c -> (char) c)
                    .collect(Collectors.toList());
            twoDArray.add(charList);
        }
        scanner.close();
        return twoDArray;
    }

    
    public static List<int[]> parseToListOfInts(String text, String sep) {
        /*Parse a string of lines separated by \n to a list of Integers */
        List<int[]> result = text.lines()
            .map(s -> s.split(sep))
            .map(nums -> Arrays.stream(nums).mapToInt(Integer::parseInt).toArray())
            .toList();
        return result;
    }


    public static <T> Iterable<T> cycle(List<T> list) {
        return () -> new Iterator<>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return !list.isEmpty();
            }

            @Override
            public T next() {
                T element = list.get(index);
                index = (index + 1) % list.size();
                return element;
            }
        };
    }
}
