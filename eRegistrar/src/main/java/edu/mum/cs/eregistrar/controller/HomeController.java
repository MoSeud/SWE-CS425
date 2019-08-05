package edu.mum.cs.eregistrar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/eregistrar")
public class HomeController {

    @GetMapping(value={"home"})
    public String homepage(){
        return "home";
    }
}
