package ir.ac.kntu.gamelogic;

import java.util.Random;

public enum Dice {
    UP, DOWN, LEFT, RIGHT,
    TOP_RIGHT, TOP_LEFT, DOWN_RIGHT, DOWN_LEFT,
    EXTRA_LIFE, NONE;

    private static final Random PRNG = new Random();

    public static void randomDice() {
        Dice[] dices = values();
        DataManager.setCurrentDice(dices[PRNG.nextInt(dices.length -1)]);
    }
}
