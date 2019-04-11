package projet3.model;

/**
 * Un digit représente un nombre. Il possède au moins une valeur.
 */
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
