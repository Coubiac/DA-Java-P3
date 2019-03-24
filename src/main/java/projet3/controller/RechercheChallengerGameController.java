package projet3.controller;


import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import projet3.model.Game;
import projet3.model.GameFactory;
import projet3.model.GameRecherche;

public class RechercheChallengerGameController {
    public Label result;
    public TextField propal;
    public Button submit;
    public Label error;
    public Label soluce;
    private Game game;
    private Stage stage;


    public void submit(ActionEvent actionEvent) {
        this.stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        GameFactory gameFactory = (GameFactory) stage.getUserData();
        this.game = gameFactory.getGame();

        this.stage.setTitle(this.game.toString());
        String propalSoluce = propal.getText();
        result.setText(this.game.checkPropal(propalSoluce));
        error.setText(this.game.showError());
        if (this.game.ChallengerWin(this.game.checkPropal(propalSoluce))){
            this.HumanWinAction();
        }

    }

    public void setTextToSoluce(String text) {
        soluce.setText(text);
    }

    public void HumanWinAction(){
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
}
