package app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/accordion.fxml"));
        stage.setScene(new Scene(loader.load()));
        stage.setTitle("Mencoba Accordion!");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}