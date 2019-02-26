package com.rusinek.suszitest.bootstrap;

import com.rusinek.suszitest.enums.Title;
import com.rusinek.suszitest.enums.TypeOfClasses;
import com.rusinek.suszitest.model.*;
import com.rusinek.suszitest.repositories.LecturerRepository;

import com.rusinek.suszitest.repositories.StudentRepository;
import com.rusinek.suszitest.repositories.SubjectRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.*;

import static com.rusinek.suszitest.enums.Title.DOCTOR;
import static com.rusinek.suszitest.enums.TypeOfClasses.LECTURES;

@Component
public class DataLoader implements ApplicationListener<ContextRefreshedEvent> {

    private final LecturerRepository lecturerRepository;
    private final SubjectRepository subjectRepository;
    private final StudentRepository studentRepository;

    public DataLoader(LecturerRepository lecturerRepository, SubjectRepository subjectRepository,
                      StudentRepository studentRepository) {
        this.lecturerRepository = lecturerRepository;
        this.subjectRepository = subjectRepository;
        this.studentRepository = studentRepository;
    }

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        loadData();
    }

    private void loadData() {
        Lecturer valenta = new Lecturer();
        valenta.setFirstName("Marek");
        valenta.setLastName("Valenta");
        valenta.setDateOfBirth(LocalDate.of(1998,4,2));
        valenta.setNrPesel(8987678);
        valenta.setAcademicTitle(DOCTOR);

        Subject bazyWyklad = new Subject();
        bazyWyklad.setSubjectName("Bazy danych");
        bazyWyklad.setTypeOfClass(LECTURES);

        valenta.addSubject(bazyWyklad);

        Student rusinekAdrian = new Student();
        rusinekAdrian.setFirstName("Adrian");
        rusinekAdrian.setLastName("Rusinek");
        rusinekAdrian.setDateOfBirth(LocalDate.of(1998,7,12));
        rusinekAdrian.setNrPesel(867545364);

        Grade grade = new Grade("5");
        Grade grade1 = new Grade("4");
        List<Grade> listOfGrades = new ArrayList<>();
        listOfGrades.add(grade);
        listOfGrades.add(grade1);

        rusinekAdrian.setListOfGrades(listOfGrades);

        valenta.addStudent(rusinekAdrian);

        lecturerRepository.save(valenta);
    }
}
