package com.rusinek.suszitest.controllers;

import com.rusinek.suszitest.commands.StudentCommand;
import com.rusinek.suszitest.model.Student;
import com.rusinek.suszitest.repositories.StudentRepository;
import com.rusinek.suszitest.services.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@RequestMapping("/student")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }


    @RequestMapping("/{id}/show")
    public String getStudent(@PathVariable Long id, Model model) {
        model.addAttribute("retrivedStudent",studentService.getStudent(id));
        return "student/showstudent";
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

    @RequestMapping("/new")
    public String newStudent(Model model) {
        model.addAttribute("student", new StudentCommand());

        return "student/studentform";
    }


    //@RequestMapping(name = "student", method = RequestMethod.POST) starszy sposob
    @PostMapping("/student/new")
    public String saveOrUpdate(@ModelAttribute("student") StudentCommand command) {
        StudentCommand savedCommand = studentService.saveStudentCommand(command);

        return "redirect:/student/list";
    }
}
