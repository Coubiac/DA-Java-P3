package projet3.controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import projet3.Main;
import projet3.model.GameFactory;
import projet3.model.GameRecherche;

import static projet3.controller.NewGameController.*;

public class RechercheDefenseurGameController {
    public Label result;
    public TextField response;
    public Button submit;
    public Label error;
    public Label nbEssais;
    private GameRecherche game;
    private Stage stage;





    private Stage handleStage(ActionEvent actionEvent){
        this.stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        GameFactory gameFactory = (GameFactory) stage.getUserData();
        this.game = (GameRecherche) gameFactory.getGame();
        this.stage.setTitle(game.toString());
        return this.stage;
    }

    public void submit(ActionEvent actionEvent) {
        this.handleStage(actionEvent);
        String responseText = response.getText();
        if (game.isResponseOk(responseText)){
            if (game.DefenseurWin(responseText)){
                computerWinAction();

            }
            else{
                game.handleResponse(responseText);
                this.game.setNbEssais(this.game.getNbEssais() - 1);
                if (this.game.getNbEssais() == 0){
                    this.humanWinAction();
                }
                nbEssais.setText("Essais restant: "+ this.game.getNbEssais().toString());
                result.setText(game.proposeCombinaison().toString());
            }

        }

        error.setText(game.showError());
    }

    public void setTextToResult (String text) {
        result.setText(text);
    }

    public void humanWinAction(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Fin de la partie");
        alert.setHeaderText(null);
        alert.setContentText("Vous avez gagné ! Bravo");

        alert.showAndWait();
        this.stage.close();
        Platform.runLater(() -> {
            try {
                new NewGameController().start(new Stage());
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public void computerWinAction(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Fin de la partie");
        alert.setHeaderText(null);
        alert.setContentText("J'ai gagné !");

        alert.showAndWait();
        this.stage.close();
        Platform.runLater(() -> {
            try {
                new NewGameController().start(new Stage());
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }


}
