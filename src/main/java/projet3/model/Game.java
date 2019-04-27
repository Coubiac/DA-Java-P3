package projet3.model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public abstract class Game implements GameInterface{

    ConfigReader configFile;


    private String error = null;
    static final Logger logger = (Logger) LogManager.getLogger("Game");
    protected Integer nbEssais;


    @Override
    public String ShowSoluce() {
        return null;
    }

    @Override
    public String checkPropal(String propal) {
        return null;
    }

    @Override
    public String showError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    /**
     * This constructor reads the configuration file and initializes the different variables
     */
    Game(){
        this.configFile = ConfigReader.getInstance();


    }

    public abstract boolean ChallengerWin(String text);

    public ConfigReader getConfigFile() {
        return configFile;
    }

    public Integer getNbEssais() {
        return nbEssais;
    }

    public void setNbEssais(Integer nbEssais) {
        this.nbEssais = nbEssais;
    }
}
