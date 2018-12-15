package projet3.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import projet3.model.ChallengerMode;
import projet3.model.DefenseurMode;
import projet3.model.DuelMode;
import projet3.model.GameFactory;

import java.io.IOException;

public class ChooseModeController {

    public void chooseDuel(ActionEvent actionEvent) throws IOException {

        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        GameFactory gameFactory = (GameFactory) stage.getUserData();
        gameFactory.setMode(new DuelMode());

        System.out.println(gameFactory.getGame().toString());
        System.out.println(gameFactory.getMode().toString());

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

        System.out.println(gameFactory.getGame().toString());
        System.out.println(gameFactory.getMode().toString());
    }

    public void chooseDefenseur(ActionEvent actionEvent) {
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        GameFactory gameFactory = (GameFactory) stage.getUserData();
        gameFactory.setMode(new DefenseurMode());

        System.out.println(gameFactory.getGame().toString());
        System.out.println(gameFactory.getMode().toString());
    }
}
