import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class BoardTest {

    private Board board;
    
    private String[][] stringBoard = {
            {".", ".", ".", ".", ".", ".", ".", "."},
            {".", ".", ".", ".", "*", ".", ".", "."},
            {".", ".", ".", "*", "*", ".", ".", "."},
            {".", ".", ".", ".", ".", ".", ".", "."}
    };

    @Before
    public void before() {
        board = new Board(stringBoard);
    }

    @Test
    public void testMain() throws Exception {

    }

    @Test
    public void testGetCellInBounds_ShouldReturnNotNull() throws Exception {
        Cell cell = board.getCell(0, 0);
        assertNotNull(cell);
        cell = board.getCell(7, 0);
        assertNotNull(cell);
        cell = board.getCell(7, 3);
        assertNotNull(cell);
        cell = board.getCell(0, 3);
        assertNotNull(cell);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetCellOutOfBoundsX_ShouldThrowException() throws Exception {
        board.getCell(8, 0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetCellOutOfBoundsY_ShouldThrowException() throws Exception {
        board.getCell(0, 4);
    }

    @Test
    public void testCellIsAliveOnDeadCell_shouldReturnFalse() throws Exception {
        boolean alive = board.getCell(0, 0).isAlive();
        assertEquals(false, alive);
    }

    @Test
    public void testCellIsAliveOnAliveCell_shouldReturnTrue() throws Exception {
        boolean alive = board.getCell(4, 1).isAlive();
        assertEquals(true, alive);
    }

    @Test
    public void testGetNeighboursInCorner_ShouldReturnThree() throws Exception {
        List<Cell> neighboursA = board.getNeighbours(board.getCell(0, 0));
        List<Cell> neighboursB = board.getNeighbours(board.getCell(7, 0));
        List<Cell> neighboursC = board.getNeighbours(board.getCell(7, 3));
        List<Cell> neighboursD = board.getNeighbours(board.getCell(0, 3));

        assertEquals(3, neighboursA.size());
        assertEquals(3, neighboursB.size());
        assertEquals(3, neighboursC.size());
        assertEquals(3, neighboursD.size());
    }

    @Test
    public void testGetNeighboursInCorner_0_0() throws Exception {
        List<Cell> neighboursA = board.getNeighbours(board.getCell(0, 0));
        assertTrue(neighboursA.contains(board.getCell(1, 0)));
        assertTrue(neighboursA.contains(board.getCell(1, 1)));
        assertTrue(neighboursA.contains(board.getCell(0, 1)));
    }

    @Test
    public void testGetNeighboursInCorner_7_0() throws Exception {
        List<Cell> neighboursA = board.getNeighbours(board.getCell(7, 0));
        assertTrue(neighboursA.contains(board.getCell(6, 0)));
        assertTrue(neighboursA.contains(board.getCell(6, 1)));
        assertTrue(neighboursA.contains(board.getCell(7, 1)));
    }

    @Test
    public void testGetNeighboursInCorner_0_3() throws Exception {
        List<Cell> neighboursA = board.getNeighbours(board.getCell(0, 3));
        assertTrue(neighboursA.contains(board.getCell(0, 2)));
        assertTrue(neighboursA.contains(board.getCell(1, 2)));
        assertTrue(neighboursA.contains(board.getCell(1, 3)));
    }

    @Test
    public void testGetNeighboursInCorner_7_3() throws Exception {
        List<Cell> neighboursA = board.getNeighbours(board.getCell(7, 3));
        assertTrue(neighboursA.contains(board.getCell(6, 3)));
        assertTrue(neighboursA.contains(board.getCell(6, 2)));
        assertTrue(neighboursA.contains(board.getCell(7, 2)));
    }

    @Test
    public void testGetNeighboursInCenter() throws Exception {
        List<Cell> neighboursA = board.getNeighbours(board.getCell(1, 1));
        assertTrue(neighboursA.contains(board.getCell(0, 0)));
        assertTrue(neighboursA.contains(board.getCell(1, 0)));
        assertTrue(neighboursA.contains(board.getCell(2, 0)));
        assertTrue(neighboursA.contains(board.getCell(2, 1)));
        assertTrue(neighboursA.contains(board.getCell(2, 2)));
        assertTrue(neighboursA.contains(board.getCell(1, 2)));
        assertTrue(neighboursA.contains(board.getCell(0, 2)));
        assertTrue(neighboursA.contains(board.getCell(0, 1)));
    }

    @Test
    public void testGetNeighboursOnEdgeA() throws Exception {
        List<Cell> neighboursA = board.getNeighbours(board.getCell(0, 1));
        assertTrue(neighboursA.contains(board.getCell(0, 0)));
        assertTrue(neighboursA.contains(board.getCell(1, 0)));
        assertTrue(neighboursA.contains(board.getCell(1, 1)));
        assertTrue(neighboursA.contains(board.getCell(1, 2)));
        assertTrue(neighboursA.contains(board.getCell(0, 2)));
    }

    @Test
    public void testGetNeighboursOnEdgeB() throws Exception {
        List<Cell> neighboursA = board.getNeighbours(board.getCell(1, 0));
        assertTrue(neighboursA.contains(board.getCell(2, 0)));
        assertTrue(neighboursA.contains(board.getCell(2, 1)));
        assertTrue(neighboursA.contains(board.getCell(1, 1)));
        assertTrue(neighboursA.contains(board.getCell(0, 1)));
        assertTrue(neighboursA.contains(board.getCell(0, 0)));
    }

    @Test
    public void testGetNeighboursOnEdgeC() throws Exception {
        List<Cell> neighboursA = board.getNeighbours(board.getCell(7, 1));
        assertTrue(neighboursA.contains(board.getCell(7, 2)));
        assertTrue(neighboursA.contains(board.getCell(6, 2)));
        assertTrue(neighboursA.contains(board.getCell(6, 1)));
        assertTrue(neighboursA.contains(board.getCell(6, 0)));
        assertTrue(neighboursA.contains(board.getCell(7, 0)));
    }

    @Test
    public void testGetNeighboursOnEdgeD() throws Exception {
        List<Cell> neighboursA = board.getNeighbours(board.getCell(1, 3));
        assertTrue(neighboursA.contains(board.getCell(0, 3)));
        assertTrue(neighboursA.contains(board.getCell(0, 2)));
        assertTrue(neighboursA.contains(board.getCell(1, 2)));
        assertTrue(neighboursA.contains(board.getCell(2, 2)));
        assertTrue(neighboursA.contains(board.getCell(2, 3)));
    }
}
