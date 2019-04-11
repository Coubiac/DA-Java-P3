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
            loader = new FXMLLoader(getClass().getResource("/rechercheChallengerGameVue.fxml"));
            scene = new Scene((Parent) loader.load());
            RechercheChallengerGameController controller = loader.getController();
            if(gameFactory.getGame().isDebugMode()){
                controller.setTextToSoluce("Solution: " + ((GameRecherche) gameFactory.getGame()).ShowSoluce());
            }

        }
        else if(gameFactory.getGame() instanceof projet3.model.GameRecherche && gameFactory.getMode() instanceof DefenseurMode){
            loader = new FXMLLoader(getClass().getResource("/rechercheDefenseurGameVue.fxml"));
            scene = new Scene((Parent) loader.load());
            RechercheDefenseurGameController controller = loader.getController();
            controller.setTextToResult(((GameRecherche) gameFactory.getGame()).proposeCombinaison().toString());


        }
        else if(gameFactory.getGame() instanceof projet3.model.GameRecherche && gameFactory.getMode() instanceof DuelMode){
            loader = new FXMLLoader(getClass().getResource("/rechercheDuelGameVue.fxml"));
            scene = new Scene((Parent) loader.load());
            RechercheDuelGameController controller = loader.getController();
            controller.setTextToResult(((GameRecherche) gameFactory.getGame()).proposeCombinaison().toString());
            if(gameFactory.getGame().isDebugMode()){
                controller.setTextToSoluce("Solution: " + ((GameRecherche) gameFactory.getGame()).ShowSoluce());
            }
        }
        else if (gameFactory.getGame() instanceof projet3.model.GameMastermind && gameFactory.getMode() instanceof ChallengerMode){
            loader = new FXMLLoader(getClass().getResource("/mastermindGameChallenger.fxml"));
            scene = new Scene((Parent) loader.load());
            MastermindChallengerGameController controller = loader.getController();
            if(gameFactory.getGame().isDebugMode()){
                controller.setTextToSoluce("Solution: " + ((GameMastermind) gameFactory.getGame()).ShowSoluce());
            }

        }
        else if (gameFactory.getGame() instanceof projet3.model.GameMastermind && gameFactory.getMode() instanceof DefenseurMode){
            loader = new FXMLLoader(getClass().getResource("/mastermindGameDefenseur.fxml"));
            scene = new Scene((Parent) loader.load());
        }
        else if (gameFactory.getGame() instanceof projet3.model.GameMastermind && gameFactory.getMode() instanceof DuelMode){
            loader = new FXMLLoader(getClass().getResource("/mastermindGameDuel.fxml"));
            scene = new Scene((Parent) loader.load());
        }
        else {
            logger.error("Le jeu ne fait pas partie de la liste possible");
            throw new IllegalArgumentException();
        }

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
