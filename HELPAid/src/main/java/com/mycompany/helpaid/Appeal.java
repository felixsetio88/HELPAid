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

//Appeal class
public class Appeal {
    //initialization of variable
    private int appealID;
    private String fromDate;
    private String toDate;
    private String description;
    private String outcome;
    
    private ArrayList <Contribution> contributions;
    private ArrayList <Goods> goods;
    private ArrayList <CashDonation> cashDon;
    private ArrayList <Disbursement> disbursements;

    //constructor that takes appealID, from date, to date, description and also outcome
    public Appeal(int appealID, String fromDate, String toDate, String description, String outcome) {
        this.appealID = appealID;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.description = description;
        this.outcome = outcome;
        this.contributions = new ArrayList<>();
        this.goods = new ArrayList<>();
        this.cashDon = new ArrayList<>();
        this.disbursements = new ArrayList<>();
    }

    
    //getter and setter of appealID
    public int getAppealID() {
        return appealID;
    }

    public void setAppealID(int appealID) {
        this.appealID = appealID;
    }
    
    //getter and setter of from date
    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    //getter and setter of to date
    public String getToDate() {
        return toDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }
    //getter and setter of description
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    //getter and setter of outcome
    public String getOutcome() {
        return outcome;
    }

    public void setOutcome(String outcome) {
        this.outcome = outcome;
    }
    
    //getter and setter of contributions
    public ArrayList<Contribution> getContributions() {
        return contributions;
    }

    public void setContribution(Contribution contribution) {
        this.contributions.add(contribution);
    }
    //getter and setter of disbursement
    public ArrayList<Disbursement> getDisbursements() {
        return disbursements;
    }

    public void setDisbursements(Disbursement disbursements) {
        this.disbursements.add(disbursements);
    }
    //getter and setter of goods
    public ArrayList<Goods> getGoods() {
        return goods;
    }

    public void setGoods(Goods good) {
        this.goods.add(good);
    }
    //getter and setter of cashdonation
    public ArrayList <CashDonation> getCashDonation(){
        return cashDon;
    }
    public void setCashDonation(CashDonation cashDonations){
        this.cashDon.add(cashDonations);
    }

    @Override
    public String toString() {
        return  " appealID: " + appealID + " fromDate : " + fromDate + " toDate: " + toDate + " description: " + description + " outcome : " + outcome + " contributions = " + contributions + " goods = " + goods + " cashDonation " + cashDon + " disbursements = " + disbursements ;
    }
    


}
