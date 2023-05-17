package ir.ac.kntu.gamelogic;

import ir.ac.kntu.Graphic;

import java.util.Scanner;

public class GameProcess {

    static Scanner scanner = new Scanner(System.in);

    public static void start() {
        readSize();
        DataManager.generateMap();
        readSnakes();
        Player.create();
        DataManager.map[0] = " ** ";
        DataManager.map[DataManager.map.length -1] = "(  )";
        DataManager.setCurrentDice(Dice.NONE);
        for (int i = 0; i < DataManager.getCommonSnakesNumber(); i++) {
            CommonSnake.createCommonSnake(i);
        }
        for (int i = 0; i < DataManager.getKindSnakesNumber(); i++) {
            KindSnake.createKindSnake(i);
        }
        for (int i = 0; i < DataManager.getWildSnakesNumber(); i++) {
            WildSnake.createWildSnake(i);
        }
        DataManager.setCurrentDice(Dice.NONE);
        Graphic.printMap();
        play();
    }

    public static void play() {
        while(true) {
            System.out.print("\n press Enter to dice... >> ");
            scanner.nextLine();
            Dice.randomDice();
            Player.move();
            CommonSnake.turn();
            KindSnake.turn();
            WildSnake.turn();
            Graphic.printMap();
            if (Player.getHealth() < 1) {
                System.out.println("\nyou died.");
                break;
            }
            if (Player.getLocation() == DataManager.getMapSizePawed() - 1) {
                System.out.println("\nyou won!");
                break;
            }
        }
    }

    public static void readSize() {
        System.out.print("size of the map: ");
        DataManager.setMapSize(Integer.parseInt(scanner.nextLine()));
    }

    public static void readSnakes() {
        System.out.print("number of common snakes: ");
        DataManager.setCommonSnakesNumber(Integer.parseInt(scanner.nextLine()));

        System.out.print("number of kind snakes: ");
        DataManager.setKindSnakesNumber(Integer.parseInt(scanner.nextLine()));

        System.out.print("number of wild snakes: ");
        DataManager.setWildSnakesNumber(Integer.parseInt(scanner.nextLine()));
    }
}
