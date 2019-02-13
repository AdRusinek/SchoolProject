package com.rusinek.suszitest.controllers;

import com.rusinek.suszitest.services.LecturerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    private final LecturerService lecturerService;

    public IndexController(LecturerService lecturerService) {
        this.lecturerService = lecturerService;
    }

    @RequestMapping({"","/","/index"})
    public String getIndexPage(Model model) {
        model.addAttribute("lecteurers",lecturerService.getLecturers());

        return "index";
    }
}
