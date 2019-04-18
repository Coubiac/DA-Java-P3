package projet3.controller;


import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import projet3.model.GameFactory;
import projet3.model.GameMastermind;


public class MastermindChallengerGameController {
    public Label result;
    public TextField propal;
    public Button submit;
    public Label error;
    public Label soluce;
    public Label nbEssais;
    public Label log;
    private GameMastermind game;
    private Stage stage;


    public void submit(ActionEvent actionEvent) {
        this.stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        GameFactory gameFactory = (GameFactory) stage.getUserData();
        this.game = (GameMastermind) gameFactory.getGame();

        this.stage.setTitle(this.game.toString());

        if(this.game.isResponseOk(this.propal.getText())){
            error.setText("");
            result.setText(this.game.checkPropal(this.propal.getText()));
            this.log.setText(this.log.getText() + this.propal.getText()+ " : " + result.getText() + "\n");
            if(this.game.ChallengerWin(result.getText())){
                this.HumanWinAction();
            }
            this.game.setNbEssais(this.game.getNbEssais() - 1);
            nbEssais.setText("Essais restant: "+ this.game.getNbEssais().toString());
            if (this.game.getNbEssais() == 0){
                this.ComputerWinAction();
            }
        }
        else {
            error.setText(this.game.showError());
        }



    }

    void setTextToSoluce(String text) {
        soluce.setText(text);
    }

    private void HumanWinAction(){
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

    private void ComputerWinAction(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Fin de la partie");
        alert.setHeaderText(null);
        alert.setContentText("J'ai gagné ! \n La solution était " + this.game.ShowSoluce());

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
