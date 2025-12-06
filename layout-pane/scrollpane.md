# 📜 ScrollPane di JavaFX

<div style="display: flex; gap: 10px;" align="center">
  <img src="media/scrollpane-demo.gif" style="height: 500px;">
</div>

<br/>

**`ScrollPane`** bukanlah kontainer tata letak (*layout pane*) dalam arti mengatur posisi anak-anaknya seperti `HBox` atau `GridPane`. Sebaliknya, ia adalah **kontrol** khusus yang berfungsi sebagai **kotak pandang** (*viewport*) yang dapat **menggulir** (*scroll*) sepotong konten tunggal yang ukurannya melebihi dimensi yang tersedia pada `ScrollPane` itu sendiri.


## 1. Konsep Dasar

* **Konten Tunggal**: `ScrollPane` hanya boleh menampung **satu** Node anak (`content`). Node tunggal ini bisa berupa *layout pane* yang kompleks (misalnya, `VBox` besar atau `GridPane` yang lebar).
* **Viewport (Kotak Pandang)**: `ScrollPane` adalah jendela yang lebih kecil ke konten yang lebih besar. Hanya bagian konten yang berada di dalam *viewport* yang terlihat oleh pengguna.
* **Bar Gulir (Scroll Bars)**: Ketika ukuran konten anak lebih besar dari ukuran `ScrollPane`, bilah gulir horizontal dan/atau vertikal akan muncul secara otomatis, memungkinkan pengguna untuk menavigasi seluruh konten.

## 2. Mekanisme Perilaku (ScrollPane)

Perilaku `ScrollPane` berpusat pada hubungan antara ukuran kontainer dan ukuran kontennya:

### A. Perilaku Bilah Gulir
* **Otomatis (`AS_NEEDED`)**: Ini adalah perilaku *default*. Bilah gulir hanya muncul ketika dimensi konten melebihi dimensi *viewport* `ScrollPane`.
* **Selalu Tampil (`ALWAYS`)**: Bilah gulir horizontal atau vertikal akan selalu terlihat, meskipun konten tidak melebihi batas.
* **Tidak Pernah Tampil (`NEVER`)**: Bilah gulir tidak akan pernah muncul, bahkan jika kontennya terpotong.

### B. Fitur Fitur
`ScrollPane` memiliki beberapa properti penting untuk mengontrol *viewport*:

| Properti | Deskripsi | Fungsi |
| :--- | :--- | :--- |
| **`fitToWidth`** | Boolean. Jika `true`, lebar Node konten akan dipaksa **meregang** agar sesuai dengan lebar `ScrollPane`. | Berguna untuk `TextArea` atau `VBox` agar tidak perlu menggulir horizontal. |
| **`fitToHeight`** | Boolean. Jika `true`, tinggi Node konten akan dipaksa **meregang** agar sesuai dengan tinggi `ScrollPane`. | Jarang digunakan, tetapi berguna jika Anda ingin konten selalu mengisi tinggi `ScrollPane`. |
| **`pannable`** | Boolean. Jika `true`, konten dapat "digeser" (*panned*) dengan menyeret mouse, tidak hanya dengan bilah gulir. | Berguna untuk melihat gambar besar atau peta. |

### C. Pengaturan Konten
Konten anak (`content`) harus merupakan Node tunggal. Biasanya, `ScrollPane` akan membungkus `VBox`, `GridPane`, atau `AnchorPane` yang menampung tata letak aplikasi yang kompleks.

## 3. Kasus Penggunaan Populer

`ScrollPane` adalah kontainer yang sangat diperlukan dalam hampir setiap aplikasi GUI modern:

* **Area Teks Besar**: Menampung `TextArea` atau `Text` yang berisi sejumlah besar teks.
* **Formulir yang Panjang**: Mengelilingi `VBox` atau `GridPane` yang menampung banyak bidang input sehingga formulir dapat digulir jika panjangnya melebihi jendela aplikasi.
* **Tampilan Gambar Besar**: Digunakan untuk menampilkan gambar beresolusi tinggi di mana pengguna harus menggulir untuk melihat semua bagiannya.
* **List View atau Tree View**: Meskipun `ListView` dan `TreeView` sudah memiliki bilah gulir internal, `ScrollPane` terkadang digunakan sebagai pembungkus untuk mengontrol keseluruhan.

> [!TIP]
> **`ScrollPane`** adalah kontrol fungsional yang tugasnya adalah **menyediakan jendela gulir** untuk satu Node konten. Kontainer ini memungkinkan Anda menyajikan konten yang sangat besar di area aplikasi yang terbatas dengan mekanisme *scrolling* yang otomatis dan fleksibel.

---

Source: [Jenkov](https://jenkov.com/tutorials/javafx/scrollpane.html) | [Tutorialspoint](https://www.tutorialspoint.com/javafx/javafx_scrollpane.htm) | [Oracle](https://openjfx.io/javadoc/13/javafx.controls/javafx/scene/control/ScrollPane.html)