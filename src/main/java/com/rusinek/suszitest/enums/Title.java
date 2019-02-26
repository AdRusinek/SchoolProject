package com.rusinek.suszitest.enums;

public enum Title {


    ENGINEER ("Inżynier"),

    MASTER_OF_ARTS ("Magister"),

    DOCTOR ("Doktor"),

    PROFESSOR ("Profesor");

    private final String title;

    private Title(String s) {
        title = s;
    }

    public String toString() {
        return this.title;
    }
}
