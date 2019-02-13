package com.rusinek.suszitest.controllers;

import com.rusinek.suszitest.services.LecturerService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;


import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

public class IndexControllerTest {

    @Mock
    LecturerService lecturerService;
    @Mock
    Model model;

    IndexController indexController;


    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        indexController = new IndexController(lecturerService);
    }

    @Test
    public void getIndexPage() {

        String viewName = indexController.getIndexPage(model);

        assertEquals("index",viewName);
        verify(lecturerService, times(1)).getLecturers();
        verify(model,times(1)).addAttribute(eq("lecteurers"),anySet());
    }
}