package projet3.model;

/**
 *  SearchDigit represents one of the numbers of the solution the computer is looking for in the game Search in Defender or DUEL mode
 */
public class SearchDigit  {

    private int maxLimit;
    private  int minLimit;
    private int value;
    private int computerTry;

    SearchDigit(){
        this.setComputerTry(5);
        this.setMaxLimit(9);
        this.setMinLimit(0);
    }


    /**
     * Adjusts the limit values of this digitrecherche according to the response of the human player
     * @param responseChar
     *                      The human player's answer (+,- or =)
     */
    void adjustLimits(char responseChar){
        switch (responseChar){
            case '+':
                this.setMinLimit(this.getComputerTry());
                this.setComputerNextTry();
                break;
            case '-':
                this.setMaxLimit(this.getComputerTry());
                this.setComputerNextTry();
                break;
            case '=':
                this.setMaxLimit(this.getComputerTry());
                this.setMinLimit(this.getComputerTry());
                this.setValue(this.getComputerTry());
                break;
            default:
                throw new IllegalArgumentException("responseChar must be +, - or =");
        }
    }


    public int getMaxLimit() {
        return maxLimit;
    }

    private void setMaxLimit(int maxLimit) {
        this.maxLimit = maxLimit;
    }

    public int getMinLimit() {
        return minLimit;
    }

    private void setMinLimit(int minLimit) {
        this.minLimit = minLimit;
    }

    int getComputerTry() {
        return computerTry;
    }

    private void setComputerTry(int computerTry) {
        this.computerTry = computerTry;
    }

    /**
     * The next attempt is prepared with the number between the min and max limits
     */
    private void setComputerNextTry(){
        if(this.getMinLimit() == 8){
            this.setComputerTry(9);
        }
        else{
            this.setComputerTry(this.getMinLimit() + (this.getMaxLimit()-this.getMinLimit())/2);
        }

    }
    public void setValue(int value) {
        this.value = value;
    }
}
