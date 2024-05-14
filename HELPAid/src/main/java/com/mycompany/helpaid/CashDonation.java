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

//cashdonation class which extends with contribution class
public class CashDonation extends Contribution{
    //initialization of variable
    private int amount;
    private String paymentChannel;
    private String referenceNumber;
    
    //constructor that takes received date, contribution id, amount, payment channel, reference number
    public CashDonation(String receivedDate, int contributionID, int amount, String paymentChannel, String referenceNumber){
        super(receivedDate, contributionID);
        this.amount = amount;
        this.paymentChannel = paymentChannel;
        this.referenceNumber = referenceNumber;
    }
    //getter and setter of amount
    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
    //getter and setter of payment channel
    public String getPaymentChannel() {
        return paymentChannel;
    }

    public void setPaymentChannel(String paymentChannel) {
        this.paymentChannel = paymentChannel;
    }
    //getter and setter of reference number
    public String getReferenceNumber() {
        return referenceNumber;
    }

    public void setReferenceNumber(String referenceNumber) {
        this.referenceNumber = referenceNumber;
    }
    //tostring method that is typically used to return a string representation of an object
    @Override
    public String toString() {
        return "CashDonation " + " amount : " + amount + " paymentChannel : " + paymentChannel + " referenceNumber : " + referenceNumber;
    }
    
}
