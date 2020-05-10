import java.util.Map;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class Fetch {
    protected Map<String, List<Category>> data;

    public Fetch() {
        retrieveData();
    }

    private void retrieveData() {
        
    }

    public List<String> getYears() {
        return new ArrayList<>();
    }

    public List<String> getClasses() {
        return new ArrayList<>();
    }

    public ObservableList<Assignment> fetchAssignment() {
        ObservableList<Assignment> list = FXCollections.observableArrayList();
        list.add(new Assignment("Exam 1", "80", "Exam"));
        list.add(new Assignment("HW 1", "100", "HW"));
        list.add(new Assignment("Participation 1", "99", "Class Participation"));
        return list;
    }

    public ObservableList<Category> fetchCategories() {
        ObservableList<Category> list = FXCollections.observableArrayList();
        list.add(new Category("Exam", 20));
        list.add(new Category("HW", 10));
        list.add(new Category("Class Participation", 5));
        return list;
    }

    public String calculateGrade() {
        return "100.00";
    }
}