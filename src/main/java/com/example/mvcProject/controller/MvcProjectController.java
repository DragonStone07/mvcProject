package com.example.mvcProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.resource.HttpResource;

@Controller
public class MvcProjectController {

    @GetMapping("/hi")
    public String Hello(Model model){

        model.addAttribute("username","양용석");
        model.addAttribute("moveUrl","/bye");
        return "hello";
    }

    @GetMapping("/bye")
    public String Bye(Model model)
    {
        model.addAttribute("username","양용석");
        model.addAttribute("moveUrl","/hi");
        return "bye";
    }
}
