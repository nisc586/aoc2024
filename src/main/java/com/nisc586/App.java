package com.nisc586;


public class App {
    public static void main(String[] args){
        String text = Utils.getInputText("src\\main\\resources\\day03.txt");    
        System.out.println(com.nisc586.Day03.part1(text));

        System.out.println();

        System.out.println(com.nisc586.Day03.part2(text));
    }
}