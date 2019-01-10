package projet3.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import projet3.model.ChallengerMode;
import projet3.model.DefenseurMode;
import projet3.model.DuelMode;
import projet3.model.GameFactory;

import java.io.IOException;

public class ChooseModeController {

    private static final Logger logger = (Logger) LogManager.getLogger("ChooseModeController");


    public void chooseDuel(ActionEvent actionEvent) throws IOException {

        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        GameFactory gameFactory = (GameFactory) stage.getUserData();
        gameFactory.setMode(new DuelMode());
        if(gameFactory.isDebugMode()){
            logger.info("Mode Duel !");
        }

        if(gameFactory.getGame().toString().equals("RECHERCHE")){
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/rechercheGame.fxml"));
            Scene scene = new Scene((Parent) loader.load());
            stage.setUserData(gameFactory);
            stage.setScene(scene);
        }
        else {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/MastermindGame.fxml"));
            Scene scene = new Scene((Parent) loader.load());
            stage.setUserData(gameFactory);
            stage.setScene(scene);
        }


    }

    public void chooseChallenger(ActionEvent actionEvent) {
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        GameFactory gameFactory = (GameFactory) stage.getUserData();
        gameFactory.setMode(new ChallengerMode());
        if(gameFactory.isDebugMode()){
            logger.info("Mode Challenger !");
        }


    }

    public void chooseDefenseur(ActionEvent actionEvent) {
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        GameFactory gameFactory = (GameFactory) stage.getUserData();
        gameFactory.setMode(new DefenseurMode());
        if(gameFactory.isDebugMode()){
            logger.info("Mode Défenseur !");
        }


    }
}
