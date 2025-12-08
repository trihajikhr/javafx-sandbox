package app;

import dataflow.Database;
import controllers.Control;
import dataflow.PopUp;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.SQLException;

public class App extends Application {

    private Database db;
    private PopUp pop;

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/layout.fxml"));
        Parent root = loader.load();   // Load sekali saja

        Control ctrl = loader.getController();   // Controller valid
        ctrl.loadPage("btn1");                   // corePane sudah ter-inject

        // buka aplikasi langung jalankan database
        try {
            db = Database.getInstance();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        try {
            pop = PopUp.getInstance();
        } catch (Exception e){
            System.err.println(e.getMessage());
        }

        root.getStylesheets().add(
                getClass().getResource("/style/card.css").toExternalForm()
        );


        stage.setScene(new Scene(root));
        stage.setTitle("Hello from JavaFX!");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}