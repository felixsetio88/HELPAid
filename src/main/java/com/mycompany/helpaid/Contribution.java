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

//contribution class 
public class Contribution {
    //initialization of variable
    String receivedDate;
    int contributionID;
    //constructor that takes received date and contribution id
    public Contribution(String receivedDate, int contributionID) {
        this.receivedDate = receivedDate;
        this.contributionID = contributionID;
    }
    //getter variable received date and contribution id
    public String getReceivedDate() {
        return receivedDate;
    }

    public int getContributionID() {
        return contributionID;
    }
    //setter variable of received date and contribution id
    public void setReceivedDate(String receivedDate) {
        this.receivedDate = receivedDate;
    }

    public void setContributionID(int contributionID) {
        this.contributionID = contributionID;
    }
    //tostring that typically used to return a string representation of an object
    @Override
    public String toString() {
        return "Contribution " + " receivedDate " + receivedDate + " contributionID :" + contributionID;
    }
    
}
