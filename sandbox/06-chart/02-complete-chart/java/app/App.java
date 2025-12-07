package app;

import controllers.Control;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/layout.fxml"));
        Parent root = loader.load();   // Load sekali saja

        Control ctrl = loader.getController();   // Controller valid
        ctrl.loadPage("btn1");                   // corePane sudah ter-inject

        stage.setScene(new Scene(root));
        stage.setTitle("Hello from JavaFX!");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}