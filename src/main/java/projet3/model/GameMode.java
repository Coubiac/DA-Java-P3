package projet3.model;

public enum GameMode {
    CHALLENGER("Mode Challenger"),
    DEFENSEUR("Mode Défenseur"),
    DUEL("Mode Duel");

    private String name;

    GameMode(String name){
        this.name = name;
    }

    public String toString(){
        return name;
    }
}
