package com.rusinek.suszitest.enums;

public enum  TypeOfClasses {

    LECTURES ("Wykłady"),  //WYKLADY

    DISCUSSIONS ("Ćwiczenia"), //CWICZENIA

    LABS ("Laboratoria");

    private final String typeOfClasses;

    private TypeOfClasses(String s) {
        typeOfClasses = s;
    }

    public String toString() {
        return this.typeOfClasses;
    }
}
