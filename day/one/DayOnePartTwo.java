package day.one;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class DayOnePartTwo {
    static final String FILE = "day/one/input.txt";
    static int total = 0;
    static final HashMap<String, String> VALUES = new HashMap<>();
    static void fillMap() {
        VALUES.put("one", "1");
        VALUES.put("day/two", "2");
        VALUES.put("three", "3");
        VALUES.put("four", "4");
        VALUES.put("five", "5");
        VALUES.put("six", "6");
        VALUES.put("seven", "7");
        VALUES.put("eight", "8");
        VALUES.put("nine", "9");
    }
    public static void main(String[] args) throws IOException {
        fillMap();
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
                    if (Character.isDigit(line.charAt(i))) {
                        lastDigit = Character.getNumericValue(line.charAt(i));
                    }
                    if (i == line.length() - 1) {
                        Map<Integer, String> indexesValues = new HashMap<>();
                        String first = "" + firstDigit;
                        String second = "" + lastDigit;
                        for (String key : VALUES.keySet()) {
                            if (line.contains(key)) {
                                indexesValues.put(line.lastIndexOf(key), key);
                            }
                        }
                        if (!indexesValues.keySet().stream().toList().isEmpty()) {
                            Integer ff = indexesValues.keySet().stream().sorted(Comparator.naturalOrder()).toList().getFirst();
                            Integer ll = indexesValues.keySet().stream().sorted(Comparator.naturalOrder()).toList().getLast();

                            if (ff < line.indexOf(first)) {
                                String value = indexesValues.get(ff);
                                value = value.replace(value, VALUES.get(value));
                                firstDigit = Integer.parseInt(value);
                            } else if (ll > line.indexOf(second)) {
                                String value = indexesValues.get(ll);
                                value = value.replace(value, VALUES.get(value));
                                lastDigit = Integer.parseInt(value);
                            }
                        }
                        int number = firstDigit * 10 + lastDigit;
                        System.out.println(number);
                        total += number;
                    }
                }
            }
        }
        System.out.println(total);
    }
}