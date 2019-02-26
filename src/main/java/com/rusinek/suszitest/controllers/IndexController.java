package com.rusinek.suszitest.controllers;

import com.rusinek.suszitest.services.LecturerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

        @RequestMapping({"","/","/index"})
        public String getIndexPage() {
            return "index";
        }
}
