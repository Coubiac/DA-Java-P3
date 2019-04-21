package projet3;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import projet3.controller.NewGameController;
import projet3.model.ConfigReader;

public class Main {


    private static final Logger logger = (Logger) LogManager.getLogger("Main");

    public static void main(String[] args) {
        for (String s: args){
            if (s.equals("debug")){
                ConfigReader.getInstance().setDebugMode(true);
            }
        }
        logger.info("Demarrage de l'application!");
        NewGameController newgame = new NewGameController();
        newgame.play(args);
    }
}
