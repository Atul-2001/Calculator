module org.signature {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.jfoenix;

    opens org.signature.ui to javafx.fxml;
    exports org.signature.ui;
}