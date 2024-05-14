/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.helpaid;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author felix
 */
//Name: Felix Kurniawan Setio 
//Student ID: E2100298
//Date: 25 November 2023
//
//BIT203 Assignment 1

//HELPAid class as superclass
public class HELPAid{
    //initialization arraylist
    private ArrayList <Applicant> applicant;
    private ArrayList <OrganizationRep> orgRep;
    private ArrayList <CashDonation> cashDonation;
    private ArrayList <Goods> goods;
    private ArrayList <Document> doc;
    private ArrayList <Organization> org;
    private ArrayList <Appeal> app;
    private ArrayList <User> user;
    private ArrayList <HELPAid> help;
    private ArrayList <Disbursement> disb;
    public HELPAid(){
        
        org = new ArrayList<Organization> ();
        //organization list is hard coded
        org.add(new Organization(0001, "SUKSES ORGANIZATION", "JL. BATUBULAN"));
        org.add(new Organization(0002, "BINTANG ORGANIZATION", "JL. DEWI SRI"));
        applicant = new ArrayList <Applicant> ();
        
        //HELPAid helpAid = new HELPAid();
        //helpAid.setUser("admin", "admin", "admin", "admin", "admin");
        user = new ArrayList <User> ();
        orgRep = new ArrayList <OrganizationRep>();
        doc = new ArrayList <Document> ();
        app = new ArrayList <Appeal> ();
        goods = new ArrayList <Goods> ();
        cashDonation = new ArrayList <CashDonation> ();
        
        disb = new ArrayList <Disbursement> ();
    }


    public void setHelpAid(User helpaid){
        this.user.add(helpaid);
    }
    //Method that is used to add another organization if the user wishes to
    public void addOrganization(int orgID, String orgName, String orgAddress){
        org.add(new Organization(orgID, orgName, orgAddress));
    }
    //Return the size of the org.
    public int getLastOrgID(){
        return org.size();
    }
    //To check wether the organization name inputed by the user is available
    public boolean isOrganizationAvailable(String orgName){

        for (Organization or : org) {
            if (or.getOrgName().equals(orgName)) {
                return true;
            }
        }
        return false;

    }
    
    //To return the information of selected organization
    public Organization selectedOrganization(int num){
        return org.get(num);
    }
    //To delete an organization from the arraylist
    public boolean deleteOrganization(int num){
        num = num - 1;
        if (num == -1){
            num = 0;
        }
        int size = org.size();
        if (num > size){
            return false;
        }
        org.remove(num);
        return true;
    }
    //To set the organization representative
    public void setOrgRepData(OrganizationRep orgRep){
        this.orgRep.add(orgRep);
    }
    //To return the organization data
    public ArrayList <Organization> getOrganization(){
        return org;
    }
  
    //to get the organization information based on organization representative username 
    public String getOrgRepInfo(String name){
        String info = "";
        for (int i = 0; i < getOrganization().size(); i ++){
            Organization orga =  getOrganization().get(i);
            for (int o = 0; o < orga.getRepresentative().size(); o++){
                if (orga.getRepresentative().get(o).getUsername().equals(name)){
                info = "Organization : " + orga.getOrgName() + " Organization ID : " + orga.getOrgID() + " Organization Address : " + orga.getAddress();
            }
            }
        }
        return info;
    }
    //new method to return org id
    public int getOrgRepOrgID(String name){
        int info = -1;
        for (int i = 0; i < getOrganization().size(); i ++){
            Organization orga =  getOrganization().get(i);
            for (int o = 0; o < orga.getRepresentative().size(); o++){
                if (orga.getRepresentative().get(o).getUsername().equals(name)){
                info = orga.getOrgID();
            }
            }
        }
        return info;
    }
    //To get the organization ID based on the name of the representative
    public int getOrganizationID(String name){
        int info = -1;
        for (int i = 0; i < getOrganization().size(); i ++){
            Organization orga =  getOrganization().get(i);
            for (int o = 0; o < orga.getRepresentative().size(); o++){
                if (orga.getRepresentative().get(o).getUsername().equals(name)){
                info = orga.getOrgID();
            }
            }
        }
        
        return info;
    }
    //To display all of the organization registered
    public String showOrganization() {
        String printAll = ""; // Initialize the string to an empty value
        String info;
        // Foor loop
        for (int i = 0; i < org.size(); i++) {
            if (org.get(i).getOrgName() == ""){
                info = "There is no organization recorded.";
            }
            else{
            info = "Organization : " + org.get(i).getOrgName() + " Organization ID : " + org.get(i).getOrgID() + " Address : " + org.get(i).getAddress();
            printAll += info + "\n"; 
            }
        }

        return printAll;
    }
    
