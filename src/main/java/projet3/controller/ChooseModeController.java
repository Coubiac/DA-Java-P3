package projet3.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import projet3.model.*;

import java.io.IOException;

public class ChooseModeController {

    private static final Logger logger = (Logger) LogManager.getLogger("ChooseModeController");

    public void handleGameMode(ActionEvent actionEvent, Mode mode) throws IOException {
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        GameFactory gameFactory = (GameFactory) stage.getUserData();
        gameFactory.setMode(mode);
        if(gameFactory.getGame().isDebugMode()){
            logger.info("Mode Debug !");
            logger.info(gameFactory.getMode().toString());
        }

        Scene scene ;
        FXMLLoader loader;

        if(gameFactory.getGame() instanceof projet3.model.GameRecherche && gameFactory.getMode() instanceof ChallengerMode){
            loader = new FXMLLoader(getClass().getResource("/rechercheGameChallenger.fxml"));
        }
        else if(gameFactory.getGame() instanceof projet3.model.GameRecherche && gameFactory.getMode() instanceof DefenseurMode){
            loader = new FXMLLoader(getClass().getResource("/rechercheGameDefenseur.fxml"));

        }
        else if(gameFactory.getGame() instanceof projet3.model.GameRecherche && gameFactory.getMode() instanceof DuelMode){
            loader = new FXMLLoader(getClass().getResource("/rechercheGameDuel.fxml"));
        }
        else if (gameFactory.getGame() instanceof projet3.model.GameMastermind && gameFactory.getMode() instanceof ChallengerMode){
            loader = new FXMLLoader(getClass().getResource("/mastermindGameChallenger.fxml"));
        }
        else if (gameFactory.getGame() instanceof projet3.model.GameMastermind && gameFactory.getMode() instanceof DefenseurMode){
            loader = new FXMLLoader(getClass().getResource("/mastermindGameDefenseur.fxml"));
        }
        else if (gameFactory.getGame() instanceof projet3.model.GameMastermind && gameFactory.getMode() instanceof DuelMode){
            loader = new FXMLLoader(getClass().getResource("/mastermindGameDuel.fxml"));
        }
        else {
            logger.error("Le jeu ne fait pas partie de la liste possible");
            throw new IllegalArgumentException();
        }

        scene = new Scene((Parent) loader.load());
        stage.setUserData(gameFactory);
        stage.setScene(scene);

    }


    public void chooseDuel(ActionEvent actionEvent) throws IOException {
        this.handleGameMode(actionEvent, new DuelMode());
    }

    public void chooseChallenger(ActionEvent actionEvent) throws IOException {
        this.handleGameMode(actionEvent, new ChallengerMode());
    }

    public void chooseDefenseur(ActionEvent actionEvent) throws IOException {
        this.handleGameMode(actionEvent, new DefenseurMode());

    }
}
