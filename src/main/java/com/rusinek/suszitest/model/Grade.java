package com.rusinek.suszitest.model;

import javax.persistence.*;

@Entity
public class Grade {

    public Grade(String grade) {
        this.grade = grade;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

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
