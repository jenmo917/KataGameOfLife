import java.util.ArrayList;
import java.util.List;

public class Board implements Cloneable {

    private int numberOfCols;
    private int numberOfRows;
    //Cell[x][y]
    private Cell[][] cells;

    public Board(String[][] board) {

        numberOfCols = board[0].length;
        numberOfRows = board.length;

        cells = new Cell[numberOfCols][numberOfRows];

        for (int row = 0; row < numberOfRows; row++) {
            for (int col = 0; col < numberOfCols; col++) {
                cells[col][row] = new Cell(col, row, board[row][col]);
            }
        }
    }

    public Board(int numberOfRows, int numberOfCols) {
        this.numberOfCols = numberOfCols;
        this.numberOfRows = numberOfRows;

        cells = new Cell[numberOfCols][numberOfRows];
        for (int row = 0; row < numberOfRows; row++) {
            for (int col = 0; col < numberOfCols; col++) {
                cells[col][row] = new Cell(col, row, ".");
            }
        }
    }

    public List<Cell> getNeighbours(Cell cell) {

        List<Cell> neighbours = new ArrayList<>();

        int startRow = Math.max(cell.getY() - 1, 0);
        int endRow = Math.min(cell.getY() + 1, numberOfRows - 1);

        for (int row = startRow; row <= endRow; row++) {

            int startColumn = Math.max(0, cell.getX() - 1);
            int endColumn = Math.min(numberOfCols - 1, cell.getX() + 1);

            for (int column = startColumn; column <= endColumn; column++) {
                Cell e = cells[column][row];
                if (cell != e) {
                    neighbours.add(e);
                }
            }
        }
        return neighbours;
    }

    public Cell getCell(int x, int y) {
        return cells[x][y];
    }

    @Override
    public boolean equals(Object obj) {
        return this == obj;
    }

    public List<Cell> getCells() {
        List<Cell> cells = new ArrayList<>();
        for (int row = 0; row < numberOfRows; row++) {
            for (int col = 0; col < numberOfCols; col++) {
                cells.add(this.cells[col][row]);
            }
        }
        return cells;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int row = 0; row < numberOfRows; row++) {
            for (int col = 0; col < numberOfCols; col++) {
                sb.append(this.cells[col][row].toString());
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    @Override
    protected Board clone() {
        return new Board(numberOfRows, numberOfCols);
    }
}
