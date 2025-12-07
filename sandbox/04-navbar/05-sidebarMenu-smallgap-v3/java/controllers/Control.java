package controllers;

import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

public class Control {

    @FXML private AnchorPane labelSidebar; // layer yang berisi label (slide)
    @FXML private AnchorPane mainContent;  // layer konten yang akan didorong
    @FXML private Button toggleButton;     // tombol di iconBar

    private boolean open = false;

    // ukuran sesuai FXML: labelSidebar width 200, iconBar width 60
    private final double SIDEBAR_WIDTH = 200;
    private final double ANCHOR_ICON_WIDTH = 60;
    private final Duration D = Duration.millis(220);
    @FXML private final double BUTTON_SHIFT = SIDEBAR_WIDTH; // 200

    @FXML
    public void initialize() {
        // pastikan awal hidden
        labelSidebar.setTranslateX(-SIDEBAR_WIDTH);
        mainContent.setTranslateX(0);
        toggleButton.setText("≡");
    }

    // veri navbar button fixed di layer icon
    @FXML
    public void toggleSidebars() {
        toggleButton.setDisable(true);

        double labelTarget = open ? -SIDEBAR_WIDTH : 0; // translateX for labelSidebar
        double contentTarget = open ? 0 : SIDEBAR_WIDTH; // mainContent shift

        KeyValue kvLabel = new KeyValue(labelSidebar.translateXProperty(), labelTarget, Interpolator.EASE_BOTH);
        KeyValue kvContent = new KeyValue(mainContent.translateXProperty(), contentTarget, Interpolator.EASE_BOTH);

        KeyFrame kf = new KeyFrame(D, kvLabel, kvContent);
        Timeline tl = new Timeline(kf);

        tl.setOnFinished(evt -> {
            open = !open;
            toggleButton.setText(open ? "←" : "≡");
            toggleButton.setDisable(false);
        });

        tl.play();
    }


    // versi navbar button ikut pindah
    @FXML
    public void toggleSidebar() {
        toggleButton.setDisable(true);

        double labelTarget = open ? -SIDEBAR_WIDTH : 0;
        double contentTarget = open ? 0 : SIDEBAR_WIDTH;

        // Tambahan: tombol ikut geser
        double buttonTarget = open ? 0 : BUTTON_SHIFT;

        KeyValue kvLabel   = new KeyValue(labelSidebar.translateXProperty(), labelTarget, Interpolator.EASE_BOTH);
        KeyValue kvContent = new KeyValue(mainContent.translateXProperty(), contentTarget, Interpolator.EASE_BOTH);
        KeyValue kvButton  = new KeyValue(toggleButton.translateXProperty(), buttonTarget, Interpolator.EASE_BOTH);

        KeyFrame kf = new KeyFrame(D, kvLabel, kvContent, kvButton);
        Timeline tl = new Timeline(kf);

        tl.setOnFinished(evt -> {
            open = !open;
            toggleButton.setText(open ? "←" : "≡");
            toggleButton.setDisable(false);
        });

        tl.play();
    }

}
