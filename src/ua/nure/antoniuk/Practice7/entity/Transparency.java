package ua.nure.antoniuk.Practice7.entity;

/**
 * Created by Max on 12.12.2017.
 */
public class Transparency {
    private Double value;

    public Transparency(double v) {
        value = v;
    }

    public Transparency(){}

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
