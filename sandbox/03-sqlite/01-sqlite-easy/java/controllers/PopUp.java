package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class PopUp {
    @FXML
    public void tampilPopupBerhasil() {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Berhasil");
        alert.setHeaderText("Popup JavaFX");
        alert.setContentText("Data berhasil ditambahkan!");

        alert.showAndWait(); // tampil dan tunggu sampai user close
    }

    public PopUp(){}
}