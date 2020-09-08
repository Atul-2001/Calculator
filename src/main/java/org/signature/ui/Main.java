package org.signature.ui;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    public static boolean isWindows = false;

    @Override
    public void start(Stage stage) throws Exception {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));
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
        } catch (IOException | NullPointerException e) {
            System.err.println(e.getMessage());
            Platform.exit();
        }
    }
}
