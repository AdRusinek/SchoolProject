package com.rusinek.suszitest.model;


import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "lecturers")
public class Lecturer extends Person {

    public Lecturer() { }

    public Lecturer(String firstName, String lastName, Title academicTitle, Set<Student> students) {
        super(firstName, lastName);
        this.academicTitle = academicTitle;
        this.students = students;
    }

    @Column(name = "list_of_subjects")
    @ElementCollection(targetClass = Subject.class)
    private List<Subject> listOfSubjects;

    @Column(name = "academic_title")
    @Enumerated(value = EnumType.STRING)
    private Title academicTitle;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "students_lecturers",joinColumns = @JoinColumn(name = "lecturer_id"),
               inverseJoinColumns = @JoinColumn(name = "student_id"))
    private Set<Student> students;


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
}
