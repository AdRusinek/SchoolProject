package com.rusinek.suszitest.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "students")
public class Student extends Person{

    public Student() {
    }

    public Student (String firstName, String lastName, LocalDate dateOfBirth,
                   Integer nrPesel) {
        super(firstName, lastName);
        this.dateOfBirth = dateOfBirth;
        this.nrPesel = nrPesel;
    }


    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @Column(name = "nr_pesel")
    private Integer nrPesel;

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Integer getNrPesel() {
        return nrPesel;
    }

    public void setNrPesel(Integer nrPesel) {
        this.nrPesel = nrPesel;
    }

}
