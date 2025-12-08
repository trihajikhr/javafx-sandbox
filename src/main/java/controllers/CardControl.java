package controllers;

import javafx.animation.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Side;
import javafx.scene.CacheHint;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import javafx.animation.*;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;

import java.net.URL;
import java.util.ResourceBundle;
public class CardControl implements Initializable {

    @FXML
    private ScrollPane scroll;


    @FXML
    private VBox list;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        scroll.setFitToWidth(true);
        list.setFillWidth(true); // BIKIN semua anak follow width VBox
        addCards();
    }

    private void addCards() {
        list.getChildren().add(createCard("Makan", "120.000"));
        list.getChildren().add(createCard("Transport", "30.000"));
        list.getChildren().add(createCard("Ngopi", "25.000"));
        list.getChildren().add(createCard("Kafe", "25.000"));
        list.getChildren().add(createCard("Liburan", "25.000"));
        list.getChildren().add(createCard("Konser", "25.000"));
        list.getChildren().add(createCard("Kemarh", "25.000"));
        list.getChildren().add(createCard("Pulang Kampung", "25.000"));
    }

//    private Pane createCard(String title, String amount) {
//        HBox box = new HBox();
//        box.setStyle("""
//        -fx-background-color: white;
//        -fx-padding: 15;
//        -fx-background-radius: 8;
//        -fx-border-radius: 8;
//        -fx-border-color: #ddd;
//    """);
//
//        // sangat penting
//        box.setMaxWidth(Double.MAX_VALUE); // BIAR PANJANG FULL
//        HBox.setHgrow(box, javafx.scene.layout.Priority.ALWAYS);
//
//        box.getChildren().addAll(
//                new Label(title),
//                new Label(amount)
//        );
//
//        return box;
//    }

    private Pane createCard(String title, String amount) {
        VBox box = new VBox(5);
        box.getStyleClass().add("card"); // apply css

        Label t = new Label(title);
        Label a = new Label(amount);

        box.getChildren().addAll(t, a);

        // event: klik card
        box.setOnMouseClicked(e -> {
            System.out.println("Card ditekan: " + title);
            showEditMenu(box, title, amount);
        });

        box.setOnMouseEntered(e -> {
            ScaleTransition st = new ScaleTransition(Duration.millis(150), box);
            st.setToX(1.02);
            st.setToY(1.02);
            st.play();
        });

        box.setOnMouseExited(e -> {
            ScaleTransition st = new ScaleTransition(Duration.millis(150), box);
            st.setToX(1);
            st.setToY(1);
            st.play();
        });

        box.setCache(true);
        box.setCacheHint(CacheHint.SPEED);


        return box;
    }

//    private Pane createCard(String title, String amount) {
//        VBox box = new VBox(5);
//        box.getStyleClass().add("card");
//
//        Label t = new Label(title);
//        Label a = new Label(amount);
//
//        box.getChildren().addAll(t, a);
//
//        // event: klik card
//        box.setOnMouseClicked(e -> {
//            System.out.println("Card ditekan: " + title);
//            showEditMenu(box, title, amount);
//        });
//
//        // Shadow halus
//        DropShadow softShadow = new DropShadow();
//        softShadow.setRadius(8);
//        softShadow.setOffsetY(2);
//        softShadow.setColor(Color.rgb(0, 0, 0, 0.12));
//        box.setEffect(softShadow);
//
//        // Hover animasi shadow + scale tipis
//        box.setOnMouseEntered(e -> {
//            ScaleTransition sc = new ScaleTransition(Duration.millis(150), box);
//            sc.setToX(1.01);
//            sc.setToY(1.01);
//
//            Timeline tl = new Timeline(
//                    new KeyFrame(Duration.millis(150),
//                            new KeyValue(softShadow.radiusProperty(), 12),
//                            new KeyValue(softShadow.offsetYProperty(), 3)
//                    )
//            );
//
//            // warna langsung (nggak bisa dianimasi keyframe)
//            softShadow.setColor(Color.rgb(0, 0, 0, 0.18));
//
//            sc.play();
//            tl.play();
//        });
//
//        box.setOnMouseExited(e -> {
//            ScaleTransition sc = new ScaleTransition(Duration.millis(150), box);
//            sc.setToX(1);
//            sc.setToY(1);
//
//            Timeline tl = new Timeline(
//                    new KeyFrame(Duration.millis(150),
//                            new KeyValue(softShadow.radiusProperty(), 8),
//                            new KeyValue(softShadow.offsetYProperty(), 2),
//                            new KeyValue(softShadow.colorProperty(),
//                                    Color.rgb(0, 0, 0, 0.12))
//                    )
//            );
//
//            sc.play();
//            tl.play();
//        });
//
//        return box;
//    }

