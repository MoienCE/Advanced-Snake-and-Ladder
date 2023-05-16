package ir.ac.kntu.gamelogic;

import java.util.Random;

public enum Dice {
    UP, DOWN, LEFT, RIGHT,
    TOP_RIGHT, TOP_LEFT, DOWN_RIGHT, DOWN_LEFT,
    EXTRA_LIFE, NONE;

    private static final Random PRNG = new Random();

    private static Dice lastDice;

    public static Dice getLastDice() {
        return lastDice;
    }

    public static void setLastDice(Dice lastDice) {
        Dice.lastDice = lastDice;
    }

    public static Dice randomDice() {
        Dice[] dices = values();
        return dices[PRNG.nextInt(dices.length)];
    }
}
