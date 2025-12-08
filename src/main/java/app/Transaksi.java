package app;

import java.time.LocalDateTime;

public class Transaksi {
    public LocalDateTime tanggal;
    public String nama;
    public String kategori;
    public int value;

    public Transaksi() {}

    public Transaksi(LocalDateTime tanggal, String nama, String kategori, int value) {
        this.tanggal = tanggal;
        this.nama = nama;
        this.kategori = kategori;
        this.value = value;
    }

    public LocalDateTime getTanggal() {
        return tanggal;
    }

    public void setTanggal(LocalDateTime tanggal) {
        this.tanggal = tanggal;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
