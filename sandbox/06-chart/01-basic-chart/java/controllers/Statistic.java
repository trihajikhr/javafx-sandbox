package controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.ArrayList;
import java.util.Random;

public class Statistic implements Initializable {
    private ArrayList<String> bulan = new ArrayList<String>();
    private ArrayList<Data> firstData = new ArrayList<Data>();
    private ArrayList<Data> secondData = new ArrayList<Data>();
    private ArrayList<Data> thirdData = new ArrayList<Data>();

    /*
    * Penggunaan Class Data sebenarnyt tidak perlu, karena toh ujung-ujungy hanya menggunakan data bulan
    * dari array [bulan] dan data angka acak dari library "random". Tapi, kenapa digunakan disini?
    * Sebenarnya ini hanya sebagai simulasi, jika semisal dibutuhkan Class tertentu yang bisa diperluas.
    * by @trihajikhr
    * */

    private Random rand = new Random();
    private final int min = 5;
    private final int max = 100;

/*
    // sample tambah beberapa data sekalian, harusnya sih...
    XYChart.Series<String, Number> pengeluaran = new XYChart.Series<>();
    pengeluaran.setName("Pengeluaran");
    pengeluaran.getData().add(new XYChart.Data<>("Jan", 2000000));
    pengeluaran.getData().add(new XYChart.Data<>("Feb", 1500000));
    pengeluaran.getData().add(new XYChart.Data<>("Mar", 2200000));

    XYChart.Series<String, Number> pendapatan = new XYChart.Series<>();
    pendapatan.setName("Pendapatan");
    pendapatan.getData().add(new XYChart.Data<>("Jan", 3000000));
    pendapatan.getData().add(new XYChart.Data<>("Feb", 2500000));
    pendapatan.getData().add(new XYChart.Data<>("Mar", 3200000));

    XYChart.Series<String, Number> tabungan = new XYChart.Series<>();
    tabungan.setName("Tabungan");
    tabungan.getData().add(new XYChart.Data<>("Jan", 1000000));
    tabungan.getData().add(new XYChart.Data<>("Feb", 1000000));
    tabungan.getData().add(new XYChart.Data<>("Mar", 1000000));

    // tambahkan semua series ke chart
    lineChart.getData().addAll(pengeluaran, pendapatan, tabungan);

    // tambah data tunggal
    lineChart.getData().add(pengeluaran);
*/

    // sudah disetting ada di fxml:id, jangan lupa lagi cuk!
    @FXML
    private AreaChart<String, Number> grafikArea;

    @FXML
    private BarChart<String, Number> grafikBar;

    @FXML
    private LineChart<String, Number> grafikLine;

    @FXML
    private PieChart grafikPie;

    private void generateBulan() {
        bulan.add("Januari");
        bulan.add("Februari");
        bulan.add("Maret");
        bulan.add("April");
        bulan.add("Mei");
        bulan.add("Juni");
        bulan.add("Juli");
        bulan.add("Agustus");
        bulan.add("September");
        bulan.add("Oktober");
        bulan.add("November");
        bulan.add("Desember");
    }

    private void generateAllData() {
        for(int i=0; i<bulan.size(); i++){
            int randomNumber = rand.nextInt(max - min + 1) + min;  // +1 supaya max termasuk
            firstData.add(new Data(bulan.get(i), randomNumber));
        }
        for(int i=0; i<bulan.size(); i++){
            int randomNumber = rand.nextInt(max - min + 1) + min;  // +1 supaya max termasuk
            secondData.add(new Data(bulan.get(i), randomNumber));
        }

        for(int i=0; i<bulan.size(); i++){
            int randomNumber = rand.nextInt(max - min + 1) + min;  // +1 supaya max termasuk
            thirdData.add(new Data(bulan.get(i), randomNumber));
        }
    }

    private void regenerateAllData() {
        for(int i=0; i<bulan.size(); i++){
            int randomNumber = rand.nextInt(max - min + 1) + min;  // +1 supaya max termasuk
            firstData.get(i).month = bulan.get(i);
            firstData.get(i).num = randomNumber;
        }

        for(int i=0; i<bulan.size(); i++){
            int randomNumber = rand.nextInt(max - min + 1) + min;  // +1 supaya max termasuk
            secondData.get(i).month = bulan.get(i);
            secondData.get(i).num = randomNumber;
        }

        for(int i=0; i<bulan.size(); i++){
            int randomNumber = rand.nextInt(max - min + 1) + min;  // +1 supaya max termasuk
            thirdData.get(i).month = bulan.get(i);
            thirdData.get(i).num = randomNumber;
        }
    }

