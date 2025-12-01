# Java Swing VS JavaFX

**Java Swing** adalah toolkit antarmuka pengguna grafis (GUI) yang telah lama menjadi bagian dari Java Foundation Classes (JFC). Swing memungkinkan pengembang untuk membuat aplikasi desktop dengan elemen-elemen GUI seperti tombol, kotak teks, dan tabel. Swing **platform-independent**, artinya aplikasi yang dibuat dapat berjalan di berbagai sistem operasi.

Namun, komponen-komponen Swing (dikenal sebagai "lightweight" components) **tidak menggunakan komponen native** dari sistem operasi, melainkan digambar oleh Java sendiri. Hal ini seringkali menghasilkan tampilan yang **kurang modern** dan **kurang konsisten** dengan tampilan dan nuansa sistem operasi aslinya. Selain itu, pengembangan antarmuka pengguna yang kompleks di Swing bisa menjadi rumit dan memakan waktu, terutama dalam hal tata letak dan penyesuaian visual.

Berbeda dengan Java Swing, **JavaFX** adalah toolkit GUI yang lebih modern, dirancang sebagai **pengganti Swing**. JavaFX menawarkan kemampuan untuk membuat aplikasi desktop, seluler, dan web (melalui teknologi lain) dengan antarmuka yang lebih **kaya, dinamis, dan menarik secara visual**. Salah satu keunggulan utamanya adalah penggunaan **Scene Builder** (alat visual) dan bahasa deskriptif seperti **FXML** untuk memisahkan desain antarmuka dari logika bisnis (mirip pola Model-View-Controller).

JavaFX juga memanfaatkan **akselerasi grafis perangkat keras**, menghasilkan kinerja rendering yang lebih baik dan memungkinkan efek visual yang lebih canggih. **Perpindahan** ke JavaFX direkomendasikan karena memberikan **tampilan dan nuansa yang modern** (bisa menyerupai aplikasi native), dukungan untuk **CSS** untuk kustomisasi tema, dan **paradigma pengembangan yang lebih bersih** yang sangat cocok untuk aplikasi masa kini yang menuntut desain interaktif dan responsif.

## ✨ Kelebihan JavaFX Dibandingkan Java Swing

| Fitur | JavaFX | Java Swing |
| :--- | :--- | :--- |
| **Tampilan & Desain Visual** | **Modern dan Elegan.** Mendukung akselerasi grafis perangkat keras (GPU), menghasilkan rendering UI yang cepat, halus, dan visual yang kaya. | **Kuno (Legacy).** Bergantung pada rendering Java (Lightweight), sering terlihat usang dan kurang konsisten dengan tampilan OS native. |
| **Kustomisasi Tema** | **Dukungan Penuh CSS.** Memungkinkan penataan gaya (styling) menggunakan Cascading Style Sheets (CSS), memisahkan desain dari kode, dan mempermudah penerapan tema kustom. | Kustomisasi rumit, seringkali memerlukan modifikasi pada *Look-and-Feel* bawaan atau penggunaan kelas kustom yang kompleks. |
| **Arsitektur UI** | Menggunakan **FXML** (bahasa berbasis XML) untuk mendefinisikan struktur UI, yang mendorong pemisahan **View (FXML) dari Controller (Java)**, sangat mendukung pola MVC. | UI biasanya didefinisikan secara programatik (dalam kode Java), yang membuat kode menjadi lebih padat dan sulit dipertahankan. |
| **Manajemen Data** | **Data Binding Bawaan.** Memungkinkan penghubungan properti UI ke model data secara otomatis (reaktif), mengurangi kode *boilerplate* dan *bug* sinkronisasi data. | Membutuhkan kode *listener* manual untuk setiap sinkronisasi data, yang memakan waktu dan rentan terhadap kesalahan. |
| **Alat Desain** | Didukung oleh **Scene Builder**, alat desain visual *drag-and-drop* yang kuat untuk membuat UI FXML tanpa perlu menulis kode. | Dukungan alat desain visual pihak ketiga tidak sekuat atau sepopuler Scene Builder. |
| **Dukungan Multimedia** | **Integrasi Media dan Web yang Kuat.** Memiliki komponen bawaan untuk pemutar media dan komponen `WebView` (berbasis WebKit) untuk integrasi konten web. | Membutuhkan pustaka tambahan dan integrasi yang lebih sulit untuk fungsi multimedia dan web. |
| **Aplikasi Target** | Dirancang untuk mendukung aplikasi Desktop, Embedded, dan berpotensi Mobile. | Fokus utama hanya pada aplikasi Desktop. |

**Kesimpulan:** JavaFX menawarkan **paradigma pengembangan yang lebih bersih, tampilan yang jauh lebih profesional, dan kinerja yang lebih baik** berkat akselerasi grafis, menjadikannya pilihan modern dan masa depan untuk aplikasi desktop Java.

