import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class KataTest {

    private Kata kata;

    private String[][] stringBoard = {
            {".", ".", ".", ".", ".", ".", ".", "."},
            {".", ".", ".", ".", "*", ".", ".", "."},
            {".", ".", ".", "*", "*", ".", ".", "."},
            {".", ".", ".", ".", ".", ".", ".", "."}
    };

    @Before
    public void before() {
        Board board = new Board(stringBoard);
        kata = new Kata(board);
    }

    @Test
    public void testMain() throws Exception {

    }

    @Test
    public void testGetCellInBounds_ShouldReturnNotNull() throws Exception {
        Cell cell = kata.getBoard().getCell(0, 0);
        assertNotNull(cell);
        cell = kata.getBoard().getCell(7, 0);
        assertNotNull(cell);
        cell = kata.getBoard().getCell(7, 3);
        assertNotNull(cell);
        cell = kata.getBoard().getCell(0, 3);
        assertNotNull(cell);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetCellOutOfBoundsX_ShouldThrowException() throws Exception {
        kata.getBoard().getCell(8, 0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetCellOutOfBoundsY_ShouldThrowException() throws Exception {
        kata.getBoard().getCell(0, 4);
    }

    @Test
    public void testCellIsAliveOnDeadCell_shouldReturnFalse() throws Exception {
        boolean alive = kata.getBoard().getCell(0,0).isAlive();
        assertEquals(false, alive);
    }

    @Test
    public void testCellIsAliveOnAliveCell_shouldReturnTrue() throws Exception {
        boolean alive = kata.getBoard().getCell(4, 1).isAlive();
        assertEquals(true, alive);
    }

    @Test
    public void testGetNeighboursInCorner_ShouldReturnThree() throws Exception {
        Cell[] neighboursA = kata.getBoard().getNeighbours(kata.getBoard().getCell(0, 0));
        Cell[] neighboursB = kata.getBoard().getNeighbours(kata.getBoard().getCell(7, 0));
        Cell[] neighboursC = kata.getBoard().getNeighbours(kata.getBoard().getCell(7, 3));
        Cell[] neighboursD = kata.getBoard().getNeighbours(kata.getBoard().getCell(0, 3));
        assertEquals(3, neighboursA.length);
        assertEquals(3, neighboursB.length);
        assertEquals(3, neighboursC.length);
        assertEquals(3, neighboursD.length);
    }

    @Test
    public void testGetNeighboursInCorner_0_0() throws Exception {
        Cell[] neighboursA = kata.getBoard().getNeighbours(kata.getBoard().getCell(0, 0));
        assertEquals(neighboursA[0], kata.getBoard().getCell(1, 0));
        assertEquals(neighboursA[1], kata.getBoard().getCell(1, 1));
        assertEquals(neighboursA[2], kata.getBoard().getCell(0, 1));
    }

    @Test
    public void testGetNeighboursInCorner_7_0() throws Exception {
        Cell[] neighboursA = kata.getBoard().getNeighbours(kata.getBoard().getCell(7, 0));
        assertEquals(neighboursA[0], kata.getBoard().getCell(6, 0));
        assertEquals(neighboursA[1], kata.getBoard().getCell(6, 1));
        assertEquals(neighboursA[2], kata.getBoard().getCell(7, 1));
    }

    @Test
    public void testGetNeighboursInCorner_0_3() throws Exception {
        Cell[] neighboursA = kata.getBoard().getNeighbours(kata.getBoard().getCell(0, 3));
        assertEquals(neighboursA[0], kata.getBoard().getCell(0, 2));
        assertEquals(neighboursA[1], kata.getBoard().getCell(1, 2));
        assertEquals(neighboursA[2], kata.getBoard().getCell(1, 3));
    }

    @Test
    public void testGetNeighboursInCorner_7_3() throws Exception {
        Cell[] neighboursA = kata.getBoard().getNeighbours(kata.getBoard().getCell(7, 3));
        assertEquals(neighboursA[0], kata.getBoard().getCell(6, 3));
        assertEquals(neighboursA[1], kata.getBoard().getCell(6, 2));
        assertEquals(neighboursA[2], kata.getBoard().getCell(7, 2));
    }

    @Test
    public void testGetNeighboursInMid_ShouldReturnEight() throws Exception {
        Cell[] neighboursA = kata.getBoard().getNeighbours(kata.getBoard().getCell(1, 1));
        assertEquals(8, neighboursA.length);
    }

    @Test
    public void testGetNeighboursEdge_ShouldReturnFive() throws Exception {
        Cell[] neighboursA = kata.getBoard().getNeighbours(kata.getBoard().getCell(0, 1));
        Cell[] neighboursB = kata.getBoard().getNeighbours(kata.getBoard().getCell(1, 0));
        Cell[] neighboursC = kata.getBoard().getNeighbours(kata.getBoard().getCell(7, 1));
        Cell[] neighboursD = kata.getBoard().getNeighbours(kata.getBoard().getCell(1, 3));
        assertEquals(5, neighboursA.length);
        assertEquals(5, neighboursB.length);
        assertEquals(5, neighboursC.length);
        assertEquals(5, neighboursD.length);
    }

}
