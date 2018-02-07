package ua.nure.antoniuk.Practice7.entity;

import sun.awt.SunHints;

/**
 * Created by Max on 12.12.2017.
 */
public class Value {

    private Double value;

    public Value(){}

    public Value(double v) {
        value = v;
    }

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
