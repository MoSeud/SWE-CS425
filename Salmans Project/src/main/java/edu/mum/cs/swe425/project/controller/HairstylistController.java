package edu.mum.cs.swe425.project.controller;

import edu.mum.cs.swe425.project.domain.Seat;
import edu.mum.cs.swe425.project.domain.User;
import edu.mum.cs.swe425.project.service.HairStyleService;
import edu.mum.cs.swe425.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.time.LocalDate;
@Controller
public class HairstylistController {

    private UserService userService;
    private HairStyleService hairStyleService;
    @Autowired
    public HairstylistController(UserService userService, HairStyleService hairStyleService) {
        this.userService=userService;
        this.hairStyleService=hairStyleService;
    }

    @GetMapping(value = {"/salmans/admin/add_hairstyle"})
    public String getRegisterCustomerForm(Model model) {
        model.addAttribute("barber", new User());
        model.addAttribute("now", LocalDate.now());
        return "newbarber";
    }

    @PostMapping(value = {"/salmans/admin/add_hairstyle"})
    public String registerNewCustomer(@Valid @ModelAttribute("barber") User barber,
                                      BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "newbarber";
        }
        Seat seat=new Seat(23);
        barber.setSeat(seat);
        userService.saveCustomer(barber);
        return "redirect:/salmans/hairstylist/dashboard";
    }
    @GetMapping(value = {"/salmans/hairstylist/dashboard"})
    public ModelAndView barberDashboard(@RequestParam("seatno") Integer seatno) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("customers", hairStyleService.getAllCustomersWithSeatNumber(seatno));
        modelAndView.addObject("now", LocalDate.now());
        modelAndView.setViewName("Hdashboard");
        return modelAndView;
    }
}
