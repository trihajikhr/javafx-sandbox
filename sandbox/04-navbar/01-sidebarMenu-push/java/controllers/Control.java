package controllers;

import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

public class Control {
    @FXML private AnchorPane sidebar;
    @FXML private AnchorPane mainContent;

    private boolean open = false;
    private final double SIDEBAR_WIDTH = 220;

    @FXML
    public void initialize() {
        // pastikan posisi awal dan z-order
        sidebar.setTranslateX(-SIDEBAR_WIDTH);
    }

    @FXML
    public void toggleSidebar() {
        TranslateTransition tSidebar = new TranslateTransition(Duration.millis(220), sidebar);
        TranslateTransition tMain = new TranslateTransition(Duration.millis(220), mainContent);

        if (open) {
            tSidebar.setToX(-SIDEBAR_WIDTH);
            tMain.setToX(0);
        } else {
            tSidebar.setToX(0);
            tMain.setToX(SIDEBAR_WIDTH);
        }

        open = !open;
        tSidebar.play();
        tMain.play();
    }
}
