package ir.ac.kntu.gamelogic;

import java.util.concurrent.ThreadLocalRandom;

public class Utilities {
    public static int[] tailLocator(int[] headLocation) {
        int x = ThreadLocalRandom.current().nextInt(0, DataManager.getMapSize());
        int y = ThreadLocalRandom.current().nextInt(0, DataManager.getMapSize());

        if (x + y >= headLocation[0] + headLocation[1]) {
            tailLocator(headLocation);
        } return new int[]{x, y};
    }
}
