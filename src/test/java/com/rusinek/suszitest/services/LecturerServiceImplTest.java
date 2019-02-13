package com.rusinek.suszitest.services;

import com.rusinek.suszitest.model.Lecturer;
import com.rusinek.suszitest.repositories.LecturerRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class LecturerServiceImplTest {

    LecturerServiceImpl lecturerService;

    @Mock
    LecturerRepository lecturerRepository;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        lecturerService = new LecturerServiceImpl(lecturerRepository);
    }

    @Test
    public void getLecturers() {

        Lecturer lecturer = new Lecturer();
        HashSet lecturerData = new HashSet();
        lecturerData.add(lecturer);

        when(lecturerService.getLecturers()).thenReturn(lecturerData);

        Set<Lecturer> lecturers = lecturerService.getLecturers();

        assertEquals(lecturers.size(),1);

        verify(lecturerRepository,times(1)).findAll();
    }
}