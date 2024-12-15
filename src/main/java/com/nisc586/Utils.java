package com.nisc586;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

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
}
