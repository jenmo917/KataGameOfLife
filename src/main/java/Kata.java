public class Kata {

    private static boolean[][] booleanBoard = {
            {false, false, false, false, false, false, false, false},
            {true, false, true, true, true, false, false, false},
            {false, false, false, true, true, true, false, false},
            {false, false, false, true, false, false, true, false}
    };

    public static void main(String args[]) {
        Board board = new Board(booleanBoard);

        System.out.println("Start board");
        System.out.println(board.toString());

        System.out.println("Evolution board");
        Evolution evolution = new Evolution();
        evolution.evolve(board);
        System.out.println(evolution.getEvolutionBoard().toString());

        evolveBestPossibleStartBoard();

    }

    private static void evolveBestPossibleStartBoard() {

        Evolution evolution = new Evolution();

        Board board = new Board(booleanBoard);
        board.generateRandomLife();

        evolution.evolve(board);

        int maxNumberOfAlive = 0;
        int maxNumberOfDead = 0;

        Board maxAliveStartBoard = board.clone();
        Board maxDeadStartBoard = board.clone();
        Board tempBoard = board.clone();

        evolution.evolve(board);

        for (int i = 0; i < 100000; i++) {

            int numberOfAliveCells = evolution.getEvolutionBoard().getNumberOfCellsAlive();
            int numberOfDeadCells = evolution.getEvolutionBoard().getNumberOfCellsDead();

            if (numberOfAliveCells > maxNumberOfAlive) {
                maxAliveStartBoard = tempBoard;
                maxNumberOfAlive = evolution.getEvolutionBoard().getNumberOfCellsAlive();
            }

            if (numberOfDeadCells > maxNumberOfDead) {
                maxDeadStartBoard = tempBoard;
                maxNumberOfDead = numberOfDeadCells;
            }

            board.generateRandomLife();
            tempBoard = board.clone();
            evolution.evolve(board);
        }

        System.out.println("Best possible start board");
        System.out.println(maxAliveStartBoard.toString());
        evolution.evolve(maxAliveStartBoard);
        System.out.println("After evolution");
        System.out.println("Alive: " + evolution.getEvolutionBoard().getNumberOfCellsAlive());
        System.out.println("Dead: " + evolution.getEvolutionBoard().getNumberOfCellsDead());
        System.out.println(evolution.getEvolutionBoard().toString());

        System.out.println("Worst possible start board");
        System.out.println(maxDeadStartBoard.toString());
        evolution.evolve(maxDeadStartBoard);
        System.out.println("After evolution");
        System.out.println("Alive: " + evolution.getEvolutionBoard().getNumberOfCellsAlive());
        System.out.println("Dead: " + evolution.getEvolutionBoard().getNumberOfCellsDead());
        System.out.println(evolution.getEvolutionBoard().toString());
    }

}