/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author M Umair Malik
 */
//used  to interact with model                               //model to interact   //primary key
public interface UserRepository extends JpaRepository< UserModel , Integer>
{ 
    
    
}
