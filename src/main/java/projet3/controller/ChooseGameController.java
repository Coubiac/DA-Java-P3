package projet3.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import projet3.model.Game;
import projet3.model.GameFactory;
import projet3.model.GameMastermind;
import projet3.model.GameRecherche;

import java.io.IOException;

public class ChooseGameController {

    public Button search;
    public Button mastermind;

    private static final Logger logger = (Logger) LogManager.getLogger("ChooseGameController");


    private void handleGame(Game game, Stage stage, FXMLLoader loader) throws IOException {
        GameFactory gameFactory = (GameFactory) stage.getUserData();
        gameFactory.setGame(game);
        if(gameFactory.getGame().isDebugMode()){
            logger.info(gameFactory.getGame().toString());
        }
        stage.setUserData(gameFactory);

        Scene scene = new Scene((Parent) loader.load());
        stage.setScene(scene);
    }

    @FXML
    public void chooseRecherche(ActionEvent actionEvent) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/chooseMode.fxml"));
        //on récupère la fenêtre
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        //on récupère les données
        GameRecherche game = new GameRecherche();
        //on prépare prépare le jeu
        this.handleGame(game, stage, loader);

    }

    @FXML
    public void chooseMasterMind(ActionEvent actionEvent) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/chooseMode.fxml"));
        //on récupère la fenêtre
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        //on récupère les données
        GameMastermind game = new GameMastermind();
        this.handleGame(game, stage, loader);
    }

}
