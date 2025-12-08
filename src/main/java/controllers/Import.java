package controllers;

import dataflow.Database;
import dataflow.Dosen;
import dataflow.Mahasiswa;
import dataflow.PopUp;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Import {
    // mahasiswa
    @FXML private TextField nimForm;
    @FXML private TextField namaForm;
    @FXML private TextField ipkForm;
    @FXML private TextField semesterForm;

    // dosen
    @FXML private TextField nipForm;
    @FXML private TextField namaFormDosen;
    @FXML private TextField lamaForm;
    @FXML private TextField publikasiForm;
    @FXML private TextField emailForm;

    @FXML private Button submitMahasiswa;
    @FXML private Button submitDosen;

    @FXML private GridPane gridFormMhs;
    @FXML private GridPane gridFormDsn;

    // jika node adalah anak langsung
//    private boolean validateGrid(GridPane grid) {
//        boolean valid = true;
//
//        for (Node node : grid.getChildren()) {
//            if (node instanceof TextField tf) {
//                boolean empty = tf.getText().trim().isEmpty();
//
//                tf.setStyle(empty ? "-fx-border-color: red;" : "");
//
//                if (empty) valid = false;
//            }
//        }
//
//        return valid;
//    }

    // rekursive validate
    private boolean validate(Node root) {
        boolean valid = true;

        if (root instanceof TextField tf) {
            boolean empty = tf.getText().trim().isEmpty();
            tf.setStyle(empty ? "-fx-border-color: red;" : "");
            if (empty) valid = false;
        }

        if (root instanceof javafx.scene.Parent parent) {
            for (Node child : parent.getChildrenUnmodifiable()) {
                if (!validate(child)) {
                    valid = false;
                }
            }
        }

        return valid;
    }

    // jika node adalah anak langsuing!
//    @FXML
//    private void clearAllData(GridPane grid) {
//        for (Node node : grid.getChildren()) {
//            if (node instanceof TextField tf) {
//                tf.clear();        // kosongkan field
//                tf.setStyle("");   // hilangkan border merah kalau ada
//            }
//        }
//    }

    // rekursif clear
    private void clearAll(Node root) {
        if (root instanceof TextField tf) {
            tf.clear();
            tf.setStyle("");
        }

        if (root instanceof javafx.scene.Parent parent) {
            for (Node child : parent.getChildrenUnmodifiable()) {
                clearAll(child);
            }
        }
    }

    @FXML
    private void cancelMhs(){
        System.out.println("gridFormMhs = " + gridFormMhs);
        clearAll(gridFormMhs);
    }

    @FXML
    private void cancelDsn(){
        System.out.println("gridFormMhs = " + gridFormDsn);
        clearAll(gridFormDsn);
    }

    @FXML
    private void submitMhs() {
        if(!validate(gridFormMhs)) {
            PopUp.getInstance().tampilPopupWarning("Ada data kosong!");
            return;
        }

        String nim = nimForm.getText();
        String nama = namaForm.getText();
        double ipk = Double.parseDouble(ipkForm.getText());
        int semester = Integer.parseInt(semesterForm.getText());
        try {
            Database.getInstance().insertMahasiswa(new Mahasiswa(nim, nama, ipk, semester));
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            PopUp.getInstance().tampilPopupWarning("Data gagal ditambahkan!");
        }
    }


    @FXML
    private void submitDsn() {
        if(!validate(gridFormDsn)) {
            PopUp.getInstance().tampilPopupWarning("Ada data kosong!");
            return;
        }

        String nip = nipForm.getText();
        String nama = namaFormDosen.getText();
        int lama = Integer.parseInt(lamaForm.getText());
        int publikasi = Integer.parseInt(publikasiForm.getText());
        String email = emailForm.getText();
        try {
            Database.getInstance().insertDosen(new Dosen(nip, nama, lama, publikasi, email));
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            PopUp.getInstance().tampilPopupWarning("Data gagal ditambahkan!");
        }
    }
}