    private void setGrafikArea() {
        // pengeluaran
        XYChart.Series<String, Number> pengeluaran = new XYChart.Series<>();
        pengeluaran.setName("Pengeluaran");

        for(int i=0; i<firstData.size(); i++){
            pengeluaran.getData().add(new XYChart.Data<>(firstData.get(i).month, firstData.get(i).num));
        }

        // pemasukan
        XYChart.Series<String, Number> pemasukan = new XYChart.Series<>();
        pemasukan.setName("Pemasukan");

        for(int i=0; i<secondData.size(); i++){
            pemasukan.getData().add(new XYChart.Data<>(secondData.get(i).month, secondData.get(i).num));
        }

        // tabungan
        XYChart.Series<String, Number> tabungan = new XYChart.Series<>();
        tabungan.setName("Tabungan");

        for(int i=0; i<thirdData.size(); i++){
            tabungan.getData().add(new XYChart.Data<>(secondData.get(i).month, thirdData.get(i).num));
        }

        // jika hanya menambahkan satu data, misal pemasukan (gunakan add())
        // grafikArea.getData().add(pemasukan);

        // tambahkan banyak data aja sekalian bro.. buat dokumentasi mungkin? (gunakan addAll())
        grafikArea.getData().addAll(pemasukan, pengeluaran, tabungan);
    }

    private void setGrafikBar() {
        // pengeluaran
        XYChart.Series<String, Number> pengeluaran = new XYChart.Series<>();
        pengeluaran.setName("Pengeluaran");

        for(int i=0; i<firstData.size(); i++){
            pengeluaran.getData().add(new XYChart.Data<>(firstData.get(i).month, firstData.get(i).num));
        }

        // pemasukan
        XYChart.Series<String, Number> pemasukan = new XYChart.Series<>();
        pemasukan.setName("Pemasukan");

        for(int i=0; i<secondData.size(); i++){
            pemasukan.getData().add(new XYChart.Data<>(secondData.get(i).month, secondData.get(i).num));
        }

        // tabungan
        XYChart.Series<String, Number> tabungan = new XYChart.Series<>();
        tabungan.setName("Tabungan");

        for(int i=0; i<thirdData.size(); i++){
            tabungan.getData().add(new XYChart.Data<>(secondData.get(i).month, thirdData.get(i).num));
        }

        // jika hanya menambahkan satu data, misal pemasukan (gunakan add())
        // grafikBar.getData().add(pemasukan);

        // tambahkan banyak data aja sekalian bro.. buat dokumentasi mungkin? (gunakan addAll())
        grafikBar.getData().addAll(pemasukan, pengeluaran, tabungan);
    }

    private void setGrafikLine() {
        // pengeluaran
        XYChart.Series<String, Number> pengeluaran = new XYChart.Series<>();
        pengeluaran.setName("Pengeluaran");

        for(int i=0; i<firstData.size(); i++){
            pengeluaran.getData().add(new XYChart.Data<>(firstData.get(i).month, firstData.get(i).num));
        }

        // pemasukan
        XYChart.Series<String, Number> pemasukan = new XYChart.Series<>();
        pemasukan.setName("Pemasukan");

        for(int i=0; i<secondData.size(); i++){
            pemasukan.getData().add(new XYChart.Data<>(secondData.get(i).month, secondData.get(i).num));
        }

        // tabungan
        XYChart.Series<String, Number> tabungan = new XYChart.Series<>();
        tabungan.setName("Tabungan");

        for(int i=0; i<thirdData.size(); i++){
            tabungan.getData().add(new XYChart.Data<>(secondData.get(i).month, thirdData.get(i).num));
        }

        // jika hanya menambahkan satu data, misal pemasukan (gunakan add())
        // grafikLine.getData().add(pemasukan);

        // tambahkan banyak data aja sekalian bro.. buat dokumentasi mungkin? (gunakan addAll())
        grafikLine.getData().addAll(pemasukan, pengeluaran, tabungan);
    }

    private void setGrafikPie() {
        // jika tambah data langsung oy..
//        ObservableList<PieChart.Data> grafik = FXCollections.observableArrayList(
//            new PieChart.Data("Makanan", 30),
//            new PieChart.Data("Transportasi", 20),
//            new PieChart.Data("Hiburan", 50)
//        );

        ObservableList<PieChart.Data> grafik = FXCollections.observableArrayList();
        for(int i=0; i<firstData.size(); i++){
            grafik.add(new PieChart.Data(firstData.get(i).month, firstData.get(i).num));
        }

        grafikPie.setData(grafik);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // generate awal data
        generateBulan();
        generateAllData();

        // panggli areaChart
        setGrafikArea();
        regenerateAllData();

        // barChart
        setGrafikBar();
        regenerateAllData();

        // lineChart
        setGrafikLine();
        regenerateAllData();

        // pirChart
        setGrafikPie();
    }
}
