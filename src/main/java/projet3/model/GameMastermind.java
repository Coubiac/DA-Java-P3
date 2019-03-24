package projet3.model;

public class GameMastermind extends Game {

    @Override
    public String toString() {
        return "MASTERMIND";
    }

    @Override
    public boolean ChallengerWin(String text) {
        return false;
    }
}
