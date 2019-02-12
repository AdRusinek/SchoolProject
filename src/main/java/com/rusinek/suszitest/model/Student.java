package com.rusinek.suszitest.model;


import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Entity
@Table(name = "students")
public class Student extends Person{

    public Student() {
    }

    public Student(String firstName, String lastName, List<Grade> listOfGrades,
                   Map<TypeOfClasses, Subject> studentClasses, LocalDate dateOfBirth, Integer nrPesel) {
        super(firstName, lastName);
        this.listOfGrades = listOfGrades;
        this.studentClasses = studentClasses;
        this.dateOfBirth = dateOfBirth;
        this.nrPesel = nrPesel;
    }

    @Column(name = "list_of_grades")
    @ElementCollection(targetClass = Grade.class)
    @OneToMany
    private List<Grade> listOfGrades;

    @ElementCollection
    @JoinTable(name = "student_classes",joinColumns = @JoinColumn(name = "id"))
    @MapKeyEnumerated(EnumType.STRING)
    @MapKeyColumn(name = "type_of_classes")
    @Column(name = "subject")
    private Map<TypeOfClasses,Subject> studentClasses;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @Column(name = "nr_pesel")
    private Integer nrPesel;

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Integer getNrPesel() {
        return nrPesel;
    }

    public void setNrPesel(Integer nrPesel) {
        this.nrPesel = nrPesel;
    }

}
