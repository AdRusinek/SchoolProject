package com.rusinek.suszitest.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
public class Lecturer extends Person {

    public Lecturer(Long id, String firstName, String lastName) {
        super(id, firstName, lastName);
    }



    @Enumerated(value = EnumType.STRING)
    private Title academicTitle;

    @ManyToMany
    @JoinTable(name = "students_lecturers")
    private Set<Student> students;
}
