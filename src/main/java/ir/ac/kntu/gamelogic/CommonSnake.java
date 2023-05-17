package ir.ac.kntu.gamelogic;

import java.util.concurrent.ThreadLocalRandom;

public class CommonSnake {

    private final int headLocation;

    private int tailLocation;

    private final int id;

    public CommonSnake(int headLocation, int tailLocation, int id) {
        this.headLocation = headLocation;
        this.tailLocation = tailLocation;
        this.id = id;
    }

    public int getHeadLocation() {
        return headLocation;
    }

    public int getId() {
        return id;
    }

    public void eat() {
        Player.setLocation(this.tailLocation);
    }

    public static void createCommonSnake(int id) {
        int headLocation;
        do {
            headLocation = ThreadLocalRandom.current().nextInt(0, DataManager.getMapSizePawed());
        } while (!DataManager.map[headLocation].equals("    "));

        int tailLocation;
        do {
            tailLocation = ThreadLocalRandom.current().nextInt(0, DataManager.getMapSizePawed());
        } while (!DataManager.map[tailLocation].equals("    ") || tailLocation >= headLocation);

        DataManager.addCommonSnake(new CommonSnake(headLocation, tailLocation, id));
        DataManager.map[headLocation] = " \u001B[33m▟" + id + "\u001B[0m ";
        DataManager.map[tailLocation] = " \u001B[33m▘" + id + "\u001B[0m ";
    }

    public static void turn() {
        for (int i = 0; i < DataManager.getCommonSnakes().size(); i++) {
            DataManager.getCommonSnakes().get(i).changeTail();
        }
    }

    private void changeTail() {
        int tailLocation;

        do {
            tailLocation = ThreadLocalRandom.current().nextInt(0, DataManager.getMapSizePawed());
        } while (!DataManager.map[tailLocation].equals("    ") || tailLocation >= headLocation);
        int previousTailLocation = this.tailLocation;
        this.tailLocation = tailLocation;
        if (DataManager.map[previousTailLocation].equals(" \u001B[33m▘" + this.id + "\u001B[0m ")) {
            DataManager.map[previousTailLocation] = "    ";
        }
        DataManager.map[this.tailLocation] = " \u001B[33m▘" + this.id + "\u001B[0m ";
    }


    @Override
    public String toString() {
        return "\u001B[33m" + this.getId() + "\u001B[0m";
    }
}
