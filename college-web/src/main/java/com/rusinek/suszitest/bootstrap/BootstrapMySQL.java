package com.rusinek.suszitest.bootstrap;

import com.rusinek.suszitest.model.*;
import com.rusinek.suszitest.repositories.LecturerRepository;
import com.rusinek.suszitest.repositories.MessageRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static com.rusinek.suszitest.enums.Title.DOCTOR;
import static com.rusinek.suszitest.enums.Title.MASTER_OF_ARTS;
import static com.rusinek.suszitest.enums.TypeOfClasses.*;
import static com.rusinek.suszitest.enums.TypeOfMessage.PRIORITY;

@Slf4j
@Component
@Profile({"dev","prod"})
public class BootstrapMySQL implements ApplicationListener<ContextRefreshedEvent> {

    private final LecturerRepository lecturerRepository;
    private final MessageRepository messageRepository;

    public BootstrapMySQL(LecturerRepository lecturerRepository, MessageRepository messageRepository) {
            this.lecturerRepository = lecturerRepository;
            this.messageRepository = messageRepository;
            }

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
            loadData();
            loadMessages();
            }

    private void loadMessages() {
            Message message = new Message();
            message.setMessage("Somethind ");
            message.setTypeOfMessage(PRIORITY);

            messageRepository.save(message);
            }

    private void loadData() {

        Lecturer valenta = new Lecturer();
        valenta.setFirstName("Marek");
        valenta.setLastName("Valenta");
        valenta.setDateOfBirth(LocalDate.of(1998,4,2));
        valenta.setNrPesel(8987678);
        valenta.setAcademicTitle(DOCTOR);
        valenta.setEmail("valentaMarek@gmail.com");

        Subject bazyWyklad = new Subject();
        bazyWyklad.setSubjectName("Bazy danych");
        bazyWyklad.setTypeOfClass(LECTURES);

        valenta.addSubject(bazyWyklad);

        Student rusinekAdrian = new Student();
        rusinekAdrian.setFirstName("Adrian");
        rusinekAdrian.setLastName("Rusinek");
        rusinekAdrian.setDateOfBirth(LocalDate.of(1998,7,12));
        rusinekAdrian.setNrPesel(867545364);
        rusinekAdrian.setEmail("rusinekAdrian19@gmail.com");

        Grade grade = new Grade("5");
        Grade grade1 = new Grade("4");
        List<Grade> listOfGrades = new ArrayList<>();
        listOfGrades.add(grade);
        listOfGrades.add(grade1);

        rusinekAdrian.setListOfGrades(listOfGrades);

        valenta.addStudent(rusinekAdrian);

        lecturerRepository.save(valenta);


        Lecturer jurczyk = new Lecturer();
        jurczyk.setFirstName("Tomasz");
        jurczyk.setLastName("Jurczyk");
        jurczyk.setDateOfBirth(LocalDate.of(1982,4,2));
        jurczyk.setNrPesel(32452334);
        jurczyk.setAcademicTitle(MASTER_OF_ARTS);
        jurczyk.setEmail("jurczykTomasz@gmail.com");

        Subject podstawyInformatykiCwiczenia = new Subject();
        podstawyInformatykiCwiczenia.setSubjectName("Podstawy Informatyki");
        podstawyInformatykiCwiczenia.setTypeOfClass(DISCUSSIONS);

        Subject podstawyInformatykiLaby = new Subject();
        podstawyInformatykiLaby.setSubjectName("Podstawy Informatyki");
        podstawyInformatykiLaby.setTypeOfClass(LABS);

        jurczyk.addSubject(podstawyInformatykiCwiczenia);
        jurczyk.addSubject(podstawyInformatykiLaby);

        Student dawidJurecki = new Student();
        dawidJurecki.setFirstName("Dawid");
        dawidJurecki.setLastName("Jurecki");
        dawidJurecki.setDateOfBirth(LocalDate.of(1997,2,12));
        dawidJurecki.setNrPesel(96343642);
        dawidJurecki.setEmail("jureckiDawid@gmail.com");

        Grade grade3 = new Grade("3");
        Grade grade4 = new Grade("3");
        List<Grade> listOfGrades1 = new ArrayList<>();
        listOfGrades1.add(grade3);
        listOfGrades1.add(grade4);

        dawidJurecki.setListOfGrades(listOfGrades1);

        jurczyk.addStudent(dawidJurecki);
        jurczyk.addStudent(rusinekAdrian);

        lecturerRepository.save(jurczyk);
        }
        }

