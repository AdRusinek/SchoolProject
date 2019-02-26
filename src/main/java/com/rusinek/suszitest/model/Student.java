package com.rusinek.suszitest.model;


import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
public class Student extends Person{


    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Grade> listOfGrades;

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable
    private Set<Lecturer> lecturers = new HashSet<>();

    public List<Grade> getListOfGrades() {
        return listOfGrades;
    }

    public void setListOfGrades(List<Grade> listOfGrades) {
        this.listOfGrades = listOfGrades;
    }

    public Set<Lecturer> getLecturers() {
        return lecturers;
    }

    public void setLecturers(Set<Lecturer> lecturers) {
        this.lecturers = lecturers;
    }



    public void removeGrade(Grade grade) {
        listOfGrades.remove(grade);
    }
}
