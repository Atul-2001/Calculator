package org.signature.ui;

public enum Operator {

    ADD("\u002B"),

    SUBTRACT("\u2212"),

    MULTIPLY("\u00D7"),

    DIVIDE("\u00F7"),

    ONE_BY_X("1/"),

    X_SQUARE("sqr"),

    SQUARE_ROOT("\u221A");

    private final String value;

    Operator(String s) {
        this.value = s;
    }

    @Override
    public String toString() {
        return value;
    }
}
