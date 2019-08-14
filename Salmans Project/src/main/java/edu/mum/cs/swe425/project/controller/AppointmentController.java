package edu.mum.cs.swe425.project.controller;

import edu.mum.cs.swe425.project.domain.Review;
import edu.mum.cs.swe425.project.domain.User;
import edu.mum.cs.swe425.project.service.ReviewService;
import edu.mum.cs.swe425.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.time.LocalDate;
@Controller
public class AppointmentController {


    private UserService userService;
  private ReviewService reviewService;
    @Autowired
    public AppointmentController(UserService userService,ReviewService reviewService) {

        this.userService = userService;
        this.reviewService=reviewService;
    }

    @GetMapping(value = {"/salmans/signup"})
    public String getRegisterCustomerForm(Model model) {
        model.addAttribute("customer", new User());
        model.addAttribute("now", LocalDate.now());
        return "registerCustomer";
    }

    @PostMapping(value = {"/salmans/signup"})
    public String registerNewCustomer(@Valid @ModelAttribute("customer") User customer,
                                      BindingResult bindingResult, Model model) {
        User existing = userService.findByEmail(customer.getEmail());
        if (existing != null) {
            bindingResult.rejectValue("email", null, "There is already an account registered with that email");
        }
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "registerCustomer";
        }
        userService.saveCustomer(customer);
        return "redirect:/salmans/customer/dashboard";
    }

    @GetMapping(value = {"/salmans/customer/dashboard"})
    public ModelAndView customerDashBoard() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("customers", userService.getAllCustomers());
        modelAndView.addObject("now", LocalDate.now());
        modelAndView.setViewName("dashboard");
        return modelAndView;
    }

    @GetMapping(value = {"/salmans/customer/addreview"})
    public String getCustomersReviewForm(Model model) {
        model.addAttribute("review", new Review());
        model.addAttribute("now", LocalDate.now());
        return "addreview";
    }

    @PostMapping(value = {"/salmans/customer/addreview"})
    public String getAllCustomersReview(@Valid @ModelAttribute("review") Review review,
                                        BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "addreview";
        }
        reviewService.saveReview(review);
        return "redirect:/salmans/customer/viewReview";
    }
    @GetMapping(value = {"/salmans/customer/viewReview"})
    public ModelAndView getAllReviews() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("reviews", reviewService.getAllReviews());
        modelAndView.addObject("now", LocalDate.now());
        modelAndView.setViewName("review");
        return modelAndView;
    }
}