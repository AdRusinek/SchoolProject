package com.rusinek.suszitest.controllers;

import com.rusinek.suszitest.commands.StudentCommand;
import com.rusinek.suszitest.model.Student;
import com.rusinek.suszitest.services.StudentService;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

@ExtendWith(MockitoExtension.class)
public class StudentControllerTest {

    private static final Long STUDENT_ID = 1L;

    @Mock
    StudentService studentService;

    StudentController studentController;

    MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        studentController = new StudentController(studentService);
        mockMvc = MockMvcBuilders.standaloneSetup(studentController).build();
    }

    @Test
    public void testGetStudent() throws Exception {

        Student student = new Student();
        student.setId(STUDENT_ID);

        when(studentService.getStudent(anyLong())).thenReturn(student);

        mockMvc.perform(get("/student/1/show"))
                .andExpect(status().isOk())
                .andExpect(view().name("student/showstudent"))
                .andExpect(model().attributeExists("retrivedStudent"));
    }

    @Test
    public void testGetAllStudents() throws Exception {
        Set<Student> students = new HashSet<>();
        Student student = new Student();
        students.add(student);

        when(studentService.getAllStudents()).thenReturn(students);

        mockMvc.perform(get("/student/list"))
                .andExpect(status().isOk())
                .andExpect(view().name("student/studentlist"))
                .andExpect(model().attributeExists("studentList"));

        assertEquals(students.size(),1);
    }

    @Test
    public void testDeleteStudent() throws Exception {

        mockMvc.perform(get("/student/1/delete"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/student/list"));

            verify(studentService, times(1)).deleteStudent(anyLong());
    }


    @Test
    public void testNewStudent() throws Exception {

        mockMvc.perform(get("/student/new"))
                .andExpect(status().isOk())
                .andExpect(view().name("student/studentform"))
                .andExpect(model().attributeExists("student"));
    }

    @Test
    public void testSaveOrUpdate() throws Exception {
        StudentCommand command = new StudentCommand();
        command.setId(STUDENT_ID);

        when(studentService.saveStudentCommand(any())).thenReturn(command);

        mockMvc.perform(post("/student/new")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("id","")
                .param("firstName","somthing"))

                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/student/list"));

    }
}