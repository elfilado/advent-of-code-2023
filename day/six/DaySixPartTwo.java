package day.six;

public class DaySixPartTwo {
    static final long G1_TIME = 41777096L;
    static final long G1_DISTANCE = 249136211271011L;
    static int waysOfWin = 0;
    public static void main(String[] args) {
        long distance;
        for (long buttonHoldingTime = 0; buttonHoldingTime < G1_TIME; buttonHoldingTime++) {
            distance = buttonHoldingTime * (G1_TIME - buttonHoldingTime);
            if (distance > G1_DISTANCE) {
                waysOfWin++;
            }
        }
        System.out.println(waysOfWin);
    }
}
