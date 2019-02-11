package com.rusinek.suszitest.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

public class Person {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String lastName;


}
