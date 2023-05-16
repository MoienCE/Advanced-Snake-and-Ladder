package ir.ac.kntu.gamelogic;

public class DataManager {
    private static int mapSize;

    public static int getMapSize() {
        return mapSize;
    }

    public static void setMapSize(int mapSize) {
        DataManager.mapSize = mapSize;
    }

    private static int commonSnakesNumber;

    private static int kindSnakesNumber;

    private static int wildSnakesNumber;

    public static int getCommonSnakesNumber() {
        return commonSnakesNumber;
    }

    public static void setCommonSnakesNumber(int commonSnakesNumber) {
        DataManager.commonSnakesNumber = commonSnakesNumber;
    }

    public static int getKindSnakesNumber() {
        return kindSnakesNumber;
    }

    public static void setKindSnakesNumber(int kindSnakesNumber) {
        DataManager.kindSnakesNumber = kindSnakesNumber;
    }

    public static int getWildSnakesNumber() {
        return wildSnakesNumber;
    }

    public static void setWildSnakesNumber(int wildSnakesNumber) {
        DataManager.wildSnakesNumber = wildSnakesNumber;
    }
}
