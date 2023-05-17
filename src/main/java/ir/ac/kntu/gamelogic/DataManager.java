package ir.ac.kntu.gamelogic;

import java.util.ArrayList;
import java.util.Arrays;

public class DataManager {
    //********* (Snake Data) *********
    private static int commonSnakesNumber;

    private static int kindSnakesNumber;

    private static int wildSnakesNumber;

    private static final ArrayList<CommonSnake> COMMON_SNAKES = new ArrayList<>();

    private static final ArrayList<KindSnake> KIND_SNAKES = new ArrayList<>();

    private static final ArrayList<WildSnake> WILD_SNAKES = new ArrayList<>();

    public static ArrayList<CommonSnake> getCommonSnakes() {
        return COMMON_SNAKES;
    }

    public static void addCommonSnake(CommonSnake commonSnake) {
        COMMON_SNAKES.add(commonSnake);
    }

    public static ArrayList<KindSnake> getKindSnakes() {
        return KIND_SNAKES;
    }

    public static void addKindSnake(KindSnake kindSnake) {
        KIND_SNAKES.add(kindSnake);
    }

    public static ArrayList<WildSnake> getWildSnakes() {
        return WILD_SNAKES;
    }

    public static void addWildSnake(WildSnake wildSnake) {
        WILD_SNAKES.add(wildSnake);
    }

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



    //********* (Map Data) *********
    private static int mapSize;

    public static int getMapSizePawed() {
        return mapSize*mapSize;
    }

    public static int getMapSize() {
        return mapSize;
    }

    public static void setMapSize(int mapSize) {
        DataManager.mapSize = mapSize;
    }

    public static String[] map;

    public static void generateMap() {
        map = new String[mapSize * mapSize];
        Arrays.fill(map, "    ");
    }


    //********* (Dice Data) *********
    private static Dice currentDice;

    public static Dice getCurrentDice() {
        return currentDice;
    }

    public static void setCurrentDice(Dice currentDice) {
        DataManager.currentDice = currentDice;
    }
}
