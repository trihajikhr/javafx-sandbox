# 📄 StackPane di JavaFX

**`StackPane`** adalah kontainer tata letak yang dirancang untuk mengatur semua Node anak-anaknya **satu di atas yang lain**, menumpuknya (stacking) di lokasi yang sama secara **pusat (tengah)**. Kontainer ini sangat berguna untuk menampilkan satu Node pada satu waktu atau untuk melapisi elemen (seperti teks di atas gambar).

## 1. Konsep Dasar

* **Penumpukan (Stacking)**: Semua Node anak menempati area *StackPane* yang sama persis.
* **Prioritas Z-Order**: Node yang ditambahkan **terakhir** ke dalam `StackPane` akan secara visual berada di **lapisan paling atas** (memiliki *Z-order* tertinggi) dan akan menutupi Node yang ditambahkan lebih awal.
* **Perataan Pusat (Centering)**: Secara *default*, `StackPane` akan mengatur semua Node anak di **tengah horizontal dan vertikal**.

## 2. Mekanisme Tata Letak (StackPane)

Mekanisme `StackPane` relatif sederhana karena hanya ada sedikit aturan penempatan, tetapi penting untuk memahami bagaimana ukuran dan perataan dikontrol:

### A. Pengaturan Ukuran (*Resizing*)
* **Ukuran Kontainer**: `StackPane` akan mencoba memiliki ukuran yang cukup besar untuk mengakomodasi Node anak **terbesar** (*preferred size* terbesar) di tumpukan tersebut.
* **Peregangan Anak**: Node anak yang dapat meregang (seperti `Region` atau `Pane` lainnya) akan **meregang penuh** untuk mengisi seluruh ruang `StackPane`. Node yang tidak dapat meregang (seperti `Button` atau `Label`) akan mempertahankan ukuran disukai mereka.

### B. Perataan Khusus (*Custom Alignment*)
Meskipun *default*-nya adalah pusat, Anda dapat mengatur perataan Node individual di dalam tumpukan menggunakan properti *static*:

* **`StackPane.setAlignment(node, Pos)`**: Memungkinkan Anda memposisikan Node tertentu (misalnya, tombol) ke sudut tertentu dari `StackPane` meskipun Node lain tetap di tengah.
    * Contoh: Menempatkan tombol "Tutup" di sudut kanan atas: `StackPane.setAlignment(closeButton, Pos.TOP_RIGHT)`.

### C. Penggunaan Tumpukan
* `StackPane` sering digunakan untuk **menampilkan elemen yang bergantian**; misalnya, hanya satu Node yang diatur terlihat (`setVisible(true)`) pada satu waktu, sementara Node lainnya disembunyikan.

## 3. Kasus Penggunaan Populer

`StackPane` adalah kontainer yang kuat dan serbaguna, sering digunakan untuk efek visual atau manajemen konten yang bergantian:

* **Tampilan Pemuatan (*Loading Overlay*)**: Menempatkan `ProgressIndicator` di atas konten utama aplikasi. Konten utama adalah Node pertama, dan indikator pemuatan adalah Node kedua (di atas).
* **Galeri Gambar Sederhana**: Menampilkan sebuah gambar (Node 1) dengan keterangan atau tombol navigasi (Node 2, diatur ke `BOTTOM_CENTER`) yang ditumpuk di atasnya.
* **Manajemen Layar (*Screen Switching*)**: Seluruh layar atau tampilan (misalnya, Tampilan Login, Tampilan Dashboard) ditempatkan di dalam `StackPane`, tetapi hanya satu yang ditampilkan pada satu waktu.

> [!TIP]
> **`StackPane`** adalah kontainer yang berfokus pada **penumpukan elemen di tengah**. Kontainer ini sangat ideal untuk skenario di mana Anda perlu melapisi atau menampilkan konten yang bergantian di lokasi yang sama.

---

Source: 