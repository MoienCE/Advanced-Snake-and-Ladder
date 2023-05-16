package ir.ac.kntu;

import ir.ac.kntu.gamelogic.DataManager;

public class Map {
    public static void printMap (){
        int length = DataManager.getMapSize();
        int height = (length * 2) + 1;
        for (int j = 0; j < height; j++) {
            if (j == 0) {
                System.out.print("┌");
                for (int i = 1; i < length; i++) {
                    System.out.print("───┬");
                }
                System.out.print("───┐\n");
            } else if (j == height - 1) {
                System.out.print("└");
                for (int i = 1; i < length; i++) {
                    System.out.print("───┴");
                }
                System.out.print("───┘");
            } else if (j % 2 == 1) {
                System.out.print("│" );
                for (int i = 0; i < length; i++) {
                    System.out.print(" M " + "│");
                }
                System.out.println();
            } else {
                System.out.print("├");
                for (int i = 1; i < length; i++) {
                    System.out.print("───┼");
                }
                System.out.print("───┤\n");
            }
        }
    }
}
