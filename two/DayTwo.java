package two;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Integer.parseInt;

public class DayTwo {
    static final int RED_CUBES = 12;
    static final int GREEN_CUBES = 13;
    static final int BLUE_CUBES = 14;
    static final String FILE = "two/input.txt";
    static int totalOfGameIds = 0;
    public static void main(String[] args) throws RuntimeException, IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                processGame(line);
            }
        }
        System.out.println(totalOfGameIds);
    }

    /**
     * Effectue un jeu
     *
     * @param line la ligne du jeu
     */
    private static void processGame(String line) {
        String[] partsOfCurrentLine = line.split(":");

        // game id du jeu
        int gameIdOfCurrentLine = getId(partsOfCurrentLine[0]);

        // tableau des tours où les cubes ont été tirées
        String[] sets = partsOfCurrentLine[1].split(";");

        for (String set : sets) {
            if (gameIdOfCurrentLine != -1) {
                String[] cubes = set.split(",");

                for (String cube : cubes) {
                    int red = 0;
                    int blue = 0;
                    int green = 0;

                    if (cube.contains("red")) {
                        cube = cube.replace("red", "").trim();
                        red = parseInt(cube) <= RED_CUBES ? parseInt(cube) : -1;
                    } else if (cube.contains("blue")) {
                        cube = cube.replace("blue", "").trim();
                        blue = parseInt(cube) <= BLUE_CUBES ? parseInt(cube) : -1;
                    } else {
                        cube = cube.replace("green", "").trim();
                        green = parseInt(cube) <= GREEN_CUBES ? parseInt(cube) : -1;
                    }
                    if (red == -1 || blue == -1 || green == -1) {
                        gameIdOfCurrentLine = -1;
                        break;
                    }
                }
            } else {
                break;
            }
        }
        if (gameIdOfCurrentLine != -1) {
            totalOfGameIds += gameIdOfCurrentLine;
        }
    }

    /**
     * Gets game ID
     * @param line the line representing the current game
     *
     * @return the id
     */
    private static int getId(String line) {
        Pattern pattern = Pattern.compile("\\d+");

        Matcher matcher = pattern.matcher(line);

        if (matcher.find()) {
            String nombreString = matcher.group();
            return parseInt(nombreString);
        }
        return -1;
    }
}
