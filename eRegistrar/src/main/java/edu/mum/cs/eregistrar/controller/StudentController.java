package edu.mum.cs.eregistrar.controller;

import edu.mum.cs.eregistrar.domain.Student;
import edu.mum.cs.eregistrar.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping("/eregistrar")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping(value = {"/student/list"})
    public ModelAndView getAllStudents(@RequestParam(defaultValue = "0") int pageno) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("students", studentService.getAllStudentByPagesByPage(pageno));
        modelAndView.addObject("currentPage",pageno);
        modelAndView.setViewName("studentlist");
        return modelAndView;
    }

    @GetMapping(value = {"/student/registration"})
    public String displayNewBookForm(Model model) {
        model.addAttribute("student", new Student());
        return "registrationForm";
    }
    @PostMapping(value = {"/student/registration"})
    public String registerNewStudent(@Valid @ModelAttribute("student") Student student,
                             BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "registrationForm";
        }
        studentService.saveStudent(student);
        return "redirect:/student/list";
    }
}
