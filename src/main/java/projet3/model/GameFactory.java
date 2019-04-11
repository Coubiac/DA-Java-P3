package projet3.model;

/**
 * A class to prepare the game.
 */
public class GameFactory  {

    private Game game;
    private Mode mode;


    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public Mode getMode() {
        return mode;
    }

    public void setMode(Mode mode) {
        this.mode = mode;
    }




}
