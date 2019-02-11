package com.rusinek.suszitest.model;

import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.util.Set;

public class Lecturer extends Person {

    public Lecturer(Long id, String firstName, String lastName) {
        super(id, firstName, lastName);
    }


    @ManyToMany
    @JoinTable(name = "students_lecturers")
    private Set<Student> students;
}
