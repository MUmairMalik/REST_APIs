/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

/**
 *
 * @author M Umair Malik
 */
@Entity
@Table(name = "employeeTest")
public class UserModel implements Serializable {
    
    @Id
    Integer id;
    String name;
    String password;
    String gender;
    Date dob;
    boolean activity;

    public String getGender() {
        return gender;
    }

    public Date getDob() {
        return dob;
    }

    public boolean isActivity() {
        return activity;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public void setActivity(boolean activity) {
        this.activity = activity;
    }
    
    

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public UserModel(Integer id, String name, String password, String gender, Date dob, boolean activity) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.gender = gender;
        this.dob = dob;
        this.activity = activity;
    }

   

    public UserModel() {
    }

  
 public static String[] getNullPropertyNames (Object source) {
    final BeanWrapper src = new BeanWrapperImpl(source);
    java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();

    Set<String> emptyNames = new HashSet<String>();
    for(java.beans.PropertyDescriptor pd : pds) {
        Object srcValue = src.getPropertyValue(pd.getName());
        if (srcValue == null) emptyNames.add(pd.getName());
    }
    String[] result = new String[emptyNames.size()];
    return emptyNames.toArray(result);
}

// then use Spring BeanUtils to copy and ignore null
public static void myCopyProperties(Object src, Object target) {
    BeanUtils.copyProperties(src, target, getNullPropertyNames(src));
}
   }
