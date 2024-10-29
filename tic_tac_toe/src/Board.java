public class Board {
    private char[][] grid;

    public Board() {
        grid = new char[][]{
                {' ', 'A', 'B', 'C'},
                {'1', ' ', ' ', ' '},
                {'2', ' ', ' ', ' '},
                {'3', ' ', ' ', ' '}
        };
    }

    public void print() {
        for (char[] row : grid) {
            for (char cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }
    public boolean isValidMove(Move move) {
        String position = move.getPosition();
        if (position.length() != 2) return false;
        char col = position.charAt(0);
        char row = position.charAt(1);
        if (col < 'A' || col > 'C' || row < '1' || row > '3') return false;
        return grid[row - '0'][col - 'A' + 1] == ' ';
    }

    public void makeMove(Move move) {
        char col = move.getPosition().charAt(0);
        char row = move.getPosition().charAt(1);
        grid[row - '0'][col - 'A' + 1] = move.getPlayer().getSymbol();
    }

    public boolean checkWin(char currentPlayerSymbol) {
        // Check rows, columns, and diagonals
        for (int i = 1; i <= 3; i++) {
            if (grid[i][1] == currentPlayerSymbol && grid[i][2] == currentPlayerSymbol && grid[i][3] == currentPlayerSymbol) return true;
            if (grid[1][i] == currentPlayerSymbol && grid[2][i] == currentPlayerSymbol && grid[3][i] == currentPlayerSymbol) return true;
        }
        if (grid[1][1] == currentPlayerSymbol && grid[2][2] == currentPlayerSymbol && grid[3][3] == currentPlayerSymbol) return true;
        if (grid[1][3] == currentPlayerSymbol && grid[2][2] == currentPlayerSymbol && grid[3][1] == currentPlayerSymbol) return true;
        return false;
    }

    public boolean isFull() {
        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 3; j++) {
                if (grid[i][j] == ' ') return false;
            }
        }
        return true;
    }
}
