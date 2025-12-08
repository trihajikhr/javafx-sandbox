package dataflow;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class PopUp {
    private static PopUp instance;

    @FXML
    public void tampilPopupBerhasil(String note) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Berhasil");
        alert.setHeaderText("Penambahan data pada database Berhasil!");
        alert.setContentText(note);

        alert.showAndWait(); // tampil dan tunggu sampai user close
    }

    @FXML
    public void tampilPopupKonfirmasi(String note) {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Konfirmasi");
        alert.setHeaderText("Penambahan data");
        alert.setContentText(note);

        alert.showAndWait(); // tampil dan tunggu sampai user close
    }

    @FXML
    public void tampilPopupWarning(String note) {
        Alert alert = new Alert(AlertType.WARNING);
        alert.setTitle("Gagal");
        alert.setHeaderText("Terjadi kesalahan");
        alert.setContentText(note);

        alert.showAndWait(); // tampil dan tunggu sampai user close
    }

    public PopUp(){}

    public static PopUp getInstance() {
        if (instance == null) {
            instance = new PopUp();
        }

        return instance;
    }
}