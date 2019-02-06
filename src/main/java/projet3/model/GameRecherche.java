package projet3.model;

import java.util.Random;
import org.apache.commons.lang3.StringUtils;

public class GameRecherche extends Game {

    private char[] solution;
    private DigitRecherche[] digitRecherches;



    @Override
    public String toString() {
        return "RECHERCHE";
    }


    public GameRecherche() {
        super();
        this.solution = new char[this.getNbCases()];
        Random r = new Random();
        String alphabet = "1234567890";
        for (int i = 0; i < solution.length; i++) {
            this.solution[i] = alphabet.charAt(r.nextInt(alphabet.length()));
        }

        if (this.isDebugMode()) {
            logger.info("la solution est: " + this.ShowSoluce());
        }
        this.digitRecherches = new DigitRecherche[this.getNbCases()];

        for (int i = 0; i < this.getNbCases(); i++){
            this.digitRecherches[i] = new DigitRecherche();
        }



    }

    @Override
    public String ShowSoluce() {
        return new String(this.solution);
    }

    @Override
    public String checkPropal(String propal) {
        StringBuilder reponse = new StringBuilder();
        char[] propArray = propal.toCharArray();

        if (this.solution.length != propal.length() || !StringUtils.isNumeric(propal)) {
            this.setError("Votre proposition doit comporter\n exactement " + this.solution.length + " chiffres");
        } else {
            for (int i = 0; i < solution.length; i++) {
                int sol = Character.getNumericValue(solution[i]);
                int prop = Character.getNumericValue(propArray[i]);

                if (prop == sol) {
                    reponse.append("=");
                }
                if (prop > sol) {
                    reponse.append("-");
                }
                if (prop < sol) {
                    reponse.append("+");
                }

            }
            if (this.ShowSoluce().equals(propal)) {
                return "Gagné !";
            }
        }
        return reponse.toString();
    }

    public void handleResponse(String response){
        for(int i = 0; i <= this.getNbCases(); i++)
        {
            char c = response.charAt(i);
            this.digitRecherches[i].adjustLimits(c);
        }
    }

    public boolean win(String response){
        return response.contains("=") && !response.contains("+") && !response.contains("-");
    }

    public void computerPlay(){

    }
}
