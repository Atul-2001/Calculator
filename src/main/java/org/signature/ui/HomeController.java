package org.signature.ui;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXHamburger;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;

public class HomeController {

    @FXML
    private BorderPane base;
    @FXML
    private JFXButton clearAll;
    @FXML
    private JFXButton clear;
    @FXML
    private JFXButton backspace;
    @FXML
    private JFXHamburger hamburger;
    @FXML
    private Label primaryDisplay;
    @FXML
    private Label secondaryDisplay;
    @FXML
    private JFXButton seven;
    @FXML
    private JFXButton eight;
    @FXML
    private JFXButton nine;
    @FXML
    private JFXButton four;
    @FXML
    private JFXButton five;
    @FXML
    private JFXButton six;
    @FXML
    private JFXButton one;
    @FXML
    private JFXButton two;
    @FXML
    private JFXButton three;
    @FXML
    private JFXButton plusMinus;
    @FXML
    private JFXButton zero;
    @FXML
    private JFXButton decimal;
    @FXML
    private JFXButton add;
    @FXML
    private JFXButton subtract;
    @FXML
    private JFXButton multiply;
    @FXML
    private JFXButton divide;
    @FXML
    private JFXButton modulus;
    @FXML
    private JFXButton oneX;
    @FXML
    private JFXButton xSquare;
    @FXML
    private JFXButton squareRoot;
    @FXML
    private JFXButton equals;

    private double lastValue;
    private String lastOperation;
    private double result;
    private boolean isResult;
    private boolean isEquals;
    private boolean isButtonsDisabled;
    private double advMathOpResult;
    private boolean isAdvMathOp;

