# Scene Builder

Kita anggap kita masih awam terhadap JavaFX. Jadi kita akan membabat habis semua "tanda tanya" sehingga kita bisa memahami dengan lebih baik.

Seperti yang sudah dijelaskan sebelumnya, membuat aplikasi berbasis Graphical User Interface atau GUI pada Java memang umum dilakukan. Dan di Java, biasanya orang-orang akan menggunakan yang namanya Java Swing. Namun tampilan dari Java Swing terlalu kuno (walaupun sekarnag sudah ada library flatlaf yang bisa membuat tampilan Java Swing menjadi seperti intellij), tidak modular karena tidak memisahkan kode logika dengan kode yang mengatur tampilan, dan modifikasi desain yang terbatas.

Menggunakan fitur drag-and-drop pada plugin untuk Java Swing juga tidak terlalu disarankan, karena fitur tersebut men generate kode yang sulit dibaca, aneh, dan susah didebug. Intinya pengguna Java modern sudah banyak yang meninggalkan Java Swing ini.

Alternatifnya sekarang adalah apa yang sedang kita pakai, yaitu menggunakan JavaFX. Library untuk membuat Java GUI yang... Well, penjelasan tentang ini sudah dibahas panjang di bagian depan repositori harusnya, jadi baca saja [JavaSwing VS JavaFX](javaswing-vs-javafx.md) ku wkwkkw.

Nah, untuk menggunakan JavaFX, kita justru diperbolehkan dan disarankan menggunakan fitur drag-and-drop yang diberikan, yaitu dengan menginstall aplikasi terpisah yang bernama Scene Builder, yang bisa diunduh lewat [Gluonhq](https://gluonhq.com/products/scene-builder/).

## Kenapa menggunakan Scene Builder?

Untuk emngatur tampilan JavaFX, kita bisa menggunakan Java code atau FXML. Tetapi menuliskan langsung secara manual jelas tidak efisien. Jadi, akan jauh lebih baik jika menggunakan file FXML. File FXML adalah file yang mendeskripsikan UI dari JavaFX, dan kita akan dibuatkan kode dari desain yang kita buat lewat Scene Builder, cukup dengan load file FXML itu dengan:

```java
FXMLLoader.load(getClass().getResource("main-view.fxml"));
```

Maka kita sudah bisa menampilkan program Java dengan desain yang kita mau.

Selain itu, pemisahakan kode membuat program lebih modular. Kita memisahkan kode logika, dengan kode UI. Logika diurus oleh Java, sedangkan UI diurus oleh file FXML. Ini membuat kode kita lebih mudah di maintain, debug, dan lebih mudah melakukan kolaborasi.

Dan alasan terakhir untuk menggunakan Scene Builder, adalah WYSIWYG, atau _What You See Is What You Get._ Fitur seperti:

- responsive layout
- anchor constraints
- vbox/hbox spacing
- alignment control

…lebih mudah dilihat secara visual daripada ngetik “setPadding(new Insets(10))” tiap 3 detik.

Kesimpulanya, tidak wajib menggunakan Scene Builder, kita tetap bisa membuat UI dengan mengetik langsung. Tapi Scene Builder ini akan sangat mempermudah hidup, apalagi jika ingin membuat desain UI yang kompleks.