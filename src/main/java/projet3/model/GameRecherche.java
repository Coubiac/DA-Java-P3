package projet3.model;

import java.util.Random;

public class GameRecherche extends Game {

    private  char[] solution;

    @Override
    public String toString() {
        return "RECHERCHE";
    }


    public GameRecherche(){
        this.solution = new char[5];
        Random r = new Random();
        String alphabet = "1234567890";
        for(int i = 0; i < solution.length; i++){
            this.solution[i] = alphabet.charAt(r.nextInt(alphabet.length()));
        }
    }

    public String ShowSoluce(){
        StringBuilder solution = new StringBuilder();
        for (char aSolution : this.solution) {
            solution.append(aSolution);
        }
        return solution.toString();
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
        if (reponse.toString() == "=====")
        {
            return "Gagné !";
        }
        return reponse.toString();
    }
}
