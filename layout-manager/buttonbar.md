# 🎛️ ButtonBar di JavaFX

<div style="display: flex; gap: 10px;" align="center">
  <img src="media/buttonbar-demo.gif" style="height: 300px;">
</div>

<br/>

**`ButtonBar`** adalah kontainer tata letak khusus yang dirancang semata-mata untuk menampung dan mengatur **tombol-tombol (`Button`)** secara konsisten sesuai dengan standar pedoman desain platform (seperti Windows, macOS, atau Linux), terutama untuk tombol yang berada di bagian bawah dialog atau form.

## 1. Konsep Dasar

* **Fokus Tombol**: `ButtonBar` hanya boleh menampung Node yang merupakan tombol (`Button`). Ia akan mengabaikan Node lain (walaupun secara teknis bisa ditambahkan) dan berfokus pada penataan tombol.
* **Standar Platform**: Tujuan utamanya adalah memastikan tombol, seperti "OK", "Batal", "Simpan", atau "Terapkan", selalu ditempatkan dan diberi urutan yang benar sesuai kebiasaan sistem operasi yang digunakan.
* **Enumerasi `ButtonData`**: Pengembang mengaitkan setiap tombol dengan kategori (`ButtonData`) untuk memberi tahu `ButtonBar` mengenai peran tombol tersebut (misalnya, `ButtonData.OK_DONE`, `ButtonData.CANCEL_CLOSE`, `ButtonData.HELP`).

## 2. Mekanisme Tata Letak (ButtonBar)

`ButtonBar` menggunakan properti `buttonOrder` untuk menentukan bagaimana tombol disusun, berdasarkan kategori `ButtonData` yang ditetapkan:

* **Urutan Tombol (Ordering)**: Secara *default*, `ButtonBar` mengatur urutan tombol berdasarkan platform:
    * **Windows/Linux**: Tombol positif (misalnya, "OK") biasanya diletakkan di sisi **kiri**, diikuti tombol negatif (misalnya, "Batal").
    * **macOS**: Urutan sering kali dibalik, dengan tombol positif diletakkan di sisi **kanan**.
* **Perataan (Alignment)**: Secara *default*, `ButtonBar` biasanya akan menyelaraskan tombol ke **kanan bawah** atau **tengah** dari kontainer, tergantung pada standar platform.
* **Pereganggan (Stretching)**: Tombol-tombol yang ditetapkan sebagai kategori `ButtonData.BIG_GAP` atau `ButtonData.SMALL_GAP` dapat digunakan untuk memasukkan celah peregang atau pemisah di antara kelompok tombol.

## 3. Kasus Penggunaan Populer

`ButtonBar` sangat ideal digunakan dalam situasi di mana **konsistensi platform** untuk tombol aksi diperlukan:

* **Jendela Dialog (Dialog Window)**: Menempatkan tombol "Ya," "Tidak," "Batal" di bagian bawah dialog peringatan atau konfirmasi.
* **Panel Pengaturan (Settings Panel)**: Mengorganisir tombol aksi seperti "Terapkan" dan "Reset" di bagian footer.
* **Form Dasar**: Memberikan tempat standar yang konsisten untuk tombol pengiriman dan pembatalan form.

> [!TIP]
> `ButtonBar` adalah kontainer yang **praktis** untuk mengelola tata letak tombol aksi agar sesuai dengan **pedoman desain OS**, menghilangkan kebutuhan untuk mengatur urutan dan perataan secara manual menggunakan `HBox` atau `GridPane`.

---
Source: [Tutorialspoint](https://www.tutorialspoint.com/javafx/javafx_buttonbar.htm) | [Oracle](https://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/ButtonBar.html)