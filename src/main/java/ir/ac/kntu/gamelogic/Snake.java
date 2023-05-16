package ir.ac.kntu.gamelogic;

import java.util.concurrent.ThreadLocalRandom;

public abstract class Snake {
    private final int[] headLocation = new int[2];

    private int[][] tailLocation;

    private int id;

    public int[] getHeadLocation() {
        return headLocation;
    }

    public int[][] getTailLocation() {
        return tailLocation;
    }

    public void setTailLocation(int[][] tailLocation) {
        this.tailLocation = tailLocation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static void create() {
        for (int i = 0; i < DataManager.getCommonSnakesNumber(); i++) {

        }
    }

    public abstract void eat();
    public abstract String print();

    public abstract void generate();
}
