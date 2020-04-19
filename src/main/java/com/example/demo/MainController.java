/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author M Umair Malik
 */
@RestController
@RequestMapping(path = "/employee")
public class MainController {
    
    @Autowired
    UserService employeeService;
    
    @RequestMapping("/")
    public String greeting()
    {
        return "Welcome to spring boot demo";
    }
     
    @GetMapping("/list")
    public List<UserModel> getEmployees()
    {
        List<UserModel> employeeList= employeeService.getEmployee();
        System.out.println(employeeList.get(0).name);
        return employeeList;
  
    }
    
    @PostMapping("/signup")
    public String createEmployee(@RequestBody UserModel employeeList )
    {
        System.out.println("Object is recieved "+employeeList);
        UserModel employeeModel=employeeService.createEmployee(employeeList);
        return "User "+ employeeModel.name+ " is created with id " + employeeModel.id;

    }
    @PutMapping("/login")
    public String loginEmployee(@RequestBody UserModel employeeList )
    {
       System.out.println("Object is recieved of id "+employeeList.id);
         UserModel employeeModel=employeeService.loginEmployee(employeeList);
        if(employeeModel!=null)
        {
            return "User "+ employeeModel.name+ " is signed in.";
        }
        return "Failed to logging in of your provided deteail of user";
    }
     @PutMapping("/update")
    public String updateEmployee(@RequestBody UserModel employeeList )
    {
       System.out.println("Object is recieved of id "+employeeList.id);
         UserModel employeeModel=employeeService.updateEmployee(employeeList);
        if(employeeModel!=null)
        {
            return "User "+ employeeModel.name+ "'s details updated";
        }
        return "Failed to updating in of your provided deteail of user";
    }
    @GetMapping("/details")
    public String detailEmployee(@RequestBody UserModel employeeList )
    {
       System.out.println("Object is recieved of id "+employeeList.id);
       UserModel employeeModel=employeeService.detailEmployee(employeeList);
        if(employeeModel!=null)
        {
            return "User id: "+ employeeModel.id+ "\nUsername is:"+ employeeModel.name+ "\nGender:"+ employeeModel.gender+"\nDOB:" +employeeModel.dob;
        }
        return "Failed to getting provided details of user or you are off-line";
    }
    @DeleteMapping("/delete")
    public String deleteEmployee(@RequestBody UserModel employeeList )
    {
       System.out.println("Object is recieved of id "+employeeList.id);
       return employeeService.deleteEmployee(employeeList);
       
    } 
    @PutMapping("/logout")
    public String logoutEmployee(@RequestBody UserModel employeeList )
    {
        System.out.println("Object is recieved of id "+employeeList.id);
        UserModel employeeModel=employeeService.logoutEmployee(employeeList);
        if(employeeModel!=null)
        {
            return "User "+ employeeModel.name+ " is logged out.";
        }
        return "Failed to logging out of your provided deteail of user";
    }
    @PutMapping("/password")
    public String changePassword(@RequestBody UserModel employeeList )
    {
        System.out.println("Object is recieved of id "+employeeList.id);
        UserModel employeeModel=employeeService.changePassEmployee(employeeList);
        if(employeeModel!=null)
        {
            
            return "Password of user "+ employeeModel.name+ " is updated.";
        
        }
          return "Failed to changing password provided details of user or you are off-line";
  }
    @PostMapping(path = "/login/{id}")
    String getMapping(@PathVariable Integer id, @RequestBody String password)
    {
       UserModel user =employeeService.getMapping(id);
        System.out.println(user+"\n\n"+id+"\n\n"+password );
       if(user.password.equalsIgnoreCase(password))
       {
           employeeService.UpdateActivityStatus(id, true);
           return "User is successfully Logged in";
       }
       return "User is not logged in!";
    }
    
}
