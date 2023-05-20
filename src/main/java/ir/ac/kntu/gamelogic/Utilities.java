package ir.ac.kntu.gamelogic;

import ir.ac.kntu.Graphic;
import org.jetbrains.annotations.NotNull;

import java.util.Random;

public class Utilities extends DataManager {

    private static final String TAIL_NOT_FOUND = """
            \u001B[31mno empty locations found for the << tail >>\u001B[0m
            -------------------------------------------
                ¯\\_(ツ)_/¯ kill yourself! ¯\\_(ツ)_/¯""";

    private static final String NOT_FOUND = """
            \u001B[31mno empty locations found for the << head >>\u001B[0m
            -------------------------------------------
                ¯\\_(ツ)_/¯ kill yourself! ¯\\_(ツ)_/¯""";

    public static int getRandom(int[] array) {
        int rnd = new Random().nextInt(array.length);
        return array[rnd];
    }

    public static int getRandomPro(int[] array) {
        int rnd = new Random().nextInt(1, array.length);
        return array[rnd];
    }


    public static int @NotNull [] emptyPlaces() {
        System.out.println("finding head location ...");

        int numberOfEmptyLocations = 0;
        for (int i = DataManager.getMapSize(); i < map.length - 3; i++) {
            if (map[i].equals("    ")) {
                numberOfEmptyLocations++;
            }
        }
        if (numberOfEmptyLocations == 0) {
            System.out.println(NOT_FOUND);
            System.out.println("\n\nWHY?\ntake a look at the last version of the generated map:");
            Graphic.printMap();
            System.exit(34);
        }

        int[] emptyLocations = new int[numberOfEmptyLocations];
        int counter = 0;
        for (int i = DataManager.getMapSize(); i < map.length - 3; i++) {
            if (map[i].equals("    ")) {
                emptyLocations[counter] = i;
                counter++;
            }
        }
        return emptyLocations;
    }

    public static int @NotNull [] emptyPlaces(int headLocation) {
        System.out.println("finding tail location...");

        int numberOfEmptyLocations = 0;
        for (int i = 0; i < headLocation; i++) {
            if (map[i].equals("    ") || i == Player.getLocation()) {
                numberOfEmptyLocations++;
            }
        }
        if (numberOfEmptyLocations == 0) {
            System.out.println(TAIL_NOT_FOUND);
            System.out.println("\n\nWHY?\ntake a look at the last version of the generated map:");
            Graphic.printMap();
            System.exit(34);
        }

        int[] emptyLocations = new int[numberOfEmptyLocations];
        int counter = 0;
        for (int i = 0; i < headLocation; i++) {
            if (map[i].equals("    ") || map[i].equals(" ** ")) {
                emptyLocations[counter] = i;
                counter++;
            }
        }
        return emptyLocations;
    }

    public static int @NotNull [] epKind(int headLocaation) {
        System.out.println("finding tail location...");

        int numberOfEmptyLocations = 0;
        for (int i = headLocaation + 1; i < map.length; i++) {
            if (map[i].equals("    ") || map[i].equals(" ** ")) {
                numberOfEmptyLocations++;
            }
        }
        if (numberOfEmptyLocations == 0) {
            System.out.println(TAIL_NOT_FOUND);
            System.out.println("\n\nWHY?\ntake a look at the last version of the generated map:");
            Graphic.printMap();
            System.exit(34);
        }

        int[] emptyLocations = new int[numberOfEmptyLocations];
        int counter = 0;
        for (int i = headLocaation + 1; i < map.length; i++) {
            if (map[i].equals("    ") || map[i].equals(" ** ")) {
                emptyLocations[counter] = i;
                counter++;
            }
        }
        return emptyLocations;
    }

}
