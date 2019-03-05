package com.rusinek.suszitest.converters;

import com.rusinek.suszitest.commands.StudentCommand;
import com.rusinek.suszitest.model.Student;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class StudentToStudentCommandTest {


    public static final Long ID = 2L;
    public static final String FIRST_NAME = "Adrian";
    public static final String LAST_NAME = "Ktosiek";
    public static final Integer PESEL = 999;
    public static final LocalDate DATE_OF_BIRTH = LocalDate.of(1998,01,01);



    StudentToStudentCommand converter;


    @Before
    public void setUp() throws Exception {
        converter = new StudentToStudentCommand();
    }

    @Test
    public void testNullConvert() throws Exception {
        assertNull(converter.convert(null));
    }

    @Test
    public void convert() {

        Student student = new Student();
        student.setId(ID);
        student.setFirstName(FIRST_NAME);
        student.setLastName(LAST_NAME);
        student.setNrPesel(PESEL);
        student.setDateOfBirth(DATE_OF_BIRTH);

        StudentCommand command = converter.convert(student);

        assertEquals(ID,command.getId());
        assertEquals(FIRST_NAME,command.getFirstName());
        assertEquals(LAST_NAME,command.getLastName());
        assertEquals(PESEL,command.getNrPesel());
        assertEquals(DATE_OF_BIRTH,command.getDateOfBirth());

    }
}