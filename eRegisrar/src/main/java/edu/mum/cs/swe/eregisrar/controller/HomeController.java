package edu.mum.cs.swe.eregisrar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/eRegistrar")
public class HomeController {

    @GetMapping
    public String displayPage(){
        return "RegistrationHome";
    }
}
