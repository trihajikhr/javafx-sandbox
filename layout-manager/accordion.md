# 📚 Accordion di JavaFX

![accordion-demo.mp4](media/accordion-demo.mp4)

**`Accordion`** adalah komponen kontrol (yang berfungsi sebagai kontainer) khusus di JavaFX yang dirancang untuk menampilkan daftar panel yang dapat dibuka dan ditutup, yang dikenal sebagai **`TitledPane`**.

## 1. Fungsi Utama

`Accordion` sangat berguna untuk menyajikan sejumlah besar informasi yang dikelompokkan atau bersifat hierarkis secara **ringkas** dan **hemat ruang**.

## 2. Komponen Kunci (`TitledPane`)

* **`TitledPane`**: Setiap item dalam `Accordion` adalah sebuah `TitledPane`. Ini adalah kontainer dengan **judul** (title) dan area konten yang dapat disembunyikan atau ditampilkan.
* **Konten**: Anda dapat menempatkan kontainer lain (seperti `VBox`, `GridPane`, atau bahkan `ListView`) di dalam setiap `TitledPane` untuk mengatur isinya.

## 3. Perilaku Unik

Perilaku utama yang mendefinisikan `Accordion` adalah:

1.  **Eksklusivitas**: **Hanya satu** `TitledPane` yang diizinkan untuk terbuka (mengembang/expanded) pada waktu tertentu.
2.  **Otomatisasi**: Ketika pengguna mengklik judul panel lain untuk membukanya, `TitledPane` yang sebelumnya terbuka akan secara otomatis **tertutup** (menciut/collapsed).

## 4. Contoh Penggunaan

* **FAQ (Frequently Asked Questions)**: Setiap pertanyaan adalah judul `TitledPane`, dan jawabannya ada di dalam konten.
* **Menu Pengaturan (Settings Menu)**: Mengelompokkan pengaturan yang berbeda (misalnya, "Akun," "Notifikasi," "Privasi") dalam panel terpisah.
* **Navigasi/Struktur Data**: Menampilkan kategori produk atau struktur folder.

---

Dengan kata lain, `Accordion` adalah manajer untuk kumpulan `TitledPane` yang memastikan hanya satu dari mereka yang menjadi fokus pada saat tertentu.