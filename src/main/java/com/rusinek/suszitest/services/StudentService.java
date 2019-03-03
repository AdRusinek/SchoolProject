package com.rusinek.suszitest.services;

import com.rusinek.suszitest.commands.StudentCommand;
import com.rusinek.suszitest.model.Student;

import java.util.Set;
import java.util.Optional;

public interface StudentService  {

    Student getStudent(Long id);

    Set<Student> getAllStudents();

    void deleteStudent(Long id);

    StudentCommand saveStudentCommand(StudentCommand command);
}
