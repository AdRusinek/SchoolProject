package com.rusinek.suszitest.services;

import com.rusinek.suszitest.model.Student;

import java.util.Set;

public interface StudentService  {

    Set<Student> getAllStudents();

    void deleteStudent(Long id);
}
