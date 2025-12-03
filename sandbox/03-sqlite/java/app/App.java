package app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/daftar.fxml"));
        Database.getInstance();
        stage.setScene(new Scene(loader.load()));
        stage.setTitle("Percobaaan SQLite!");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}