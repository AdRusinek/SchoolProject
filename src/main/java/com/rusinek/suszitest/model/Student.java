package com.rusinek.suszitest.model;


import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "students")
public class Student extends Person{

    public Student() {
    }

    public Student(Integer nrPesel, LocalDate localDate, String firstName, String lastName,
                   List<Grade> listOfGrades) {
        super(nrPesel, localDate, firstName, lastName);
        this.listOfGrades = listOfGrades;
    }

    @Column(name = "list_of_grades")
    @ElementCollection(targetClass = Grade.class)
    @OneToMany(cascade = CascadeType.ALL)
    private List<Grade> listOfGrades;

//    @ElementCollection
//    @JoinTable(name = "student_classes",joinColumns = @JoinColumn(name = "id"))
//    @MapKeyEnumerated(EnumType.STRING)
//    @MapKeyColumn(name = "type_of_classes")
//    @Column(name = "subject")
//    private Map<TypeOfClasses,Subject> studentClasses;


    public List<Grade> getListOfGrades() {
        return listOfGrades;
    }

    public void setListOfGrades(List<Grade> listOfGrades) {
        this.listOfGrades = listOfGrades;
    }
}
