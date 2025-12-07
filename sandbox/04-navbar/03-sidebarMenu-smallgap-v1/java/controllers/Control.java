package controllers;

import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

public class Control {
    @FXML private VBox sidebar;
    @FXML private AnchorPane mainContent;
    @FXML private Button toggleButton;

    private boolean open = false;
    private final double COLLAPSED = 60;
    private final double EXPANDED = 220;
    private final Duration ANIM_DUR = Duration.millis(220);

    @FXML
    public void initialize() {
        // Pastikan keadaan awal konsisten: collapsed
        sidebar.setPrefWidth(COLLAPSED);
        mainContent.setTranslateX(0);
        toggleButton.setText("≡");
    }

    @FXML
    public void toggleSidebar() {
        // disable tombol selama animasi supaya gak nabrak
        toggleButton.setDisable(true);

        double targetWidth = open ? COLLAPSED : EXPANDED;
        double targetShift = open ? 0 : (EXPANDED - COLLAPSED);

        // Timeline untuk meng-animasi prefWidth (smooth collapse/expand)
        KeyValue kvWidth = new KeyValue(sidebar.prefWidthProperty(), targetWidth, Interpolator.EASE_BOTH);
        KeyValue kvShift = new KeyValue(mainContent.translateXProperty(), targetShift, Interpolator.EASE_BOTH);

        Timeline tl = new Timeline(new KeyFrame(ANIM_DUR, kvWidth, kvShift));

        tl.setOnFinished(evt -> {
            // pastikan layout stabil setelah animasi
            sidebar.setPrefWidth(targetWidth);
            mainContent.setTranslateX(targetShift);

            // update icon dan state
            open = !open;
            toggleButton.setText(open ? "←" : "≡");

            // re-enable tombol
            toggleButton.setDisable(false);
        });

        tl.play();
    }
}
