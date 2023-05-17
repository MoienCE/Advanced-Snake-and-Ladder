package ir.ac.kntu.gamelogic;

import java.util.concurrent.ThreadLocalRandom;

public class Player {

    private static int location;

    private static int previousLocation;

    private static int health;

    public static int getHealth() {
        return health;
    }

    public static void setHealth(int health) {
        Player.health = health;
    }

    public static int getLocation() {
        return location;
    }

    public static void setLocation(int location) {
        Player.location = location;
    }

    public static int getPreviousLocation() {
        return previousLocation;
    }

    public static void setPreviousLocation(int previousLocation) {
        Player.previousLocation = previousLocation;
    }

    public static void create() {
        location = 0;
        health = 3;
    }

    public static void move() {
        switch (DataManager.getCurrentDice()) {
            case UP -> goUp();
            case DOWN -> goDown();
            case LEFT -> goLeft();
            case RIGHT -> goRight();
            case TOP_LEFT -> goTopLeft();
            case TOP_RIGHT -> goTopRight();
            case DOWN_LEFT -> goDownLeft();
            case DOWN_RIGHT -> goDownRight();
            case EXTRA_LIFE -> {
                if (health < 3) {
                    health++;
                }
            }
        }
    }

    private static void goUp() {
        if (location - DataManager.getMapSize() >= 0) {
            previousLocation = location;
            location -= DataManager.getMapSize();
            DataManager.map[previousLocation] = "    ";
            DataManager.map[location] = " ** ";
        }
    }

    private static void goDown() {
        if (location + DataManager.getMapSize() < DataManager.getMapSizePawed()) {
            previousLocation = location;
            location += DataManager.getMapSize();
            DataManager.map[previousLocation] = "    ";
            DataManager.map[location] = " ** ";
        }
    }

    private static void goLeft() {
        if (location % DataManager.getMapSize() != 0 && location - 1 >= 0) {
            previousLocation = location;
            location--;
            DataManager.map[previousLocation] = "    ";
            DataManager.map[location] = " ** ";
        }
    }

    private static void goRight() {
        if (location % DataManager.getMapSize() != DataManager.getMapSize() - 1
                && location + 1 < DataManager.getMapSizePawed()) {

            previousLocation = location;
            location++;
            DataManager.map[previousLocation] = "    ";
            DataManager.map[location] = " ** ";
        }
    }

    private static void goTopLeft() {
        if (location % DataManager.getMapSize() != 0 &&
                location - (DataManager.getMapSize() + 1) >= 0) {

            previousLocation = location;
            location -= (DataManager.getMapSize() + 1);
            DataManager.map[previousLocation] = "    ";
            DataManager.map[location] = " ** ";
        }
    }

    private static void goTopRight() {
        if (location % DataManager.getMapSize() != (DataManager.getMapSize() - 1)
                && location - (DataManager.getMapSize() - 1) >= 0) {

            previousLocation = location;
            location -= (DataManager.getMapSize() - 1);
            DataManager.map[previousLocation] = "    ";
            DataManager.map[location] = " ** ";
        }
    }

    private static void goDownLeft() {
        if (location % DataManager.getMapSize() != 0 &&
                location + (DataManager.getMapSize() - 1) < DataManager.getMapSizePawed()) {
            previousLocation = location;
            location += (DataManager.getMapSize() - 1);
            DataManager.map[previousLocation] = "    ";
            DataManager.map[location] = " ** ";
        }
    }

    private static void goDownRight() {
        if (location % DataManager.getMapSize() != (DataManager.getMapSize() - 1)
                && location + (DataManager.getMapSize() + 1) < DataManager.getMapSizePawed()) {

            previousLocation = location;
            location += (DataManager.getMapSize() + 1);
            DataManager.map[previousLocation] = "    ";
            DataManager.map[location] = " ** ";
        }
    }

    @Override
    public String toString() {
        return " ** ";
    }
}
