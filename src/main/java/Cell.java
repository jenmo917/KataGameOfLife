
public class Cell {
    private final int x;
    private final int y;
    private boolean alive;

    public Cell(int x, int y, boolean isAlive){
        this.x = x;
        this.y = y;
        this.alive = isAlive;
    }


    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return isAlive() ? "*" : ".";
    }
}
