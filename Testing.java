import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import javafx.scene.control.TableView;

public class Testing extends Application {
    public void start(Stage primaryStage) {
        VBox main = new VBox(new Text("Main Screen"));
        TableView<String> table = new TableView<>();
        

        main.getChildren().add(table);
        Scene sc = new Scene(main);
        primaryStage.setScene(sc);
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}