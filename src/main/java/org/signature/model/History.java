package org.signature.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class History {

    private final ObservableList<Equation> historyList;
    private static final History instance = new History();

    private History() {
        historyList = FXCollections.observableArrayList();
    }

    public static History getInstance() {
        return instance;
    }

    public void addHistory(String eq, String result, String operation, String lastValue) {
        historyList.add(new Equation(eq, result, operation, lastValue));
    }

    public ObservableList<Equation> getHistory() {
        return historyList;
    }
}
