package two;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Integer.parseInt;

public class DayTwoPartTwo {
    static final String FILE = "two/input.txt";
    static int total = 0;
    public static void main(String[] args) throws RuntimeException, IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                processGame(line);
            }
        }
        System.out.println(total);
    }

    /**
     * Effectue un jeu
     *
     * @param line la ligne du jeu
     */
    private static void processGame(String line) {
        int sum = 0;
        int redCubes = 0;
        int blueCubes = 0;
        int greenCubes = 0;
        String[] partsOfCurrentLine = line.split(":");

        // tableau des tours où les cubes ont été tirées
        String[] sets = partsOfCurrentLine[1].split(";");

        for (String set : sets) {
            String[] cubes = set.split(",");
            for (String cube : cubes) {
                if (cube.contains("red")) {
                    cube = cube.replace("red", "").trim();
                    redCubes = Math.max(parseInt(cube), redCubes);
                } else if (cube.contains("blue")) {
                    cube = cube.replace("blue", "").trim();
                    blueCubes = Math.max(parseInt(cube), blueCubes);
                } else {
                    cube = cube.replace("green", "").trim();
                    greenCubes = Math.max(parseInt(cube), greenCubes);
                }
            }
        }
        sum += redCubes * blueCubes * greenCubes;
        total += sum;
    }
}
