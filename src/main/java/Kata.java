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
        Board board = new Board(3, 7);
        board.generateRandomLife();
        evolution.evolve(board);

        int maxNumberOfAlive = 0;
        int maxNumberOfDead = 0;

        Board maxAliveStartBoard = board.clone();
        Board maxDeadStartBoard = board.clone();

        for (int i = 0; i < 100000; i++) {
            int numberOfAliveCells = evolution.getEvolutionBoard().getNumberOfCellsAlive();
            int numberOfDeadCells = evolution.getEvolutionBoard().getNumberOfCellsDead();
            if (numberOfAliveCells > maxNumberOfAlive) {
                maxAliveStartBoard = evolution.getEvolutionBoard();
                maxNumberOfAlive = evolution.getEvolutionBoard().getNumberOfCellsAlive();
            }

            if (numberOfDeadCells > maxNumberOfDead) {
                maxDeadStartBoard = evolution.getEvolutionBoard();
                maxNumberOfDead = numberOfDeadCells;
            }

            board.generateRandomLife();
            evolution.evolve(board);
        }

        System.out.println("Best possible start board");
        System.out.println("Alive: " + maxAliveStartBoard.getNumberOfCellsAlive());
        System.out.println("Dead: " + maxAliveStartBoard.getNumberOfCellsDead());
        System.out.println(maxAliveStartBoard.toString());

        System.out.println("Worst possible start board");
        System.out.println("Alive: " + maxDeadStartBoard.getNumberOfCellsAlive());
        System.out.println("Dead: " + maxDeadStartBoard.getNumberOfCellsDead());
        System.out.println(maxDeadStartBoard.toString());
    }

}