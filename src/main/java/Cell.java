
public class Cell {
    private final int x;
    private final int y;
    private boolean alive;

    public Cell(int x, int y, String status){
        this.x = x;
        this.y = y;
        this.alive = status.equals("*");
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
}
