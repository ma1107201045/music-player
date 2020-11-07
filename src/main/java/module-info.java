module music.player {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.lingyi.controller to javafx.fxml;
    exports com.lingyi;
}