package com.nisc586;

import java.util.Scanner;
import java.io.FileReader;
import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException{
        Scanner reader = new Scanner(new FileReader("src\\main\\resources\\day01.txt"));
        StringBuilder sb = new StringBuilder();
        while (reader.hasNextLine()) {
                sb.append(reader.nextLine()+ "\n");
        }
        String text = sb.toString();        
        String solution = com.nisc586.Day01.part1(text);
        System.out.println(solution);
        reader.close();
    }
}