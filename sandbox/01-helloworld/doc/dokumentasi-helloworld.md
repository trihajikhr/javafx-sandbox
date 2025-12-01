# JavaFX HelloWorld

Buatlah sebuah program JavaFX sederhana yang akan menampilkan sebuah jendela, dan tulisan berupa `Hello World!`. Ini adalah program sederhana, jadi cukup tampilkan tulisan saja.

Dibuat desain sebagai berikut pada SceneBuilder:

![img.png](src/img.png)

Desainya sederhana, digunakan 2 jenis library, yaitu:
1. Pane, yang digunakan sebagai container dari window. 
2. Label, tempat menuliskan pesan `Hello World!`.

Setelah dibuat, simpan pada `main/resources/fxml/helloworld.fxml`, maka bisa dilihat file `helloworld.fxml` yang dibuat adalah sebagai berikut:

```fxml
<?xml version="1.0" encoding="UTF-8"?>

<?import javafx.scene.control.Label?>
<?import javafx.scene.layout.Pane?>
<?import javafx.scene.text.Font?>


<Pane maxHeight="-Infinity" maxWidth="-Infinity" minHeight="-Infinity" minWidth="-Infinity" prefHeight="400.0" prefWidth="600.0" xmlns="http://javafx.com/javafx/25" xmlns:fx="http://javafx.com/fxml/1">
   <children>
      <Label alignment="CENTER" layoutX="51.0" layoutY="52.0" prefHeight="297.0" prefWidth="499.0" text="Hello World!" textAlignment="CENTER">
         <font>
            <Font size="40.0" />
         </font>
      </Label>
   </children>
</Pane>
```

Setelah itu, pada pada file `main/java/app/Main.java`, kita buat kode Java sebagai berikut:

```java
package app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/helloworld.fxml"));
        stage.setScene(new Scene(loader.load()));
        stage.setTitle("Program Hello World");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
```

Setelah itu, jalankan dengan konfigurasi Maven pada file `pom.xml`, atau dengan membuat konfiguras perintah (jika menggunakan intellij) dengan syntax `javafx:run`.

Maka akan dihasilkan output sebagai berikut:

![img_1.png](src/img_1.png)

Oke, sekarang masuk ke tahap pemabahasan, yang akan membahasa semua hal yang perlu dibahas.