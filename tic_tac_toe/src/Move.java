public class Move {
    private Player player;
    private String position;

    public Move(Player player, String position) {
        this.player = player;
        this.position = position;
    }

    public Player getPlayer() {
        return player;
    }

    public String getPosition() {
        return position;
    }
}
