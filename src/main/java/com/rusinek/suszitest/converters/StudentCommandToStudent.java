package com.rusinek.suszitest.converters;

import com.rusinek.suszitest.commands.StudentCommand;
import com.rusinek.suszitest.model.Student;
import com.rusinek.suszitest.repositories.StudentRepository;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class StudentCommandToStudent implements Converter<StudentCommand, Student> {

    private final StudentRepository studentRepository;

    public StudentCommandToStudent(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    @Synchronized
    @Nullable
    public Student convert(StudentCommand source) {
        if(source == null) {
            return null;
        }

        final Student student = new Student();
        student.setId(source.getId());
        student.setFirstName(source.getFirstName());
        student.setLastName(source.getLastName());
        student.setNrPesel(source.getNrPesel());
        student.setDateOfBirth(source.getDateOfBirth());

        return student;
    }
}
