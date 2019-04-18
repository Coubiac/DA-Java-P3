package projet3.model;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameMastermind extends Game {


    private List<Integer> secret;
    private Integer nbCoul;
    private Integer nbTrous;

    public GameMastermind(){
        super();

        this.nbEssais = this.configFile.getMMnbEssais();
        this.nbCoul = this.configFile.getMMnbCoul();
        this.nbTrous = this.configFile.getMMnbTrous();
        this.secret = generateCode(this.nbTrous,this.nbCoul);
        logger.info("la solution est: " + this.ShowSoluce());

    }


    @Override
    public String ShowSoluce(){
        return this.secret.toString();
    }

    @Override
    public String toString() {
        return "MASTERMIND";
    }

    @Override
    public boolean ChallengerWin(String score) {
        Integer scoreNumber = Integer.parseInt(score);
        return scoreNumber.equals(10 * nbTrous);
    }
    @Override
    public String checkPropal(String propal){
        List<Integer> propalSoluce =  this.handleResponse(propal);
        int score = this.Score(propalSoluce);
        return String.valueOf(score);
    }

    private List<Integer> generateCode(int nbTrous, int nbCoul){

        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < nbTrous; i++){
            list.add(Alea(nbCoul));
        }

        return list;

    }

    private Integer Alea(int valeurMax){
        Random r = new Random();
        return r.nextInt(valeurMax);

    }



    private Integer Score(List<Integer> Propal){
        int r=0;
        for (int i = 0; i < this.nbTrous; i++){
            if(this.secret.get(i).equals(Propal.get(i))){
                r++;
            }
        }
        int b = -r;
        for (int i = 0; i < this.nbCoul; i++) {
            int n = 0;
            int m = 0;
            for (int j = 0; j < this.nbTrous; j++){
                if(this.secret.get(j).equals(i)){
                    n++;
                }
                if(Propal.get(j).equals(i)){
                    m++;
                }
            }
            if(n<m){
                b=b+n;
            }else{
                b=b+m;
            }
        }
        return 10*r+b;
    }

    public Boolean playerWin(Integer score){
        return score.equals(this.nbTrous);
    }

    public boolean isResponseOk(String str){

        int maxValue = this.getNbCoul() - 1;

        if (str.matches("[0-" + maxValue +"]+") && str.length() == this.getNbTrous()){
            return true;

        }
        else if (str.matches("[0-"+ maxValue + "]+")){
            String errorMessage = "la reponse contient " + str.length() + " chiffres au lieu de " + this.getNbTrous();
            logger.error(errorMessage);
            this.setError(errorMessage);
            return false;
        }
        else{
            String errorMessage = "REPONSE: "+ str +" .la réponse ne doit contenir que des chiffres entre 0 et" + maxValue;
            logger.error(errorMessage);
            this.setError(errorMessage);
            return false;
        }
    }

    private List<Integer> handleResponse(String propal){

        int[] tempArray = new int[propal.length()];
        for (int i = 0; i < propal.length(); i++)
        {
            tempArray[i] = propal.charAt(i) - '0';
        }
        List<Integer> list = new ArrayList<>();
        for (int i : tempArray) {
            Integer integer = i;
            list.add(integer);
        }
        return list;
    }



    private Integer getNbCoul(){
        return nbCoul;
    }

    private Integer getNbTrous() {
        return nbTrous;
    }
}
