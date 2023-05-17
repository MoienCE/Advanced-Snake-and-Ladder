package ir.ac.kntu.gamelogic;

import java.util.concurrent.ThreadLocalRandom;

public class WildSnake {

    private int headLocation;

    private int tailLocation;

    private final int id;

    public WildSnake(int headLocation, int tailLocation, int id) {
        this.headLocation = headLocation;
        this.tailLocation = tailLocation;
        this.id = id;
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
        Player.setLocation(this.tailLocation);
        Player.setHealth(Player.getHealth() - 1);
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

    public static void turn() {
        for (int i = 0; i < DataManager.getWildSnakes().size(); i++) {
            DataManager.getWildSnakes().get(i).refactor();
        }
    }

    private void refactor() {
        int headLocation;
        do {
            headLocation = ThreadLocalRandom.current().nextInt(2, DataManager.getMapSizePawed());
        } while (!DataManager.map[headLocation].equals("    "));

        int tailLocation;
        do {
            tailLocation = ThreadLocalRandom.current().nextInt(0, DataManager.getMapSizePawed());
        } while (!DataManager.map[tailLocation].equals("    ") || tailLocation >= headLocation);

        int previousHeadLocation = this.headLocation;
        int previousTailLocation = this.tailLocation;

        this.headLocation = headLocation;
        this.tailLocation = tailLocation;

        if (DataManager.map[previousHeadLocation].equals(" \u001B[31m▟" + this.id + "\u001B[0m ")) {
            DataManager.map[previousHeadLocation] = "    ";
        }
        if (DataManager.map[previousTailLocation].equals(" \u001B[31m▘" + this.id + "\u001B[0m ")) {
            DataManager.map[previousTailLocation] = "    ";
        }

        DataManager.map[headLocation] = " \u001B[31m▟" + this.id + "\u001B[0m ";
        DataManager.map[tailLocation] = " \u001B[31m▘" + this.id + "\u001B[0m ";
    }

    @Override
    public String toString() {
        return "\u001B[31m" + this.getId() + "\u001B[0m";
    }
}
