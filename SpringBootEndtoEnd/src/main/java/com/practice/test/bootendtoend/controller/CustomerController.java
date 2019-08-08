package com.practice.test.bootendtoend.controller;

import com.practice.test.bootendtoend.domain.Account;
import com.practice.test.bootendtoend.domain.Customer;
import com.practice.test.bootendtoend.service.AccountService;
import com.practice.test.bootendtoend.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/bank")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private AccountService accountService;

    @RequestMapping("/customerlist")
    public  String getAllCustomers(Model model){
        List<Customer> customers = customerService.getAllCustomers();
        model.addAttribute("customers", customers);
        return "customerlist";
    }
    @GetMapping("/accounts/registerNewCustomer")
    public  String getaddnewCustomerForm(Model model){
        List<Account> accounts=accountService.getAllAccounts();
        Customer customer= new Customer();
        model.addAttribute("customer",customer);
        model.addAttribute("accounts",accounts);
        return "addcustomer";
    }
    @PostMapping(value = {"/accounts/registerNewCustomer"})
    public String addNewCustomer(@Valid @ModelAttribute("customer") Customer cust,
                             BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "addcustomer";
        }
         customerService.saveCustomer(cust);
        return "redirect:/bank/customerlist";
    }
    @GetMapping(value = {"/customer/edit/{customerId}"})
    public String editBook(@PathVariable Long customerId, Model model) {
        Customer customer = customerService.getCustomerById(customerId);
        if (customer != null) {
            model.addAttribute("customer", customer);
            return "edit";
        }
        return "bank/customerlist";
    }
}
