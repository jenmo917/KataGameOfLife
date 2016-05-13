import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.*;

public class EvolutionTest {

    // 1. Any live cell with fewer than two live neighbours dies, as if caused by underpopulation.
    // 2. Any live cell with more than three live neighbours dies, as if by overcrowding.
    // 3. Any live cell with two or three live neighbours lives on to the next generation.
    // 4. Any dead cell with exactly three live neighbours becomes a live cell.

    private String[][] stringBoard = {
            {".", ".", ".", ".", ".", ".", ".", "."},
            {".", ".", ".", ".", ".", ".", ".", "."},
            {".", ".", ".", ".", ".", ".", ".", "."},
            {".", ".", ".", ".", ".", ".", ".", "."}
    };

    private Board board;

    @Before
    public void setUp() throws Exception {
        board = new Board(stringBoard);
    }

    @Test
    public void testRule1_oneAlive_shouldDie() throws Exception {
        board.getCell(0,0).setAlive(true);
        Evolution evolution = new Evolution();
        evolution.evolve(board);
        assertFalse(evolution.getEvolutionBoard().getCell(0, 0).isAlive());
    }

    @Test
    public void testRule1_twoAlive_shouldDie() throws Exception {
        board.getCell(0, 0).setAlive(true);
        board.getCell(1, 0).setAlive(true);

        Evolution evolution = new Evolution();
        evolution.evolve(board);
        assertFalse(evolution.getEvolutionBoard().getCell(0, 0).isAlive());
        assertFalse(evolution.getEvolutionBoard().getCell(1, 0).isAlive());
    }

    @Test
    public void testRule1_ThreeAlive_shouldSurvive() throws Exception {
        board.getCell(0, 0).setAlive(true);
        board.getCell(1, 0).setAlive(true);
        board.getCell(0, 1).setAlive(true);

        Evolution evolution = new Evolution();
        evolution.evolve(board);
        assertTrue(evolution.getEvolutionBoard().getCell(0, 0).isAlive());
        assertTrue(evolution.getEvolutionBoard().getCell(1, 0).isAlive());
        assertTrue(evolution.getEvolutionBoard().getCell(0, 1).isAlive());
    }

    @Test
    public void testRule2_aliveWithFourAliveNeighbours_shouldDie() throws Exception {
        board.getCell(0,0).setAlive(true);
        board.getCell(1,0).setAlive(true);
        board.getCell(0,1).setAlive(true);
        board.getCell(1,1).setAlive(true);
        board.getCell(2,0).setAlive(true);
        board.getCell(2, 1).setAlive(true);

        Evolution evolution = new Evolution();
        evolution.evolve(board);
        assertTrue(evolution.getEvolutionBoard().getCell(0, 0).isAlive());
        assertFalse(evolution.getEvolutionBoard().getCell(1, 0).isAlive());
        assertTrue(evolution.getEvolutionBoard().getCell(0, 1).isAlive());
        assertFalse(evolution.getEvolutionBoard().getCell(1, 1).isAlive());
        assertTrue(evolution.getEvolutionBoard().getCell(2, 0).isAlive());
        assertTrue(evolution.getEvolutionBoard().getCell(2, 1).isAlive());
    }

    // 3. Any live cell with two or three live neighbours lives on to the next generation.

    @Test
    public void testRule3_aliveWithTwoAliveNeighbours_shouldLive() throws Exception {
        board.getCell(0,0).setAlive(true);
        board.getCell(1,0).setAlive(true);
        board.getCell(0,1).setAlive(true);
        board.getCell(1, 1).setAlive(false);

        Evolution evolution = new Evolution();
        evolution.evolve(board);
        assertTrue(evolution.getEvolutionBoard().getCell(0, 0).isAlive());
        assertTrue(evolution.getEvolutionBoard().getCell(1, 0).isAlive());
        assertTrue(evolution.getEvolutionBoard().getCell(0, 1).isAlive());
    }

    @Test
    public void testRule3_1_1_deadThreeAliveNeighbours_shouldLive() throws Exception {
        board.getCell(0,0).setAlive(true);
        board.getCell(1,0).setAlive(true);
        board.getCell(0, 1).setAlive(true);
        board.getCell(1, 1).setAlive(false);

        Evolution evolution = new Evolution();
        evolution.evolve(board);
        assertTrue(evolution.getEvolutionBoard().getCell(1, 1).isAlive());
    }

    @Test
    public void testRule3_aliveWithThreeAliveNeighbours_shouldLive() throws Exception {
        board.getCell(0,0).setAlive(false);
        board.getCell(1,0).setAlive(true);
        board.getCell(2,0).setAlive(false);
        board.getCell(0,1).setAlive(true);
        board.getCell(1,1).setAlive(true);
        board.getCell(2, 1).setAlive(true);

        Evolution evolution = new Evolution();
        evolution.evolve(board);
        assertTrue(evolution.getEvolutionBoard().getCell(1, 0).isAlive());
        assertTrue(evolution.getEvolutionBoard().getCell(1, 1).isAlive());
    }

    @Test
    public void testRule4_1_0_deadWithThreeAliveNeighbours_shouldLive() throws Exception {
        board.getCell(0,0).setAlive(false);
        board.getCell(1,0).setAlive(false);
        board.getCell(2,0).setAlive(false);
        board.getCell(0,1).setAlive(true);
        board.getCell(1,1).setAlive(true);
        board.getCell(2, 1).setAlive(true);

        Evolution evolution = new Evolution();
        evolution.evolve(board);
        assertTrue(evolution.getEvolutionBoard().getCell(1, 0).isAlive());
        assertTrue(evolution.getEvolutionBoard().getCell(1, 1).isAlive());
    }

}