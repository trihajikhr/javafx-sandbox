# Konversi Java ke Jar

> [!NOTE]
> Membuat aplikasi Java agar dapat dijalankan pada berbagai lingkungan memerlukan proses konversi ke dalam format JAR, dan apabila dibutuhkan, dilanjutkan ke format EXE. Sebelum tahap konversi ke EXE dapat dilakukan, aplikasi Java harus terlebih dahulu dikemas menjadi JAR. 
> 
> Pada kasus aplikasi yang menggunakan JavaFX, proses pembuatan JAR dan EXE menjadi lebih kompleks. Hal ini disebabkan oleh pemisahan JavaFX dari JDK sejak JDK 11, yang menjadikannya proyek _open-source_ mandiri. Konsekuensinya, pengembang perlu memasang JDK dan pustaka JavaFX secara terpisah serta melakukan konfigurasi tambahan agar lingkungan pengembangan dapat berfungsi dengan baik. Dokumentasi ini disusun untuk menjelaskan proses tersebut secara sistematis setelah tahapan implementasinya berhasil dilakukan.

File JAR adalah singkatan dari Java Archive, sebuah format file terkompresi yang digunakan untuk menggabungkan banyak file yang terkait dengan aplikasi Java menjadi satu file. Format ini didasarkan pada format file ZIP dan dapat digunakan untuk mendistribusikan aplikasi, pustaka, atau modul Java secara mudah, karena sifatnya yang independen dari platform dan dapat dijalankan di mana saja dengan JRE (Java Runtime Environment) terpasang.

Fitur utama file JAR
1. **Penggabungan dan Kompresi**: Menggabungkan file seperti *.class, sumber daya (teks, gambar, suara), dan metadata ke dalam satu file terkompresi.
2. **Independen Platform**: Dapat berjalan di sistem operasi apa pun selama memiliki Java Virtual Machine (JVM).
3. **Dapat Dieksekusi**: File JAR dapat dikonfigurasi untuk menjalankan aplikasi secara langsung (executable jar) dengan mengacu pada titik masuk aplikasi dalam file manifesnya.
4. **Keamanan**: File JAR dapat ditandatangani secara digital untuk mengautentikasi asal-usulnya dan memastikan integritas datanya.
5. **Pustaka dan Plugin**: Selain aplikasi yang dapat dieksekusi, file JAR juga sering digunakan untuk mengemas pustaka atau plugin untuk digunakan oleh aplikasi Java lainnya. 

## Kenapa JAR?

Format JAR (Java ARchive) digunakan sebagai cara standar untuk mengemas aplikasi Java agar dapat dijalankan dan didistribusikan secara konsisten. Dengan menggabungkan bytecode, resource, dan metadata eksekusi dalam satu berkas, JAR membuat aplikasi menjadi portabel dan mudah dijalankan melalui Java Runtime. Selain itu, JAR berfungsi sebagai tahap perantara sebelum pembuatan executable atau installer native, sehingga memudahkan integrasi dengan alat build seperti Maven atau Gradle. Pada aplikasi yang memiliki dependensi tambahan—seperti JavaFX—penggunaan JAR memungkinkan seluruh komponen dapat dikemas secara terstruktur, mengurangi risiko kesalahan classpath dan memastikan aplikasi dapat berjalan pada berbagai lingkungan tanpa konfigurasi manual yang rumit.

## Persyaratan Awal

Untuk bisa mengkonveri program Java yang dibangun dengan menggunakan Maven, kita bisa menggunakan konfigurasi build dari Maven untuk membuat file JAR tersebut. Syarat-syarat berikut perlu dipenuhi:

