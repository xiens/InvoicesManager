/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.controller;

import com.example.demo.repo.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author xiens
 */
@Controller
public class CompanyController {

    @Autowired
    CompanyRepository companyRepository;

    @GetMapping("/companies")
    public String companyForm(Model model) {
        model.addAttribute("companieslist", companyRepository.findAll());
        return "companies";
    }
}
