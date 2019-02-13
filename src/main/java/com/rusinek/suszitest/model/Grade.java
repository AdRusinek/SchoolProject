package com.rusinek.suszitest.model;

import javax.persistence.*;

@Entity
public class Grade {

    public Grade(String grade) {
        this.grade = grade;
    }

    public Grade(String grade, Subject subject) {
        this.grade = grade;
        this.subject = subject;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "subject_id")
    private Subject subject;

    @Column(name = "grade")
    private String grade;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
