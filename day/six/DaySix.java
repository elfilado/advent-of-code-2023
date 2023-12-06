package day.six;

public class DaySix {
    static final int NUMBER_OF_GAMES = 4;
    static final int G1_TIME = 41;
    static final int G1_DISTANCE = 249;
    static int G1_WAYS_OF_WIN = 0;
    static final int G2_TIME = 77;
    static final int G2_DISTANCE = 1362;
    static int G2_WAYS_OF_WIN = 0;
    static final int G3_TIME = 70;
    static final int G3_DISTANCE = 1127;
    static int G3_WAYS_OF_WIN = 0;
    static final int G4_TIME = 96;
    static final int G4_DISTANCE = 1011;
    static int G4_WAYS_OF_WIN = 0;
    static int total = 0;

    public static void main(String[] args) {
        int distance;
        for (int buttonHoldingTime = 0; buttonHoldingTime < G1_TIME; buttonHoldingTime++) {
            distance = buttonHoldingTime * (G1_TIME - buttonHoldingTime);
            if (distance > G1_DISTANCE) {
                G1_WAYS_OF_WIN++;
            }
        }
        System.out.println(G1_WAYS_OF_WIN);

        for (int buttonHoldingTime = 0; buttonHoldingTime < G2_TIME; buttonHoldingTime++) {
            distance = buttonHoldingTime * (G2_TIME - buttonHoldingTime);
            if (distance > G2_DISTANCE) {
                G2_WAYS_OF_WIN++;
            }
        }
        System.out.println(G2_WAYS_OF_WIN);

        for (int buttonHoldingTime = 0; buttonHoldingTime < G3_TIME; buttonHoldingTime++) {
            distance = buttonHoldingTime * (G3_TIME - buttonHoldingTime);
            if (distance > G3_DISTANCE) {
                G3_WAYS_OF_WIN++;
            }
        }
        System.out.println(G3_WAYS_OF_WIN);

        for (int buttonHoldingTime = 0; buttonHoldingTime < G4_TIME; buttonHoldingTime++) {
            distance = buttonHoldingTime * (G4_TIME - buttonHoldingTime);
            if (distance > G4_DISTANCE) {
                G4_WAYS_OF_WIN++;
            }
        }
        System.out.println(G4_WAYS_OF_WIN);

        System.out.println(G1_WAYS_OF_WIN * G2_WAYS_OF_WIN * G3_WAYS_OF_WIN * G4_WAYS_OF_WIN);
    }
}
