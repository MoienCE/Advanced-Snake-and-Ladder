package ir.ac.kntu.gamelogic;

import java.util.concurrent.ThreadLocalRandom;

public class Player {
    static int[] location = new int[2];
    public static void create() {
        location[0] = 0;
        location[1] = 0;
    }

    @Override
    public String toString() {
        return "☻";
    }
}
