package projet3.model;

/**
 * A class to prepare the game.
 */
public class GameFactory  {

    private Game game;
    private GameMode gameMode;


    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public GameMode getGameMode() {
        return gameMode;
    }

    public void setGameMode(GameMode gameMode) {
        this.gameMode = gameMode;
    }
}
