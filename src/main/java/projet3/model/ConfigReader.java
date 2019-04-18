package projet3.model;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

/**
 * Service for reading and using the config.properties.
 * We use the singleton design pattern to ensure that the configuration is read only once. In particular to manage properties overwriting using command line arguments.
 */
public class ConfigReader {

    private static ConfigReader config;

    private Boolean debugMode;
    private Integer RechercheNbCases;
    private Integer RechercheNbEssais;
    private Integer MMnbCoul;
    private Integer MMnbTrous;
    private Integer MMnbEssais;

    /**
     * Read the config file and hydrate the class properties
     */
    private ConfigReader() {

        Properties configProperties = new Properties();

        FileInputStream file = null;

        //try to read the file in the root program
        String path = "./config.properties";
        try {
            file = new FileInputStream(path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            configProperties.load(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            Objects.requireNonNull(file).close();
        } catch (IOException e) {
            e.printStackTrace();
        }


        //try to hydrate properties
        try {
            this.debugMode = Boolean.parseBoolean(configProperties.getProperty("debugMode"));
            this.RechercheNbCases = Integer.parseInt(configProperties.getProperty("RechercheNbCases"));
            this.RechercheNbEssais = Integer.parseInt(configProperties.getProperty("RechercheNbEssais"));
            this.MMnbCoul = Integer.parseInt(configProperties.getProperty("MMnbCoul"));
            this.MMnbTrous = Integer.parseInt(configProperties.getProperty("MMnbTrous"));
            this.MMnbEssais = Integer.parseInt(configProperties.getProperty("MMnbEssais"));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * Method to access the singleton
     * @return
     *         ConfigReader
     */
    public static ConfigReader getInstance(){
        if(config == null)
            config = new ConfigReader();

        return config;
    }


    /**
     * Debug mode
     * @return
     *          boolean
     */
    public boolean isDebugMode(){
        return this.debugMode;
    }

    /**
     * returns the number of boxes to be used for the search game
     * @return
     *          integer
     */
    Integer getRechercheNbCases(){
        return this.RechercheNbCases;
    }

    /**
     * returns the number of tries allowed for the search game
     * @return
     *          integer
     */
    Integer getRechercheNbEssais(){
        return this.RechercheNbEssais;
    }

    /**
     * returns the number of colors to be used for the mastermind game
     * @return
     *          integer
     */
    Integer getMMnbCoul(){
        return this.MMnbCoul;
    }

    /**
     * returns the number of holes to be used for the search game
     * @return
     *          integer
     */
    Integer getMMnbTrous() {
        return MMnbTrous;
    }

    /**
     * returns the number of tries allowed for the mastermind game
     * @return
     *          integer
     */
    Integer getMMnbEssais() {
        return MMnbEssais;
    }

    public void setDebugMode(Boolean debugMode) {
        this.debugMode = debugMode;
    }
}
