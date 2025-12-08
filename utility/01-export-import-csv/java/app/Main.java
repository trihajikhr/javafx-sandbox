package app;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

 class CSVUtil {
    public static void exportToCSV(List<Transaksi> data, String namaFile) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(namaFile))) {

            // Tulis header
            writer.write("waktu,nama,jenis,nominal");
            writer.newLine();

            // Loop data
            for (Transaksi t : data) {
                String line = t.getTanggal() + "," + t.getNama() + "," + t.getKategori() + "," + t.getValue();
                writer.write(line);
                writer.newLine();
            }

            System.out.println("Data berhasil diekspor ke " + namaFile);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

     // Fungsi import CSV → mengembalikan list transaksi
     public static ArrayList<Transaksi> importFromCSV(String namaFile) {
         ArrayList<Transaksi> list = new ArrayList<>();

         try (BufferedReader reader = new BufferedReader(new FileReader(namaFile))) {

             String line;
             boolean isFirstLine = true;

             while ((line = reader.readLine()) != null) {
                 // skip header
                 if (isFirstLine) {
                     isFirstLine = false;
                     continue;
                 }

                 // pisah pakai koma
                 String[] parts = line.split(",");

                 // pastikan jumlah kolom sesuai
                 if (parts.length < 4) continue;

                 LocalDateTime waktu = LocalDateTime.parse(parts[0]); // asumsi format ISO
                 String nama = parts[1];
                 String jenis = parts[2];
                 int nominal = Integer.parseInt(parts[3]);

                 Transaksi t = new Transaksi(waktu, nama, jenis, nominal);
                 list.add(t);
             }

             System.out.println("Data berhasil diimpor dari " + namaFile);

         } catch (IOException e) {
             e.printStackTrace();
         }

         return list;
     }
 }

public class Main {
    public static void main(String[] args){

        ArrayList<Transaksi> data = new ArrayList<Transaksi>();
        LocalDateTime waktu = LocalDateTime.now();

//        data.add(new Transaksi(waktu, "Joni", "Bengkel", 100000));
//        data.add(new Transaksi(waktu, "Tania", "Cafe", 250000));
//        data.add(new Transaksi(waktu, "Febri", "Konser", 340000));
//        data.add(new Transaksi(waktu, "Toni", "Hiking", 561000));
//        data.add(new Transaksi(waktu, "Jacob", "Mudik", 90000));
//
//        String namaFile = "transaksi.csv";
//
//        CSVUtil.exportToCSV(data, namaFile);

        data = CSVUtil.importFromCSV("transaksi.csv");

        for(Transaksi t : data) {
            System.out.println("Tanggal  : " + t.getTanggal());
            System.out.println("Nama     : " + t.getNama());
            System.out.println("Kategori : " + t.getKategori());
            System.out.println("Value    : " + t.getValue() + "\n");
        }
    }
}
