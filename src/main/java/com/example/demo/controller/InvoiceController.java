/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.controller;

import com.example.demo.model.Invoice;
import com.example.demo.repo.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author xiens
 */
@Controller
public class InvoiceController {

    @Autowired
    InvoiceRepository invoiceRepository;

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
}
