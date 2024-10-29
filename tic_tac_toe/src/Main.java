public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        game.addPlayer(new Player("Player 1", 'X'));
        game.addPlayer(new Player("Player 2", 'O'));
        game.start();
    }
}
