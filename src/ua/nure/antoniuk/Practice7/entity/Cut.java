package ua.nure.antoniuk.Practice7.entity;

/**
 * Created by Max on 12.12.2017.
 */
public class Cut {

    private Integer cut;

    public Cut(){}

    public Cut(int cut) {
        this.cut = cut;
    }

    public int getCut() {
        return cut;
    }

    public void setCut(int cut) {
        this.cut = cut;
    }

    @Override
    public String toString() {
        return String.valueOf(cut);
    }
}
