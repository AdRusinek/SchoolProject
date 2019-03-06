package com.rusinek.suszitest.enums;

public enum  TypeOfMessage {

    ORDINARY ("Zwykła"),

    PRIORITY ("Priorytetowa");

    private final String typeOfMessage;

     TypeOfMessage(String s) {
        typeOfMessage = s;
    }

    @Override
    public String toString() {
        return this.typeOfMessage;
    }
}
