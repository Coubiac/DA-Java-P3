package projet3.model;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public abstract class Game implements GameInterface{

    private Integer nbCases;
    private Integer nbEssais;
    private Boolean debugMode;
    private String error = null;

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

    Game(){
        Properties prop = new Properties();
        InputStream input = null;
        try {

            input = ClassLoader.getSystemClassLoader().getResourceAsStream("config.properties");
            prop.load(input);

            // Verification si débug mode est activé
            this.debugMode = Boolean.parseBoolean(prop.getProperty("debugMode"));

            this.setNbCases(Integer.parseInt(prop.getProperty("nbCases")));
            this.setNbEssais(Integer.parseInt(prop.getProperty("nbEssais")));

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

    public Integer getNbCases() {
        return nbCases;
    }

    public void setNbCases(Integer nbCases) {
        this.nbCases = nbCases;
    }

    public Integer getNbEssais() {
        return nbEssais;
    }

    public void setNbEssais(Integer nbEssais) {
        this.nbEssais = nbEssais;
    }

    public Boolean isDebugMode() {
        return debugMode;
    }

    public void setDebugMode(Boolean debugMode) {
        this.debugMode = debugMode;
    }
}
