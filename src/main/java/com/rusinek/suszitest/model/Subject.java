package com.rusinek.suszitest.model;

import javax.persistence.*;

@Entity
public class Subject {

    public Subject(String subjectName, TypeOfClasses typeOfClass) {
        this.subjectName = subjectName;
        this.typeOfClass = typeOfClass;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "subject_name")
    private String subjectName;

    @Column(name = "type_off_class")
    private TypeOfClasses typeOfClass;

}
