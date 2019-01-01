package projet3.model;

import java.util.Arrays;

abstract public class Game {

    public char[] solution;


    public Boolean Win(String propal) {
        char[] letters = propal.toCharArray();
        return Arrays.equals(letters, this.solution);
    }


    public String ShowSoluce (){
        String string = new String(this.solution);
        return string;
    }

    public String checkSoluce(String propal){
        String string = new String(this.solution);
        return string;
    }
}
