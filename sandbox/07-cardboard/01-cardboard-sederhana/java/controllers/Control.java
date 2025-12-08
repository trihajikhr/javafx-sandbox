package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.chart.*;
import javafx.scene.layout.AnchorPane;
import java.io.IOException;

public class Control {

    @FXML
    private AnchorPane corePane;

    @FXML private void btn1(ActionEvent e) { loadPage("btn1"); }
    @FXML private void btn2(ActionEvent e) { loadPage("btn2"); }
    @FXML private void btn3(ActionEvent e) { loadPage("btn3"); }
    @FXML private void btn4(ActionEvent e) { loadPage("btn4"); }
    @FXML private void btn5(ActionEvent e) { loadPage("btn5"); }
    @FXML private void btn6(ActionEvent e) { loadPage("btn6"); }

    @FXML
    public void loadPage(String page) {
        try {
            FXMLLoader loadder = new FXMLLoader(getClass().getResource("/fxml/" + page + ".fxml"));
            Parent root = loadder.load();

            // ini yang kamu cari:
            corePane.getChildren().setAll(root);

            // optional supaya halaman selalu nempel kiri/kanan/atas/bawah
            AnchorPane.setTopAnchor(root, 0.0);
            AnchorPane.setBottomAnchor(root, 0.0);
            AnchorPane.setLeftAnchor(root, 0.0);
            AnchorPane.setRightAnchor(root, 0.0);
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}