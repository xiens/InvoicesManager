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

    @GetMapping("/index")
    public String GetIndex() {
        return "index";
    }

}
