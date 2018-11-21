/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.repo;

import com.example.demo.model.Company;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author xiens
 */
public interface CompanyRepository extends CrudRepository<Company, Long> {
    
}
