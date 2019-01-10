package projet3.model;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class GameFactory  {

    private Game game;
    private Mode mode;
    private Boolean debugMode;
    private int nbChiffres;


    public GameFactory(){
        this.readProperties();
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public Mode getMode() {
        return mode;
    }

    public void setMode(Mode mode) {
        this.mode = mode;
    }

    public Boolean isDebugMode() {
        return debugMode;
    }

    private void readProperties(){
        Properties prop = new Properties();
        InputStream input = null;
        try {

            input = ClassLoader.getSystemClassLoader().getResourceAsStream("config.properties");
            prop.load(input);

            // Verification si débug mode est activé
            this.debugMode = Boolean.parseBoolean(prop.getProperty("debugMode"));
            this.nbChiffres = Integer.parseInt(prop.getProperty("nbChiffresRecherche"));

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
