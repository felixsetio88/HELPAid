/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.helpaid;

/**
 *
 * @author felix
 */
//Name: Felix Kurniawan Setio 
//Student ID: E2100298
//Date: 25 November 2023
//
//BIT203 Assignment 1

//user class
public class User {
    //initialization of variable
    private String username;
    private String password;
    private String fullName;
    private String email;
    private String mobileNo;
    

    //user constructor which take username, password, fullname, email, and mobile no
    public User(String username, String password, String fullName, String email, String mobileNo) {
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.email = email;
        this.mobileNo = mobileNo;
    }

    //getter and setter for username
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    //getter and setter of password
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    //getter and setter of full name
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    //getter and setter of email
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    //getter and setter of mobile number
    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }


    //a tostring method which will return a string based on object
    @Override
    public String toString() {
        return "Username : " + username + " Password : " + password + " Full Name : " + fullName + " Email : " + email + " Phone Number : " + mobileNo;
    }
    
    
}
