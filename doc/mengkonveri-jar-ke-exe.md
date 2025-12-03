# Konversi JAR ke EXE

Aplikasi Java umumnya dikemas dalam format JAR, namun pada beberapa kasus diperlukan distribusi dalam bentuk EXE agar lebih mudah digunakan oleh pengguna Windows. Proses konversi ini tidak hanya memindahkan format, tetapi juga memastikan seluruh dependensi—termasuk runtime Java—dapat berjalan secara mandiri. Dokumen ini menyajikan penjelasan mengenai metode dan alat yang dapat digunakan untuk mengubah JAR menjadi EXE dengan konfigurasi yang sesuai.

## Mengapa Perlu Mengonversi JAR Menjadi EXE?

Meskipun aplikasi Java secara teknis dapat dijalankan melalui berkas JAR, distribusi aplikasi dalam format tersebut sering kali kurang praktis untuk pengguna akhir. Format JAR tetap membutuhkan Java Runtime Environment (JRE) yang terpasang, konfigurasi path yang sesuai, serta perintah terminal untuk menjalankannya. Bagi sebagian besar pengguna, langkah-langkah tambahan ini dianggap tidak ramah dan dapat menimbulkan kesalahan, terutama ketika versi JRE tidak kompatibel.

Dengan mengonversi JAR menjadi berkas EXE, aplikasi dapat dijalankan secara langsung seperti program native pada Windows. Proses ini memungkinkan penyertaan runtime bawaan, memastikan kompatibilitas lingkungan, serta memberikan pengalaman penggunaan yang lebih sederhana. Selain itu, format EXE juga memudahkan distribusi, integrasi dengan installer, pembuatan ikon aplikasi, serta pengaturan metadata yang lebih rapi. Oleh karena itu, konversi JAR ke EXE menjadi langkah penting untuk menghasilkan aplikasi Java yang lebih mudah dijalankan dan lebih siap untuk didistribusikan kepada pengguna umum.

## Mengenal JPackage dan Tools sejenis 

Untuk bisa mengkonversi format JAR menjadi EXE, dibutuhkan alat atau tools tertentu, berikut adalah beberapa alat yang bisa digunaan:

- [Launch4j](https://launch4j.sourceforge.net/) – Membungkus JAR menjadi EXE dengan kemampuan konfigurasi ikon dan parameter JVM.
- [JSmooth](https://jsmooth.sourceforge.net/) – Membuat executable Windows dari JAR, termasuk pengaturan wrapper.
- [Inno Setup](https://jrsoftware.org/isinfo.php) – Digunakan untuk membuat installer dari file JAR, bukan langsung EXE.
- JPackage – Alat bawaan JDK untuk membuat aplikasi mandiri dengan bundling runtime.

Dari berbagai opsi tersebut, **JPackage** dipilih sebagai tools utama yang digunakan di lingkungan repository ini 😀. Tentuk karena beberapa alasan:

1. **Bawaan JDK** – Tidak perlu mengunduh atau menginstal software tambahan.
2. **Mendukung Modul dan Runtime Java** – Dapat membuat *custom runtime image* sehingga EXE dapat dijalankan tanpa memerlukan instalasi Java terpisah.
3. **Cross-Platform** – Mendukung pembuatan aplikasi mandiri untuk Windows, macOS, dan Linux.
4. **Integrasi yang Mudah dengan Build Modern** – Dapat digunakan langsung setelah build Maven atau Gradle tanpa proses tambahan yang kompleks.

Karena JPackage sudah otomatis ada sebagai alat bawan JDK, maka tools ini bisa langsung digunakan jika sebelumnya sudah memiliki JDK.

Karena sudah otomatis ada, maka kita bisa periksa versi JPackage dengan menggunakan command berikut di terminal:

```bash
jpackage --version
```

Maka akan muncul output sebagai berikut:

```bash
PS C:\Users\ASUS> jpackage --version
25.0.1
```
> [!CAUTION]
> Jika perintah `jpackage --version` tidak menghasilkan output yang sesuai, semisal `'jpackage' is not recognized`, kemungkinan ada dua masalah:
> - DJK belum terpasang
> - JDK terpasang tapi `PATH` belum dikonfigurasi di Environtment Variables.
> 
> Jika masalah ini muncul, pastikan JDK sudah terpasang, dan tambahakan `PATH` yang mengarah ke JDK yang terpasang!

Dengan mempertimbangkan faktor-faktor tersebut, JPackage menjadi alat yang paling efisien dan praktis untuk mengonversi file JAR menjadi EXE, terutama untuk aplikasi yang menggunakan modul-modul Java modern seperti JavaFX.

## Memasang Wix Toolset