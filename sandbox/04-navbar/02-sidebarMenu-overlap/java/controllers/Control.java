package controllers;

import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

public class Control {

    @FXML
    private VBox sidebar;

    private boolean open = false;
    private final double SIDEBAR_WIDTH = 220;

    @FXML
    public void initialize() {
        // Pastikan posisi awal oke
        sidebar.setTranslateX(-SIDEBAR_WIDTH);
    }

    @FXML
    public void toggleSidebar() {
        TranslateTransition tt = new TranslateTransition(Duration.millis(220), sidebar);

        if (open) {
            tt.setToX(-SIDEBAR_WIDTH); // Nutup
        } else {
            tt.setToX(0); // Buka
        }

        open = !open;
        tt.play();
    }
}