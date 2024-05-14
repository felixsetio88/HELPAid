/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.helpaid;
import java.util.ArrayList;
/**
 *
 * @author felix
 */
//Name: Felix Kurniawan Setio 
//Student ID: E2100298
//Date: 25 November 2023
//
//BIT203 Assignment 1

//organizationRep class is extended from user class
public class OrganizationRep extends User{
    //initialization of variable
    private String jobTitle;
    
    //constructor that take username, password, fullname, email, and mobile number
    public OrganizationRep(String username, String password, String fullName, String email, String mobileNo, String jobTitle){
        super(username, password, fullName, email, mobileNo);
        this.jobTitle = jobTitle;
        
    }
    
    //getter and setter of job title
    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }
    //a toString() method that is used to return a string representing an object
    @Override
    public String toString() {
        return "Username : " + getUsername() + " password : " + getPassword() + " Full name : " + getFullName() + " Mobile number : " + getMobileNo();
    }
    
   
    
}
