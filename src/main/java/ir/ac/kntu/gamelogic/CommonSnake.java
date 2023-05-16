package ir.ac.kntu.gamelogic;

public class CommonSnake extends Snake{
    @Override
    public void eat() {
        //TODO eating
    }

    @Override
    public String print() {
        return "\\u001B[33m" + Integer.toString(this.getId()) + "\\u001B[01m";
    }

    @Override
    public void generate() {
        //TODO generate snake
    }
}
