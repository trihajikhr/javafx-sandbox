# 🖼️ BorderPane di JavaFX

<div style="display: flex; gap: 10px;" align="center">
  <img src="media/borderpane-demo.gif" style="height: 300px;">
  <img src="media/borderpane-config-demo.gif" style="height: 500px;">
</div>

<br/>

**`BorderPane`** adalah kontainer yang paling sering digunakan sebagai tata letak utama (root layout) aplikasi, karena ia membagi ruang menjadi **lima wilayah fungsional** yang berbeda.

Pada video demo bagian kiri, ditampilkan bagaimana semisal kita membuat tampilan aplikasi menggunakan `BorderPane`. Sedangkan pada bagian kanan, adalah bagaimana tampilan `BorderPane` ketika sedang dibuat di Scene Builder.

## 1. Konsep Dasar

* **Pembagian Wilayah**: `BorderPane` dirancang untuk mengatur hingga lima Node anak, masing-masing ditempatkan di salah satu dari lima posisi tetap: **Atas (`Top`), Bawah (`Bottom`), Kiri (`Left`), Kanan (`Right`), dan Tengah (`Center`)**.
* **Hierarki Layout**: Posisi Tengah (`Center`) adalah yang paling penting karena ia secara otomatis akan mengambil sisa ruang yang tersedia setelah keempat wilayah lainnya diukur dan ditempatkan.
* **Pengaturan Node**: Node anak ditempatkan menggunakan *static methods*, misalnya: `BorderPane.setTop(pane, node)`.

## 2. Mekanisme Tata Letak (BorderPane)

Perilaku ukuran ulang (`resizing`) dalam `BorderPane` sangat terstruktur dan mengikuti aturan prioritas:

| Wilayah | Perilaku Horizontal                                               | Perilaku Vertikal                                                                                              |
| :--- |:------------------------------------------------------------------|:---------------------------------------------------------------------------------------------------------------|
| **Top & Bottom** | **Mengisi penuh lebar** kontainer.                                | Menggunakan **tinggi yang disukai** (`preferred height`) Node anak.                                            |
| **Left & Right** | Menggunakan **lebar yang disukai** (`preferred width`) Node anak. | Mengisi sisa ruang **di antara** wilayah Top dan Bottom.                                                       |
| **Center** | **Mengisi penuh** sisa lebar yang ada.                            | **Mengisi penuh** sisa tinggi yang ada. Node ini **meregang** untuk mengambil semua ruang kosong yang tersisa. |

* **Penyusutan Otomatis (Collapse)**: Jika Anda tidak menempatkan Node di salah satu wilayah, wilayah tersebut akan **menyusut** dan tidak menggunakan ruang, kecuali untuk wilayah `Center` yang akan meregang untuk mengisi ruang tersebut.

## 3. Kasus Penggunaan Populer

`BorderPane` adalah pilihan ideal untuk menciptakan **struktur jendela aplikasi standar**, seperti:

* **Baris Menu/Toolbar**: Ditempatkan di wilayah **`Top`**.
* **Bilah Status (Status Bar)**: Ditempatkan di wilayah **`Bottom`**.
* **Panel Navigasi/Sidebar**: Ditempatkan di wilayah **`Left`** atau **`Right`**.
* **Area Konten Utama**: Seluruh tampilan atau data utama aplikasi (misalnya, `TabPane`, `TextArea`, atau `TableView`) ditempatkan di wilayah **`Center`**.

> [!TIP]
> `BordePane` adalah fondasi yang kokoh untuk membangun antarmuka aplikasi dengan tata letak **tetap** dan **terstruktur** yang secara otomatis mengelola peregangan konten utama Anda di wilayah `Center`.

---

Source: [Oracle](https://openjfx.io/javadoc/11/javafx.graphics/javafx/scene/layout/BorderPane.html) | [GeeksforGeeks](https://www.geeksforgeeks.org/java/javafx-borderpane-class/) | [Tutorialspoint](https://www.tutorialspoint.com/javafx/layout_borderpane.htm)