package controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.*;

import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;

public class Report implements Initializable {
    private ArrayList<String> bulan = new ArrayList<String>();
    private ArrayList<Data> firstData = new ArrayList<Data>();
    private ArrayList<Data> secondData = new ArrayList<Data>();
    private ArrayList<Data> thirdData = new ArrayList<Data>();

    private ArrayList<Data> bubData = new ArrayList<Data>();

    /*
    * Penggunaan Class Data sebenarnyt tidak perlu, karena toh ujung-ujungy hanya menggunakan data bulan
    * dari array [bulan] dan data angka acak dari library "random". Tapi, kenapa digunakan disini?
    * Sebenarnya ini hanya sebagai simulasi, jika semisal dibutuhkan Class tertentu yang bisa diperluas.
    * by @trihajikhr
    * */

    private Random rand = new Random();
    private final int MIN = 5;
    private final int MAX = 100;

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
    private BubbleChart<Number, Number> grafikBubble;

    @FXML
    private ScatterChart<String, Number> grafikScatter;

    @FXML
    private StackedAreaChart<String, Number> grafikStackedArea;

    @FXML
    private StackedBarChart<String, Number> grafikStackedBar;

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
            int randomNumber = rand.nextInt(MAX - MIN + 1) + MIN;  // +1 supaya max termasuk
            firstData.add(new Data(bulan.get(i), randomNumber));
        }
        for(int i=0; i<bulan.size(); i++){
            int randomNumber = rand.nextInt(MAX - MIN + 1) + MIN;  // +1 supaya max termasuk
            secondData.add(new Data(bulan.get(i), randomNumber));
        }

        for(int i=0; i<bulan.size(); i++){
            int randomNumber = rand.nextInt(MAX - MIN + 1) + MIN;  // +1 supaya max termasuk
            thirdData.add(new Data(bulan.get(i), randomNumber));
        }
    }

    private void regenerateAllData() {
        for(int i=0; i<bulan.size(); i++){
            int randomNumber = rand.nextInt(MAX - MIN + 1) + MIN;  // +1 supaya max termasuk
            firstData.get(i).month = bulan.get(i);
            firstData.get(i).num = randomNumber;
        }

        for(int i=0; i<bulan.size(); i++){
            int randomNumber = rand.nextInt(MAX - MIN + 1) + MIN;  // +1 supaya max termasuk
            secondData.get(i).month = bulan.get(i);
            secondData.get(i).num = randomNumber;
        }

        for(int i=0; i<bulan.size(); i++){
            int randomNumber = rand.nextInt(MAX - MIN + 1) + MIN;  // +1 supaya max termasuk
            thirdData.get(i).month = bulan.get(i);
            thirdData.get(i).num = randomNumber;
        }
    }

    private void generateBubbleChartData() {
        for(int i=0; i<12; i++) {
            int x = rand.nextInt(100);
            int y = rand.nextInt(100);
            int range = rand.nextInt(10);

            bubData.add(new Data(x,y,range));
        }
    }

    private void setGrafikBubble() {
        // BUBBLECHART HANYA MENERIMA 3 PARAMETER NUMBER! TIDAK ADA STRING!!!!!
        // parameter pertama dan kedua mengatur posisi X dan Y axis,
        // parameter ketiga mengatur ukuran bubble

        XYChart.Series series = new XYChart.Series<>();
        series.setName("Aktivitas");

//        for(int i = 0; i < bubData.size(); i++){
//            System.out.println(bubData.get(i).xVal);
//            pengeluaran.getData().add(new XYChart.Data(
//                    i+1,
//                    bubData.get(i).yVal,
//                    bubData.get(i).range
//            ));
//        }

        series.getData().add(new XYChart.Data(10,30,4));
        series.getData().add(new XYChart.Data(25,40,5));
        series.getData().add(new XYChart.Data(40,50,9));
        series.getData().add(new XYChart.Data(55,60,7));
        series.getData().add(new XYChart.Data(70,70,9));
        series.getData().add(new XYChart.Data(85,80,6));

        // tambahkan ke chart
        grafikBubble.getData().add(series);
    }

    private void setGrafikScatter() {
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
            tabungan.getData().add(new XYChart.Data<>(thirdData.get(i).month, thirdData.get(i).num));
        }

        // jika hanya menambahkan satu data, misal pemasukan (gunakan add())
        // grafikScatter.getData().add(pemasukan);

        // tambahkan banyak data aja sekalian bro.. buat dokumentasi mungkin? (gunakan addAll())
        grafikScatter.getData().addAll(pemasukan, pengeluaran, tabungan);
    }

    private void setGrafikStackedArea() {

        XYChart.Series dataSeries1 = new XYChart.Series();
        dataSeries1.setName("Desktop");

        dataSeries1.getData().add(new XYChart.Data( 0, 567));
        dataSeries1.getData().add(new XYChart.Data( 1, 612));
        dataSeries1.getData().add(new XYChart.Data( 2, 800));
        dataSeries1.getData().add(new XYChart.Data( 3, 780));
        dataSeries1.getData().add(new XYChart.Data( 4, 650));
        dataSeries1.getData().add(new XYChart.Data( 5, 610));
        dataSeries1.getData().add(new XYChart.Data( 6, 590));

        grafikStackedArea.getData().add(dataSeries1);

        XYChart.Series dataSeries2 = new XYChart.Series<>();
        dataSeries2.setName("Mobile");

        dataSeries2.getData().add(new XYChart.Data( 0, 101));
        dataSeries2.getData().add(new XYChart.Data( 1, 140));
        dataSeries2.getData().add(new XYChart.Data( 2, 100));
        dataSeries2.getData().add(new XYChart.Data( 3, 200));
        dataSeries2.getData().add(new XYChart.Data( 4, 350));
        dataSeries2.getData().add(new XYChart.Data( 5, 105));
        dataSeries2.getData().add(new XYChart.Data( 6, 290));

        grafikStackedArea.getData().add(dataSeries2);

        XYChart.Series dataSeries3 = new XYChart.Series<>();
        dataSeries2.setName("Mobile");

        dataSeries3.getData().add(new XYChart.Data( 0, 201));
        dataSeries3.getData().add(new XYChart.Data( 1, 100));
        dataSeries3.getData().add(new XYChart.Data( 2, 231));
        dataSeries3.getData().add(new XYChart.Data( 3, 90));
        dataSeries3.getData().add(new XYChart.Data( 4, 75));
        dataSeries3.getData().add(new XYChart.Data( 5, 265));
        dataSeries3.getData().add(new XYChart.Data( 6, 290));

        grafikStackedArea.getData().add(dataSeries3);

//        XYChart.Series<String, Number> series1 = new XYChart.Series<>();
//        series1.setName("Asia");
//        series1.getData().add(new XYChart.Data("1750", 502));
//        series1.getData().add(new XYChart.Data("1800", 635));
//        series1.getData().add(new XYChart.Data("1850", 809));
//        series1.getData().add(new XYChart.Data("1900", 947));
//        series1.getData().add(new XYChart.Data("1950", 1402));
//        series1.getData().add(new XYChart.Data("1999", 3634));
//        series1.getData().add(new XYChart.Data("2050", 5268));


//        XYChart.Series series2 = new XYChart.Series();
//        series2.setName("Africa");
//        series2.getData().add(new XYChart.Data("1750", 106));
//        series2.getData().add(new XYChart.Data("1800", 107));
//        series2.getData().add(new XYChart.Data("1850", 111));
//        series2.getData().add(new XYChart.Data("1900", 133));
//        series2.getData().add(new XYChart.Data("1950", 221));
//        series2.getData().add(new XYChart.Data("1999", 767));
//        series2.getData().add(new XYChart.Data("2050", 1766));
//
//
//        XYChart.Series series3 = new XYChart.Series();
//        series3.setName("Europe");
//
//        series3.getData().add(new XYChart.Data("1750", 163));
//        series3.getData().add(new XYChart.Data("1800", 203));
//        series3.getData().add(new XYChart.Data("1850", 276));
//        series3.getData().add(new XYChart.Data("1900", 408));
//        series3.getData().add(new XYChart.Data("1950", 547));
//        series3.getData().add(new XYChart.Data("1999", 729));
//        series3.getData().add(new XYChart.Data("2050", 628));
//
//
//        XYChart.Series series4 = new XYChart.Series();
//        series4.setName("America");
//        series4.getData().add(new XYChart.Data("1750", 18));
//        series4.getData().add(new XYChart.Data("1800", 31));
//        series4.getData().add(new XYChart.Data("1850", 54));
//        series4.getData().add(new XYChart.Data("1900", 156));
//        series4.getData().add(new XYChart.Data("1950", 339));
//        series4.getData().add(new XYChart.Data("1999", 818));
//        series4.getData().add(new XYChart.Data("2050", 1201));
//
//
//        XYChart.Series series5 = new XYChart.Series();
//        series5.setName("Oceania");
//        series5.getData().add(new XYChart.Data("1750", 2));
//        series5.getData().add(new XYChart.Data("1800", 2));
//        series5.getData().add(new XYChart.Data("1850", 2));
//        series5.getData().add(new XYChart.Data("1900", 6));
//        series5.getData().add(new XYChart.Data("1950", 13));
//        series5.getData().add(new XYChart.Data("1999", 30));
//        series5.getData().add(new XYChart.Data("2050", 46));

        //Setting the data to area chart
//        grafikStackedArea.getData().addAll(series1);
    }

    private void setGrafikStackedBar() {
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
            tabungan.getData().add(new XYChart.Data<>(thirdData.get(i).month, thirdData.get(i).num));
        }

        // jika hanya menambahkan satu data, misal pemasukan (gunakan add())
        // grafikStackedBar.getData().add(pemasukan);

        // tambahkan banyak data aja sekalian bro.. buat dokumentasi mungkin? (gunakan addAll())
        grafikStackedBar.getData().addAll(pemasukan, pengeluaran, tabungan);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // generate awal data
        generateBulan();
        generateAllData();

        // panggil dan regenerate dataChart
        setGrafikBubble();
        regenerateAllData();

        setGrafikScatter();
        regenerateAllData();

        setGrafikStackedArea();
        regenerateAllData();

        setGrafikStackedBar();
    }
}