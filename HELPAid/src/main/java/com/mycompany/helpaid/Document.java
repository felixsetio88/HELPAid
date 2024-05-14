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

//document class
class Document{
    //Initialization of a variable
    private int documentID;
    private String filename;
    private String description;
    private ArrayList <Applicant> app;
    
    public Document(int documentID, String filename, String description) {
        this.documentID = documentID;
        this.filename = filename;
        this.description = description;
        app = new ArrayList<>();
    }

    //getter and setter of document id

    public int getDocumentID() {
        return documentID;
    }

    public void setDocumentID(int documentID) {
        this.documentID = documentID;
    }
    //getter and setter of file name
    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }
    //getter and setter of description
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    //getter and setter of applicant
    public ArrayList <Applicant> getApplicant(){
        return app;
    }
    public void setApplicant(Applicant App){
        this.app.add(App);
    }
    
    //Tostring method that is typically used to return a string representing a method
    @Override
    public String toString() {
        return "Document{" + "documentID=" + documentID + ", filename=" + filename + ", description=" + description + '}';
    }
    
}
    

