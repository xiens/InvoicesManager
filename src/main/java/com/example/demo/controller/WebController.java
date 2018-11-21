/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.controller;

/**
 *
 * @author xiens
 */
import com.example.demo.model.Company;
import com.example.demo.model.Invoice;
import com.example.demo.model.User;
import com.example.demo.repo.CompanyRepository;
import com.example.demo.repo.ContractorRepository;
import com.example.demo.repo.InvoiceRepository;
import com.example.demo.repo.UserRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WebController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    CompanyRepository companyRepository;

    @Autowired
    ContractorRepository contractorRepository;

    @Autowired
    InvoiceRepository invoiceRepository;

    
    @GetMapping("/users")
    public String userForm(Model model) {
        model.addAttribute("userlist", userRepository.findAll());
        model.addAttribute("user", new User());
        return "users";
    }

    @PostMapping("/users")
    public String userSubmit(@ModelAttribute User user, Model model) {
        userRepository.save(user);
        model.addAttribute("userlist", userRepository.findAll());
        return "users";
    }

    @GetMapping("/invoices")
    public String invoiceForm(Model model) {
        model.addAttribute("invoiceslist", invoiceRepository.findAll());
        model.addAttribute("invoice", new Invoice());
        return "invoices";
    }

    @PostMapping("/invoices")
    public String invoiceSubmit(@ModelAttribute Invoice invoice, Model model) {
        invoiceRepository.save(invoice);
        model.addAttribute("invoiceslist", invoiceRepository.findAll());
        return "invoices";
    }

    @GetMapping("/companies")
    public String companyForm(Model model) {
        model.addAttribute("companieslist", companyRepository.findAll());
        return "companies";
    }

    @GetMapping("/index")
    public String GetIndex() {
        return "index";
    }

    @PostMapping("/save")
    public String saveUser(User user) {
        userRepository.save(user);
        return "redirect:/";
    }

    @GetMapping("/delete")
    public String deleteUser(Long userId) {
        userRepository.deleteById(userId);
        return "redirect:/";
    }

    @GetMapping("/findOne")
    public Optional<User> findByUserId(Long userId) {
        return userRepository.findById(userId);
    }

    @RequestMapping("/save")
    public String process() {
        // save a single User
        userRepository.save(new User("Jack", "Smith"));
        userRepository.save(new User("Adam", "Johnson"));
        userRepository.save(new User("Bro", "Johnson"));
        userRepository.save(new User("OO Long", "Johnson"));
        userRepository.save(new User("Evan", "Smith"));

        return "Done";
    }

    @RequestMapping("/findbyid")
    public String findById(@RequestParam("id") long id) {
        String result = "";
        result = userRepository.findById(id).toString();
        return result;
    }

}
