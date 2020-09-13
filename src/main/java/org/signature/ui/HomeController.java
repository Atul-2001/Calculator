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
    private String lastOperation = "";
    private double result;
    private boolean isResult;
    private boolean isEquals;
    private boolean isButtonsDisabled;
    private double advMathOpResult;
    private boolean isAdvMathOp;
    private boolean isModulus;

    public void initialize() {
        Platform.runLater(() -> equals.requestFocus());
        equals.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) {
                equals.requestFocus();
            }
        });

        zero.setOnAction(event -> {
            String value = primaryDisplay.getText();
            if (value.length() < 16 || ((value.contains("-") || value.contains(".")) && value.replaceAll("[\\-|\\.]", "").length() <= 16)) {
                if (isResult || isEquals) {
                    primaryDisplay.setText("0");
                    if (isEquals) secondaryDisplay.setText("");
                    isResult = false;
                    isEquals = false;

                    if (isButtonsDisabled) {
                        disableButtons(false);
                    }

                    if (isAdvMathOp) {
                        try {
                            String currentValue = secondaryDisplay.getText();
                            String modifiedValue = currentValue.substring(0, currentValue.lastIndexOf(lastOperation)+1);
                            secondaryDisplay.setText(modifiedValue);
                        } catch (Exception ignored) {}
                        isAdvMathOp = false;
                    }
                } else {
                    if (value.matches("^0+$")) {
                        primaryDisplay.setText("0");
                    } else {
                        primaryDisplay.setText(value + "0");
                    }
                }
            }
        });

        one.setOnAction(event -> printDigit(1));
        two.setOnAction(event -> printDigit(2));
        three.setOnAction(event -> printDigit(3));
        four.setOnAction(event -> printDigit(4));
        five.setOnAction(event -> printDigit(5));
        six.setOnAction(event -> printDigit(6));
        seven.setOnAction(event -> printDigit(7));
        eight.setOnAction(event -> printDigit(8));
        nine.setOnAction(event -> printDigit(9));

        decimal.setOnAction(event -> {
            if (primaryDisplay.textProperty().isEmpty().get() || isResult || isEquals) {
                primaryDisplay.setText("0.");
                if (isEquals) secondaryDisplay.setText("");

                if (isAdvMathOp && (isResult || isEquals)) {
                    try {
                        String currentValue = secondaryDisplay.getText();
                        String modifiedValue = currentValue.substring(0, currentValue.lastIndexOf(lastOperation)+1);
                        secondaryDisplay.setText(modifiedValue);
                    } catch (Exception ignored) {}
                    isAdvMathOp = false;
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
            isEquals = false;
            isAdvMathOp = false;
            advMathOpResult = 0.0;
            isModulus = false;
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
            isEquals = false;
            isAdvMathOp = false;
            advMathOpResult = 0.0;
            isModulus = false;
            if (isButtonsDisabled) {
                disableButtons(false);
                isButtonsDisabled = false;
            }
        });

        add.setOnAction(event -> performOperation(Operator.ADD));
        subtract.setOnAction(event -> performOperation(Operator.SUBTRACT));
        multiply.setOnAction(event -> performOperation(Operator.MULTIPLY));
        divide.setOnAction(event -> performOperation(Operator.DIVIDE));

        modulus.setOnAction(event -> {
            if (!primaryDisplay.textProperty().isEmpty().get() && (!isResult || isEquals)) {
                String value = getValue();

                if (secondaryDisplay.textProperty().isEmpty().get() || isEquals) {
                    if (lastOperation.isEmpty()) result = 0.0;
                    result = calculatePercentage(Double.parseDouble(value));
                    String resultStr = String.valueOf(result);
                    if (resultStr.contains(".")) {
                        int indexOfDecimal= resultStr.lastIndexOf(".");
                        String valueBeforeDecimal = resultStr.substring(0, indexOfDecimal);
                        String valueAfterDecimal = resultStr.substring(indexOfDecimal + 1);

                        if (valueAfterDecimal.matches("^0+$")) {
                            secondaryDisplay.setText(valueBeforeDecimal);
                        } else {
                            secondaryDisplay.setText(resultStr);
                        }
                    }
                    lastOperation = "";
                    printResult(String.valueOf(result));
                    isEquals = true;
                } else {
                    advMathOpResult = calculatePercentage(Double.parseDouble(value));

                    if (isAdvMathOp) {
                        String currentValue = secondaryDisplay.getText();
                        int indexOfLastAdvMathOp = currentValue.lastIndexOf(lastOperation);
                        String beforeAdvMathOp = currentValue.substring(0, indexOfLastAdvMathOp + 1);

                        String resultStr = String.valueOf(advMathOpResult);
                        if (resultStr.contains(".")) {
                            int indexOfDecimal= resultStr.lastIndexOf(".");
                            String valueBeforeDecimal = resultStr.substring(0, indexOfDecimal);
                            String valueAfterDecimal = resultStr.substring(indexOfDecimal + 1);

                            String formattedValue;
                            if (valueAfterDecimal.matches("^0+$")) {
                                formattedValue = beforeAdvMathOp + valueBeforeDecimal;
                            } else {
                                formattedValue = beforeAdvMathOp + resultStr;
                            }
                            secondaryDisplay.setText(formattedValue);
                        }
                    } else {
                        String resultStr = String.valueOf(advMathOpResult);
                        if (resultStr.contains(".")) {
                            int indexOfDecimal= resultStr.lastIndexOf(".");
                            String valueBeforeDecimal = resultStr.substring(0, indexOfDecimal);
                            String valueAfterDecimal = resultStr.substring(indexOfDecimal + 1);

                            if (valueAfterDecimal.matches("^0+$")) {
                                secondaryDisplay.setText(secondaryDisplay.getText() + valueBeforeDecimal);
                            } else {
                                secondaryDisplay.setText(secondaryDisplay.getText() + resultStr);
                            }
                        }
                    }

                    isAdvMathOp = true;
                    printResult(String.valueOf(advMathOpResult));
                }
                isResult = true;
                isModulus = true;
            } else if (!primaryDisplay.textProperty().isEmpty().get()){
                String value = primaryDisplay.getText();
                advMathOpResult = calculatePercentage(Double.parseDouble(value));

                if (isAdvMathOp) {
                    String currentValue = secondaryDisplay.getText();
                    int indexOfLastAdvMathOp = currentValue.lastIndexOf(lastOperation);
                    String beforeAdvMathOp = currentValue.substring(0, indexOfLastAdvMathOp + 1);
                    String formattedValue = beforeAdvMathOp + advMathOpResult;
                    secondaryDisplay.setText(formattedValue);
                } else {
                    secondaryDisplay.setText(secondaryDisplay.getText() + advMathOpResult);
                }

                isAdvMathOp = true;
                printResult(String.valueOf(advMathOpResult));
                isModulus = true;
            }
        });

        oneX.setOnAction(event -> performAdvOperation(Operator.ONE_BY_X));
        xSquare.setOnAction(event -> performAdvOperation(Operator.X_SQUARE));
        squareRoot.setOnAction(event -> performAdvOperation(Operator.SQUARE_ROOT));

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

    private void printDigit(int digit) {
        String value = primaryDisplay.getText();
        if (value.length() < 16 || ((value.contains("-") || value.contains(".")) && value.replaceAll("[\\-|\\.]", "").length() <= 16)) {
            if (primaryDisplay.getText().matches("^0+$") || isResult || isEquals) {
                primaryDisplay.setText(String.valueOf(digit));
                if (isEquals) secondaryDisplay.setText("");

                if (isButtonsDisabled) {
                    disableButtons(false);
                }

                if (isAdvMathOp && (isResult || isEquals)) {
                    try {
                        String currentValue = secondaryDisplay.getText();
                        String modifiedValue = currentValue.substring(0, currentValue.lastIndexOf(lastOperation)+1);
                        secondaryDisplay.setText(modifiedValue);
                    } catch (Exception ignored) {}
                    isAdvMathOp = false;
                }

                isResult = false;
                isEquals = false;
            } else {
                primaryDisplay.setText(value + digit);
            }
        }
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

    private void performOperation(Operator operator) {
        if (!primaryDisplay.textProperty().isEmpty().get() && !isResult) {
            String value = getValue();

            if (operator.equals(Operator.DIVIDE)) {
                if (secondaryDisplay.textProperty().isEmpty().get() || isEquals) {
                    secondaryDisplay.setText(value + operator);
                    result = Double.parseDouble(value);
                    lastOperation = operator.toString();
                } else {
                    lastValue = Double.parseDouble(value);
                    if (lastValue == 0 || lastValue == 0.0) {
                        primaryDisplay.setText("Can't divide by zero!");
                        lastValue = result;
                        disableButtons(true);
                    } else {
                        secondaryDisplay.setText(secondaryDisplay.getText() + value + operator);
                        calculate();
                        printResult(String.valueOf(result));
                        lastOperation = operator.toString();
                    }
                }
            } else {
                if (secondaryDisplay.textProperty().isEmpty().get() || isEquals) {
                    secondaryDisplay.setText(value + operator);
                    result = Double.parseDouble(value);
                } else {
                    secondaryDisplay.setText(secondaryDisplay.getText() + value + operator);
                    lastValue = Double.parseDouble(value);
                    calculate();
                    printResult(String.valueOf(result));
                }
                lastOperation = operator.toString();
            }
            isResult = true;
        } else if (!secondaryDisplay.getText().isEmpty()) {
            String currentValue = secondaryDisplay.getText();

            String modifiedValue = "";
            if (operator.equals(Operator.ADD)) {
                modifiedValue = currentValue.replaceAll("[\u2212|\u00D7|\u00F7]$", "\u002B").replaceAll("\\)$", ")\u002B");
                if (isModulus) {
                    modifiedValue = modifiedValue + "\u002B";
                    isModulus = false;
                }
            } else if (operator.equals(Operator.SUBTRACT)) {
                modifiedValue = currentValue.replaceAll("[\u002B|\u00D7|\u00F7]$", "\u2212").replaceAll("\\)$", ")\u2212");
                if (isModulus) {
                    modifiedValue = modifiedValue + "\u2212";
                    isModulus = false;
                }
            } else if (operator.equals(Operator.MULTIPLY)) {
                modifiedValue = currentValue.replaceAll("[\u002B|\u2212|\u00F7]$", "\u00D7").replaceAll("\\)$", ")\u00D7");
                if (isModulus) {
                    modifiedValue = modifiedValue + "\u00D7";
                    isModulus = false;
                }
            } else if (operator.equals(Operator.DIVIDE)) {
                modifiedValue = currentValue.replaceAll("[\u002B|\u2212|\u00D7]$", "\u00F7").replaceAll("\\)$", ")\u00F7");
                if (isModulus) {
                    modifiedValue = modifiedValue + "\u00F7";
                    isModulus = false;
                }
            }

            secondaryDisplay.setText(modifiedValue);
            if (isAdvMathOp) {
                if (lastOperation.isEmpty()) {
                    result = advMathOpResult;
                } else {
                    lastValue = advMathOpResult;
                }
                calculate();
                printResult(String.valueOf(result));
                isAdvMathOp = false;
            }
            lastOperation = operator.toString();
        }
        isEquals = false;
    }

    private void calculate() {
        if (lastOperation != null) {
            switch (lastOperation) {
                case "\u002B":
                    result = result + lastValue;
                    break;
                case "\u2212":
                    result = result - lastValue;
                    break;
                case "\u00D7":
                    result = result * lastValue;
                    break;
                case "\u00F7":
                    result = result / lastValue;
            }
        }
    }

    private double calculatePercentage(double value) {
        if (lastOperation.equals(Operator.MULTIPLY.toString()) || lastOperation.equals(Operator.DIVIDE.toString())) {
            return (value / 100);
        } else if (lastOperation.equals(Operator.ADD.toString()) || lastOperation.equals(Operator.SUBTRACT.toString())){
            return ((result / 100) * value);
        } else {
            return 0.0;
        }
    }

    private void performAdvOperation(Operator operator) {
        if (!primaryDisplay.textProperty().isEmpty().get() && !isResult) {
            String value = getValue();

            if (secondaryDisplay.textProperty().isEmpty().get() || isEquals) {
                secondaryDisplay.setText(operator + "(" + value + ")");
                
                if (operator.equals(Operator.ONE_BY_X)) {
                    result = 1/Double.parseDouble(value);
                } else if (operator.equals(Operator.X_SQUARE)) {
                    result = Math.pow(Double.parseDouble(value), 2);
                } else if (operator.equals(Operator.SQUARE_ROOT)) {
                    result = Math.sqrt(Double.parseDouble(value));
                }
                
                lastOperation = "";
                printResult(String.valueOf(result));
                isEquals = true;
            } else {
                secondaryDisplay.setText(secondaryDisplay.getText() + operator +  "(" + value + ")");
                if (operator.equals(Operator.ONE_BY_X)) {
                    advMathOpResult = 1/Double.parseDouble(value);
                } else if (operator.equals(Operator.X_SQUARE)) {
                    advMathOpResult = Math.pow(Double.parseDouble(value), 2);
                } else if (operator.equals(Operator.SQUARE_ROOT)) {
                    advMathOpResult = Math.sqrt(Double.parseDouble(value));
                }
                isAdvMathOp = true;
                printResult(String.valueOf(advMathOpResult));
            }
            isResult = true;
        } else if (!primaryDisplay.textProperty().isEmpty().get()) {
            String value = primaryDisplay.getText();
            if(isEquals) {
                String currentValue = secondaryDisplay.getText();
                String formattedValue = operator + "(" + currentValue + ")";
                secondaryDisplay.setText(formattedValue);
            } else if (isAdvMathOp) {
                String currentValue = secondaryDisplay.getText();
                int indexOfLastAdvMathOp = currentValue.lastIndexOf(lastOperation);
                String beforeAdvMathOp = currentValue.substring(0, indexOfLastAdvMathOp + 1);
                String lastAdvMathOp = currentValue.substring(indexOfLastAdvMathOp + 1);
                String formattedValue = beforeAdvMathOp + operator + "(" + lastAdvMathOp + ")";
                secondaryDisplay.setText(formattedValue);
            } else {
                secondaryDisplay.setText(secondaryDisplay.getText() + operator + "(" + value + ")");
            }
            if (operator.equals(Operator.ONE_BY_X)) {
                advMathOpResult = 1/Double.parseDouble(value);
            } else if (operator.equals(Operator.X_SQUARE)) {
                advMathOpResult = Math.pow(Double.parseDouble(value), 2);
            } else if (operator.equals(Operator.SQUARE_ROOT)) {
                advMathOpResult = Math.sqrt(Double.parseDouble(value));
            }
            isAdvMathOp = true;
            printResult(String.valueOf(advMathOpResult));
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
            } else if ((!event.isShiftDown() && keyCode.equals(KeyCode.DIGIT5)) || keyCode.equals(KeyCode.NUMPAD5)) {
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
            } else if ((event.isShiftDown() && keyCode.equals(KeyCode.DIGIT5))) {
                fireButton(modulus);
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
