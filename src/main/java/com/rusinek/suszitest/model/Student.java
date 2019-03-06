package com.rusinek.suszitest.model;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Student extends Person{


    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Grade> listOfGrades;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable
    private Set<Lecturer> lecturers = new HashSet<>();


    @OneToMany(cascade = CascadeType.ALL)
    private List<Message> listOfMessages = new ArrayList();

    public List<Grade> getListOfGrades() {
        return listOfGrades;
    }

    public List<Message> getListOfMessages() {
        return listOfMessages;
    }

    public void setListOfMessages(List<Message> listOfMessages) {
        this.listOfMessages = listOfMessages;
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
