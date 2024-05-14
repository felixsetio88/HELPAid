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

//disbursement class
public class Disbursement {
    //initialization of variable
    private String disbursementDate;
    private double cashAmount;
    private String goodsDistributed;

    //constructor that takes disbursement date, cash amount, and goods distributed
    public Disbursement(String disbursementDate, double cashAmount, String goodsDistributed) {
        this.disbursementDate = disbursementDate;
        this.cashAmount = cashAmount;
        this.goodsDistributed = goodsDistributed;
    }

    //getter and setter of disbursement date
    public String getDisbursementDate() {
        return disbursementDate;
    }

    public void setDisbursementDate(String disbursementDate) {
        this.disbursementDate = disbursementDate;
    }

    //getter and setter of cash amount
    public double getCashAmount() {
        return cashAmount;
    }

    public void setCashAmount(double cashAmount) {
        this.cashAmount = cashAmount;
    }
    
    //getter and setter of goods distributed
    public String getGoodsDistributed() {
        return goodsDistributed;
    }

    public void setGoodsDistributed(String goodsDistributed) {
        this.goodsDistributed = goodsDistributed;
    }


    //TO string method used to return a string representation of an object

    @Override
    public String toString() {
        return "Disbursement " + " Date : " + disbursementDate + " cashAmount : " + cashAmount + " goodsDistributed : " + goodsDistributed ;
    }


}
