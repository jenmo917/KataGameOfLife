public class Kata {

    private static String[][] stringBoard = {
            {".", ".", ".", ".", ".", ".", ".", "."},
            {"*", ".", "*", "*", "*", ".", ".", "."},
            {".", ".", ".", "*", "*", "*", ".", "."},
            {".", ".", ".", "*", ".", ".", "*", "."}
    };

    public static void main(String args[]) {
        Board board = new Board(stringBoard);

        System.out.println("Start board");
        System.out.print(board.toString());

        System.out.println("Evolution board");
        Evolution evolution = new Evolution();
        evolution.evolve(board);
        System.out.print(evolution.getEvolutionBoard().toString());
    }

}