package com.rusinek.suszitest.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.ManyToMany;
import java.time.LocalDate;
import java.util.Set;

@Data
@EqualsAndHashCode(callSuper = true)
public class Student extends Person{


    public Student(Long id, String firstName, String lastName, LocalDate dateOfBirth,
                   Integer nrPesel, Set<Lecturer> lecturers) {
        super(id, firstName, lastName);
        this.dateOfBirth = dateOfBirth;
        this.nrPesel = nrPesel;
        this.lecturers = lecturers;
    }

    private LocalDate dateOfBirth;

    private Integer nrPesel;

    @ManyToMany
    private Set<Lecturer> lecturers;
}