1. Pastikan JDK telah terpasang dan variabel lingkungan seperti `JAVA_HOME` telah dikonfigurasi dengan benar. Install JDK versi terbaru di [jdk.java.net](https://jdk.java.net/), dan pilih versi terbaru, misal ketika dokumentasi ini dibuat, sudah terdapat JDK 25. Jika proses pemasangan sudah dilakukan, lakukan setup dan konfigurasi pada Environtment Variables, dengan mengatur `PATH` dan `JAVA_HOME` yang mengarah ke path tempat JDK terpasang. Misalnya seperti ini:

    `Path`:
    ```bash
    C:\Program Files\Java\jdk-25.0.1\bin
    ```
    
    `JAVA_HOME`:
    ```bash
    C:\Program Files\Java\jdk-25.0.1
    ```
   
    Setup berhasil jika ketika kita mengetikan perintah `java -version` pada terminal, maka muncul output sebagai berikut:
    
    ```bash
    PS C:\Users\ASUS> java -version
    openjdk version "25.0.1" 2025-10-21
    OpenJDK Runtime Environment (build 25.0.1+8-27)
    OpenJDK 64-Bit Server VM (build 25.0.1+8-27, mixed mode, sharing)
    ```
2. Pastikan proyek telah memiliki struktur Maven yang sesuai, termasuk direktori `src/main/java` untuk kode sumber dan `src/main/resources` untuk berkas pendukung. Jika projek Maven dibuat langsung melalui Intellij, biasanya struktur folder ini sudah otomatis terbuat.

3. Pastikan file `pom.xml` telah berisi deklarasi dependensi yang dibutuhkan, termasuk pustaka JavaFX apabila aplikasi menggunakannya. Patikan konfiguras pada tahap [Konfigurasi awal](konfigurasi-awal.md) sudah diikuti dengan baik hingga bekerja dengan benar. Mungkin pada bagian blok `<build>` isinya seperti ini:

    ```xml
    <build>
        <plugins>
            <plugin>
                <groupId>org.openjfx</groupId>
                <artifactId>javafx-maven-plugin</artifactId>
                <version>0.0.8</version>
                <configuration>
                    <mainClass>app.Main</mainClass>
                </configuration>
            </plugin>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <version>3.11.0</version>
                <configuration>
                    <source>20</source>
                    <target>20</target>
                </configuration>
            </plugin>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-shade-plugin</artifactId>
                <version>3.5.0</version>
                <executions>
                    <execution>
                        <phase>package</phase>
                        <goals>
                            <goal>shade</goal>
                        </goals>
                        <configuration>
                            <transformers>
                                <transformer implementation="org.apache.maven.plugins.shade.resource.ManifestResourceTransformer">
                                    <mainClass>app.Main</mainClass>
                                </transformer>
                            </transformers>
                        </configuration>
                    </execution>
                </executions>
            </plugin>
        </plugins>
    </build>
    ```

4. Pastikan plugin build yang diperlukan—seperti `maven-compiler-plugin` dan plugin untuk pembuatan JAR—telah dikonfigurasi sehingga Maven dapat mengompilasi dan mengemas aplikasi dengan benar. Kunjungi [Konfigurasi awal](konfigurasi-awal.md) untuk lebih jelas, atau lihat [pom.xml](../pom.xml) untuk melihat konfigurasi yang dipakai pada repository ini sebagai referensi.

## Memasang Maven

Karena projek Java yang kita buat menggunakan Maven sebagai projek managernya, dan kedepanya kita perlu berinteraksi dengan Maven melalui terminal, maka kita perlu menginstall Maven pada komputer kita. 

Pertama, install terlebih dahulu Maven dari [Apache Maven](https://maven.apache.org/download.cgi), lalu ekstrak file ZIP tersebut, dan letakan pada `C:\Program Files`. 

> [!IMPORTANT]
> Penempatan folder Maven di direktori `C:\Program Files` bertujuan untuk menjaga konsistensi. Dengan lokasi yang seragam, seluruh aplikasi yang berinteraksi melalui terminal memiliki struktur path yang konsisten dan lebih mudah dikelola.

Setelah itu, perbarui `PATH` pada Environtment Variables, dengan menambahkan struktur path dari folder Maven tadi:

```bash
C:\Program Files\apache-maven-3.9.11\bin
```

Untuk mengecek apakah konfigurasi ini berhasil, buka terminal dan masukan perintah `mvn -v` atau `mvn --version` (keduanya sama), maka keluar output sebagai berikut:

```bash
PS C:\Users\ASUS> mvn -v
Apache Maven 3.9.11 (3e54c93a704957b63ee3494413a2b544fd3d825b)
Maven home: C:\Program Files\apache-maven-3.9.11
Java version: 25.0.1, vendor: Oracle Corporation, runtime: C:\Program Files\Java\jdk-25.0.1
Default locale: en_US, platform encoding: UTF-8
OS name: "windows 11", version: "10.0", arch: "amd64", family: "windows"
```

Jika output yang keluar sama seperti diatas, maka Maven berhasil terpasang dengan benar.

## Berinteraksi dengan Maven

Untuk membuat file JAR, Maven menyediakan dua perintah yang sering digunakan, yaitu `mvn package` dan `mvn install`. Keduanya memang menghasilkan JAR, tetapi memiliki fungsi yang berbeda. Perintah `mvn package` hanya menjalankan proses kompilasi, pengujian (jika tidak di-skip), dan kemudian mengemas aplikasi menjadi JAR sesuai konfigurasi pada `pom.xml`. Ini adalah perintah standar yang digunakan ketika tujuan utama hanya membuat JAR yang dapat dijalankan atau didistribusikan.

Sementara itu, `mvn install` menjalankan semua langkah yang dilakukan `package`, tetapi menambahkan satu tahap tambahan: Maven akan menginstal hasil build ke repository lokal pada direktori `~/.m2/repository`. Tahap ini diperlukan bila JAR tersebut ingin digunakan sebagai dependensi oleh proyek lain, atau bila proyek yang dikerjakan merupakan multi-module project yang saling membutuhkan.

Secara ringkas, perintah yang tepat untuk membuat JAR aplikasi adalah:

* **`mvn package`** — digunakan ketika hanya perlu menghasilkan JAR.
* **`mvn install`** — digunakan ketika hasil JAR perlu tersedia di repository lokal untuk proyek lain.

**Jika ingin membuat program Java bisa menjadi _stand-alone_ dengan tujuan merubahnya menjadi EXE, harus pakai _command_ yang mana 🤔?**

Ketika tujuanmu hanya ingin melihat atau menjalankan hasil JAR secara lokal, perintah `mvn package` sudah sepenuhnya cukup. Perintah tersebut memang dibuat untuk menghasilkan artefak akhir seperti JAR atau WAR tanpa perlu memasukkannya ke repository lokal Maven.

Di sisi lain, `mvn install` tidak memiliki kaitan langsung dengan pembuatan aplikasi mandiri atau konversi JAR ke EXE. Perintah ini hanya menambahkan langkah ekstra berupa instalasi JAR ke repository lokal (`~/.m2/repository`) agar dapat dipakai sebagai dependensi oleh proyek Maven lain di komputermu.

Secara ringkas:

* **`mvn package`** dipakai ketika hanya ingin membuat JAR yang bisa dijalankan atau diuji secara lokal.
* **`mvn install`** dipakai ketika JAR tersebut perlu tersedia sebagai dependensi untuk proyek Maven lain.

Proses membuat EXE atau runtime mandiri **tidak bergantung** pada `package` atau `install`. Yang kamu butuhkan untuk membuat EXE adalah JAR yang sudah jadi — entah itu dihasilkan melalui `package` atau `install`, hasilnya tetap sama. Setelah JAR tersedia, barulah kamu menggunakan `jlink`, `jpackage`, atau alat pihak ketiga untuk membuat aplikasi mandiri.

> [!TIP]
> Ketika menjalankan `mvn package` atau `mvn install`, Maven akan menghasilkan berkas hasil kompilasi—termasuk file JAR—di dalam folder `target`. Namun proses build yang dilakukan berulang kali dapat meninggalkan artefak lama yang menimpa atau bercampur dengan hasil terbaru, sehingga berpotensi menimbulkan konflik, error yang sulit dilacak, atau JAR yang tidak mencerminkan perubahan kode. Untuk mencegah masalah tersebut, digunakan perintah `mvn clean` yang berfungsi menghapus seluruh isi folder `target` agar proses build berikutnya dimulai dari kondisi bersih dan terjamin konsistensinya. Sehingga kerap kali kedua perintah tersebut dimodifikasi menjadi `mvn clean package` dan `mvn clean install`.

## Konversi ke JAR

Jika semua syarat sudah dipenuhi, Maven sudah terpasang, dan sudah paham perintah dasar Maven, maka selanjutnya adalah menjalankan salah satu perintah yang sudah dijelaskan diatas, misal menjalankan perintah berikut pada terminal yang berlokasi di root folder projek Java yang dikelola dengan Maven:

```bash
mvn clean install
```
Perintah tersebut akan membersihkan folder `target` dari artefak lama, kemudian melakukan proses kompilasi, menjalankan pengemasan (`packaging`), dan akhirnya menghasilkan berkas JAR yang siap dijalankan atau dibagikan.

Setelah proses selesai tanpa error, file JAR dapat ditemukan di dalam folder `target/`. Biasanya dengan nama yang sesuai dengan konfigurasi pada `pom.xml`. Misal dimiliki berkas `pom.xml` sebagai berikut:

```xml
<groupId>javafx</groupId>
<artifactId>javafx-sandbox</artifactId>
<version>v0.0.2</version>
```

Maka akan dihasilkan berkas JAR dengan nama `javafx-sandbox-v0.0.2.jar`. 

> [TIP]
> Jika ingin dihasilkan berkas JAR dengan nama custom, cukup rubah konfigurasi `pom.xml` sesuai keingingan.

## Error Log
Terkadang terdapat error yang terjadi ketika dilakukan proses ini, dan berikut `error-log` yang bisa membantu jika terjadi error yang sama: