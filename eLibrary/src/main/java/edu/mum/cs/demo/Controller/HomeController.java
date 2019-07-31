package edu.mum.cs.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/eLibrary")
public class HomeController {

    @GetMapping("/home")
    public String displayPage(){
        return "home";
    }
    @GetMapping("/about")
    public String aboutElibrary(){
        return "about";
    }
}
