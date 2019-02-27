package com.rusinek.suszitest.controllers;

import com.rusinek.suszitest.model.Student;
import com.rusinek.suszitest.repositories.StudentRepository;
import com.rusinek.suszitest.services.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/student")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @RequestMapping("/list")
    public String getAllStudents(Model model) {
        model.addAttribute("studentList",studentService.getAllStudents());
        return "student/studentlist";
    }


    @RequestMapping("/{studentId}/delete")
    public String deleteStudent(@PathVariable Long studentId) {
        log.info("Deleting student");
        studentService.deleteStudent(studentId);

        return "redirect:/student/list";
    }
}
