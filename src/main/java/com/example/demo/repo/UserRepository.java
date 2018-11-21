/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.repo;

import com.example.demo.model.User;
import java.util.ArrayList;
import java.util.List;
import org.springframework.data.repository.CrudRepository;


/**
 *
 * @author xiens
 */

public interface UserRepository extends CrudRepository<User, Long> {
    
    //List<User> findByLastName(String lastName);
    
//    public void save(List<User> asList);
//
//    public Object findOne(long id);



}
