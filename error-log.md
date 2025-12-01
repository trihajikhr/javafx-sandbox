# Error Log

- [Alasan javaFX dipisa](https://stackoverflow.com/questions/23117541/how-to-make-a-runnable-jar-for-an-application-that-uses-javafx-without-native-in)
- [Tidak bisa membuat jarfile](https://stackoverflow.com/questions/52653836/maven-shade-javafx-runtime-components-are-missing)
- [Membuat Jar dari javaFX](https://medium.com/@kennydop/how-to-create-an-executable-jar-file-for-javafx-using-maven-f8a0039de1fa)
- [Dokumentasi penting tentang javaFX intelij](https://www.jetbrains.com/help/idea/packaging-javafx-applications.html)
- -[lagi](https://stackoverflow.com/questions/60994105/build-standalone-jar-with-javafx-14-and-fxml-files)


Daftar error:

```bash
PS D:\Github-Grinder\Java\javafx-sandbox> jpackage --input target --name MyTeam --main-jar javafx-sandbox-0.0.jar --type exe 
[20:29:06.818] Can not find WiX tools (light.exe, candle.exe)
[20:29:06.818] Download WiX 3.0 or later from https://wixtoolset.org and add it to the PATH.
Error: Invalid or unsupported type: [exe]
```

```bash
Failed to execute goal org.openjfx:javafx-maven-plugin:0.0.8:jlink (default-cli) on project javafx-sandbox: Error: jlink requires a module descriptor -> [Help 1]
```

```bash
[INFO] Replacing original artifact with shaded artifact.
[INFO] Replacing D:\Github-Grinder\Java\javafx-sandbox\target\javafx-sandbox-1.0-SNAPSHOT.jar with D:\Github-Grinder\Java\javafx-sandbox\target\javafx-sandbox-1.0-SNAPSHOT-shaded.jar
```

```bash
jlink failed with: Error: Error reading module: C:\Program Files\Java\javafx-sdk-25.0.1\lib\javafx.base.jar
```

Butuh WixToolset:

```bash
jpackage --input target --name MyTeam --main-jar javafx-sandbox-0.0.jar --type exe 
```

link ke [wixtoolset](https://github.com/wixtoolset/wix3/releases).

syntac compile ke jar dengan semua dependency masuk (YANG INI BERHASIL!)

```bash
mvn clean
mvn install
```
Setelah itu coba jalan dengan :

```bash
java -jar target/javafx-sandbox-0.0.jar
```

syntax untuk jadikan file jar ke exe (eix toolset sudah berhasil dipasang):

```bash
jpackage --input target --name MyTeam --main-jar javafx-sandbox-0.0.jar --type exe --icon src/main/resources/icons/favicon.ico
```
Proses ini memakan waktu lama, jadi tunggu saja.



- Proses update ke JDK 25 sangat panjang, dan hbanyak path environtmen yang harus dihapus, suapa jdk-25 lah yang hanya terbaca, baru setlah itu tidak ada eror untuk:

```bash
jlink --module-path "C:\Program Files\Java\jdk-25.0.1\jmods;C:\Program Files\Java\javafx-sdk-25.0.1\lib" --add-modules java.base,java.desktop,javafx.controls,javafx.fxml --output custom-jre
Error: directory already exists: custom-jre
```

akan mebuat file custom-jre. yang isinya sudah ada beberapa file lain

baru setelah itu jalankan:

```bash
jpackage --input target --name MyTeam --main-jar javafx-sandbox-0.0.jar --type app-image --runtime-image custom-jre --icon src/main/resources/icons/favicon.ico
```