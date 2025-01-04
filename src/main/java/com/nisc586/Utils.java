package com.nisc586;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
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
}
