# JavaFX Sandbox

Tempat eksplorasi, latihan, dan eksperimen pribadi dengan **JavaFX**. Repo ini berfungsi sebagai buku catatan digital untuk berbagai fitur, komponen, dan pola desain JavaFX.

## Tujuan Utama

Repo ini dibuat untuk:

* **Belajar Cepat:** Mengembangkan contoh-contoh kecil dan terisolasi untuk memahami cara kerja komponen JavaFX tertentu (seperti `TableView`, `ListView`, atau animasi).
* **Eksperimen Bebas:** Menguji berbagai pola desain (misalnya, **MVC** atau **MVVM**) dalam konteks aplikasi JavaFX.
* **Referensi Praktis:** Menyimpan *snippets* kode yang sering dibutuhkan untuk diakses kembali dengan mudah di proyek lain.

## Struktur Proyek

Setiap folder atau *package* di dalam *source code* dirancang untuk menjadi contoh yang **mandiri** dan **terisolasi** yang fokus pada satu fitur atau konsep spesifik.

| Direktori/Package                     | Deskripsi                                                                                      |
|:--------------------------------------|:-----------------------------------------------------------------------------------------------|
| `src/main/java/app/Main`              | Tempat menjalankan aplikasi Java berbasis JavaFX                                               |
| `src/main/java/resources/fxml`        | Folder konfigurasi file FXML disimpan.                                                         |
| `src/main/java/resources/css`         | Eksperimen dengan *styling* JavaFX menggunakan **CSS** dan **Pseudo-classes**.                 |


## Persyaratan dan Cara Menjalankan

### Persyaratan

Pastikan kamu memiliki:

* **Java Development Kit (JDK)**: Versi **17** atau yang lebih baru direkomendasikan.
* **Build Tool**: Proyek ini menggunakan **Maven** (atau Gradle, sesuaikan).

> [!NOTE]
> Proyek ini menggunakan Maven, dengan compiler option versi 20, dan DJK versi 20. Lihat konfigurasi `pom.xml` di [pom file](pom.xml).

### Menjalankan Contoh

Karena repo ini adalah koleksi *main class* yang berbeda:

1.  **Clone** repo ini ke mesin lokalmu.
2.  Buka proyek di **IDE** favoritmu (IntelliJ IDEA, VS Code, atau Eclipse).
3.  Untuk menjalankan suatu contoh, navigasikan ke *package* yang diinginkan (misalnya, `app.Main`).
4.  Jalankan *class* yang berisi method `main()`.

> [!IMPORTANT]
> Jika kamu menggunakan Java versi modular, pastikan konfigurasi IDE atau *build tool* yang digunakan sudah menyertakan **JavaFX SDK** sebagai modul *runtime*.


##  Daftar Dokumentasi & Sumber Daya Utama

Untuk bisa menggunakan JavaFX dan Maven, gunakan dokumentasi dan panduan yang tersedia di repository ini. Berikut setup dan konfigurasi awal JavaFX yang bisa diikuti:

- [JavaSwing VS JavaFX](doc/javaswing-vs-javafx.md) - Perbedaan antara JavaSwing dan JavaFX, dan kenapa JavaFX dipilih disini.
- [Konfigurasi awal](doc/konfigurasi-awal.md) - Konfigurasi awal JavaFX untuk pengguna Maven.
- [Scene Builder](doc/scene-builder.md) - Pemasangan dan integrasi Scene Builder dengan Intellij IDEA.
- [Menjalankan Program JavaFX dengan Maven] - _Coming Soon_
- [Mengkonversi ke Format JAR](doc/mengkonversi-java-ke-jar.md) - Melakukan konversi dari Java file ke format JAR.
- [Mengkonversi JAR ke EXE](doc/mengkonveri-jar-ke-exe.md)- Cara merubah program Java dengan format JAR menjadi EXE.

> [!CAUTION]
> Tidak ada pengembangan yang berjalan tanpa Error. Ada banyak error ketika berurusan dengan JavaFX dan Maven. Kunjungi Error-log untuk melihat dokumentasi Error yang terjadi.

Untuk dokumentasi resmi dan materi pembelajaran yang lebih mendalam, silakan kunjungi:

