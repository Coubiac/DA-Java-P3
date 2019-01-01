package projet3;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

public class Main extends Application {


    private static final Logger logger = (Logger) LogManager.getLogger("Main");

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/chooseGame.fxml"));
        primaryStage.setTitle("Game P3");
        primaryStage.setScene(new Scene(root, 431, 380));
        primaryStage.show();
    }


    public static void main(String[] args) {
        logger.info("Did it again!");
        launch(args);
    }
}
