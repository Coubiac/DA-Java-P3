package projet3;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import projet3.controller.NewGameController;

public class Main {


    private static final Logger logger = (Logger) LogManager.getLogger("Main");

    public static void main(String[] args) {
        logger.info("Demarrage de l'application!");
        NewGameController newgame = new NewGameController();
        newgame.play(args);
    }
}