    //To display all of the organization representative registered
    public String showOrganizationRepresentative() {
        String printAll = ""; // Initialize the string to an empty value
        String info;
        for (int i = 0; i < org.size(); i++) {
            if (org.get(i).getOrgName() == ""){
                info = "There is no organization representative recorded.";
            }
            else{
            info = "Organization : " + org.get(i).getOrgName() + " Organization ID : " + org.get(i).getOrgID() + " Address : " + org.get(i).getAddress();
            printAll += info + "\n"; // Concatenate usernames with line breaks
            }
        }

        return printAll;
    }
    //To get user data in arraylist
    public ArrayList <User> getUserData(){
        return user;
    }

    //To check wether the username is unique or not
    public boolean isUsernameAvailable(String username){

        for (User u : user) {
            if (u.getUsername().equals(username)) {
                return true;
            }
        }
        return false;

    }
    
    public boolean isOrgRepAvailable(String username){

        for (OrganizationRep o : orgRep) {
            if (o.getUsername().equals(username)) {
                return true;
            }
        }
        return false;

    }
    //To display all of administrator registered
    public String showAllUser() {
        String printAll = ""; 

        for (int i = 0; i < user.size(); i++) {
            String username = "Username: " + user.get(i).getUsername() + 
                    " Full name: "+ user.get(i).getFullName() + " Email: " + 
                    user.get(i).getEmail()+ " sMobile No: " + user.get(i).getMobileNo();
            printAll += username + "\n"; 
        }

        return printAll;
    }
    public void registerUser(String username, String password, String fullname, String email, String phoneNumber){
        User User = new User(username, password, fullname, email, phoneNumber);
        setHelpAid(User);
    }
    
    public void addOrganizationRep(String username, String generatedPassword, String fullname, String email, String mobileno,String jobtitle,int selOrg){
        OrganizationRep orgRep = new OrganizationRep(username, generatedPassword, fullname, "", mobileno, jobtitle);
        /*OrganizationRep orRep = new OrganizationRep(username, generatedPassword, fullname, "", mobileno, jobtitle);
        setOrgRepData(orRep);
        Organization Org = getOrganization(selOrg -1);
        Org.setRepresentative(orRep);*/
    }
    

    //To display all of organization representative registered
    public String showAllOrgRep() {
        String printAll = ""; 

        for (int i = 0; i < orgRep.size(); i++) {
            printAll = "Username: " + orgRep.get(i).getUsername() + 
                    " Full name: "+ orgRep.get(i).getFullName() + " Email: " + 
                    orgRep.get(i).getEmail()+ " Mobile No: " + orgRep.get(i).getMobileNo() + 
                    " Job title: " + orgRep.get(i).getJobTitle();
            printAll += "\n"; 
        }
        
        return printAll;
    }
    //To display all applicant registered
    public String showAllApplicant() {
        String printAll = ""; 

        for (int i = 0; i < applicant.size(); i++) {
            String username = "Username: " + applicant.get(i).getUsername() + " Full name: "+ applicant.get(i).getFullName() + 
                    " Email: " + applicant.get(i).getEmail()+ " Mobile No: " + applicant.get(i).getMobileNo() + " ID Number : " + 
                    applicant.get(i).getIdNo() + " Address : " + applicant.get(i).getAddress() + " Income: " + applicant.get(i).getHouseholdIncome();
            printAll += username + "\n"; 
        }

        return printAll;
    }
    //To check login information, if it match any of the data in arraylist
    public boolean administratorLoginChecker(String username, String password){
        for (int i = 0; i < user.size(); i++){
            if (user.get(i).getUsername().equals(username) && user.get(i).getPassword().equals(password)){
                return true;
            }
        }
        return false;
    }
    //To return combination of numbers and alphabet to be used as password or username
    public String randomPasswordGenerator(int length){
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder sb = new StringBuilder();

        Random random = new Random();
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            char randomChar = characters.charAt(index);
            sb.append(randomChar);
        }

        return sb.toString();
    
    }
    //To check wether the usernmame and password of organization representative is correct or not
    public boolean loginOrganizationRepresentative(String loginUsername, String loginPassword){
        boolean output = false;
        for (int i = 0; i < orgRep.size(); i++){
            if (orgRep.get(i).getUsername().equals(loginUsername) && orgRep.get(i).getPassword().equals(loginPassword)){
                return true;
            }
            else{
                return false;
            }
        }
        return output;
        
    }
    

    


    
    //to return organization based on organization id 
    public Organization getOrganization(int num){
        for (int i = 0; i < org.size(); i++){
            if (i == num){
                return org.get(i);
            }
        }
        return null;
    }
    //to return applicant data based on their id
    public Applicant getApplicant(int num){
        for (int i = 0; i < applicant.size(); i++){
            if (i == num){
                return applicant.get(i);
            }
        }
        return null;
    }
    public String getApplicantString(int num){
        for (int i = 0; i < applicant.size(); i++){
            if (i == num){
                return applicant.get(i).toString();
            }
        }
        return null;
    }
    // to set applicant's data
    public void setApplicantData(Applicant applicant){
        this.applicant.add(applicant);
    }
    
    
    //new method for integrating org and applicant
    public int getOrgIDBasedOnOrgRep(String name){
        int info = -1;
        for (int i = 0; i < getOrganization().size(); i ++){
            Organization orga =  getOrganization().get(i);
            for (int o = 0; o < orga.getRepresentative().size(); o++){
                if (orga.getRepresentative().get(o).getUsername().equals(name)){
                info = orga.getOrgID();
            }
            }
        }
        return info;
        
    }
    //To set disbursement to arraylist
    public void setDisbursementData(Disbursement dis){
        this.disb.add(dis);
    }
    //to get disbursement from arraylist
    public ArrayList <Disbursement> getDisbursement(){
        return disb;
    }
    //To get applicant from arraylist
    public ArrayList <Applicant> getApplicant(){
        return applicant;
    }
    public ArrayList <OrganizationRep> getOrganizationRep(){
        return orgRep;
    }
    //To record outcome, this method is used to replace the outcome value from "",
    //to user desired.
    public void recordOutcome(String out, int id){
        int appID;
        String From;
        String To;
        String Desc;
        appID = app.get(id).getAppealID();
        From = app.get(id).getFromDate();
        To = app.get(id).getToDate();
        Desc = app.get(id).getDescription();
        Appeal appl = new Appeal(appID, From, To, Desc, out);
        app.set(id, appl);
    }
    
    //To return information of applicant based on its id.
    public String getApplicantBasedOnOrg(int id){
        String info = "";
        for (int i = 0; i < getOrganization().size(); i ++){
            Organization orga =  getOrganization().get(i);
            for (int o = 0; o < orga.getApplicant().size(); o++){
                if (orga.getOrgID() == id){
                info = "Applicant name: " + getApplicant().get(o).getFullName() + "Applicant address : " +  getApplicant().get(o).getAddress() + "Household income: " +getApplicant().get(o).getHouseholdIncome() + " ID no: " + getApplicant().get(o).getIdNo();
            }
            }
        }
        return info;
    }
    
    // add document method
    public void addDocument(int docID, String docName, String docDesc){
        doc.add(new Document(docID, docName, docDesc));
    }
    //To display all of the document registered
    public String showDocument() {
        // Initializa the string to ""
        String printAll = ""; 
        String info;
        for (int i = 0; i < doc.size(); i++) {
            if (doc.get(i).getFilename() == ""){
                info = "There is no document recorded.";
            }
            else{
            info = "Document ID : " + doc.get(i).getDocumentID() + " Document name : " + doc.get(i).getFilename() + " Document desc : " + doc.get(i).getDescription();
            printAll += info + "\n"; 
            }
        }

        return printAll;
    }
    //A setter to set documents
    public void setDocuments(Document Doc){
        this.doc.add(Doc);
    }
    //To get a document based on its specific location
    public Document getDocument(int num){
        for (int i = 0; i < doc.size(); i++){
            if (i == num){
                return doc.get(i);
            }
        }
        return null;
    }
    //To get a document from arraylist
    public ArrayList <Document> getDocument(){
        return doc;
    }
    // To return applicant's document information based on its name
    public String getApplicantInfo(String name){
        String returnInfo = "";
        for (int i = 0; i < getDocument().size(); i ++){
            Document docs =  getDocument().get(i);
            for (int o = 0; o < docs.getApplicant().size(); o++){
                if (docs.getApplicant().get(o).getUsername().equals(name)){
                returnInfo = "Document name : " + docs.getFilename() + " Document ID : " + docs.getDocumentID() + " Document description : " + docs.getDescription();
            }
            }
        }
        return returnInfo;
    }
    //To return document information based on its array index
   public Document selectedDocument(int num){
       return doc.get(num);
   }
   //To check applican't login information, if it is correct, it will allow the applicant to login
    public boolean applicantLoginChecker(String appUsername, String appPassword){
        
        for (int i = 0; i < applicant.size(); i ++){
            if (applicant.get(i).getUsername().equals(appUsername) && applicant.get(i).getPassword().equals(appPassword)){
                return true;
            }
        }
        return false;
    }
    //To get the size of appeal, then it will be used as 
    //appeal id with added value of 1
    public int getAppealID(){
        return app.size();
    }
    //To get the size of applicant, then it will be used as 
    //applicant id with added value of 1
    public int getApplicantID(){
        return applicant.size();
    }
    //To get the size of cash donation
    public int getCashDonationID(){
        return cashDonation.size();
    }
    //To get the size of goods
    public int getGoodsID(){
        return goods.size();
    }
    //To get appeal in arraylsit
    public ArrayList <Appeal> getAppeal(){
        return app;
    }
    //To return all of the data in disbursement
    public String getDisbursementInfo(String name){
        String returnInfo = "";
        for (int i = 0; i < getDisbursement().size(); i ++){
            

                    returnInfo = "Disbursement : " + getDisbursement().get(i);
                
            
            }
 
        return returnInfo;
    }
    
    //To show all of the appeal information
    public String showAppeal(){
        int num = 1;
        String printAll = ""; 
        String info;
        for (int i = 0; i < app.size(); i++) {
            if (app.get(i).getFromDate() == ""){
                info = "There is no appeal recorded";
            }
            else{
            info = "From date : " + app.get(i).getFromDate() + " To date : " + app.get(i).getToDate() + " Description : " + app.get(i).getDescription() + " ID: " + app.get(i).getAppealID();
            printAll += info + "\n"; 
            }
        }

        return printAll;
    }
    //To show appeal based on appeal id
    public String showAppeal(int num){
        for (int i = 0; i < app.size(); i++){
            if (i == num){
                return "From date : " + app.get(i).getFromDate() + " To date : " + app.get(i).getToDate() + " Description : " + app.get(i).getDescription();
            }
        }
        return null;
    }
    //to set the goods data
    public void setGoodsData(Goods good){
        this.goods.add(good);
    }
    //to get appeal based on its id, it will return null if it is not available
    public Appeal getAppeal(int num){
        for (int i = 0; i < app.size(); i++){
            if (i == num){
                return app.get(i);
            }
        }
        return null;
    }
    //to set the appeal data
    public void setAppealData(Appeal appl){
        this.app.add(appl);
    }
    //to set the cashdonation data
    public void setCashDonationData(CashDonation cashDon){
        this.cashDonation.add(cashDon);
    }
 

    //To get the appeal based on contribution ID
    public String getDonationInfo(int num){
        String info = "";
        for (int i = 0; i < getAppeal().size(); i ++){
            Appeal appl =  getAppeal().get(i);
            for (int o = 0; o < appl.getGoods().size(); o++){
                if (appl.getGoods().get(o).getContributionID() == num){
                info = "Appeal : " + " Description " + appl.getDescription() + " From Date : " +
                                    appl.getFromDate() + " Outcome: " + appl.getOutcome() + " To Date: " +
                                    appl.getToDate() + "\n" + appl.getCashDonation() + appl.getGoods();

            }
                
                
            }
        }

        return info;
    }
    
    public String getCashDonation() {
        // Initializa the string to ""
        String printAll = ""; 
        String info;
        for (int i = 0; i < cashDonation.size(); i++) {
            if (cashDonation.get(i).getPaymentChannel() == ""){
                info = "There is no cash donation recorded.";
            }
            else{
            info = "Payment Channel : " + cashDonation.get(i).getPaymentChannel() + " Received date : " + cashDonation.get(i).getReceivedDate() + " Reference Number : " + cashDonation.get(i).getReferenceNumber();
            printAll += info + "\n"; 
            }
        }

        return printAll;
    }
    
    public String getGoods() {
        // Initializa the string to ""
        String printAll = ""; 
        String info;
        for (int i = 0; i < goods.size(); i++) {
            if (goods.get(i).getDescription() == ""){
                info = "There is no goods donation recorded.";
            }
            else{
            info = "Description : " + goods.get(i).getDescription() + " Est. Value : " + goods.get(i).getEstimatedValue() + " Received date : " + goods.get(i).getReceivedDate();
            printAll += info + "\n"; 
            }
        }

        return printAll;
    }

    
    //to get organization information based on appeal id
    public String getAppealInfo(int id){
        String info = "";
        for (int i = 0; i < getOrganization().size(); i ++){
            Organization orga =  getOrganization().get(i);
            for (int o = 0; o < orga.getAppeal().size(); o++){
                if (orga.getAppeal().get(o).getAppealID() == id){
                info = "Organization : " + orga.getOrgName() + " Organization ID : " + orga.getOrgID() + " Organization Address : " + orga.getAddress();
            }
            }
        }
        return info;
    }
  
}

   
