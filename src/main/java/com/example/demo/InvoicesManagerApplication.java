package com.example.demo;

import com.example.demo.model.Company;
import com.example.demo.model.Contractor;
import com.example.demo.repo.CompanyRepository;
import com.example.demo.repo.ContractorRepository;
import com.example.demo.repo.InvoiceRepository;
import com.example.demo.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;

@SpringBootApplication
public class InvoicesManagerApplication implements CommandLineRunner {

    @Autowired
    UserRepository userRepository;

    @Autowired
    CompanyRepository companyRepository;

    @Autowired
    ContractorRepository contractorRepository;

    @Autowired
    InvoiceRepository invoiceRepository;

    public static void main(String[] args) {
        SpringApplication.run(InvoicesManagerApplication.class, args);
    }

    @Override
    public void run(String... arg0) throws Exception {
        
        userRepository.deleteAll();
        companyRepository.deleteAll();
        contractorRepository.deleteAll();
        Company c1 = new Company("Czipsy");
        Company c2 = new Company("Buty");
        Company c3 = new Company("Meble");
        companyRepository.save(c1);
        companyRepository.save(c2);
        companyRepository.save(c3);

        contractorRepository.save(new Contractor("Pringles", c1));
        contractorRepository.save(new Contractor("Lays", c1));

        contractorRepository.save(new Contractor("Circa", c2));
        contractorRepository.save(new Contractor("DC", c2));
        contractorRepository.save(new Contractor("es", c2));

        contractorRepository.save(new Contractor("Ikea", c3));
        contractorRepository.save(new Contractor("Agata", c3));
        contractorRepository.save(new Contractor("Obi", c3));
        contractorRepository.save(new Contractor("GoodFurniture", c3));

    }
}
