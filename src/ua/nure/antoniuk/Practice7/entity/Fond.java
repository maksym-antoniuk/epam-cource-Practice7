package ua.nure.antoniuk.Practice7.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by Max on 12.12.2017.
 */
public class Fond {

    private List<Gem> gems;

    public List<Gem> getGems() {
        if (gems == null) {
            gems = new ArrayList<>();
        }
        return gems;
    }

    @Override
    public String toString() {
        if (Objects.isNull(gems) || gems.size() == 0) {
            return "Fond contains no gems";
        }
        StringBuilder result = new StringBuilder();
        for (Gem question : gems) {
            result.append(question).append('\n');
        }
        return result.toString();
    }
}
