package projet3.model;

import java.util.Random;
import org.apache.commons.lang3.StringUtils;

public class GameRecherche extends Game {

    /**
     * random combination that will serve as a solution (challenger mode)
     */
    private char[] solution;
    /**
     * Digits array for dual mode.
     */
    private SearchDigit[] digitRecherches;




    @Override
    public String toString() {
        return "RECHERCHE";
    }


    /**
     * The constructor initializes the properties of the configuration file and prepares a random combination
     * for the challenger mode solution. It also prepares an array of "digits" of the size of the number of boxes (configuration file) for the defender mode.
     */
    public GameRecherche() {
        super();
        this.setNbEssais(this.configFile.getRechercheNbEssais());

        //On crée une combinaison aléatoire qui servira de solution (mode challenger)
        this.solution = new char[this.configFile.getRechercheNbCases()];
        Random r = new Random();
        String alphabet = "1234567890";
        for (int i = 0; i < solution.length; i++) {
            this.solution[i] = alphabet.charAt(r.nextInt(alphabet.length()));
        }

        if (this.configFile.isDebugMode()) {
            logger.info("la solution est: " + this.ShowSoluce());
        }

        //on prépare les Chiffres pour le mode défenseur
        this.digitRecherches = new SearchDigit[this.configFile.getRechercheNbCases()];

        for (int i = 0; i < this.configFile.getRechercheNbCases(); i++){
            this.digitRecherches[i] = new SearchDigit();
        }



    }

    @Override
    public String ShowSoluce() {
        return new String(this.solution);
    }

    /**
     * Analysis of the player's proposal and return of the result
     * @param propal
     *               player proposition for the challenger mode
     * @return String response
     *                  computer response
     */
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

    /**
     * Defender mode: Verifies that the human player's response has the correct number of characters and only has +, - or = characters
     * @param str
     *            Human player response to the computer proposal.
     * @return Boolean
     */
    private boolean isResponseOk(String str){

        if (str.matches("^[=+-]+$") && str.length() == this.configFile.getRechercheNbCases()){
            return true;

        }
        else if (str.matches("^[=+-]+$")){
            logger.error("la reponse contient " + str.length() + " chiffres sur " + this.configFile.getRechercheNbCases());
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
            for(int i = 0; i < this.configFile.getRechercheNbCases(); i++)
            {
                char c = response.charAt(i);
                this.digitRecherches[i].adjustLimits(c);
            }
        }
        else this.setError("votre réponse est incorrecte");

    }

    /**
     * Defenseur mode: Proposes a new combination
     * @return Stringbuilder
     *                       New combination
     */
    public StringBuilder proposeCombinaison(){
        StringBuilder newCombinaison = new StringBuilder();
        for(int i = 0; i < this.configFile.getRechercheNbCases(); i++)
        {
            newCombinaison.append(this.digitRecherches[i].getComputerTry());
        }
        return newCombinaison;
    }

    public boolean DefenseurWin(String response){

        return response.matches("^[=]+$") && response.length() == this.configFile.getRechercheNbCases();
    }


    public boolean ChallengerWin(String propal){
        return propal.matches("^[=]+$");
    }

}
