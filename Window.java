import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.*;
import javafx.scene.layout.*;

public class Window extends Application {

    // -- Data Retrieval --
    private Fetch data = new Fetch();

    private TableView<Assignment> grade_table;
    private TableView<Category> category_table;

    private Label average_grade;

    public void start(Stage primaryStage) {
        // -- Layout Setup --
        VBox main_body = new VBox();    // the overall container
        HBox body = new HBox();         // the inner body
        HBox menu = new HBox();
        VBox left_col = new VBox();
        VBox center_col = new VBox();
        VBox right_col = new VBox();

        main_body.getChildren().addAll(menu, body);
        body.getChildren().addAll(left_col, center_col, right_col);

        leftColSetup(left_col);
        centerColSetup(center_col);
        rightColSetup(right_col);

        // -- Window Specifications --
        main_body.setSpacing(10);
        body.setSpacing(10);

        Scene sc = new Scene(main_body);
        primaryStage.setScene(sc);
        primaryStage.setTitle("Grade Calculator");
        primaryStage.show();
    }

    private void leftColSetup(Pane left_col) {
        // -- Interior Setup Left-Column --
        ChoiceBox<String> year_option = new ChoiceBox<>(FXCollections.observableArrayList());
        year_option.getItems().add("New Year");
        year_option.getItems().addAll(data.getYears());

        ChoiceBox<String> class_option = new ChoiceBox<>(FXCollections.observableArrayList());
        class_option.getItems().add("New Class");
        class_option.getItems().addAll(data.getClasses());

        // Mode Box Setup
        VBox mode_box = new VBox(new Label("MODE"));
        ToggleGroup mode_group = new ToggleGroup();
        RadioButton input_mode = new RadioButton("Input Mode");
        RadioButton estimate_mode = new RadioButton("Estimate Mode");
        input_mode.setToggleGroup(mode_group);
        estimate_mode.setToggleGroup(mode_group);
        mode_box.getChildren().add(input_mode);
        mode_box.getChildren().add(estimate_mode);

        // Image Setup
        Image logo = new Image("images/bunny.jpg");
        ImageView logo_view = new ImageView(logo);
        logo_view.setPreserveRatio(true);
        logo_view.setFitHeight(100);

        // Input Mode Layout
        GridPane input_layout = new GridPane();

        // Estimate Mode Layout
        GridPane estimate_layout = new GridPane();

        // Adding Elements to Left Column
            // TODO: Currently doesn't properly switch between input and estimate mode appearance, must do manually
        left_col.getChildren().add(year_option);
        left_col.getChildren().add(class_option);
        left_col.getChildren().add(mode_box);
        left_col.getChildren().add(input_layout);
        left_col.getChildren().add(logo_view);
    }

    private void centerColSetup(Pane center_col) {
        grade_table = new TableView<>();
        grade_table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        TableColumn<Assignment, String> name_col = new TableColumn<>("Assignment");
        name_col.setMinWidth(100);
        name_col.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Assignment, String> grade_col = new TableColumn<>("Grade");
        grade_col.setMinWidth(100);
        grade_col.setCellValueFactory(new PropertyValueFactory<>("grade"));

        TableColumn<Assignment, Category> category_col = new TableColumn<>("Category");
        category_col.setMinWidth(100);
        category_col.setCellValueFactory(new PropertyValueFactory<>("category"));

        grade_table.setItems(data.fetchAssignment());
        grade_table.getColumns().addAll(name_col, grade_col, category_col);

        Label table_name = new Label("All Grades");
        average_grade = new Label("Average Grade: " + data.calculateGrade());

        center_col.getChildren().add(table_name);
        center_col.getChildren().add(grade_table);
        center_col.getChildren().add(average_grade);
    }

    private void rightColSetup(Pane right_col) {
        category_table = new TableView<>();
        category_table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        TableColumn<Category, String> name_col = new TableColumn<>("Category");
        name_col.setMinWidth(100);
        name_col.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Category, Double> weight_col = new TableColumn<>("Weight");
        weight_col.setMinWidth(100);
        weight_col.setCellValueFactory(new PropertyValueFactory<>("weight"));

        category_table.setItems(data.fetchCategories());
        category_table.getColumns().addAll(name_col, weight_col);

        right_col.getChildren().add(category_table);
    }

    public static void main (String[] args) {
        Application.launch(args);
    }
}