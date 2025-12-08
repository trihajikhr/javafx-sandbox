package dataflow;

import java.io.File;
import java.sql.*;

/*
* Bisa dipanggil secara langsung di Main, atau ditaruh di initialize di class Import
* Class ini adalah class singleton, jadi ketika dipanggi, jika belum dibuat maka objeknya dibuat.
* Jika sudah dibuat, maka hanya memanggil yang sudah ada sebelumnya.
*
* Ini membuat kita tidak perlu membuat koneksi baru berulang kali, yang mana tidak perlu dan
* bukan pendekatan yang efisien!
* */

public class Database {
    private static Database instance;
    private Connection koneksi;

    private final String JDBC_URL =  "jdbc:sqlite:";
    private final String DATABASE_FOLDER = "databases";
    private final String DATABASE_NAME = "data.db";
    // absolute path:
    // private final String DB_FILE = System.getProperty("user.home") + "/myapp/data.db";

    private Database () throws SQLException {
        try {
            File folder = new File(DATABASE_FOLDER);
            if(!folder.exists()){
                folder.mkdir();
            }

            koneksi = DriverManager.getConnection(JDBC_URL + DATABASE_FOLDER + File.separator + DATABASE_NAME);
            Statement perintah = koneksi.createStatement();

            String createTableMahasiswa =
                    """
                    CREATE TABLE IF NOT EXISTS "mahasiswa" (
                        "nim"	TEXT NOT NULL UNIQUE,
                        "nama"	TEXT,
                        "ipk"	REAL,
                        "semester"	INTEGER,
                        PRIMARY KEY("nim")
                    )
                    """;

            String createTableDosen =
                    """
                    CREATE TABLE IF NOT EXISTS "dosen" (
                        "nip"	TEXT NOT NULL UNIQUE,
                        "nama"	TEXT,
                        "lama"	INTEGER,
                        "publikasi"	INTEGER,
                        "email"	TEXT UNIQUE,
                        PRIMARY KEY("nip")
                    )
                    """;

            perintah.executeUpdate(createTableMahasiswa);
            perintah.executeUpdate(createTableDosen);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            throw e;
        }
    }

    public static Database getInstance() throws SQLException {
        if (instance == null) {
            instance = new Database();
            System.err.println("Connection Succesfull!");
        }

        return instance;
    }

    public Connection getConnection() {
        return koneksi;
    }

    public boolean insertMahasiswa(Mahasiswa mhs) {
        String sql = "INSERT INTO mahasiswa (nim, nama, ipk, semester) VALUES (?, ?, ?, ?)";

        try {
            PreparedStatement perintah = koneksi.prepareStatement(sql);
            perintah.setString(1, mhs.nim);
            perintah.setString(2, mhs.nama);
            perintah.setDouble(3, mhs.ipk);
            perintah.setInt(4, mhs.semester);

            perintah.executeUpdate();
            PopUp.getInstance().tampilPopupBerhasil("Data berhasil ditambahkan!");
            return true;

        } catch (SQLException e) {
            // Tangani constraint violation (PK/UNIQUE)
            if (e.getErrorCode() == 19) {
                PopUp.getInstance().tampilPopupWarning("Nim sudah ada di database!");
            } else {
                PopUp.getInstance().tampilPopupWarning("SQL Error: " + e.getMessage());
            }
            return false;
        }
    }

    public boolean insertDosen(Dosen dsn) {
        String sql = "INSERT INTO dosen (nip, nama, lama, publikasi, email) VALUES (?, ?, ?, ?, ?)";

        try {
            PreparedStatement perintah = koneksi.prepareStatement(sql);
            perintah.setString(1, dsn.nip);
            perintah.setString(2, dsn.nama);
            perintah.setInt(3, dsn.lama);
            perintah.setInt(4, dsn.publikasi);
            perintah.setString(5, dsn.email);

            perintah.executeUpdate();
            PopUp.getInstance().tampilPopupBerhasil("Data berhasil ditambahkan!");
            return true;

        } catch (SQLException e) {
            // Tangani constraint violation (PK/UNIQUE)
            if (e.getErrorCode() == 19) {
                PopUp.getInstance().tampilPopupWarning("Nip / email sudah ada di database!");
            } else {
                PopUp.getInstance().tampilPopupWarning("SQL Error: " + e.getMessage());
            }
            return false;
        }
    }
}

// INSTALLER SAFE PATH FOR DATABASE!
//public class AppPaths {
//
//    public static Path getDatabasePath() {
//        String base = System.getenv("LOCALAPPDATA");
//        Path folder = Paths.get(base, "ExtraWallet", "databases");
//
//        try {
//            Files.createDirectories(folder);
//        } catch (IOException e) {
//            throw new RuntimeException("Gagal buat folder database", e);
//        }
//
//        return folder.resolve("data.db");
//    }
//}
//
//Path dbPath = AppPaths.getDatabasePath();
//String url = "jdbc:sqlite:" + dbPath.toString();
//connection = DriverManager.getConnection(url);