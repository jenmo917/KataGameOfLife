import java.util.List;

public class Evolution {

    // 1. Any live cell with fewer than two live neighbours dies, as if caused by underpopulation.
    // 2. Any live cell with more than three live neighbours dies, as if by overcrowding.
    // 3. Any live cell with two or three live neighbours lives on to the next generation.
    // 4. Any dead cell with exactly three live neighbours becomes a live cell.

    private Board evolutionBoard;

    public Evolution() {
    }

    public void evolve(Board board) {

        evolutionBoard = board.clone();
        evolutionBoard.killAll();

        for (Cell cell : board.getCells()) {
            List<Cell> neighbours = board.getNeighbours(cell);
            int numberOfAliveNeighbours = 0;
            for (Cell neighbour : neighbours) {
                if (neighbour.isAlive()) {
                    numberOfAliveNeighbours++;
                }
            }

            if (cell.isAlive() && numberOfAliveNeighbours >= 2 && numberOfAliveNeighbours <= 3) {
                evolutionBoard.getCell(cell.getX(), cell.getY()).setAlive(true);

            }
            else if(!cell.isAlive() && numberOfAliveNeighbours == 3){
                evolutionBoard.getCell(cell.getX(), cell.getY()).setAlive(true);
            }
        }
    }

    public Board getEvolutionBoard(){
        return evolutionBoard;
    }

}
