package com.rusinek.suszitest.controllers;

import com.rusinek.suszitest.services.LecturerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/lecturer")
public class LecturerController {

    private final LecturerService lecturerService;

    public LecturerController(LecturerService lecturerService) {
        this.lecturerService = lecturerService;
    }

    @RequestMapping("/list")
    public String getIndexPage(Model model) {
        model.addAttribute("lecturers",lecturerService.getLecturers());

        return "lecturer/lecturerlist";
    }
}
