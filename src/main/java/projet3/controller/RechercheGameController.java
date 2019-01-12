package projet3.controller;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import projet3.model.Game;
import projet3.model.GameFactory;

public class RechercheGameController {
    public Label result;
    public TextField propal;
    public Button submit;
    public Label error;


    public void submit(ActionEvent actionEvent) {

        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        GameFactory gameFactory = (GameFactory) stage.getUserData();
        Game game = gameFactory.getGame();
        stage.setTitle(game.toString());

        String propalSoluce = propal.getText();
        result.setText(game.checkPropal(propalSoluce));
        error.setText(game.showError());
    }
}
