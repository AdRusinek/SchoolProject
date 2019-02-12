package com.rusinek.suszitest.bootstrap;

import com.rusinek.suszitest.model.*;
import com.rusinek.suszitest.repositories.LecturerRepository;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class DataLoader implements ApplicationListener<ContextRefreshedEvent> {

    private final LecturerRepository lecturerRepository;

    public DataLoader(LecturerRepository lecturerRepository) {
        this.lecturerRepository = lecturerRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

    }

    private List<Lecturer> getLecturers() {

        List<Subject> valentaSubjects = new ArrayList<>();
        Subject databasesLectures = new Subject("Bazy danych", TypeOfClasses.LECTURES);
        valentaSubjects.add(databasesLectures);

        List<Subject> mrajcanSubjects = new ArrayList<>();
        Subject databasesLabs = new Subject("Bazy danych", TypeOfClasses.LABS);
        mrajcanSubjects.add(databasesLabs);

        List<Subject> kowalskaMusialSubjects = new ArrayList<>();
        Subject economicLectures = new Subject("Ekonomia",TypeOfClasses.LECTURES);
        kowalskaMusialSubjects.add(economicLectures);

        List<Subject> zbigniewTarnawskiSubjects = new ArrayList<>();
        Subject physicsForItSpecialistsLectures = new Subject("Fizyka dla informatyków",TypeOfClasses.LECTURES);
        Subject physicsForItSpecialistsDiscussions = new Subject("Fizyka dla informatyków",TypeOfClasses.DISCUSSIONS);
        zbigniewTarnawskiSubjects.add(physicsForItSpecialistsLectures);
        zbigniewTarnawskiSubjects.add(physicsForItSpecialistsDiscussions);

        List<Subject> hoaKimNganNhuTarnawskaSubjects = new ArrayList<>();
        Subject physicsForItSpecialistsLabs = new Subject("Fizyka dla informatyków",TypeOfClasses.LABS);
        hoaKimNganNhuTarnawskaSubjects.add(physicsForItSpecialistsLabs);

        List<Subject> agnieszkaWcisloSubjects = new ArrayList<>();
        Subject managementInformatics = new Subject("Informatyka Zarządcza",TypeOfClasses.DISCUSSIONS);
        agnieszkaWcisloSubjects.add(managementInformatics);

        List<Subject> donataJaworskaGlodSubjects = new ArrayList<>();
        Subject english = new Subject("Język Angielski",TypeOfClasses.DISCUSSIONS);
        donataJaworskaGlodSubjects.add(english);

        List<Subject> januszMajewskiSubjects = new ArrayList<>();
        Subject probabilisticMethodsAndStatisticsLectures = new Subject("Metody probabilistyczne i statystyka",TypeOfClasses.LECTURES);
        Subject probabilisticMethodsAndStatisticsDiscussions = new Subject("Metody probabilistyczne i statystyka",TypeOfClasses.DISCUSSIONS);
        januszMajewskiSubjects.add(probabilisticMethodsAndStatisticsLectures);
        januszMajewskiSubjects.add(probabilisticMethodsAndStatisticsDiscussions);

        List<Subject> beataBasiuraSubjects = new ArrayList<>();
        Subject probabilisticMethodsAndStatisticsLabs = new Subject("Metody probabilistyczne i statystyka",TypeOfClasses.LABS);
        beataBasiuraSubjects.add(probabilisticMethodsAndStatisticsLabs);

        List<Subject> monikaDeksterSubjects = new ArrayList<>();
        Subject javaProgrammingLectures = new Subject("Programowanie w języku Java",TypeOfClasses.LECTURES);
        Subject javaProgrammingLabs = new Subject("Programowanie w języku Java",TypeOfClasses.LABS);
        monikaDeksterSubjects.add(javaProgrammingLectures);
        monikaDeksterSubjects.add(javaProgrammingLabs);



        List<Grade> rusinekGrades = new ArrayList<>();
        rusinekGrades.add(new Grade("5",databasesLectures));
        rusinekGrades.add(new Grade("4.5",databasesLabs));
        rusinekGrades.add(new Grade("5",economicLectures));
        rusinekGrades.add(new Grade("4.5",physicsForItSpecialistsLectures));

        Set<Student> students2018 = new HashSet<>();
        Student Rusinek = new Student(999999999,LocalDate.of(1998,7,12),"Adrian","Rusinek",)




        valentaSubjects.add(databasesLectures);

        Lecturer lecturer = new Lecturer(98072019, LocalDate.of(1960,7,12),"Marek","Valenta",valentaSubjects
        ,Title.DOCTOR,)
    }
}
