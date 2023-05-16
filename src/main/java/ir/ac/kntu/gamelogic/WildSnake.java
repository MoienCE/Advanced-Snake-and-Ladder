package ir.ac.kntu.gamelogic;

import java.util.concurrent.ThreadLocalRandom;

public class WildSnake {
    private int[] headLocation;
    private int[] tailLocation;
    private final int id;

    public WildSnake(int[] headLocation, int[] tailLocation, int id) {
        this.headLocation = headLocation;
        this.tailLocation = tailLocation;
        this.id = id + 1;
    }

    public int[] getHeadLocation() {
        return headLocation;
    }

    public int[] getTailLocation() {
        return tailLocation;
    }

    public void setHeadLocation(int[] headLocation) {
        this.headLocation = headLocation;
    }

    public void setTailLocation(int[] tailLocation) {
        this.tailLocation = tailLocation;
    }

    public int getId() {
        return id;
    }

    public void eat() {
        //TODO eating
    }

    public static void createWildSnake(int id) {
        int x = ThreadLocalRandom.current().nextInt(0, DataManager.getMapSize());
        int y = ThreadLocalRandom.current().nextInt(0, DataManager.getMapSize());
        if (DataManager.map[x][y] == Object.EMPTY) {
            int[] headLocation = {x, y};
            int[] tailLocation = Utilities.tailLocator(headLocation);
            DataManager.addKindSnake(new KindSnake(headLocation, tailLocation, id));
            DataManager.map[x][y] = Object.WILD_SNAKE_TAIL;
            DataManager.map[tailLocation[0]][tailLocation[1]] = Object.WILD_SNAKE_TAIL;

        } else createWildSnake(id);
    }

    @Override
    public String toString() {
        return "\\u001B[37m" + this.getId() + "\\u001B[01m";
    }
}
