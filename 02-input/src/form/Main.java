package form;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage stage) {
        Button btn = new Button("Hello JavaFX!");
        StackPane root = new StackPane(btn);

        Scene scene = new Scene(root, 300, 200);
        stage.setScene(scene);
        stage.setTitle("JavaFX Maven");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
