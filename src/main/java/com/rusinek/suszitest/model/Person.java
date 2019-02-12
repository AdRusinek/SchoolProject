package com.rusinek.suszitest.model;

import javax.persistence.*;
import java.io.Serializable;

@MappedSuperclass
public class Person implements Serializable {

    public Person() {
    }

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String lastName;


}
