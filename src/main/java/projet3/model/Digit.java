package projet3.model;

public abstract class Digit {

    private int value;


    public String toString() {
        return String.valueOf(this.value);
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
