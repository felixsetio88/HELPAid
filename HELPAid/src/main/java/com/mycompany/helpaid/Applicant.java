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

//Applicant class which extends from user class
public class Applicant extends User{
    //initialization of variable
    private int idNo;
    private String address;
    private int householdIncome;
    
    private ArrayList<Disbursement> disb;
    private ArrayList<Document> doc;
    //constructor that takes username, password, fullname, email, mobile no, id no, address, and household income
    public Applicant(String username, String password, String fullName, String email, String mobileNo, int idNo, String address, int householdIncome) {
        super(username, password, fullName, email, mobileNo);
        this.idNo = idNo;
        this.address = address;
        this.householdIncome = householdIncome;
        this.disb = new ArrayList<>();
        this.doc = new ArrayList<>();
    }
    //getter and setter of document
    public void setDocument(Document docs){
        this.doc.add(docs);
    }
    public ArrayList<Document> getDocument(){
        return doc;
    }
    //getter and setter of id number
    public int getIdNo() {
        return idNo;
    }
    
    public void setIdNo(int idNo) {
        this.idNo = idNo;
    }
    //getter and setter of address
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    //getter and setter of household income
    public int getHouseholdIncome() {
        return householdIncome;
    }

    public void setHouseholdIncome(int householdIncome) {
        this.householdIncome = householdIncome;
    }
    //getter and setter of disbursement
    public ArrayList<Disbursement> getDis() {
        return disb;
    }

    public void setDisbursement(Disbursement dis) {
        this.disb.add(dis);
    }


    
    //tostring  is used to return a string representation of an object
    @Override
    public String toString() {
        return "Applicant " + " idNo: " + idNo + " address : " + address + " householdIncome : " + householdIncome ;
    }
    
    
}
