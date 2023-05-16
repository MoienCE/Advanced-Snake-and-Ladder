package ir.ac.kntu.gamelogic;

import java.util.concurrent.ThreadLocalRandom;

public class Player {

    static int location;

    private static int health;

    public static int getHealth() {
        return health;
    }

    public static void setHealth(int health) {
        Player.health = health;
    }

    public static void create() {
        location = 0;
        health = 3;
    }

    @Override
    public String toString() {
        return " ** ";
    }
}
