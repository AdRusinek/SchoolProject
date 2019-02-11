package com.rusinek.suszitest.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.ManyToMany;
import java.util.Map;
import java.util.Set;

@Getter
@Setter
public class Student extends Person{


    public Student(Long id, String firstName, String lastName) {
        super(id, firstName, lastName);
    }

    @ManyToMany
    private Set<Lecturer> lecturers;
}
