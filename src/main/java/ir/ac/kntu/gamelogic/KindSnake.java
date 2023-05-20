package ir.ac.kntu.gamelogic;

public class KindSnake {

    private final int headLocation;

    private int tailLocation;

    private final int id;

    public KindSnake(int headLocation, int tailLocation, int id) {
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

    public static void createKindSnake(int id) {
        System.out.println("\n--- creating kind snake " + id + " ---");

        int headLocation = Utilities.getRandom(Utilities.emptyPlaces());
        DataManager.map[headLocation] = " \u001B[36m▟" + id + "\u001B[0m ";

        int tailLocation = Utilities.getRandom(Utilities.epKind(headLocation));
        DataManager.map[tailLocation] = " \u001B[36m▘" + id + "\u001B[0m ";

        DataManager.addKindSnake(new KindSnake(headLocation, tailLocation, id));
    }

    public static void turn() {
        for (int i = 0; i < DataManager.getKindSnakes().size(); i++) {
            DataManager.getKindSnakes().get(i).changeTail();
        }
    }

    private void changeTail() {
        System.out.println("\n--- editing kind snake " + id + " ---");

        if (DataManager.map[this.tailLocation].equals(" \u001B[36m▘" + this.id + "\u001B[0m ")) {
            DataManager.map[this.tailLocation] = "    ";
        }

        this.tailLocation = Utilities.getRandom(Utilities.epKind(this.headLocation));
        DataManager.map[this.tailLocation] = " \u001B[36m▘" + id + "\u001B[0m ";
    }


    @Override
    public String toString() {
        return "\u001B[36m" + this.getId() + "\u001B[0m";
    }
}
