package ir.ac.kntu.gamelogic;

import java.util.concurrent.ThreadLocalRandom;

public class WildSnake {

    private int headLocation;

    private int tailLocation;

    private final int id;

    public WildSnake(int headLocation, int tailLocation, int id) {
        this.headLocation = headLocation;
        this.tailLocation = tailLocation;
        this.id = id + 1;
    }

    public int getHeadLocation() {
        return headLocation;
    }

    public int getTailLocation() {
        return tailLocation;
    }

    public void setHeadLocation(int headLocation) {
        this.headLocation = headLocation;
    }

    public void setTailLocation(int tailLocation) {
        this.tailLocation = tailLocation;
    }

    public int getId() {
        return id;
    }

    public void eat() {
        //TODO eating
    }

    public static void createWildSnake(int id) {
        int headLocation;
        do {
            headLocation = ThreadLocalRandom.current().nextInt(0, DataManager.getMapSizePawed());
        } while (!DataManager.map[headLocation].equals("    "));

        int tailLocation;
        do {
            tailLocation = ThreadLocalRandom.current().nextInt(0, DataManager.getMapSizePawed());
        } while (!DataManager.map[tailLocation].equals("    ") || tailLocation >= headLocation);

        DataManager.addWildSnake(new WildSnake(headLocation, tailLocation, id));
        DataManager.map[headLocation] = " \u001B[31m▟" + id + "\u001B[0m ";
        DataManager.map[tailLocation] = " \u001B[31m▘" + id + "\u001B[0m ";
    }

    @Override
    public String toString() {
        return "\u001B[31m" + this.getId() + "\u001B[0m";
    }
}
