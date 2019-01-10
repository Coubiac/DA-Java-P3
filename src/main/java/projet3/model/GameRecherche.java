package projet3.model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

import java.util.Random;

public class GameRecherche extends Game {

    private  char[] solution;

    @Override
    public String toString() {
        return "RECHERCHE";
    }

    private static final Logger logger = (Logger) LogManager.getLogger("GameRecherche");

    public GameRecherche(){
        this.solution = new char[5];
        Random r = new Random();
        String alphabet = "1234567890";
        for(int i = 0; i < solution.length; i++){
            this.solution[i] = alphabet.charAt(r.nextInt(alphabet.length()));
        }

        logger.info("la solution est: " + this.ShowSoluce());
    }

    public String ShowSoluce(){
        return new String(this.solution);
    }

    @Override
    public String checkSoluce(String propal){
        StringBuilder reponse = new StringBuilder();
        char[] proposition = propal.toCharArray();

        if (this.solution.length != propal.length()){
            return "Votre proposition doit comporter exactement " + this.solution.length + " chiffres";
        }
        for(int i = 0; i < solution.length; i++){
            int sol = Character.getNumericValue(solution[i]);
            int prop = Character.getNumericValue(proposition[i]);

            if(prop == sol){
                reponse.append("=");
            }
            if(prop > sol){
                reponse.append("-");
            }
            if(prop < sol){
                reponse.append("+");
            }

        }
        if (reponse.toString().equals("====="))
        {
            return "Gagné !";
        }
        return reponse.toString();
    }
}
