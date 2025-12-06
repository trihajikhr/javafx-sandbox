# 🛠️ ToolBar di JavaFX

**`ToolBar`** adalah kontrol khusus yang berfungsi sebagai kontainer dan dirancang untuk menampung sekumpulan **komponen yang dapat diakses dengan cepat** dan **berfokus pada aksi**, seperti tombol, pemisah (*separator*), *dropdown*, dan bidang teks. Tujuan utamanya adalah menyediakan antarmuka yang terorganisir untuk fungsi yang sering digunakan.

## 1. Konsep Dasar

* **Fokus Aksi**: `ToolBar` ideal untuk menempatkan tombol-tombol yang memicu fungsi utama aplikasi (misalnya, *Save*, *Open*, *Print*).
* **Kontainer Khusus**: Meskipun pada dasarnya adalah kontainer horizontal, `ToolBar` bukan hanya `HBox` biasa; ia memiliki *styling* dan fungsionalitas tambahan yang membuatnya terlihat dan berfungsi seperti bilah alat standar OS.
* **Elemen Pemisah**: `ToolBar` sering menggunakan `Separator` untuk membagi tombol menjadi kelompok fungsional (misalnya, kelompok *File* dipisahkan dari kelompok *Edit*).

## 2. Mekanisme Tata Letak (ToolBar)

Mekanisme `ToolBar` sangat mirip dengan `HBox`, tetapi dengan beberapa fitur khusus yang terkait dengan fungsi:

### A. Aliran dan Spasi
* **Aliran Horizontal**: Secara *default*, `ToolBar` menyusun Node anak dari **kiri ke kanan** (horizontal).
* **Orientasi**: Anda dapat mengubah `ToolBar` menjadi vertikal menggunakan properti **`orientation`** (`Orientation.VERTICAL`) untuk membuat bilah alat samping.

### B. Pengaturan Ukuran dan Perataan
* **Pereganggan**: `ToolBar` akan secara otomatis menerapkan logika peregangan horizontal yang sesuai, sering kali menggunakan objek **`Region`** atau `Separator` dengan `Hgrow` yang disetel ke `ALWAYS` untuk memaksa elemen terluar berpisah atau untuk mengisi ruang kosong yang tersisa.
* **Penyelarasan**: Semua Node anak diselaraskan secara vertikal di **tengah** `ToolBar` untuk memberikan tampilan yang bersih dan rapi.

### C. Elemen Kunci (`Separator`)
* **Visual Grouping**: Penggunaan objek `Separator` adalah ciri khas `ToolBar`. `Separator` (vertikal dalam orientasi horizontal) berfungsi sebagai pembatas visual yang jelas, membantu pengguna mengidentifikasi kelompok aksi terkait.

## 3. Kasus Penggunaan Populer

`ToolBar` adalah komponen utama dalam sebagian besar antarmuka aplikasi:

* **Bilah Alat Utama**: Ditempatkan di wilayah `Top` dari `BorderPane` untuk menampung fungsi utama yang berlaku untuk seluruh aplikasi.
* **Bilah Alat Editor**: Dalam editor teks atau kode, `ToolBar` menampung tombol-tombol format (misalnya, **B** *old*, *I talic*, *Underline*).
* **Sidebar Vertikal**: Menggunakan `orientation="VERTICAL"` di wilayah `Left` atau `Right` dari `BorderPane` untuk menampung alat dan ikon.

> [!TIP]
> **`ToolBar`** adalah kontrol kontainer yang dirancang secara fungsional untuk **mengatur aksi dan alat yang sering digunakan** secara horizontal atau vertikal dengan tampilan yang terorganisir, menggunakan `Separator` untuk pengelompokan yang jelas.

---

Source: