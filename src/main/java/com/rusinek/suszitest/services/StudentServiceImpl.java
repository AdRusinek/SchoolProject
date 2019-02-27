package com.rusinek.suszitest.services;

import com.rusinek.suszitest.model.Lecturer;
import com.rusinek.suszitest.model.Student;
import com.rusinek.suszitest.repositories.LecturerRepository;
import com.rusinek.suszitest.repositories.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Slf4j
@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;
    private LecturerRepository lecturerRepository;

    public StudentServiceImpl(StudentRepository studentRepository, LecturerRepository lecturerRepository) {
        this.studentRepository = studentRepository;
        this.lecturerRepository = lecturerRepository;
    }

    @Override
    public Set<Student> getAllStudents() {
        Set<Student> students = new HashSet<>();

        studentRepository.findAll().forEach(students::add);

        return students;
    }

    @Override
    public void deleteStudent(Long id) {

        Optional<Student> studentOptional = studentRepository.findById(id);

        if (studentOptional.isPresent()) {
                studentRepository.deleteById(id);
        } else {
            log.debug("Cannot find student with id: " + id);
        }
    }
}
