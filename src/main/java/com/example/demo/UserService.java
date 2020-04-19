/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author M Umair Malik
 */

@Service
public class UserService {
    
    @Autowired
    UserRepository employeeRepository;
   
   
    
    List<UserModel> getEmployee()
    {
        List<UserModel> employeeList = employeeRepository.findAll();
        System.out.println("employee " + employeeList.get(0).name);
        return employeeList;
    } 
    
    UserModel createEmployee(UserModel employee){
        return employeeRepository.save(employee);
        
    }
    UserModel loginEmployee(UserModel employee){
        
        List<UserModel> employeeList = employeeRepository.findAll();
        UserModel employ=null;
        System.out.println("id and password for service of login is " + employee.id + employee.password );
        if(employee.id!=null && employee.password!=null)
        {
            for(UserModel em:employeeList)
            {
                System.out.println("id and password checking is " + em.id + em.password );
                if((em.id==employee.id )&&( em.password.equals(employee.password)))
                {
                    employ=em;
                    break ;
                }
            }
        
            if(employ != null)
            {
                employ.activity=true;
                System.out.println("employee " + employeeList.get(0).name);
                return employeeRepository.save(employ);
            }
        }
        return null;
    }
     UserModel updateEmployee(UserModel employee){
        
        List<UserModel> employeeList = employeeRepository.findAll();
        UserModel employ=null;
        System.out.println("id and password for service of login is " + employee.id + employee.password );
        if(employee.id!=null )
        {
            for(UserModel em:employeeList)
            {
                System.out.println("id and password checking is " + em.id + em.password );
                if((em.id==employee.id )&&( em.activity==true))
                {
                    employ=em;
                    break ;
                }
            }
        
            if(employ != null)
            {
                
                employ.myCopyProperties(employee, employ);
                employ.activity=true;
                System.out.println("employee " + employ.name);
                return employeeRepository.save(employ);
            }
        }
        return null;
    }
    UserModel detailEmployee(UserModel employee){
        
        List<UserModel> employeeList = employeeRepository.findAll();
        UserModel employ=null;
        System.out.println("id and password for service of login is " + employee.id );
        if(employee.id!=null)
        {
            for(UserModel em:employeeList)
            {
                System.out.println("id and password checking is " + em.id + em.password );
                if((em.id==employee.id )&&( em.activity==true))
                {
                    employ=em;
                    break ;
                }
            }
           
            if(employ != null)
            {
                return employ;
            }
        }
        return null;
    }
    
    UserModel logoutEmployee(UserModel employee){
        
        List<UserModel> employeeList = employeeRepository.findAll();
        UserModel employ=null;
        if(employee.id!=null)
        {
            for(UserModel em:employeeList)
            {
                if(em.id==employee.id )
                {
                    employ=em;
                    break ;
                }
            }
            if(employ!=null)
            {
                employ.activity=false;
                return employeeRepository.save(employ);
            }
        }
        return null;
    }
    
    UserModel changePassEmployee(UserModel employee){
        
        List<UserModel> employeeList = employeeRepository.findAll();
        UserModel employ=null;
        System.out.println("id and password for service of login is " + employee.id + employee.password );
        if(employee.id!=null )
        {
            for(UserModel em:employeeList)
            {
                System.out.println("id and password checking is " + em.id + em.password );
                if((em.id==employee.id )&&( em.activity==true))
                {
                    employ=em;
                    break ;
                }
            }
           
            if(employ != null)
            {
                employ.password=employee.password;
                return employeeRepository.save(employ);
            }
        }
        return null;
    }       
    String deleteEmployee(UserModel employee){
        
        List<UserModel> employeeList = employeeRepository.findAll();
        UserModel employ=null;
        System.out.println("id and password for service of login is " + employee.id + employee.password );
        if(employee.id!=null )
        {
            for(UserModel em:employeeList)
            {
                System.out.println("id and password checking is " + em.id + em.password );
                if((em.id==employee.id )&&( em.activity==true))
                {
                    employ=em;
                    break ;
                }
            }
        
            if(employ != null)
            {
                employeeRepository.deleteById(employee.id);
                return "Successfully deleted";
            }
        }
        return "Error in deleting";
    }
   
    UserModel getMapping(int id)
    {
        if(true)
        {
              UserModel user=employeeRepository.getOne(id);
              System.out.println(user);
              return user;
        }
         List<UserModel> employeeList =  employeeRepository.findAll();
       for(UserModel em: employeeList)
       {
           if(em.id== id)
           {
               return em;
           }
       }
       return null;
    }
    void UpdateActivityStatus(int id,boolean f)
    {
        UserModel user=employeeRepository.getOne(id);
        user.activity=f;                
        employeeRepository.save(user);
    }
        
}
