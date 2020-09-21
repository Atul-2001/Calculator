package org.signature.ui;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    public static boolean isWindows = false;
    protected static HomeController controller;

    @Override
    public void start(Stage stage) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Home.fxml"));
            BorderPane root = loader.load();
            controller = loader.getController();
            Scene scene = new Scene(root);
            scene.setFill(Color.TRANSPARENT);
            stage.setScene(scene);
            stage.setTitle("Calculator");
            stage.setMinWidth(320.0);
            stage.setMinHeight(480.0);
//            stage.getIcons().add(new Image(getClass().getResource("/icons/logo.png").toString()));
            if (System.getProperty("os.name").startsWith("Windows")) {
                isWindows = true;
            }
            stage.show();

            VBox sidePane = FXMLLoader.load(getClass().getResource("HistoryPane.fxml"));
            stage.widthProperty().addListener((observable, oldValue, newValue) -> {
                if (newValue.doubleValue() > oldValue.doubleValue()) {
                    if (root.getRight() == null) {
                        if (newValue.doubleValue() > 728) {
                            root.setRight(sidePane);
                        }
                    }
                } else if (oldValue.doubleValue() > newValue.doubleValue()) {
                    if (newValue.doubleValue() <= 728) {
                        if (root.getRight() != null) {
                            root.setRight(null);
                        }
                    }
                }
            });
        } catch (IOException | NullPointerException e) {
            System.err.println(e.getMessage());
            Platform.exit();
        }
    }
}
