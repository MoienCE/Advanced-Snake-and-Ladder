package ir.ac.kntu.gamelogic;

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
        System.out.println("\n--- creating common snake " + id + " ---");

        int headLocation = Utilities.getRandom(Utilities.emptyPlaces());
        DataManager.map[headLocation] = " \u001B[33m▟" + id + "\u001B[0m ";

        int tailLocation = Utilities.getRandom(Utilities.emptyPlaces(headLocation));
        DataManager.map[tailLocation] = " \u001B[33m▘" + id + "\u001B[0m ";

        DataManager.addCommonSnake(new CommonSnake(headLocation, tailLocation, id));
    }

    public static void turn() {
        for (int i = 0; i < DataManager.getCommonSnakes().size(); i++) {
            DataManager.getCommonSnakes().get(i).changeTail();
        }
    }

    private void changeTail() {
        System.out.println("\n--- editing common snake " + id + " ---");

        if (DataManager.map[this.tailLocation].equals(" \u001B[33m▘" + this.id + "\u001B[0m ")) {
            DataManager.map[this.tailLocation] = "    ";
        }

        this.tailLocation = Utilities.getRandom(Utilities.emptyPlaces(this.headLocation));
        DataManager.map[this.tailLocation] = " \u001B[33m▘" + this.id + "\u001B[0m ";
    }


    @Override
    public String toString() {
        return "\u001B[33m" + this.getId() + "\u001B[0m";
    }
}
