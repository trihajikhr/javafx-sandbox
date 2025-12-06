# 📑 TabPane di JavaFX

**`TabPane`** adalah kontrol yang berfungsi sebagai kontainer tingkat tinggi (bukan *layout pane* murni) yang dirancang untuk menampung banyak area konten di lokasi yang sama, namun hanya **satu** yang dapat dilihat pada satu waktu. Setiap area konten ini diakses melalui **Tab** (tabulasi) yang sesuai.

## 1. Konsep Dasar

* **Item Tab**: Anak-anak dari `TabPane` bukanlah Node tata letak biasa, melainkan objek **`Tab`**. Setiap objek `Tab` adalah wadah untuk **satu Node konten** yang bisa berupa kontainer lain (`VBox`, `GridPane`, dll.).
* **Akses Konten Eksklusif**: Hanya **satu** tab yang dapat **aktif** (*selected*) pada satu waktu, dan hanya konten dari tab yang aktif itulah yang ditampilkan.
* **Tujuan**: Memecah informasi yang luas menjadi bagian-bagian yang mudah dikelola, menghemat ruang layar dan mengurangi kekacauan visual.

## 2. Mekanisme Tata Letak (TabPane)

Perilaku utama `TabPane` adalah mengelola tampilan, penempatan, dan penyajian kontennya:

### A. Penempatan Tab (*Tab Placement*)
Anda dapat mengontrol di mana barisan tab diletakkan relatif terhadap konten menggunakan properti **`side`**:

* **`Side.TOP` (Default)**: Tab berada di atas konten (paling umum).
* **`Side.BOTTOM`**: Tab berada di bawah konten.
* **`Side.LEFT` / `Side.RIGHT`**: Tab berada di sisi vertikal, berguna untuk tampilan navigasi seperti *sidebar*.

### B. Perilaku Ukuran Ulang
* **Konten Meregang**: Node konten di dalam `Tab` akan **meregang penuh** untuk mengisi seluruh area konten `TabPane`.
* **Konten Inaktif**: Konten dari tab yang tidak aktif tidak dirender dan tidak memengaruhi perhitungan tata letak, menjadikannya efisien.

### C. Fitur Interaktif
* **Tab yang Dapat Ditutup**: Properti `closable` pada objek `Tab` memungkinkan pengguna untuk menutup tab secara dinamis saat *runtime* (misalnya pada antarmuka *browser*).
* **Pengguliran Otomatis**: Jika jumlah tab melebihi lebar yang tersedia, `TabPane` secara otomatis menyediakan tombol gulir untuk menavigasi barisan tab.

## 3. Kasus Penggunaan Populer

`TabPane` adalah kontrol navigasi yang esensial untuk mengelola informasi berlapis dalam aplikasi GUI:

* **Pengaturan Aplikasi (Settings)**: Memisahkan berbagai kategori pengaturan (misalnya, "Akun," "Notifikasi," "Jaringan") ke dalam tab yang berbeda.
* **Editor Kode atau Browser Web**: Setiap *file* atau halaman web ditampilkan dalam tab terpisah.
* **Tampilan Detail Multi-Aspek**: Menampilkan beberapa jenis data atau tampilan yang berbeda tentang satu objek yang dipilih (misalnya, detail pelanggan memiliki tab "Informasi Dasar," "Riwayat Pesanan," dan "Catatan").


> [!TIP]
> **`TabPane`** adalah kontrol **manajemen konten** yang sangat baik untuk menyusun informasi terfragmentasi ke dalam halaman-halaman yang efisien dan mudah diakses, memberikan solusi yang rapi untuk **menghemat ruang layar**.

---

Source: 