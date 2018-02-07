package ua.nure.antoniuk.Practice7.entity;

import java.util.Objects;

/**
 * Created by Max on 12.12.2017.
 */
public class VisualParam {

    private Color color;

    private Cut cut;

    private Transparency transparency;

    public Color getColor() {
        if (Objects.isNull(color)) {
            return Color.GREEN;
        }
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Cut getCut() {
        if (Objects.isNull(cut)) {
            return new Cut();
        }
        return cut;
    }

    public void setCut(Cut cut) {
        this.cut = cut;
    }

    @Override
    public String toString() {
        return "VisualParam{" +
                "color=" + color +
                ", cut=" + cut +
                ", transparency=" + transparency +
                '}';
    }

    public Transparency getTransparency() {
        if (Objects.isNull(transparency)) {
            return new Transparency();
        }
        return transparency;
    }

    public void setTransparency(Transparency transparency) {
        this.transparency = transparency;
    }
}
