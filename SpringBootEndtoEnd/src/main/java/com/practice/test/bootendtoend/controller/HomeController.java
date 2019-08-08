package com.practice.test.bootendtoend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/bank")
public class HomeController {


    @GetMapping(value = {"/home","/"})
    public  String displayHome(){
        return "home";
    }
}