//    private Pane createCard(String title, String amount) {
//        VBox box = new VBox(5);
//        box.getStyleClass().add("card");
//        box.setPadding(new javafx.geometry.Insets(10));
//        box.setMaxWidth(Double.MAX_VALUE);
//
//        Label t = new Label(title);
//        Label a = new Label(amount);
//        box.getChildren().addAll(t, a);
//
//        //        // event: klik card
//        box.setOnMouseClicked(e -> {
//            System.out.println("Card ditekan: " + title);
//            showEditMenu(box, title, amount);
//        });
//
//        // --- DropShadow awal ---
//        DropShadow softShadow = new DropShadow();
//        softShadow.setRadius(8);                         // blur radius awal
//        softShadow.setOffsetY(2);
//        softShadow.setColor(Color.rgb(0, 0, 0, 0.12));
//        box.setEffect(softShadow);
//
//        box.setCache(true);
//        box.setCacheHint(CacheHint.SPEED);
//
//        // --- proxy property untuk radius (penting!) ---
//        DoubleProperty radiusProxy = new SimpleDoubleProperty(softShadow.getRadius());
//        // setiap kali proxy berubah, apply ke DropShadow
//        radiusProxy.addListener((obs, oldV, newV) -> softShadow.setRadius(newV.doubleValue()));
//
//        // Hover in
//        box.setOnMouseEntered(e -> {
//            // scale
//            ScaleTransition sc = new ScaleTransition(Duration.millis(150), box);
//            sc.setToX(1.01);
//            sc.setToY(1.01);
//            sc.setInterpolator(Interpolator.EASE_BOTH);
//
//            // animate radius via proxy and offsetY directly
//            Timeline tl = new Timeline(
//                    new KeyFrame(Duration.millis(150),
//                            new KeyValue(radiusProxy, 12, Interpolator.EASE_BOTH),    // proxy anim
//                            new KeyValue(softShadow.offsetYProperty(), 3, Interpolator.EASE_BOTH)
//                    )
//            );
//
//            // set warna sedikit lebih gelap (tidak dianimasi)
//            softShadow.setColor(Color.rgb(0, 0, 0, 0.18));
//
//            new ParallelTransition(sc, tl).play();
//        });
//
//        // Hover out
//        box.setOnMouseExited(e -> {
//            ScaleTransition sc = new ScaleTransition(Duration.millis(140), box);
//            sc.setToX(1.0);
//            sc.setToY(1.0);
//            sc.setInterpolator(Interpolator.EASE_BOTH);
//
//            Timeline tl = new Timeline(
//                    new KeyFrame(Duration.millis(140),
//                            new KeyValue(radiusProxy, 8, Interpolator.EASE_BOTH),
//                            new KeyValue(softShadow.offsetYProperty(), 2, Interpolator.EASE_BOTH)
//                    )
//            );
//
//            softShadow.setColor(Color.rgb(0, 0, 0, 0.12));
//
//            new ParallelTransition(sc, tl).play();
//        });
//
//        // Context menu on click
//        box.setOnMouseClicked(e -> {
//            ContextMenu menu = new ContextMenu();
//            MenuItem edit = new MenuItem("Edit");
//            MenuItem delete = new MenuItem("Hapus");
//            menu.getItems().addAll(edit, delete);
//            menu.show(box, Side.RIGHT, 0, 0);
//        });
//
//        return box;
//    }

    private void showEditMenu(Pane card, String title, String amount) {
        ContextMenu menu = new ContextMenu();

        MenuItem edit = new MenuItem("Edit");
        MenuItem delete = new MenuItem("Hapus");

        edit.setOnAction(e -> {
            System.out.println("Edit " + title);
            // buka popup fxml atau dialog custom kamu
        });

        delete.setOnAction(e -> {
            System.out.println("Hapus " + title);
            // logic hapus
        });

        menu.getItems().addAll(edit, delete);

        // muncul di posisi mouse
        menu.show(card, Side.RIGHT, 0, 0);
    }
}
