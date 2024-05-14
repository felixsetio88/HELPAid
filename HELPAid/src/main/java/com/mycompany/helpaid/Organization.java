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

//organization class
public class Organization {
    //initialization of variable
    private int orgID;
    private String orgName;
    private String address;
    private ArrayList <OrganizationRep> orgRep;
    private ArrayList <Appeal> app;
    private ArrayList <Applicant> applicant;
    
    //constructor that takes org ID, organization name, and organization address
    public Organization(int orgID, String orgName, String address) {
        this.orgID = orgID;
        this.orgName = orgName;
        this.address = address;
        this.orgRep = new ArrayList<>();
        this.app = new ArrayList<>();
        this.applicant = new ArrayList<>();
    }
    //getter and setter of organization id
    public int getOrgID() {
        return orgID;
    }

    public void setOrgID(int orgID) {
        this.orgID = orgID;
    }
    //getter and setter of organization name
    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }
    //getter and setter of organization address
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    //to return the data from organizationRep arraylist
    public ArrayList <OrganizationRep> getRepresentative(){
        return orgRep;
    }
    //to set a data into the arraylist
    public void setRepresentative(OrganizationRep OrgRep){
        this.orgRep.add(OrgRep);
    }
    //to return the data from appeal arraylist
    public ArrayList <Appeal> getAppeal(){
        return app;
    }
    //to set a data into appeal arraylist
    public void setAppeal(Appeal App){
        this.app.add(App);
    }
    //to set a data into applicant arraylisty
    public void setApplicant(Applicant applicant){
        this.applicant.add(applicant);
    }
    // To get a data from Applicant arrayList
    public ArrayList <Applicant> getApplicant(){
        return applicant;
    }
    @Override
    //a method to return a string representing an object
    public String toString() {
        return "Organization{" + "orgID=" + orgID + ", orgName=" + orgName + ", address=" + address + '}';
    }
    
}
