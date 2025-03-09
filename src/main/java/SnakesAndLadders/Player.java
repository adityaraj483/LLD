package SnakesAndLadders;

public class Player {
    int id;
    String name;
    int currPosition;
    public Player(int id, String name, int currPosition){
        this.id = id;
        this.name = name;
        this.currPosition = currPosition;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCurrPosition() {
        return currPosition;
    }

    public void setCurrPosition(int currPosition) {
        this.currPosition = currPosition;
    }
}
