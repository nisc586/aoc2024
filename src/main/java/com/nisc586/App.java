package com.nisc586;


public class App {
    public static void main(String[] args){
        String text = Utils.getInputText("src\\main\\resources\\day02.txt");    
        System.out.println(com.nisc586.Day02.part1(text));

        System.out.println();

        System.out.println(com.nisc586.Day02.part2(text));
    }
}