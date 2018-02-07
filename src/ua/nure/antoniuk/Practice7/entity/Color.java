package ua.nure.antoniuk.Practice7.entity;

/**
 * Created by Max on 12.12.2017.
 */
public enum Color {

    GREEN("green"), BLUE("blue"), VIOLET("violet"), WHITE("white"), RED("red");

    private final String claim;

    Color(String claim) {
        this.claim = claim;
    }

    public String getClaim() {
        return claim;
    }

    @Override
    public String toString() {
        return claim;
    }
}
