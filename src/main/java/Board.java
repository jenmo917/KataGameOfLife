
public class Board {

    //Cell[x][y]
    private Cell[][] cells;

    public Board(String[][] board) {

        int numberOfCols = board[0].length;
        int numberOfRows = board.length;
        this.cells = new Cell[numberOfCols][numberOfRows];

        for (int row = 0; row < numberOfRows; row++) {
            for (int col = 0; col < numberOfCols; col++) {
                cells[col][row] = new Cell(col, row, board[row][col]);
            }
        }
    }

    public Cell[] getNeighbours(Cell cell) {
        Cell[] neighbours = new Cell[3];

        if (cell.getX() == 0 && cell.getY() == 0) {
            neighbours[0] = cells[1][0];
            neighbours[1] = cells[1][1];
            neighbours[2] = cells[0][1];
        }
        if (cell.getX() == 7 && cell.getY() == 0) {
            neighbours[0] = cells[6][0];
            neighbours[1] = cells[6][1];
            neighbours[2] = cells[7][1];
        }
        if (cell.getX() == 0 && cell.getY() == 3) {
            neighbours[0] = cells[0][2];
            neighbours[1] = cells[1][2];
            neighbours[2] = cells[1][3];
        }
        if (cell.getX() == 7 && cell.getY() == 3) {
            neighbours[0] = cells[6][3];
            neighbours[1] = cells[6][2];
            neighbours[2] = cells[7][2];
        }
        return neighbours;
    }

    public Cell getCell(int x, int y) {
        return cells[x][y];
    }

}
