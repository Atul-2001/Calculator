package org.signature.model;

public class Equation {
    private String equation;
    private String result ;
    private String lastOperation;
    private String lastValue;

    public Equation(String equation, String result, String lastOperation, String lastValue) {
        this.equation = equation;
        this.result = result;
        this.lastOperation = lastOperation;
        this.lastValue = lastValue;
    }

    public String getEquation() {
        return equation;
    }

    public void setEquation(String equation) {
        this.equation = equation;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getLastOperation() {
        return lastOperation;
    }

    public void setLastOperation(String lastOperation) {
        this.lastOperation = lastOperation;
    }

    public String getLastValue() {
        return lastValue;
    }

    public void setLastValue(String lastValue) {
        this.lastValue = lastValue;
    }
}
