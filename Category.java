import java.util.List;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.ArrayList;

public class Category {
    protected String name;
    protected double weight;
    protected List<Assignment> assignments;

    public Category(String name, double weight) {
        this.name = name;
        this.weight = weight;
        this.assignments = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public double getWeight() {
        return this.weight;
    }

    public List<Assignment> getAssignments() {
        return this.assignments;
    }

    public String toString() {
        return this.name;
    }
}