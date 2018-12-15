package projet3.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class RechercheGameController {
    public Label result;
    public TextField propal;
    public Button submit;


    public void submit(ActionEvent actionEvent) {
        String propalSoluce = propal.getText();
        result.setText(propalSoluce);
    }
}
