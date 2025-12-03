package app;

import controllers.PopUp;

import java.sql.*;

/*
* Penggunaan instane dibutuhkan untuk membuat pemanggilan objek class database tanpa perlu membuat objek baru.
* Ini penting supaya tidak terlalu banyak koneksi yang dibuka untuk terhubung ke databse!
*/

public class Database {
    private static Database instance;
    private Connection con;
    private static final String DB_PATH = "D:\\Github-Grinder\\Java\\javafx-sandbox\\src\\main\\resources\\database\\data.db";

    private Database() {
        try {
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection("jdbc:sqlite:" + DB_PATH);
            con.setAutoCommit(true);

            System.out.println("Database connected!");

        } catch (Exception e) {
            throw new RuntimeException("Failed to connect database: " + e.getMessage());
        }
    }

    public static Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }

    public Connection getConnection() {
        return con;
    }

    public void mendaftar(String nama, int semester) {
        String sql = "INSERT INTO mahasiswa (nama, semester) VALUES (?, ?)";

        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, nama);
            stmt.setInt(2, semester);
            stmt.executeUpdate();
            PopUp popup = new PopUp();
            popup.tampilPopupBerhasil();
        } catch (SQLException e) {
            System.out.println("Gagal insert: " + e.getMessage());
        }
    }
}
