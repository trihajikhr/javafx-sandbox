package controllers;

import app.Database;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

import java.sql.*;
import java.io.File;

public class Control {
    @FXML
    private Button daftar;

    @FXML
    private Button tampil;

    @FXML
    private TextField inputSemester;

    @FXML
    private TextField inputNama;

    @FXML
    private TextArea outputArea;

    @FXML
    private void setDaftar() {
        int semester = Integer.parseInt(inputSemester.getText());
        String nama = inputNama.getText();

        Database.getInstance().mendaftar(nama, semester);
        clearAll();
    }

    private void clearAll(){
        inputNama.clear();
        inputSemester.clear();
    }

    @FXML
    public void showAllMahasiswa() {
        String sql = "SELECT * FROM mahasiswa";
        StringBuilder result = new StringBuilder();

        Connection conn = Database.getInstance().getConnection();

        try (PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id_mahasiswa");
                String nama = rs.getString("nama");
                int semester = rs.getInt("semester");

                result.append("[" + id + "]")
                        .append("[" + semester + "]: ")
                        .append("[" + nama + "]")
                        .append("\n");
            }

            outputArea.setText(result.toString());

        } catch (SQLException e) {
            outputArea.setText("Error: " + e.getMessage());
        }
    }
}