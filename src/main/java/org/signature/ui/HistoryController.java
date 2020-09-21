package org.signature.ui;

import com.jfoenix.controls.JFXListView;
import javafx.fxml.FXML;
import javafx.scene.control.ListCell;
import javafx.scene.control.SelectionMode;
import javafx.scene.text.Font;
import org.signature.model.Equation;
import org.signature.model.History;

public class HistoryController {

    @FXML
    private JFXListView<Equation> history;

    public void initialize() {
        history.setItems(History.getInstance().getHistory());
        history.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

        history.setCellFactory(param -> new ListCell<>() {
            @Override
            protected void updateItem(Equation item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setText(null);
                } else {
                    setMinWidth(param.getWidth());
                    setPrefWidth(param.getWidth());
                    setMaxWidth(param.getWidth());

                    setWrapText(true);

                    setText(item.getEquation() + "\n" + item.getResult());
                    setFont(new Font("Roboto", 24.0));
                }
            }
        });

        history.setOnMouseClicked(event -> {
            Equation equation = history.getSelectionModel().getSelectedItem();
            Main.controller.loadFormHistory(equation);
        });

        history.setOnKeyPressed(event -> {
            Equation equation = history.getSelectionModel().getSelectedItem();
            Main.controller.loadFormHistory(equation);
        });
    }
}
