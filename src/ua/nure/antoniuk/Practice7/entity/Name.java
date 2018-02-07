package ua.nure.antoniuk.Practice7.entity;

/**
 * Created by Max on 12.12.2017.
 */
public class Name {

    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return content;
    }
}
