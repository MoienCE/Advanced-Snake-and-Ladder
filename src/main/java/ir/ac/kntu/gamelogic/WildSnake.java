package ir.ac.kntu.gamelogic;

public class WildSnake extends Snake{
    @Override
    public void eat() {
        //TODO eating
    }

    @Override
    public String print() {
        return "\\u001B[31m" + Integer.toString(this.getId()) + "\\u001B[0m";
    }

    @Override
    public void generate() {
        //TODO generate snake
    }
}
