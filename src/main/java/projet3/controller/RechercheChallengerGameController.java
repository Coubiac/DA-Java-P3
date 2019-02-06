package projet3.controller;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import projet3.model.Game;
import projet3.model.GameFactory;

public class RechercheChallengerGameController {
    public Label result;
    public TextField propal;
    public Button submit;
    public Label error;
    private Game game;



    private Stage handleStage(ActionEvent actionEvent){
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        GameFactory gameFactory = (GameFactory) stage.getUserData();
        this.game = gameFactory.getGame();
        stage.setTitle(game.toString());
        return stage;
    }

    public void submit(ActionEvent actionEvent) {
        this.handleStage(actionEvent);
        String propalSoluce = propal.getText();
        result.setText(game.checkPropal(propalSoluce));
        error.setText(game.showError());
    }

}
