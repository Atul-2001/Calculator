module org.signature {
    requires javafx.controls;
    requires javafx.fxml;

    opens org.signature to javafx.fxml;
    exports org.signature;
}