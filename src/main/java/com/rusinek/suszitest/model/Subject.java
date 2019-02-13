package com.rusinek.suszitest.model;

import javax.persistence.*;

@Entity
public class Subject {

    public Subject() { }

    public Subject(String subjectName, TypeOfClasses typeOfClass) {
        this.subjectName = subjectName;
        this.typeOfClass = typeOfClass;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "subject_name")
    private String subjectName;

    @Enumerated(value = EnumType.STRING)
    private TypeOfClasses typeOfClass;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public TypeOfClasses getTypeOfClass() {
        return typeOfClass;
    }

    public void setTypeOfClass(TypeOfClasses  typeOfClass) {
        this.typeOfClass = typeOfClass;
    }
}