## ✂️ Pemisahan JavaFX dari Java SDK

Sebelumnya, JavaFX (seperti halnya Swing) dibundel secara otomatis di dalam Java Development Kit (**JDK**).

* **Sebelum Java 11:** JavaFX sudah termasuk dalam JDK (versi 8, misalnya). Anda hanya perlu menginstal JDK, dan JavaFX siap digunakan.
* **Mulai Java 11 dan Seterusnya:** Oracle memutuskan untuk **memisahkan** JavaFX dari JDK standar. Keputusan ini dibuat untuk mengurangi ukuran JDK dan memberikan fleksibilitas pada modul inti Java.
    * JavaFX kini dikembangkan dan dikelola sebagai proyek sumber terbuka yang disebut **OpenJFX** oleh komunitas, di bawah naungan **Gluon**.
    * Ini berarti jika Anda menggunakan JDK modern (11 atau lebih tinggi), JavaFX **tidak tersedia secara *default***. Anda harus **menambahkan** JavaFX sebagai **modul terpisah (dependency)** ke proyek Anda.
    * Pemisahan ini mendorong penggunaan **build tool** seperti Maven atau Gradle untuk mengelola dan memasukkan modul JavaFX ke dalam proyek.


## ⚔️ Mitos vs. Fakta: Penggunaan *Drag-and-Drop* Visual Builder dalam Pengembangan GUI Java

Ada rumor yang beredar di kalangan pengembang Java bahwa menggunakan fitur *drag-and-drop* dari alat **Visual GUI Builder** adalah praktik yang buruk dan tidak profesional. Rumor ini mengatakan bahwa *builder* menghasilkan kode yang kotor, sulit diatur (*unmaintainable*), tata letak yang tidak konsisten, dan membatasi kontrol programmer.


### ⛔ Kebenaran Rumor (Kasus Java Swing Lama)

Rumor tersebut **memang benar** dan berlaku untuk alat *Visual Builder* yang digunakan pada **Java Swing** lama. Alat-alat ini seringkali menghasilkan output yang bermasalah:

1.  **Kode Java yang Buruk:** *Builder* Swing cenderung menghasilkan **kode Java** secara otomatis yang menggunakan **Absolute Positioning** (koordinat piksel $x$ dan $y$). Kode jenis ini sangat kaku dan rentan hancur ketika ukuran jendela (aplikasi) diubah atau ketika aplikasi dijalankan di sistem operasi yang berbeda, karena tidak memanfaatkan **Layout Manager** Swing secara efektif.
2.  **Mengganggu Kontrol:** Kode *layout* yang dihasilkan otomatis dan rumit ini sangat sulit dibaca, dimodifikasi, atau di-*debug* oleh programmer secara manual, memaksa programmer untuk terus kembali ke *builder* untuk penyesuaian terkecil.
3.  **Pemisahan yang Buruk:** *Builder* Swing seringkali mencampur kode visual (*View*) dengan logika aplikasi (*Controller*) dalam satu file Java, melanggar prinsip desain *Model-View-Controller* (MVC).

Inilah sebabnya mengapa banyak programmer Java berpengalaman **menghindari** *Visual Builder* Swing dan memilih untuk menulis semua konfigurasi tata letak (*Layout Manager*) secara manual.

### ✅ Pembaharuan Fakta (Kasus JavaFX Scene Builder)

Sebaliknya, alat *drag-and-drop* pada teknologi modern seperti **JavaFX Scene Builder** adalah praktik yang **sangat direkomendasikan** dan diterima secara luas. Perbedaannya terletak pada hasil yang diciptakan oleh alat tersebut:

1.  **Output FXML yang Bersih:** Scene Builder **tidak menghasilkan kode Java** yang kotor. Sebaliknya, ia menghasilkan file **FXML** (XML Markup). FXML adalah bahasa **deklaratif** yang hanya mendefinisikan *apa* yang harus ada di UI, bukan *bagaimana* membuatnya.
2.  **Mendukung MVC:** FXML dirancang untuk memisahkan **View** (file FXML yang dihasilkan oleh *builder*) dari **Controller** (file Java murni yang berisi logika bisnis). Pemisahan ini sangat bersih, memungkinkan desainer bekerja di Scene Builder sementara programmer fokus pada kode Java.
3.  **Tata Letak Responsif:** FXML secara alami bekerja dengan Layout Manager modern JavaFX (seperti `HBox`, `VBox`, dan `GridPane`) yang fleksibel dan menghasilkan tata letak yang **konsisten** dan **responsif** di berbagai perangkat dan resolusi.

Oleh karena itu, meskipun kritikan terhadap *drag-and-drop* itu valid untuk teknologi GUI Java yang lama (Swing), Anda **disarankan** untuk menggunakan **Scene Builder** saat mengembangkan aplikasi JavaFX, karena alat ini meningkatkan kecepatan desain tanpa mengorbankan kualitas kode dan pemeliharaan proyek Anda.


