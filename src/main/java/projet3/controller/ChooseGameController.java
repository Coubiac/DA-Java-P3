package projet3.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import projet3.model.GameFactory;
import projet3.model.GameMastermind;
import projet3.model.GameRecherche;

public class ChooseGameController {

    public Button search;
    public Button mastermind;

    @FXML
    public void chooseRecherche(ActionEvent actionEvent) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/chooseMode.fxml"));

        //on récupère la fenêtre
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        //on récupère les données
        GameFactory gameFactory = (GameFactory) stage.getUserData();
        GameRecherche game = new GameRecherche();
        gameFactory.setGame(game);

        stage.setUserData(gameFactory);
        Scene scene = new Scene((Parent) loader.load());
        stage.setScene(scene);
    }


    @FXML
    public void chooseMasterMind(ActionEvent actionEvent) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/chooseMode.fxml"));

        //on récupère la fenêtre
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        //on récupère les données
        GameFactory gameFactory = (GameFactory) stage.getUserData();
        GameMastermind game = new GameMastermind();
        gameFactory.setGame(game);

        stage.setUserData(gameFactory);
        Scene scene = new Scene((Parent) loader.load());
        stage.setScene(scene);
    }

}
