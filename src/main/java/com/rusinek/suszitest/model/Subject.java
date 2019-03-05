package com.rusinek.suszitest.model;

import com.rusinek.suszitest.enums.TypeOfClasses;

import javax.persistence.*;

@Entity
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String subjectName;

    @ManyToOne
    private Lecturer lecturer;

    @Enumerated(value = EnumType.STRING)
    private TypeOfClasses typeOfClass;

    @Override
    public String toString() {
        return subjectName + " | " + typeOfClass;
    }

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

    public Lecturer getLecturer() {
        return lecturer;
    }

    public void setLecturer(Lecturer lecturer) {
        this.lecturer = lecturer;
    }
}