## 🛠️ Langkah-Langkah Memasang JavaFX (Menggunakan Maven)

Cara paling modern dan direkomendasikan untuk menggunakan JavaFX adalah melalui sistem manajemen dependensi seperti **Maven** atau **Gradle**. Berikut adalah langkah-langkahnya menggunakan **Maven**, yang merupakan praktik standar industri:

### 1. Prasyarat

Pastikan Anda telah menginstal ini di sistem Anda:

* **Java Development Kit (JDK):** Versi 11 atau yang lebih baru (misalnya, OpenJDK atau Oracle JDK).
* **Maven:** Build tool (jika Anda membuat proyek dari awal).
* **IDE:** Integrated Development Environment (misalnya, IntelliJ IDEA, Eclipse, atau VS Code) yang mendukung Maven.

### 2. Buat Proyek Maven Baru

Buat proyek Maven baru di IDE Anda atau melalui *command line*. Proyek ini akan memiliki file konfigurasi utama bernama `pom.xml`.

### 3. Tambahkan Dependensi JavaFX

Buka file `pom.xml` dan tambahkan dependensi untuk modul JavaFX yang Anda butuhkan (misalnya, `javafx-controls` dan `javafx-fxml`).

> Pastikan untuk mengganti `${javafx.version}` dengan versi JavaFX terbaru yang stabil (misalnya, 21 atau 22).

```xml
<properties>
    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    <javafx.version>22</javafx.version> 
    <maven.compiler.source>17</maven.compiler.source>
    <maven.compiler.target>17</maven.compiler.target>
</properties>

<dependencies>
    <dependency>
        <groupId>org.openjfx</groupId>
        <artifactId>javafx-controls</artifactId>
        <version>${javafx.version}</version>
    </dependency>
    <dependency>
        <groupId>org.openjfx</groupId>
        <artifactId>javafx-fxml</artifactId>
        <version>${javafx.version}</version>
    </dependency>
    </dependencies>
```

### 4. Konfigurasi Plugin Maven

Untuk memastikan JavaFX dapat dijalankan sebagai modul Java yang terpisah (dengan menggunakan `module-path`), Anda harus menambahkan **Plugin Maven JavaFX** (atau setidaknya mengkonfigurasi *plugin* yang ada seperti `exec-maven-plugin`).

Tambahkan plugin ini di bagian `<build>` dari `pom.xml`:

```xml
<build>
    <plugins>
        <plugin>
            <groupId>org.openjfx</groupId>
            <artifactId>javafx-maven-plugin</artifactId>
            <version>0.0.8</version>
            <configuration>
                <mainClass>com.example.NamaAplikasiAnda</mainClass> </configuration>
        </plugin>
    </plugins>
</build>
```

### 5. Tulis Kode dan Jalankan Aplikasi

* Buat *main class* Anda (misalnya `MainApp.java`) yang harus memperluas `javafx.application.Application`.

* Jalankan proyek Anda melalui IDE, atau dari *command line* menggunakan perintah Maven:

  ```bash
  mvn clean javafx:run
  ```

**Catatan Penting:** Jika Anda tidak menggunakan Maven atau Gradle, Anda harus mengunduh JavaFX SDK secara manual, menyetel *path* ke *library* tersebut, dan menjalankannya secara eksplisit menggunakan opsi `--module-path` pada *command line*. Namun, metode ini **tidak disarankan** untuk proyek serius karena kompleksitasnya.

## ⛓️‍💥 Link Dependency & Dokumentasi JavaFX

- [Getting Started with JavaFX](https://openjfx.io/openjfx-docs/#introduction) - Dokumentasi dan panduan awal memulai JavaFX.
- [Maven Repository](https://mvnrepository.com/artifact/javafx) - Beberapa dependency JavaFX yang bisa dipasang dengan memasang dependency dari Maven Repository.
- [OpenJFX 11](https://mvnrepository.com/artifact/org.openjfx/javafx/11) - Dependency JavaFX 11.
- [OpenJFX » 26-ea+18](https://mvnrepository.com/artifact/org.openjfx/javafx/26-ea+18) - Dependency JavaFX yang lebih baru.
- [Run HelloWorld using Maven](https://openjfx.io/openjfx-docs/#maven) - Menjalankan program JavaFX dengan menggunaan Maven.
- [JavaFX FXML](https://mvnrepository.com/artifact/org.openjfx/javafx-fxml) - Dependency JavaFX FXML dari Maven.
- [Gluon Scene-Builder](https://gluonhq.com/products/scene-builder/) - Fitur drag-and-drop JavaFX. Harus dilakukan dengan aplikasi terpisah ini. Install terlebih dahulu, dan koneksikan ke Intellij.