package com.rusinek.suszitest.model;


import com.rusinek.suszitest.enums.Title;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Lecturer extends Person {

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Subject> subjects = new ArrayList<>();

    @Enumerated(value = EnumType.STRING)
    private Title academicTitle;

    @ManyToMany(mappedBy = "lecturers", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<Student> students = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sender", orphanRemoval = true)
    private List<Message> messages;

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public Title getAcademicTitle() {
        return academicTitle;
    }

    public void setAcademicTitle(Title academicTitle) {
        this.academicTitle = academicTitle;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }



    public void addStudent(Student student) {
        students.add(student);
        student.getLecturers().add(this);
    }

    public void removeStudent(Student student) {
        students.remove(student);
        student.getLecturers().remove(this);
    }

    public void addSubject(Subject subject) {
        subjects.add(subject);
        subject.setLecturer(this);
    }

    public void removeSubject(Subject subject) {
        subjects.remove(subject);
        subject.setLecturer(null);
    }
}
