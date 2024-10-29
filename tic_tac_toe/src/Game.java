import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Game {
    private List<Player> players;
    private Board board;
    private Player currentPlayer;

    public Game() {
        players = new ArrayList<>();
        board = new Board();
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        boolean gameWon = false;
        int currentPlayerIndex = 0;

        while (!gameWon && !board.isFull()) {
            board.print();
            currentPlayer = players.get(currentPlayerIndex);
            System.out.println("Player " + currentPlayer.getName() + " (" + currentPlayer.getSymbol() + ") next move (e.g., A1): ");
            String moveInput = scanner.nextLine();
            Move move = new Move(currentPlayer, moveInput);
            if (board.isValidMove(move)) {
                board.makeMove(move);
                gameWon = board.checkWin(currentPlayer.getSymbol());
                if (!gameWon) {
                    currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
                }
            } else {
                System.out.println("Invalid move. Try again.");
            }
        }

        board.print();
        if (gameWon) {
            System.out.println("Player " + currentPlayer.getName() + " wins!");
        } else {
            System.out.println("It's a draw!");
        }
        scanner.close();
    }
}
