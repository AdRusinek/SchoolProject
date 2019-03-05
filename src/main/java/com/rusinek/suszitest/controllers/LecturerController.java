package com.rusinek.suszitest.controllers;

import com.rusinek.suszitest.model.Lecturer;
import com.rusinek.suszitest.services.LecturerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
//@RequestMapping("/lecturer")
public class LecturerController {

    private final LecturerService lecturerService;

    public LecturerController(LecturerService lecturerService) {
        this.lecturerService = lecturerService;
    }

    @RequestMapping("/lecturer/list")
    public String getIndexPage(Model model) {
        model.addAttribute("lecturers",lecturerService.getLecturers());

        return "lecturer/lecturerlist";
    }

    @RequestMapping("/lecturer/show/{id}")
    public String showLecturer(@PathVariable Long id, Model model) {
        model.addAttribute("retrivedLecturer",lecturerService.findById(id));

        return "lecturer/showlecturer";
    }

    @GetMapping("/lecturer/find")
    public String findLecturer(Model model) {
        model.addAttribute("lecturer", new Lecturer());
        return "lecturer/lecturerfind";
    }


    @GetMapping
    public String processFindForm(Lecturer lecturer, BindingResult bindingResult, Model model) {
        if (lecturer.getLastName() == null) {
            lecturer.setLastName("");
        }

        List<Lecturer> lecturers = lecturerService.findAllByLastNameLike(lecturer.getLastName());

        if (lecturers.isEmpty()) {
            bindingResult.rejectValue("lastName", "notFound", "not found");
            return "lecturer/lecturerfind";
        } else if (lecturers.size() == 1) {
            lecturer = lecturers.get(0);
            return "redirect:/lecturer/show/" + lecturer.getId();
        }
        else {
            model.addAttribute("lecturers", lecturers);
            return "lecturer/lecturerlist";
        }
    }

}



