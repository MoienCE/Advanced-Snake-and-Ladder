package ir.ac.kntu;

import ir.ac.kntu.gamelogic.DataManager;
import ir.ac.kntu.gamelogic.Player;

import java.util.Arrays;

public class Graphic {

    public static void printMap() {
        int length = DataManager.getMapSize();
        int height = (length * 2) + 1;
        int k = 0;
        for (int j = 0; j < height; j++) {
            if (j == 0) {
                System.out.print("┌");
                for (int i = 1; i < length; i++) {
                    System.out.print("────┬");
                }
                System.out.print("────┐\n");
            } else if (j == height - 1) {
                System.out.print("└");
                for (int i = 1; i < length; i++) {
                    System.out.print("────┴");
                }
                System.out.print("────┘");
            } else if (j % 2 == 1) {
                System.out.print("│");
                for (int i = 0; i < length; i++) {
                    System.out.print(DataManager.map[k] + "│");
                    k++;
                }
                System.out.println();
            } else {
                System.out.print("├");
                for (int i = 1; i < length; i++) {
                    System.out.print("────┼");
                }
                System.out.print("────┤\n");
            }
        }
    }
    
    public static void printStatus() {
        for (int i = 0; i < Player.getHealth(); i++) {
            System.out.print(" ♥");
        }
    }
}
