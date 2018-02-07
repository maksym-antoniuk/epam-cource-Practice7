package ua.nure.antoniuk.Practice7.entity;

/**
 * Created by Max on 12.12.2017.
 */
public class Gem {

    private Name name;
    private Preciousness preciousness;
    private Origin origin;
    private VisualParam visualParam;
    private Value value;

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public Preciousness getPreciousness() {
        return preciousness;
    }

    public void setPreciousness(Preciousness preciousness) {
        this.preciousness = preciousness;
    }

    public Origin getOrigin() {
        return origin;
    }

    public void setOrigin(Origin origin) {
        this.origin = origin;
    }

    public VisualParam getVisualParam() {
        return visualParam;
    }

    public void setVisualParam(VisualParam visualParam) {
        this.visualParam = visualParam;
    }

    public Value getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Gem{" +
                "name=" + name +
                ", preciousness=" + preciousness +
                ", origin=" + origin +
                ", visualParam=" + visualParam +
                ", value=" + value +
                '}';
    }

    public void setValue(Value value) {
        this.value = value;
    }
}
