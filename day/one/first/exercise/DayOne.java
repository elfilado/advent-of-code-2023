package day.one.first.exercise;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class DayOne {
    static final String FILE = "day/one/first/exercise/input.txt";
    static int total = 0;
    public static void main(String[] args) throws IOException {

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {

                int firstDigit = 0;
                int lastDigit = 0;
                boolean firstFound = false;

                for (int i = 0; i < line.length(); i++) {
                    if (Character.isDigit(line.charAt(i)) && !firstFound) {
                        firstDigit = Character.getNumericValue(line.charAt(i));
                        firstFound = true;
                    }
                    if (Character.isDigit(line.charAt(i)) && firstFound) {
                        lastDigit = Character.getNumericValue(line.charAt(i));
                    }
                    if (i == line.length() - 1) {
                        int number = firstDigit * 10 + lastDigit;
                        total += number;
                    }
                }
            }
        }
        System.out.println(total);
    }
}