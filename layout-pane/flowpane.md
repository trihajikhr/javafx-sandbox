# 🌊 FlowPane di JavaFX

<div style="display: flex; gap: 10px;" align="center">
  <img src="media/flowpane-demo.gif" style="height: 500px;">
</div>

<br/>

**`FlowPane`** adalah kontainer tata letak yang mengatur elemen anak-anaknya berdasarkan **alur** (flow) dan sangat berguna untuk menciptakan antarmuka yang **adaptif** karena ia memiliki kemampuan untuk **membungkus** (wrap) elemen ke baris atau kolom berikutnya ketika ruang kontainer menyusut.

## 1. Konsep Dasar

* **Aliran Kontinu**: Node ditempatkan satu demi satu sesuai dengan arah aliran yang ditentukan, meniru cara kata-kata disusun dalam sebuah dokumen.
* **Fleksibilitas Tinggi**: `FlowPane` secara otomatis menyesuaikan tata letaknya tanpa perlu `Constraint` yang rumit, menjadikannya pilihan mudah untuk tata letak yang harus merespons perubahan ukuran jendela.
* **Ukuran Natural**: Elemen anak dipertahankan pada ukuran yang disukai (preferred size) mereka; `FlowPane` tidak akan memaksa mereka meregang untuk mengisi ruang.

## 2. Mekanisme Tata Letak (FlowPane)

Perilaku `FlowPane` ditentukan oleh properti **`orientation`** dan **`wrap`**:

### A. Orientasi Aliran (`Orientation`)
Properti ini menentukan arah utama aliran dan pembungkusannya:

| Orientation | Deskripsi Aliran Utama | Perilaku Pembungkusan (Wrapping) |
| :--- | :--- | :--- |
| **`HORIZONTAL` (Default)** | Elemen mengalir **kiri ke kanan**. | Ketika kehabisan lebar, elemen pindah ke **baris baru** di bawah. |
| **`VERTICAL`** | Elemen mengalir **atas ke bawah**. | Ketika kehabisan tinggi, elemen pindah ke **kolom baru** di sebelah kanan. |

### B. Pengaturan Spasi dan Penjajaran
`FlowPane` menawarkan kontrol pada spasi dan penempatan elemen:
* **`hgap` dan `vgap`**: Mengatur jarak horizontal dan vertikal antar Node, yang dipertahankan bahkan setelah pembungkusan.
* **`alignment`**: Mengontrol bagaimana **seluruh blok** konten (kumpulan baris atau kolom) ditempatkan di dalam `FlowPane` (misalnya, `CENTER`, `TOP_LEFT`).
* **`rowValignment` & `columnHalignment`**: Digunakan untuk menyelaraskan Node di dalam baris/kolom.

## 3. Kasus Penggunaan Populer

`FlowPane` sangat ideal untuk situasi di mana konten perlu **menyusun diri kembali** secara dinamis:

* **Toolbar yang Responsif**: Menyusun ulang tombol-tombol toolbar ke beberapa baris secara otomatis ketika lebar jendela menyusut.
* **Galeri Thumbnail / Gambar**: Menampilkan sekumpulan gambar kecil yang akan membungkus dengan rapi ke baris berikutnya di perangkat dengan resolusi berbeda.
* **Tag atau Label Input**: Digunakan untuk menampung *tag* atau *chip* input yang ditambahkan secara dinamis, di mana mereka harus mengisi ruang yang tersedia dan otomatis berpindah baris saat penuh.

> [!TIP]
> `FlowPane` adalah kontainer **dinamis** yang memungkinkan Node mengalir dan membungkus seperti teks, menjadikannya alat yang sempurna untuk menciptakan area antarmuka yang **responsif** dan **hemat ruang** tanpa perlu logika *resizing* yang rumit.

---

Source: [GeeksforGeeks](https://www.geeksforgeeks.org/java/javafx-flowpane-class/) | [Oracle](https://docs.oracle.com/javase/8/javafx/api/javafx/scene/layout/FlowPane.html) | [Jenkov](https://jenkov.com/tutorials/javafx/flowpane.html) | [Tutorialspoint](https://www.tutorialspoint.com/javafx/layout_flowpane.htm)