    public void initialize() {

        Platform.runLater(() -> equals.requestFocus());

        base.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!oldValue) {
                base.requestFocus();
            }
        });

        zero.setOnAction(event -> {
            if (isResult || isEquals) {
                primaryDisplay.setText("0");
                if (isEquals) secondaryDisplay.setText("");
                isResult = false;
                isEquals = false;

                if (isButtonsDisabled) {
                    disableButtons(false);
                }

                if (isAdvMathOp) {
                    String currentValue = secondaryDisplay.getText();
                    String modifiedValue = currentValue.substring(0, currentValue.lastIndexOf(lastOperation)+1);
                    secondaryDisplay.setText(modifiedValue);
                }
            } else {
                String value = primaryDisplay.getText();
                if (value.matches("^0+$")) {
                    primaryDisplay.setText("0");
                } else {
                    primaryDisplay.setText(primaryDisplay.getText() + "0");
                }
            }
        });

        one.setOnAction(event -> {
            if (primaryDisplay.getText().matches("^0+$") || isResult || isEquals) {
                primaryDisplay.setText("1");
                if (isEquals) secondaryDisplay.setText("");

                if (isButtonsDisabled) {
                    disableButtons(false);
                }

                if (isAdvMathOp && (isResult || isEquals)) {
                    String currentValue = secondaryDisplay.getText();
                    String modifiedValue = currentValue.substring(0, currentValue.lastIndexOf(lastOperation)+1);
                    secondaryDisplay.setText(modifiedValue);
                }

                isResult = false;
                isEquals = false;
            } else {
                primaryDisplay.setText(primaryDisplay.getText() + "1");
            }
        });

        two.setOnAction(event -> {
            if (primaryDisplay.getText().matches("^0+$") || isResult || isEquals) {
                primaryDisplay.setText("2");
                if (isEquals) secondaryDisplay.setText("");

                if (isButtonsDisabled) {
                    disableButtons(false);
                }

                if (isAdvMathOp && (isResult || isEquals)) {
                    String currentValue = secondaryDisplay.getText();
                    String modifiedValue = currentValue.substring(0, currentValue.lastIndexOf(lastOperation)+1);
                    secondaryDisplay.setText(modifiedValue);
                }

                isResult = false;
                isEquals = false;
            } else {
                primaryDisplay.setText(primaryDisplay.getText() + "2");
            }
        });

        three.setOnAction(event -> {
            if (primaryDisplay.getText().matches("^0+$") || isResult || isEquals) {
                primaryDisplay.setText("3");
                if (isEquals) secondaryDisplay.setText("");

                if (isButtonsDisabled) {
                    disableButtons(false);
                }

                if (isAdvMathOp && (isResult || isEquals)) {
                    String currentValue = secondaryDisplay.getText();
                    String modifiedValue = currentValue.substring(0, currentValue.lastIndexOf(lastOperation)+1);
                    secondaryDisplay.setText(modifiedValue);
                }

                isResult = false;
                isEquals = false;
            } else {
                primaryDisplay.setText(primaryDisplay.getText() + "3");
            }
        });

        four.setOnAction(event -> {
            if (primaryDisplay.getText().matches("^0+$") || isResult || isEquals) {
                primaryDisplay.setText("4");
                if (isEquals) secondaryDisplay.setText("");

                if (isButtonsDisabled) {
                    disableButtons(false);
                }

                if (isAdvMathOp && (isResult || isEquals)) {
                    String currentValue = secondaryDisplay.getText();
                    String modifiedValue = currentValue.substring(0, currentValue.lastIndexOf(lastOperation)+1);
                    secondaryDisplay.setText(modifiedValue);
                }

                isResult = false;
                isEquals = false;
            } else {
                primaryDisplay.setText(primaryDisplay.getText() + "4");
            }
        });

        five.setOnAction(event -> {
            if (primaryDisplay.getText().matches("^0+$") || isResult || isEquals) {
                primaryDisplay.setText("5");
                if (isEquals) secondaryDisplay.setText("");

                if (isButtonsDisabled) {
                    disableButtons(false);
                }

                if (isAdvMathOp && (isResult || isEquals)) {
                    String currentValue = secondaryDisplay.getText();
                    String modifiedValue = currentValue.substring(0, currentValue.lastIndexOf(lastOperation)+1);
                    secondaryDisplay.setText(modifiedValue);
                }

                isResult = false;
                isEquals = false;
            } else {
                primaryDisplay.setText(primaryDisplay.getText() + "5");
            }
        });

        six.setOnAction(event -> {
            if (primaryDisplay.getText().matches("^0+$") || isResult || isEquals) {
                primaryDisplay.setText("6");
                if (isEquals) secondaryDisplay.setText("");

                if (isButtonsDisabled) {
                    disableButtons(false);
                }

                if (isAdvMathOp && (isResult || isEquals)) {
                    String currentValue = secondaryDisplay.getText();
                    String modifiedValue = currentValue.substring(0, currentValue.lastIndexOf(lastOperation)+1);
                    secondaryDisplay.setText(modifiedValue);
                }

                isResult = false;
                isEquals = false;
            } else {
                primaryDisplay.setText(primaryDisplay.getText() + "6");
            }
        });

        seven.setOnAction(event -> {
            if (primaryDisplay.getText().matches("^0+$") || isResult || isEquals) {
                primaryDisplay.setText("7");
                if (isEquals) secondaryDisplay.setText("");

                if (isButtonsDisabled) {
                    disableButtons(false);
                }

                if (isAdvMathOp && (isResult || isEquals)) {
                    String currentValue = secondaryDisplay.getText();
                    String modifiedValue = currentValue.substring(0, currentValue.lastIndexOf(lastOperation)+1);
                    secondaryDisplay.setText(modifiedValue);
                }

                isResult = false;
                isEquals = false;
            } else {
                primaryDisplay.setText(primaryDisplay.getText() + "7");
            }
        });

        eight.setOnAction(event -> {
            if (primaryDisplay.getText().matches("^0+$") || isResult || isEquals) {
                primaryDisplay.setText("8");
                if (isEquals) secondaryDisplay.setText("");

                if (isButtonsDisabled) {
                    disableButtons(false);
                }

                if (isAdvMathOp && (isResult || isEquals)) {
                    String currentValue = secondaryDisplay.getText();
                    String modifiedValue = currentValue.substring(0, currentValue.lastIndexOf(lastOperation)+1);
                    secondaryDisplay.setText(modifiedValue);
                }

                isResult = false;
                isEquals = false;
            } else {
                primaryDisplay.setText(primaryDisplay.getText() + "8");
            }
        });

        nine.setOnAction(event -> {
            if (primaryDisplay.getText().matches("^0+$") || isResult || isEquals) {
                primaryDisplay.setText("9");
                if (isEquals) secondaryDisplay.setText("");

                if (isButtonsDisabled) {
                    disableButtons(false);
                }

                if (isAdvMathOp && (isResult || isEquals)) {
                    String currentValue = secondaryDisplay.getText();
                    String modifiedValue = currentValue.substring(0, currentValue.lastIndexOf(lastOperation)+1);
                    secondaryDisplay.setText(modifiedValue);
                }

                isResult = false;
                isEquals = false;
            } else {
                primaryDisplay.setText(primaryDisplay.getText() + "9");
            }
        });

        decimal.setOnAction(event -> {
            if (primaryDisplay.textProperty().isEmpty().get() || isResult || isEquals) {
                primaryDisplay.setText("0.");
                if (isEquals) secondaryDisplay.setText("");

                if (isAdvMathOp && (isResult || isEquals)) {
                    String currentValue = secondaryDisplay.getText();
                    String modifiedValue = currentValue.substring(0, currentValue.lastIndexOf(lastOperation)+1);
                    secondaryDisplay.setText(modifiedValue);
                }

                isResult = false;
                isEquals = false;
            } else if (!primaryDisplay.getText().contains(".")) {
                primaryDisplay.setText(primaryDisplay.getText() + ".");
            }
        });

        plusMinus.setOnAction(event -> {
            if (!primaryDisplay.textProperty().isEmpty().get() && !isResult && !isEquals) {
                String value = primaryDisplay.getText();
                String valueBeforeDecimal, valueAfterDecimal;

                if (value.contains(".")) {
                    int indexOfDecimal= value.lastIndexOf(".");
                    valueBeforeDecimal = value.substring(0, indexOfDecimal);
                    if (indexOfDecimal == (value.length() - 1)) {
                        valueAfterDecimal = "0";
                    } else {
                        valueAfterDecimal = value.substring(indexOfDecimal + 1);
                    }
                } else {
                    valueBeforeDecimal = value;
                    valueAfterDecimal = "0";
                }

                if (!valueBeforeDecimal.matches("^0+$") || !valueAfterDecimal.matches("^0+$")) {
                    if (value.contains("-")) {
                        primaryDisplay.setText(value.replaceAll("-", ""));
                    } else {
                        primaryDisplay.setText("-" + value);
                    }
                }
            }
        });

        backspace.setOnAction(event -> {
            String value = primaryDisplay.getText();
            if(!value.isEmpty() && !isResult && !isEquals) {
                primaryDisplay.setText(value.replaceAll(".$", ""));
                isResult = false;

                value = primaryDisplay.getText();
                String valueBeforeDecimal, valueAfterDecimal;

                if (value.contains(".")) {
                    int indexOfDecimal= value.lastIndexOf(".");
                    valueBeforeDecimal = value.substring(0, indexOfDecimal);
                    if (indexOfDecimal == (value.length() - 1)) {
                        valueAfterDecimal = "0";
                    } else {
                        valueAfterDecimal = value.substring(indexOfDecimal + 1);
                    }
                } else {
                    valueBeforeDecimal = value;
                    valueAfterDecimal = "0";
                }

                if (valueBeforeDecimal.matches("^0+$") || valueAfterDecimal.matches("^0+$")) {
                    primaryDisplay.setText(value.replaceAll("-", ""));
                }
                if (value.isEmpty()) {
                    primaryDisplay.setText("0");
                }
            }
        });

        clearAll.setOnAction(event -> {
            primaryDisplay.setText("0");
            secondaryDisplay.setText("");
            result = 0.0;
            isResult = false;
            if (isButtonsDisabled) {
                disableButtons(false);
                isButtonsDisabled = false;
            }
        });

        clear.setOnAction(event -> {
            if (isResult || isEquals) {
                secondaryDisplay.setText("");
            }
            primaryDisplay.setText("0");
            result = 0.0;
            isResult = false;
            if (isButtonsDisabled) {
                disableButtons(false);
                isButtonsDisabled = false;
            }
        });

        add.setOnAction(event -> {
            if (!primaryDisplay.textProperty().isEmpty().get() && !isResult) {
                String value = getValue();

                if (secondaryDisplay.textProperty().isEmpty().get() || isEquals) {
                    secondaryDisplay.setText(value + "+");
                    result = Double.parseDouble(value);
                } else {
                    secondaryDisplay.setText(secondaryDisplay.getText() + value + "+");
                    lastValue = Double.parseDouble(value);
                    calculate();
                    printResult(String.valueOf(result));
                }
                lastOperation = "+";
                isResult = true;
            } else if (!secondaryDisplay.getText().isEmpty()) {
                String currentValue = secondaryDisplay.getText();
                String modifiedValue = currentValue.replaceAll("[\\-|*|/]$", "+").replaceAll("\\)$", ")+");
                secondaryDisplay.setText(modifiedValue);
                if (isAdvMathOp) {
                    lastValue = advMathOpResult;
                    calculate();
                    printResult(String.valueOf(result));
                }
                lastOperation = "+";
            }
            isEquals = false;
        });

        subtract.setOnAction(event -> {
            if (!primaryDisplay.textProperty().isEmpty().get() && !isResult) {
                String value = getValue();

                if (secondaryDisplay.textProperty().isEmpty().get() || isEquals) {
                    secondaryDisplay.setText(value + "-");
                    result = Double.parseDouble(value);
                } else {
                    secondaryDisplay.setText(secondaryDisplay.getText() + value + "-");
                    lastValue = Double.parseDouble(value);
                    calculate();
                    printResult(String.valueOf(result));
                }
                lastOperation = "-";
                isResult = true;
            } else if (!secondaryDisplay.getText().isEmpty()) {
                String currentValue = secondaryDisplay.getText();
                String modifiedValue = currentValue.replaceAll("[+|*|/]$", "-").replaceAll("\\)$", ")-");
                secondaryDisplay.setText(modifiedValue);
                if (isAdvMathOp) {
                    lastValue = advMathOpResult;
                    calculate();
                    printResult(String.valueOf(result));
                }
                lastOperation = "-";
            }
            isEquals = false;
        });

        multiply.setOnAction(event -> {
            if (!primaryDisplay.textProperty().isEmpty().get() && !isResult) {
                String value = getValue();

                if (secondaryDisplay.textProperty().isEmpty().get() || isEquals) {
                    secondaryDisplay.setText(value + "*");
                    result = Double.parseDouble(value);
                } else {
                    secondaryDisplay.setText(secondaryDisplay.getText() + value + "*");
                    lastValue = Double.parseDouble(value);
                    calculate();
                    printResult(String.valueOf(result));
                }
                lastOperation = "*";
                isResult = true;
            } else if (!secondaryDisplay.getText().isEmpty()) {
                String currentValue = secondaryDisplay.getText();
                String modifiedValue = currentValue.replaceAll("[+|\\-|/]$", "*").replaceAll("\\)$", ")*");
                secondaryDisplay.setText(modifiedValue);
                if (isAdvMathOp) {
                    lastValue = advMathOpResult;
                    calculate();
                    printResult(String.valueOf(result));
                }
                lastOperation = "*";
            }
            isEquals = false;
        });

        divide.setOnAction(event -> {
            if (!primaryDisplay.textProperty().isEmpty().get() && !isResult) {
                String value = getValue();

                if (secondaryDisplay.textProperty().isEmpty().get() || isEquals) {
                    secondaryDisplay.setText(value + "/");
                    result = Double.parseDouble(value);
                    lastOperation = "/";
                } else {
                    lastValue = Double.parseDouble(value);
                    if (lastValue == 0 || lastValue == 0.0) {
                        primaryDisplay.setText("Can't divide by zero!");
                        lastValue = result;
                        disableButtons(true);
                    } else {
                        secondaryDisplay.setText(secondaryDisplay.getText() + value + "/");
                        calculate();
                        printResult(String.valueOf(result));
                        lastOperation = "/";
                    }
                }
                isResult = true;
            } else if (!secondaryDisplay.getText().isEmpty()) {
                String currentValue = secondaryDisplay.getText();
                String modifiedValue = currentValue.replaceAll("[+|\\-|*]$", "/").replaceAll("\\)$", ")/");
                secondaryDisplay.setText(modifiedValue);
                if (isAdvMathOp) {
                    lastValue = advMathOpResult;
                    calculate();
                    printResult(String.valueOf(result));
                }
                lastOperation = "/";
            }
            isEquals = false;
        });

        modulus.setOnAction(event -> {
            if (!primaryDisplay.textProperty().isEmpty().get() && !isResult) {
                
            } else {

            }
        });

        oneX.setOnAction(event -> {
            if (!primaryDisplay.textProperty().isEmpty().get() && !isResult) {
                String value = getValue();

                if (secondaryDisplay.textProperty().isEmpty().get() || isEquals) {
                    secondaryDisplay.setText("1/(" + value + ")");
                    result = 1;
                    lastValue = Double.parseDouble(value);
                    lastOperation = "/";
                    calculate();
                    printResult(String.valueOf(result));
                    isEquals = true;
                } else {
                    secondaryDisplay.setText(secondaryDisplay.getText() + "1/(" + value + ")");
                    advMathOpResult = 1/Double.parseDouble(value);
                    isAdvMathOp = true;
                    printResult(String.valueOf(advMathOpResult));
                }
                isResult = true;
            } else if (!primaryDisplay.textProperty().isEmpty().get()) {
                String value = primaryDisplay.getText();
                secondaryDisplay.setText(secondaryDisplay.getText() + "1/(" + value + ")");
                advMathOpResult = 1/Double.parseDouble(value);
                isAdvMathOp = true;
                printResult(String.valueOf(advMathOpResult));
            }
        });

        equals.setOnAction(event -> {
            if (isButtonsDisabled) {
                clearAll.arm();
                clearAll.fire();
                try {
                    Thread.sleep(100);
                } catch (InterruptedException ignored) {
                    clearAll.disarm();
                }
                clearAll.disarm();
            } else if (!primaryDisplay.textProperty().isEmpty().get() && !isResult) {
                String value = getValue();

                if (!secondaryDisplay.textProperty().isEmpty().get() && !isResult && !isEquals) {
                    secondaryDisplay.setText(secondaryDisplay.getText() + value + "=");
                    lastValue = Double.parseDouble(value);
                    calculate();
                    printResult(String.valueOf(result));
                    isResult = false;
                    isEquals = true;
                } else if (isEquals && !isResult) {
                    String resultStr = String.valueOf(result);
                    if (resultStr.contains(".")) {
                        int indexOfDecimal= resultStr.lastIndexOf(".");
                        String valueBeforeDecimal = resultStr.substring(0, indexOfDecimal);
                        String valueAfterDecimal = resultStr.substring(indexOfDecimal + 1);

                        if (valueAfterDecimal.matches("^0+$")) {
                            resultStr = valueBeforeDecimal;
                        }
                    }

                    String lastValueStr = String.valueOf(lastValue);
                    if (lastValueStr.contains(".")) {
                        int indexOfDecimal= lastValueStr.lastIndexOf(".");
                        String valueBeforeDecimal = lastValueStr.substring(0, indexOfDecimal);
                        String valueAfterDecimal = lastValueStr.substring(indexOfDecimal + 1);

                        if (valueAfterDecimal.matches("^0+$")) {
                            lastValueStr = valueBeforeDecimal;
                        }
                    }
                    secondaryDisplay.setText(resultStr + lastOperation + lastValueStr + "=");
                    calculate();
                    printResult(String.valueOf(result));
                    isResult = false;
                    isEquals = true;
                }
            } else {
                if (isAdvMathOp) {
                    secondaryDisplay.setText(secondaryDisplay.getText() + "=");
                    lastValue = advMathOpResult;
                } else {
                    String value = getValue();
                    secondaryDisplay.setText(secondaryDisplay.getText() + value + "=");
                    lastValue = result;
                }
                calculate();
                printResult(String.valueOf(result));
                isResult = false;
                isEquals = true;
            }
        });

        bindKeys();
    }

    private String getValue() {
        String value = primaryDisplay.getText();
        if(value.matches("^0+$")) {
            value = "0";
        } else if (value.contains(".")) {
            int indexOfDecimal= value.lastIndexOf(".");
            String valueBeforeDecimal = value.substring(0, indexOfDecimal);
            String valueAfterDecimal;
            if (indexOfDecimal == (value.length() - 1)) {
                valueAfterDecimal = "0";
            } else {
                valueAfterDecimal = value.substring(indexOfDecimal + 1);
            }
            if (valueBeforeDecimal.matches("^0+$") && valueAfterDecimal.matches("^0+$")) {
                value = "0.0";
            }
        }

        if (value.contains(".")) {
            int indexOfDecimal= value.lastIndexOf(".");
            String valueBeforeDecimal = value.substring(0, indexOfDecimal);
            String valueAfterDecimal;
            if (indexOfDecimal == (value.length() - 1)) {
                valueAfterDecimal = "0";
            } else {
                valueAfterDecimal = value.substring(indexOfDecimal + 1);
            }

            if (valueAfterDecimal.matches("^0+$")) {
                value = valueBeforeDecimal;
            }
        }

        if (value.contains("NaN") || value.contains("Infinity") || value.contains("INFINITY") || value.contains("Can't divide by zero!")) {
            value = "0";
        }

        return value;
    }

    private void calculate() {
        switch (lastOperation) {
            case "+":
                result = result + lastValue;
                break;
            case "-":
                result = result - lastValue;
                break;
            case "*":
                result = result * lastValue;
                break;
            case "/":
                result = result / lastValue;
        }
    }

    private void printResult(String resultStr) {
        if (resultStr.contains(".")) {
            int indexOfDecimal= resultStr.lastIndexOf(".");
            String valueBeforeDecimal = resultStr.substring(0, indexOfDecimal);
            String valueAfterDecimal = resultStr.substring(indexOfDecimal + 1);

            if (valueAfterDecimal.matches("^0+$")) {
                primaryDisplay.setText(valueBeforeDecimal);
            } else {
                primaryDisplay.setText(resultStr);
            }
        } else {
            if (resultStr.contains("NaN") || resultStr.contains("Infinity") || resultStr.contains("INFINITY")) {
                primaryDisplay.setText("Can't divide by zero!");
                disableButtons(true);
            } else {
                primaryDisplay.setText(resultStr);
            }
        }
    }

    private void disableButtons(boolean status) {
        plusMinus.setDisable(status);
        decimal.setDisable(status);
        add.setDisable(status);
        subtract.setDisable(status);
        multiply.setDisable(status);
        divide.setDisable(status);
        modulus.setDisable(status);
        oneX.setDisable(status);
        xSquare.setDisable(status);
        squareRoot.setDisable(status);
        isButtonsDisabled = status;
    }

    private void bindKeys() {
        base.setOnKeyPressed(event -> {
            KeyCode keyCode = event.getCode();

            if (keyCode.equals(KeyCode.DIGIT0) || keyCode.equals(KeyCode.NUMPAD0)) {
                fireButton(zero);
            } else if (keyCode.equals(KeyCode.DIGIT1) || keyCode.equals(KeyCode.NUMPAD1)) {
                fireButton(one);
            } else if (keyCode.equals(KeyCode.DIGIT2) || keyCode.equals(KeyCode.NUMPAD2)) {
                fireButton(two);
            } else if (keyCode.equals(KeyCode.DIGIT3) || keyCode.equals(KeyCode.NUMPAD3)) {
                fireButton(three);
            } else if (keyCode.equals(KeyCode.DIGIT4) || keyCode.equals(KeyCode.NUMPAD4)) {
                fireButton(four);
            } else if (keyCode.equals(KeyCode.DIGIT5) || keyCode.equals(KeyCode.NUMPAD5)) {
                fireButton(five);
            } else if (keyCode.equals(KeyCode.DIGIT6) || keyCode.equals(KeyCode.NUMPAD6)) {
                fireButton(six);
            } else if (keyCode.equals(KeyCode.DIGIT7) || keyCode.equals(KeyCode.NUMPAD7)) {
                fireButton(seven);
            } else if ((!event.isShiftDown() && keyCode.equals(KeyCode.DIGIT8)) || keyCode.equals(KeyCode.NUMPAD8)) {
                fireButton(eight);
            } else if (keyCode.equals(KeyCode.DIGIT9) || keyCode.equals(KeyCode.NUMPAD9)) {
                fireButton(nine);
            } else if (keyCode.equals(KeyCode.DECIMAL) || keyCode.equals(KeyCode.PERIOD)) {
                fireButton(decimal);
            } else if ((event.isShiftDown() && keyCode.equals(KeyCode.EQUALS)) || keyCode.equals(KeyCode.PLUS) || keyCode.equals(KeyCode.ADD)) {
                fireButton(add);
            }  else if (keyCode.equals(KeyCode.MINUS)) {
                fireButton(subtract);
            } else if ((event.isShiftDown() && keyCode.equals(KeyCode.DIGIT8)) || keyCode.equals(KeyCode.MULTIPLY)) {
                fireButton(multiply);
            } else if (keyCode.equals(KeyCode.DIVIDE) || keyCode.equals(KeyCode.SLASH)) {
                fireButton(divide);
            } else if (keyCode.equals(KeyCode.EQUALS) || keyCode.equals(KeyCode.ENTER)) {
                fireButton(equals);
            } else if (keyCode.equals(KeyCode.BACK_SPACE)) {
                fireButton(backspace);
            } else if (keyCode.equals(KeyCode.DELETE)) {
                fireButton(clearAll);
            }
        });
    }

    private void fireButton(JFXButton button) {
        button.arm();
        button.fire();
        try {
            Thread.sleep(100);
        } catch (InterruptedException ignored) {
        }
        button.disarm();
    }
}
