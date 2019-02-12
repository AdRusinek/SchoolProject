package com.rusinek.suszitest.bootstrap;

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
        getLecturers();
    }

    private void getLecturers() {

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

//============================================================================================================

        List<Grade> rusinekGrades = new ArrayList<>();
        rusinekGrades.add(new Grade("5",databasesLectures));
        rusinekGrades.add(new Grade("4.5",databasesLabs));
        rusinekGrades.add(new Grade("5",economicLectures));
        rusinekGrades.add(new Grade("4.5",physicsForItSpecialistsLectures));
        rusinekGrades.add(new Grade("5",physicsForItSpecialistsDiscussions));
        rusinekGrades.add(new Grade("4",physicsForItSpecialistsLabs));
        rusinekGrades.add(new Grade("3.5",managementInformatics));
        rusinekGrades.add(new Grade("4.5",english));
        rusinekGrades.add(new Grade("5",probabilisticMethodsAndStatisticsLectures));
        rusinekGrades.add(new Grade("4",probabilisticMethodsAndStatisticsDiscussions));
        rusinekGrades.add(new Grade("5",probabilisticMethodsAndStatisticsLabs));
        rusinekGrades.add(new Grade("5",javaProgrammingLectures));
        rusinekGrades.add(new Grade("5",javaProgrammingLabs));

        List<Grade> jureckiGrades = new ArrayList<>();
        jureckiGrades.add(new Grade("4.5",databasesLectures));
        jureckiGrades.add(new Grade("3",databasesLabs));
        jureckiGrades.add(new Grade("4",economicLectures));
        jureckiGrades.add(new Grade("5",physicsForItSpecialistsLectures));
        jureckiGrades.add(new Grade("5",physicsForItSpecialistsDiscussions));
        jureckiGrades.add(new Grade("3",physicsForItSpecialistsLabs));
        jureckiGrades.add(new Grade("4.5",managementInformatics));
        jureckiGrades.add(new Grade("4.5",english));
        jureckiGrades.add(new Grade("4",probabilisticMethodsAndStatisticsLectures));
        jureckiGrades.add(new Grade("2",probabilisticMethodsAndStatisticsDiscussions));
        jureckiGrades.add(new Grade("5",probabilisticMethodsAndStatisticsLabs));
        jureckiGrades.add(new Grade("3",javaProgrammingLectures));
        jureckiGrades.add(new Grade("5",javaProgrammingLabs));

        List<Grade> podsiadloGrades = new ArrayList<>();
        podsiadloGrades.add(new Grade("3.5",databasesLectures));
        podsiadloGrades.add(new Grade("4",databasesLabs));
        podsiadloGrades.add(new Grade("3.5",economicLectures));
        podsiadloGrades.add(new Grade("4",physicsForItSpecialistsLectures));
        podsiadloGrades.add(new Grade("4.5",physicsForItSpecialistsDiscussions));
        podsiadloGrades.add(new Grade("3.5",physicsForItSpecialistsLabs));
        podsiadloGrades.add(new Grade("4",managementInformatics));
        podsiadloGrades.add(new Grade("5",english));
        podsiadloGrades.add(new Grade("4",probabilisticMethodsAndStatisticsLectures));
        podsiadloGrades.add(new Grade("3",probabilisticMethodsAndStatisticsDiscussions));
        podsiadloGrades.add(new Grade("4",probabilisticMethodsAndStatisticsLabs));
        podsiadloGrades.add(new Grade("5",javaProgrammingLectures));
        podsiadloGrades.add(new Grade("3.5",javaProgrammingLabs));

        Set<Student> students2018 = new HashSet<>();
        Student adrianRusinek = new Student(999999999,LocalDate.of(1998,7,12),"Adrian","Rusinek",rusinekGrades);
        studentRepository.save(adrianRusinek);
        Student dawidJurecki = new Student(888888888,LocalDate.of(1997,4,14),"Dawid","Jurecki",jureckiGrades);
        studentRepository.save(dawidJurecki);
        Student michalPodsiadlo = new Student(777777777,LocalDate.of(1998,3,23),"Michał","Podsiadło",podsiadloGrades);
        studentRepository.save(michalPodsiadlo);

        students2018.add(adrianRusinek);
        students2018.add(dawidJurecki);
        students2018.add(michalPodsiadlo);


        Lecturer valentaLecturer = new Lecturer(980720196, LocalDate.of(1960,7,12),"Marek","Valenta",
        valentaSubjects, Title.DOCTOR,students2018);
        lecturerRepository.save(valentaLecturer);

        Lecturer marcjanLecteurer = new Lecturer(734829882,LocalDate.of(1980,5,15),"Robert","Marcjan",
        mrajcanSubjects,Title.DOCTOR,students2018);
        lecturerRepository.save(marcjanLecteurer);

        Lecturer kowalskaMusial = new Lecturer(892432778,LocalDate.of(1981,12,29),"Magdalena","Kowalska-Musiał",
        kowalskaMusialSubjects,Title.DOCTOR,students2018);
        lecturerRepository.save(kowalskaMusial);

        Lecturer zbigniewTarnawski = new Lecturer(834124821,LocalDate.of(1970,8,22),"Zbigniew","Tarnawski",
        zbigniewTarnawskiSubjects,Title.DOCTOR_OF_SCIENCE,students2018);
        lecturerRepository.save(zbigniewTarnawski);

        Lecturer hoaKimNganNhuTarnawska = new Lecturer(234642887,LocalDate.of(1970,12,12),"Hoa Kim Ngan","Nhu-Tarnawska",
        hoaKimNganNhuTarnawskaSubjects,Title.DOCTOR_OF_SCIENCE,students2018);
        lecturerRepository.save(hoaKimNganNhuTarnawska);

        Lecturer agnieszkaWcislo = new Lecturer(884523341,LocalDate.of(1983,3,24),"Agnieszka","Wcisło",
        agnieszkaWcisloSubjects,Title.DOCTOR,students2018);
        lecturerRepository.save(agnieszkaWcislo);

        Lecturer donataJaworskaGlod = new Lecturer(993832122,LocalDate.of(1973,7,30),"Donata","Jaworska-Głód",
        donataJaworskaGlodSubjects,Title.MASTER_OF_ARTS,students2018);
        lecturerRepository.save(donataJaworskaGlod);

        Lecturer januszMajewski = new Lecturer(865456756,LocalDate.of(1966,5,23),"Janusz","Majewski",
        januszMajewskiSubjects,Title.DOCTOR,students2018);
        lecturerRepository.save(januszMajewski);

        Lecturer beataBasiura = new Lecturer(889992475,LocalDate.of(1986,9,23),"Beata","Basiura",
        beataBasiuraSubjects,Title.DOCTOR,students2018);
        lecturerRepository.save(beataBasiura);

        Lecturer monikaDekster = new Lecturer(773532333,LocalDate.of(1972,9,20),"Monika","Dekster",
        monikaDeksterSubjects, Title.DOCTOR,students2018);
        lecturerRepository.save(monikaDekster);
    }
}
