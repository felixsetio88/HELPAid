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

//goods class which extends with contribution class
public class Goods extends Contribution{
    //initialization of variable
    String description;
    String estimatedValue;

    
    //constructor that takes description, estimated value, received date, contributrion id
    public Goods(String description, String estimatedValue, String receivedDate, int contributionID) {
        super(receivedDate, contributionID);
        this.description = description;
        this.estimatedValue = estimatedValue;
    }

    //getter and setter of description
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    //getter and setter of estimated value
    public String getEstimatedValue() {
        return estimatedValue;
    }

    public void setEstimatedValue(String estimatedValue) {
        this.estimatedValue = estimatedValue;
    }
    //TOString method that is used to return a string representation of an object
    @Override
    public String toString() {
        return "Goods " + "description : " + description + " estimatedValue : " + estimatedValue;
    }
    
    
}
