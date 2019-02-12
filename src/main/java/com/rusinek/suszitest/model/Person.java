package com.rusinek.suszitest.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@MappedSuperclass
public class Person implements Serializable {

    public Person() {
    }

    public Person(Integer nrPesel, LocalDate dateOfBirth, String firstName, String lastName) {
        this.nrPesel = nrPesel;
        this.dateOfBirth = dateOfBirth;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer nrPesel;

    private LocalDate dateOfBirth;

    private String firstName;

    private String lastName;

    public Integer getNrPesel() {
        return nrPesel;
    }

    public void setNrPesel(Integer nrPesel) {
        this.nrPesel = nrPesel;
    }

    public LocalDate getLocalDate() {
        return dateOfBirth;
    }

    public void setLocalDate(LocalDate localDate) {
        this.dateOfBirth = localDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
