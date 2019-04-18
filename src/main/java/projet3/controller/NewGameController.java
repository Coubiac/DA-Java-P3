package projet3.controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import projet3.model.ConfigReader;
import projet3.model.GameFactory;

public class NewGameController extends Application {
    /**
     * The main entry point for all JavaFX applications.
     * The start method is called after the init method has returned,
     * and after the system is ready for the application to begin running.
     *
     * <p>
     * NOTE: This method is called on the JavaFX Application Thread.
     * </p>
     *
     * @param primaryStage the primary stage for this application, onto which
     *                     the application scene can be set. The primary stage will be embedded in
     *                     the browser if the application was launched as an applet.
     *                     Applications may create other stages, if needed, but they will not be
     *                     primary stages and will not be embedded in the browser.
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        GameFactory gameFactory = new GameFactory();

        for (String s: getParameters().getRaw()){
            if (s.equals("debug")){
                ConfigReader.getInstance().setDebugMode(true);
            }
        }
        primaryStage.setResizable(false);
        primaryStage.setUserData(gameFactory);
        Parent root = FXMLLoader.load(getClass().getResource("/chooseGame.fxml"));
        primaryStage.setTitle("Game P3");
        primaryStage.setScene(new Scene(root, 431, 380));
        primaryStage.show();
    }

    public void play(String[] args){
        launch(args);
    }
}
