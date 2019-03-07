package projet3.controller;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import projet3.model.Game;
import projet3.model.GameFactory;
import projet3.model.GameRecherche;

public class RechercheDefenseurGameController {
    public Label result;
    public TextField response;
    public Button submit;
    public Label error;
    private GameRecherche game;



    private Stage handleStage(ActionEvent actionEvent){
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        GameFactory gameFactory = (GameFactory) stage.getUserData();
        this.game = (GameRecherche) gameFactory.getGame();
        stage.setTitle(game.toString());
        return stage;
    }

    public void submit(ActionEvent actionEvent) {
        this.handleStage(actionEvent);
        String responseText = response.getText();
        if (game.win(responseText)){
            result.setText("J'ai gagné !");
        }
        else{
            game.handleResponse(responseText);
            result.setText(game.proposeCombinaison().toString());
        }

        error.setText(game.showError());
    }

}
