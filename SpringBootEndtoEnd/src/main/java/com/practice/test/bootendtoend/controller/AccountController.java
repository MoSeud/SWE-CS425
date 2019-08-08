package com.practice.test.bootendtoend.controller;

import com.practice.test.bootendtoend.domain.Account;
import com.practice.test.bootendtoend.domain.Customer;
import com.practice.test.bootendtoend.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/bank")
public class AccountController {

    private AccountService accountService;
@Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/accountlist")
    public String getAccountList(Model model){
    model.addAttribute("accounts",accountService.getAllAccounts());
    return "accountlist";
   }

   @GetMapping("/accounts/addnewaccount")
    public  String getAddAccountForm(Model model){
    model.addAttribute("account", new Account());
    return "addaccounts";
   }
   @PostMapping("/accounts/addnewaccount")
   public String addNewCustomer(@Valid @ModelAttribute("account") Account account,
                                BindingResult bindingResult, Model model) {
       if (bindingResult.hasErrors()) {
           model.addAttribute("errors", bindingResult.getAllErrors());
           return "addaccounts";
       }
       accountService.saveAccount(account);
       return "redirect:/bank/accountlist";
   }
}
