package com.rusinek.suszitest.controllers;

import com.rusinek.suszitest.model.Lecturer;
import com.rusinek.suszitest.services.LecturerService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;


import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;


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
    public void testMockMVC() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(indexController).build();

        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("index"));
    }

    @Test
    public void getIndexPage() {

        //given
        Set<Lecturer> lecturers = new HashSet<>();
        lecturers.add(new Lecturer());
        lecturers.add(new Lecturer());

        when(lecturerService.getLecturers()).thenReturn(lecturers);

        ArgumentCaptor<Set<Lecturer>> argumentCaptor = ArgumentCaptor.forClass(Set.class);

        //when
        String viewName = indexController.getIndexPage(model);


        //then
        assertEquals("index",viewName);
        verify(lecturerService, times(1)).getLecturers();
        verify(model,times(1)).addAttribute(eq("lecteurers"),argumentCaptor.capture());
        Set<Lecturer> setInController = argumentCaptor.getValue();
        assertEquals(2,setInController.size());
    }
}