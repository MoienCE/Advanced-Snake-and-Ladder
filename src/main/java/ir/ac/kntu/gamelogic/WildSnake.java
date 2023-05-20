package ir.ac.kntu.gamelogic;

public class WildSnake {

    private int headLocation;

    private int tailLocation;

    private final int id;

    public WildSnake(int headLocation, int tailLocation, int id) {
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
        Player.setHealth(Player.getHealth() - 1);
    }

    public static void createWildSnake(int id) {
        System.out.println("\n--- creating wild snake " + id + " ---");

        int headLocation = Utilities.getRandom(Utilities.emptyPlaces());
        DataManager.map[headLocation] = " \u001B[31m▟" + id + "\u001B[0m ";

        int tailLocation = Utilities.getRandom(Utilities.emptyPlaces(headLocation));
        DataManager.map[tailLocation] = " \u001B[31m▘" + id + "\u001B[0m ";

        DataManager.addWildSnake(new WildSnake(headLocation, tailLocation, id));
    }

    public static void turn() {
        for (int i = 0; i < DataManager.getWildSnakes().size(); i++) {
            DataManager.getWildSnakes().get(i).refactor();
        }
    }

    private void refactor() {
        System.out.println("\n--- editing wild snake " + id + " ---");

        DataManager.map[this.headLocation] = "    ";
        if (DataManager.map[this.tailLocation].equals(" \u001B[31m▘" + this.id + "\u001B[0m ")) {
            DataManager.map[this.tailLocation] = "    ";
        }

        this.headLocation = Utilities.getRandomPro(Utilities.emptyPlaces());
        DataManager.map[this.headLocation] = " \u001B[31m▟" + this.id + "\u001B[0m ";

        this.tailLocation = Utilities.getRandom(Utilities.emptyPlaces(this.headLocation));
        DataManager.map[this.tailLocation] = " \u001B[31m▘" + this.id + "\u001B[0m ";
    }

    @Override
    public String toString() {
        return "\u001B[31m" + this.getId() + "\u001B[0m";
    }
}
