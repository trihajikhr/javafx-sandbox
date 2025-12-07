package controllers;

import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import javafx.fxml.FXML;

import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.Label;
import javafx.scene.control.Alert;
import javafx.scene.text.TextFlow;
import javafx.scene.text.Text;


import javafx.scene.control.Alert.AlertType;


public class Control {

    Map<String, String> name = new HashMap<>();
    ArrayList<Data> mahasiswa = new ArrayList<>();

    public Control() {
        name.put("123", "Noe Ferreira");
        name.put("342", "Fitrah Ramadhana");
        name.put("523", "Trihaji Khoerur Rohman");
        name.put("751", "Betrand Erlangga");

        for (Map.Entry<String, String> entry : name.entrySet()){
            Data baru = new Data(entry.getKey(), entry.getValue());
            mahasiswa.add(baru);
        }
    }

    @FXML
    private Button tampil;

    @FXML
    private Button sembunyi;

    @FXML
    private Button tambah;

    @FXML
    private TextArea jendela;

    @FXML
    private TextField hasil;

    @FXML
    private TextField inputNim;

    @FXML
    private TextField inputNama;

    @FXML
    private TextFlow textFlow;

    @FXML
    private Label label;


    @FXML
    private void initialize() {
        jendela.setEditable(false); // bikin TextArea read-only
        hasil.setEditable(false);
    }

    @FXML
    private void setTampil() {
        // Kosongkan dulu TextArea jika mau menampilkan full list
        jendela.clear();

//        for (Map.Entry<String, String> entry : name.entrySet()) {
//            String key = entry.getKey();
//            String value = entry.getValue();
//            jendela.appendText("[" + key + "]: " + value + "\n");
//        }

        for(Data d : mahasiswa) {
            jendela.appendText("[" + d.nim + "] " + d.nama + "\n");
        }

        textFlow.getChildren().clear();

//        for (Map.Entry<String, String> entry : name.entrySet()) {
//            String item = "[" + entry.getKey() + "]: " + entry.getValue();
//
//            // pakai Label agar CSS hover blok bisa jalan
//            Label label = new Label(item);
//            label.getStyleClass().add("label"); // pastikan CSS .label:hover ada di envi.css
//
//            // klik event
//            label.setOnMouseClicked(e -> {
//                hasil.setText(entry.getValue());
//            });
//
//            textFlow.getChildren().add(label);
//            // Tambahkan spacer supaya tiap label ada jarak / baris baru
//            textFlow.getChildren().add(new Text("\n"));
//        }

        for(Data d : mahasiswa){
            String item = "[" + d.nim + "] " + d.nama;
            Label label = new Label(item);
            label.getStyleClass().add("label");

            label.setOnMouseClicked(e -> {
                hasil.setText(d.nama);
            });
            textFlow.getChildren().add(label);
            // Tambahkan spacer supaya tiap label ada jarak / baris baru
            textFlow.getChildren().add(new Text("\n"));
        }
    }

    @FXML
    private void setSembunyi() {
        jendela.clear();
        textFlow.getChildren().clear();
        hasil.clear();
    }

    @FXML
    private void tampilPopupBerhasil() {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Berhasil");
        alert.setHeaderText("Popup JavaFX");
        alert.setContentText("Data berhasil ditambahkan!");

        alert.showAndWait(); // tampil dan tunggu sampai user close
    }

    @FXML
    private void tampilPopupWarning(String note) {
        Alert alert = new Alert(AlertType.WARNING);
        alert.setTitle("Gagal");
        alert.setHeaderText("Popup JavaFX");
        alert.setContentText(note);

        alert.showAndWait(); // tampil dan tunggu sampai user close
    }

    @FXML
    private void setTambah() {
        String nim = inputNim.getText();
        String nama = inputNama.getText();
        if(nim.equalsIgnoreCase("") || nama.equalsIgnoreCase("")) {
            tampilPopupWarning("Data kosong!");
            return;
        }

        for (char c : nim.toCharArray()) {
            if(!Character.isDigit(c)) {
                tampilPopupWarning("NIM harus angka!");
                return;
            }
        }

        if(nim.length() != 3) {
            tampilPopupWarning("Panjang NIM tidak sesuai!");
            return;
        }

        if(name.containsKey(nim)){
            String warn = "NIM [" + nim + "] sudah dimiliki oleh " + name.get(nim);
            tampilPopupWarning(warn);
            return;
        }

        try {
            name.put(nim, nama);
            Data baru = new Data(nim, nama);
            mahasiswa.add(baru);
            tampilPopupBerhasil();
            inputNim.clear();
            inputNama.clear();

            // supaya pas baru ditambah, hasilnya langsung muncul
            setTampil();
        } catch (Exception e) {
            tampilPopupWarning("Data gagal ditambahkan!");
        }
    }
}
