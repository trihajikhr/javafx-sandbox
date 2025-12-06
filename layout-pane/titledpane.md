# 🗃️ TitledPane di JavaFX

**`TitledPane`** adalah kontrol yang berfungsi sebagai kontainer dan dirancang untuk menampung konten tunggal di bawah **judul** atau **header** yang dapat diinteraksi. Fitur utamanya adalah kemampuannya untuk **menyembunyikan** (menciutkan/ *collapse*) atau **menampilkan** (mengembangkan/ *expand*) kontennya dengan mengklik judul tersebut.

## 1. Konsep Dasar

* **Konten Tunggal**: `TitledPane` hanya dapat menampung **satu** Node anak (`content`), yang biasanya adalah *layout pane* lain (`VBox`, `GridPane`, dll.) yang menampung konten yang sebenarnya.
* **Header Interaktif**: Bagian judul (*title bar*) secara otomatis menyertakan ikon panah kecil yang menunjukkan status ciut/kembang. Mengklik judul akan memicu perubahan status ini.
* **Status Ciut/Kembang**: `TitledPane` memiliki properti boolean `expanded` yang mengontrol apakah kontennya terlihat atau tersembunyi.

## 2. Mekanisme Perilaku (TitledPane)

Perilaku `TitledPane` terutama berkaitan dengan manajemen status tampilan dan integrasi dengan `Accordion`.

### A. Pengelolaan Status
* **Ciut (Collapsed)**: Ketika `TitledPane` ciut, hanya *title bar* yang terlihat. Ini menghemat ruang vertikal secara signifikan.
* **Kembang (Expanded)**: Ketika `TitledPane` kembang, kontennya akan ditampilkan di bawah judul, dan tingginya disesuaikan dengan tinggi yang disukai konten.

### B. Perilaku Ukuran Ulang
* **Konten Meregang**: Node konten di dalam `TitledPane` akan meregang penuh untuk mengisi lebar yang tersedia di dalam `TitledPane` tersebut.
* **Tinggi Dinamis**: Tinggi total `TitledPane` **berubah secara dinamis** tergantung pada status `expanded`.

### C. Integrasi dengan `Accordion`
`TitledPane` adalah komponen utama dari kontainer `Accordion`. Ketika ditempatkan di dalam `Accordion`, `TitledPane` akan memiliki perilaku unik: **hanya satu** yang diizinkan untuk kembang pada saat yang sama. Jika Anda menggunakan `TitledPane` secara independen, perilaku tersebut tidak berlaku; Anda dapat mengembang/menciutkannya secara bebas.

## 3. Kasus Penggunaan Populer

`TitledPane` sangat berguna untuk aplikasi yang perlu mengelola informasi yang banyak dalam ruang yang terbatas:

* **Bagian Pengaturan yang Opsional**: Menyembunyikan pengaturan tingkat lanjut atau jarang diakses di bawah judul yang jelas, hanya menampilkannya saat pengguna membutuhkannya.
* **Panel Informasi di Sidebar**: Digunakan di dalam `VBox` pada *sidebar* untuk mengelompokkan berbagai jenis informasi (misalnya, "Properti File," "Metadata," "Pratinjau") yang dapat dibuka/ditutup secara independen.
* **Komponen `Accordion`**: Seperti yang disebutkan, digunakan untuk membuat antarmuka yang hanya menampilkan satu bagian konten dari sekumpulan konten pada satu waktu (misalnya, FAQ).

> [!TIP]
> **`TitledPane`** adalah kontrol yang berfungsi sebagai kontainer yang menyediakan cara **efisien** dan **interaktif** untuk menyembunyikan atau menampilkan konten, menjadikannya solusi hebat untuk **mengelola kepadatan informasi** vertikal.

---

Source: 