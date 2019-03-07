package projet3.model;

public class DigitRecherche extends Digit {

    private int maxLimit;
    private  int minLimit;
    private int computerTry;
    private int position;


    public DigitRecherche(){
        this.setComputerTry(5);
        this.setMaxLimit(9);
        this.setMinLimit(0);
    }


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

    public int getComputerTry() {
        return computerTry;
    }

    public void setComputerTry(int computerTry) {
        this.computerTry = computerTry;
    }

    //On prépare la prochaine tentative
    private void setComputerNextTry(){
        this.setComputerTry(this.getMinLimit() + (this.getMaxLimit()-this.getMinLimit())/2);
    }
}
