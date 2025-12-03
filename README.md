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

## Kontribusi


Repo ini bersifat **pribadi** untuk eksplorasi. Namun, jika kamu menemukan *bug* di salah satu contoh kode atau memiliki saran perbaikan, silakan buat *issue*!
