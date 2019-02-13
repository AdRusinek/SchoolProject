package com.rusinek.suszitest.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SubjectTest {

    Subject subject;

    @Before
    public void setUp() {
        subject = new Subject();
    }

    @Test
    public void getId() {
        Long idValue = 4l;
        subject.setId(idValue);

        assertEquals(idValue,subject.getId());
    }

    @Test
    public void getSubjectName() {
    }

    @Test
    public void getTypeOfClass() {
    }
}