- [JavaFX Official Documentation](https://openjfx.io/) - Tautan ke dokumentasi resmi JavaFX
- [OpenJFX GitHub](https://github.com/openjdk/jfx) - Tautan ke repo github OpenJFX

### Layout Manager JavaFX
Bagian ini menyajikan **panduan terperinci** dan **terstruktur** mengenai setiap *Layout Pane* (Kontainer) utama dalam JavaFX. Dokumentasi ini berfokus pada **mekanisme tata letak unik** dari masing-masing kontainer, membantu Anda memilih alat yang tepat untuk kebutuhan desain antarmuka pengguna (UI) Anda.

Setiap entri kontainer dirancang dengan format yang konsisten (`Konsep Dasar`, `Mekanisme Tata Letak`, dan `Kasus Penggunaan Populer`) untuk memudahkan perbandingan dan referensi cepat.

<details>
<summary><b>Klik di sini untuk melihat Daftar Lengkap 19 Kontainer JavaFX</b></summary>

### Daftar Kontainer Utama JavaFX

Gunakan tabel di bawah ini untuk mengakses dokumentasi lengkap setiap Layout Pane:

| Kontainer                                            | Deskripsi Singkat Fungsi                                                                                                   | Fokus Utama                                                         |
|:-----------------------------------------------------|:---------------------------------------------------------------------------------------------------------------------------|:--------------------------------------------------------------------|
| [Accordion](layout-pane/accordion.md)                | Mengelola sekumpulan `TitledPane` yang dapat dikembangkan, hanya satu yang dapat terbuka pada satu waktu.                  | Hemat Ruang & Struktur Hierarkis (FAQ, Menu Pengaturan)             |
| [AnchorPane](layout-pane/anchorpane.md)              | Memposisikan Node dengan "menambatkannya" (menguncinya) relatif terhadap tepi kontainer.                                   | Tata Letak Absolut Fleksibel & Peregangan Konten Penuh              |
| [BorderPane](layout-pane/borderpane.md)              | Mengatur konten dalam lima wilayah tetap: Top, Bottom, Left, Right, dan Center.                                            | Struktur Jendela Aplikasi Standar & Tata Letak Utama (Root)         |
| [ButtonBar](layout-pane/buttonbar.md)                | Mengatur tombol aksi secara konsisten sesuai dengan standar pedoman desain platform OS.                                    | Tombol Aksi Dialog & Konsistensi Platform                           |
| [DialogPane](layout-pane/dialogpane.md)              | Kontainer khusus yang menyediakan struktur baku untuk dialog (Header, Content, ButtonBar).                                 | Konstruksi Dialog Standar yang Cepat                                |
| [FlowPane](layout-pane/flowpane.md)                  | Mengatur elemen dalam satu baris/kolom dan **membungkus** ke baris/kolom berikutnya jika ruang habis.                      | Tata Letak yang Adaptif & Toolbar Responsif                         |
| [GridPane](layout-pane/gridpane.md)                  | Tata letak berbasis matriks baris dan kolom.                                                                               | Formulir Kompleks & Penjajaran Presisi                              |
| [HBox](layout-pane/hbox.md)                          | Mengatur Node anak dalam satu baris **Horizontal** lurus.                                                                  | Toolbar & Susunan Tombol Berdampingan                               |
| [Pane](layout-pane/pane.md)                          | Kontainer dasar yang tidak memiliki aturan tata letak; posisi Node ditentukan oleh koordinat `layoutX` dan `layoutY`.      | Kanvas Gambar & Tata Letak Manual/Absolut                           |
| [ScrollPane](layout-pane/scrollpane.md)              | Menyediakan bilah gulir untuk konten tunggal yang ukurannya lebih besar dari kotak pandang (*viewport*).                   | Manajemen Konten Berlebihan (Formulir Panjang, Teks Besar)          |
| [SplitPane](layout-pane/splitpane.md)                | Membagi ruang menjadi dua atau lebih area dengan pembagi yang dapat diseret (*draggable divider*).                         | Tata Letak Master-Detail & Panel yang Dapat Disesuaikan             |
| [StackPane](layout-pane/stackpane.md)                | Menumpuk semua Node anak satu di atas yang lain di lokasi **pusat**.                                                       | Overlay (Lapisan Pemuatan) & Pergantian Tampilan (Screen Switching) |
| [Tab](layout-pane/tab.md)                            | Merupakan item anak tunggal yang menampung Node konten di dalam kontainer `TabPane` dan memiliki judul yang dapat diklik.  | Manajemen Halaman Konten Individual & Navigasi Antar Tampilan       |
| [TabPane](layout-pane/tabpane.md)                    | Kontrol yang menampung banyak konten, diakses melalui **tab** (tabulasi) yang berbeda.                                     | Mengelompokkan Informasi & Efisiensi Ruang                          |
| [TextFlow](layout-pane/textflow.md)                  | Mengatur urutan Node teks dan non-teks agar mengalir dan membungkus seperti paragraf.                                      | Teks dengan Gaya Campuran & Elemen Tertanam Sebaris                 |
| [TilePane](layout-pane/tilepane.md)                  | Mengatur Node anak dalam ubin yang memiliki **ukuran seragam**.                                                            | Galeri Thumbnail & Menu Ikon yang Rapi                              |
| [TitledPane](layout-pane/titledpane.md)              | Kontrol kontainer yang dapat **menyembunyikan** atau **menampilkan** konten di bawah judul interaktif.                     | Mengelola Kepadatan Informasi Vertikal & Pengaturan Opsional        |
| [ToolBar](layout-pane/toolbar.md)                    | Kontainer yang dirancang untuk menampung sekumpulan komponen yang dapat diakses dengan cepat, dipisahkan oleh `Separator`. | Aksi Cepat & Navigasi Utama Aplikasi                                |
| [VBox](layout-pane/vbox.md)                          | Mengatur Node anak dalam satu kolom **Vertikal** lurus.                                                                    | Sidebar Navigasi & Tumpukan Elemen Formulir                         |

</details>

## Kontribusi

Repo ini bersifat **pribadi** untuk eksplorasi. Namun, jika kamu menemukan *bug* di salah satu contoh kode atau memiliki saran perbaikan, silakan buat *issue*!