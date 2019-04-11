package projet3.model;

import java.util.Random;
import org.apache.commons.lang3.StringUtils;

public class GameRecherche extends Game {

    private char[] solution;
    private SearchDigit[] digitRecherches;



    @Override
    public String toString() {
        return "RECHERCHE";
    }


    public GameRecherche() {
        super();

        //On crée une combinaison aléatoire qui servira de solution (mode challenger)
        this.solution = new char[this.getNbCases()];
        Random r = new Random();
        String alphabet = "1234567890";
        for (int i = 0; i < solution.length; i++) {
            this.solution[i] = alphabet.charAt(r.nextInt(alphabet.length()));
        }

        if (this.isDebugMode()) {
            logger.info("la solution est: " + this.ShowSoluce());
        }

        //on prépare les Chiffres pour le mode défenseur
        this.digitRecherches = new SearchDigit[this.getNbCases()];

        for (int i = 0; i < this.getNbCases(); i++){
            this.digitRecherches[i] = new SearchDigit();
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
            String error = "Votre proposition ("+ propal + ") doit comporter exactement " + this.solution.length + " chiffres";
            logger.error(error);
            this.setError(error);
        } else {
            for (int i = 0; i < solution.length; i++) {
                int sol = Character.getNumericValue(solution[i]);
                int prop = Character.getNumericValue(propArray[i]);;

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
        }
        return reponse.toString();
    }

    private boolean isResponseOk(String str){

        if (str.matches("^[=+-]+$") && str.length() == this.getNbCases()){
            return true;

        }
        else if (str.matches("^[=+-]+$")){
            logger.error("la reponse contient " + str.length() + " chiffres sur " + this.getNbCases());
            return false;
        }
        else{
            logger.error("REPONSE: "+ str +" .la réponse ne doit contenir que les caractère +, -, = .");
            return false;
        }
    }

    public void handleResponse(String response){
        if(isResponseOk(response)){
            this.setError("");
            for(int i = 0; i < this.getNbCases(); i++)
            {
                char c = response.charAt(i);
                this.digitRecherches[i].adjustLimits(c);
            }
        }
        else this.setError("votre réponse est incorrecte");

    }

    public StringBuilder proposeCombinaison(){
        StringBuilder newCombinaison = new StringBuilder();
        for(int i = 0; i < this.getNbCases(); i++)
        {
            newCombinaison.append(this.digitRecherches[i].getComputerTry());
        }
        return newCombinaison;
    }

    public boolean DefenseurWin(String response){

        return response.matches("^[=]+$") && response.length() == this.getNbCases();
    }


    public boolean ChallengerWin(String propal){
        return propal.matches("^[=]+$");
    }



}
