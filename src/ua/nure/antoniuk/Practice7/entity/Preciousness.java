package ua.nure.antoniuk.Practice7.entity;

/**
 * Created by Max on 12.12.2017.
 */
public enum Preciousness {
    PRECIOUS("драгоценный"), SEMIPRECIOUS("полудрагоценный");

    private final String claim;

    Preciousness(String claim) {
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
