# 📑 Tab di JavaFX

<div style="display: flex; gap: 10px;" align="center">
  <img src="media/tab-demo.gif" style="height: 500px;">
</div>

<br/>

**`Tab`** bukanlah kontainer *layout* melainkan sebuah objek data dan kontrol yang dirancang khusus untuk menampung konten di dalam kontainer **`TabPane`**. Ia berfungsi sebagai **item tunggal** yang memisahkan dan mengorganisir halaman konten.

## 1. Konsep Dasar

* **Item Anak `TabPane`**: Objek `Tab` adalah item anak yang disimpan oleh `TabPane`. `TabPane` bertindak sebagai pengelola, sementara `Tab` itu sendiri menampung data dan konten.
* **Tiga Elemen Kunci**: Setiap objek `Tab` terdiri dari:
    1.  **Teks/Judul**: Judul yang terlihat pada bilah tab.
    2.  **Grafis (Opsional)**: Ikon yang ditampilkan di samping teks tab.
    3.  **Konten (`Content`)**: Node tunggal (biasanya `Pane` atau *layout manager* lain) yang akan ditampilkan saat `Tab` ini aktif.

* **Fungsi**: Tujuan utamanya adalah untuk memecah UI menjadi tampilan yang berbeda di lokasi yang sama.

## 2. Mekanisme Perilaku (Tab)

Perilaku `Tab` sepenuhnya dikontrol dan dimanifestasikan melalui `TabPane` induknya:

### A. Status Seleksi
* **`selected`**: Properti Boolean yang menunjukkan apakah `Tab` tersebut saat ini sedang dilihat oleh pengguna. Hanya konten dari `Tab` yang sedang *selected* yang dirender dan aktif.
* **Peristiwa *Change***: `Tab` memiliki *event handler* yang dapat mendeteksi saat tab diaktifkan atau dinonaktifkan, memungkinkan Anda menjalankan logika (seperti memuat data) hanya saat tab tertentu dibuka.

### B. Perilaku Konten
* **Konten Tunggal**: `Tab` hanya menerima **satu** Node sebagai isinya (`content`). Node ini akan meregang penuh untuk mengisi seluruh area konten yang disediakan oleh `TabPane`.
* **Cicilan (*Closable*)**: `Tab` dapat diatur agar memiliki tombol silang di samping judulnya (properti `closable=true`). Tombol ini memungkinkan pengguna untuk menutup tab secara dinamis saat *runtime*.

### C. Integrasi Visual
`Tab` mengelola bagaimana tampilannya diatur secara visual, termasuk penempatan grafis relatif terhadap teks dan tampilan tombol tutup (jika diaktifkan).

## 3. Kasus Penggunaan Populer

`Tab` tidak digunakan sendiri, tetapi merupakan blok bangunan untuk:

* **Halaman Web Individual**: Dalam peramban (*browser*), setiap halaman yang terbuka diwakili oleh sebuah `Tab` (dengan tombol tutup aktif).
* **Tampilan Item Detail**: Ketika aplikasi menampilkan informasi mendalam tentang suatu objek, `Tab` digunakan untuk memisahkan kategori detail (misalnya, tab "Spesifikasi," tab "Riwayat," tab "Ulasan").
* **Area Kerja Multi-File**: Dalam editor teks atau IDE, setiap *file* yang terbuka merupakan `Tab` yang dapat ditutup.

> [!TIP]
> **`Tab`** adalah objek fungsional yang penting, bertindak sebagai **pemisah logis** dan **wadah konten tunggal** di dalam kontainer `TabPane`, memungkinkan manajemen dan navigasi yang efisien antara berbagai tampilan.

Source: [Oracle](https://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/Tab.html)