package com.rusinek.suszitest.services;

import com.rusinek.suszitest.commands.StudentCommand;
import com.rusinek.suszitest.converters.StudentCommandToStudent;
import com.rusinek.suszitest.converters.StudentToStudentCommand;
import com.rusinek.suszitest.model.Student;
import com.rusinek.suszitest.repositories.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Slf4j
@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;
    private StudentToStudentCommand studentToStudentCommand;
    private StudentCommandToStudent studentCommandToStudent;

    public StudentServiceImpl(StudentRepository studentRepository, StudentToStudentCommand studentToStudentCommand,
                              StudentCommandToStudent studentCommandToStudent) {
        this.studentRepository = studentRepository;
        this.studentToStudentCommand = studentToStudentCommand;
        this.studentCommandToStudent = studentCommandToStudent;
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

    @Override
    public Student getStudent(Long id) {
       Optional<Student> studentOptional = studentRepository.findById(id);
       if(!studentOptional.isPresent()) {
           log.info("Can't find student with id: " + id);
       }
       return studentOptional.get();
    }

    @Override
    @Transactional
    public StudentCommand saveStudentCommand(StudentCommand command) {
        Student detachedStudent = studentCommandToStudent.convert(command);

        Student savedStudent = studentRepository.save(detachedStudent);
        log.info("Saved student with id " + command.getId());
        return studentToStudentCommand.convert(savedStudent);
    }
}
