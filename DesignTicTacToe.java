public class DesignTicTacToe {

    private int[] rows;
    private int[] cols;
    private int diagonal;
    private int antiDiagonal;

    public DesignTicTacToe(int n) {
        rows = new int[n]; // n rows and n cols;
        cols = new int[n];
        diagonal = 0;
        antiDiagonal = 0;
    }

    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) { //in order to win Tic-Tac-Toe you must have the entire row or column. Thus, we don't need to keep track of an entire n^2 board;
        int toAdd = 0;
        if (player == 1) {
            toAdd = 1;
        } else {
            toAdd = -1;
        }

        rows[row] += toAdd;
        cols[col] += toAdd;

        if (row == col) { // diagonal
            diagonal += toAdd;
        }

        if (col == cols.length - row - 1) { // ex: row + col = 3, then col = 3 - row, then col = cols.length - 1 - row;
            antiDiagonal += toAdd;
        }

        int size = rows.length;

        if (Math.abs(rows[row]) == size ||
            Math.abs(cols[col]) == size ||
            Math.abs(diagonal) == size ||
            Math.abs(antiDiagonal) == size) {
                return player;
        }
        return 0;
    }
}