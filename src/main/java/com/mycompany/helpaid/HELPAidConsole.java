/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.helpaid;
import java.util.*;
import java.util.Random;
import java.time.LocalDate;
/**
 *
 * @author felix
 */
//Name: Felix Kurniawan Setio 
//Student ID: E2100298
//Date: 25 November 2023
//
//BIT203 Assignment 1

//HELPAidConsole as main class
public class HELPAidConsole{
    public static void main(String[] args)
    {
        LocalDate today = LocalDate.now();
        String dateString = today.toString();
        //initialize variable
        String username, password, email, fullname, phoneNumber;
        String usernameForLogin, passwordForLogin;
        int menuChoice = 0;
        //initialize Scanner
        Scanner kbd = new Scanner(System.in);

        //initialize object
        HELPAid helpaid = new HELPAid();
       
        //Welcome Message
        System.out.println
                ("--------------------------------------------------------------------------------------------------------");
        System.out.println("                                About HELPAid System");
        System.out.println("        HELP Aid is an information system that has been proposed to manage the registration of aid \n" +
"       applicants and organizations that are helping them");
        

        //Looping for the signup, and login menu
        while (menuChoice <= 5)
        {
            //Menu(s)
            System.out.println
                    ("--------------------------------------------------------------------------------------------------------");
            System.out.println("Please select the menu below:");
            System.out.println("1. Sign-Up as Administrator");
            System.out.println("2. Sign-In as Administrator");
            System.out.println("3. Login as Organization Representative");
            System.out.println("4. Login as Applicant");
            System.out.println("5. Menu for donors");
            System.out.println("6. Exit");
            System.out.print("\nChoice (1-6): ");

            //store the menu selected
            menuChoice = kbd.nextInt();
            kbd.nextLine();

            switch (menuChoice)
            {
                case 1:
                    System.out.println("\nSign-Up as Administrator");
                    System.out.println
                        ("-----------------------------------------");
                       
                    //helpaid.setUser("admin", "admin", "admin", "admin", "admin");
                    //input the username, password, email, and full name
                    // to sign up the administrator
                    System.out.println("\nInput your username, password, Email, and Fullname");
                    System.out.print("Username      : ");
                    username = kbd.next();
                    System.out.print("Password      : ");
                    password = kbd.next();
                    System.out.print("Email         : ");
                    email = kbd.next();
                    System.out.print("Full Name     : ");
                    fullname = kbd.next();
                    System.out.print("Phone number  : ");
                    phoneNumber = kbd.next();
                    kbd.nextLine();
                    
                    System.out.println("debug: " + helpaid.isUsernameAvailable(username));
                    
                    while (helpaid.isUsernameAvailable(username)){
                        System.out.println("Sorry, " + username + " has been taken! Try another username!");
                        System.out.print("Username      : ");
                        username = kbd.next();
                        System.out.print("Password      : ");
                        password = kbd.next();
                        System.out.print("Email         : ");
                        email = kbd.next();
                        System.out.print("Full Name     : ");
                        fullname = kbd.next();
                        System.out.print("Phone number  : ");
                        phoneNumber = kbd.next();
                        kbd.nextLine();
                    }
                  
                        //helpaid.setUser(username, password, fullname, email, phoneNumber);
                        User User = new User(username, password, fullname, email, phoneNumber);
                        helpaid.setHelpAid(User);
                        System.out.println("Congratulations! registration success");
                        System.out.println("Registration number: ");
                    
                        System.out.println("Username: " + helpaid.getUserData());
                        
                    
                    
                    
                    //validate that the username
                    // is not a duplicate data
                    
                break;

                case 2:
                    System.out.println("\nLogin as Administrator");
                    System.out.println
                        ("-----------------------------------");
                    System.out.println("Input a valid Login information:");
                    System.out.print("Username: ");
                    usernameForLogin = kbd.next();
                    System.out.print("Password: ");
                    passwordForLogin = kbd.next();
                    
                    while(helpaid.administratorLoginChecker(usernameForLogin,
                            passwordForLogin)==false){
                        System.out.println("Login failed! try again!");
                        
                        System.out.println("\nLogin as Administrator");
                        System.out.println
                            ("-----------------------------------");
                        System.out.println("Input a valid Login information:");
                        System.out.print("Username: ");
                        usernameForLogin = kbd.next();
                        System.out.print("Password: ");
                        passwordForLogin = kbd.next();
                        }

                  
                        System.out.println("       Login successful!");
                        System.out.println("----------------------------------");
                        System.out.println("1. Add a new organization representative");
                        System.out.println("2. Manage organization");
                        System.out.println("3. Display all administrator");
                        System.out.println("4. Display all organization representative");
                        System.out.println("5. Display all applicant");
                        System.out.print("Your choice (1- 5): ");
                        int case3choice = kbd.nextInt();
                        switch(case3choice){
                            case 1:
                            System.out.println("Add a new organization representative");
                            System.out.println(helpaid.showOrganization() + "\n");
                            System.out.print("Select organization by typing the organization ID : "  );
                            int orgChoice = kbd.nextInt();

                            
                            System.out.print("Username      : ");
                            String usernameOrgRep = kbd.next();
                            System.out.print("Full Name     : ");
                            String fullNameOrgRep = kbd.next();
                            System.out.print("Mobile No     : ");
                            String mobileNoOrgRep = kbd.next();
                            System.out.print("Job Title     : ");
                            String jobTitleOrgRep = kbd.next();
                            
                            while (helpaid.isUsernameAvailable(usernameOrgRep) == true){
                                //make a sorry that the username is not available
                                System.out.println("Sorry your username has been taken!");
                                System.out.print("Username      : ");
                                usernameOrgRep = kbd.next();
                                System.out.print("Full Name     : ");
                                fullNameOrgRep = kbd.next();
                                System.out.print("Mobile No     : ");
                                mobileNoOrgRep = kbd.next();
                                System.out.print("Job Title     : ");
                                jobTitleOrgRep = kbd.next();
                            }
                            String generatedPassword = helpaid.randomPasswordGenerator(8);
                            System.out.println("The generated password : " + generatedPassword);
                            System.out.println(helpaid.selectedOrganization(orgChoice -1));
                            OrganizationRep orgRep = new OrganizationRep(usernameOrgRep, generatedPassword, fullNameOrgRep, "", mobileNoOrgRep, jobTitleOrgRep);
                            helpaid.setOrgRepData(orgRep);
                            Organization Org = helpaid.getOrganization(orgChoice -1);
                            Org.setRepresentative(orgRep);
                            
                            break;
                        
                        case 2:
                            System.out.println("Manage Organization");
                            System.out.println("Recorded Organization: ");
                            System.out.println(helpaid.showOrganization());
                            System.out.println("What do you want to do?");
                            System.out.println("1. add a new organization");
                            System.out.println("2. delete a recorded organization");
                            System.out.print("Choice (1-2): ");
                            int choiceManageOrg = kbd.nextInt();
                            if (choiceManageOrg == 1){
                                System.out.println("Add a new organization");
                                System.out.print("Organization name: ");
                                String orgName = kbd.next();
                                System.out.print("Organization address: ");
                                String orgAddress = kbd.next();
                                while (helpaid.isOrganizationAvailable(orgName) == true){
                                    System.out.println(orgName + " is already registered, choose another name");
                                    System.out.print("Organization name: ");
                                    orgName = kbd.next();
                                    System.out.print("Organization address: ");
                                    orgAddress = kbd.next();
                                }
                                int newID = helpaid.getLastOrgID() + 1;
                                System.out.println("The generated ID: " + newID);
                                helpaid.addOrganization(newID, orgName, orgAddress);
                                
                            }
                            if (choiceManageOrg == 2){
                                System.out.println("Delete organization from system");
                                System.out.println(helpaid.showOrganization());
                                System.out.print("Input organization ID: ");
                                int orgToDelete = kbd.nextInt();
                                
                                while (helpaid.deleteOrganization(orgToDelete) == false){
                                    System.out.println("Organization ID : " + orgToDelete + " does not exist");
                                    System.out.print("Input a valid organization ID: ");
                                    orgToDelete = kbd.nextInt();
                                    
                                }
                                
                                    System.out.println("Organization ID " + orgToDelete + " has been successfully removed");
                                    break;
                                    
                            }
                            break;
                            
                        case 3: 
                            System.out.println("Dispay all administrator:");
                            System.out.println(helpaid.showAllUser());
                            break;

                       case 4:
                            System.out.println("Display all organization representative: ");
                            System.out.println(helpaid.showAllOrgRep());
                            break;
                        case 5: 
                            System.out.println("Display all applicant");
                            System.out.println(helpaid.showAllApplicant());
                            break;

                        case 6:
                            break;
                          
                        
                        }
                        break;
                        
                
                           
                     
                        
                        
                        
                    
                        
                        
                

                case 3:
                    System.out.println("\nLogin as Organization Representative");
                    System.out.println
                        ("-----------------------------------");
                    System.out.println("Input a valid username and password");
                    System.out.print("Username: ");
                    String usernameOrgRep = kbd.next();
                    System.out.print("Password: ");
                    String passwordOrgRep = kbd.next();
                    
                    
                    while(!helpaid.loginOrganizationRepresentative(usernameOrgRep,
                            passwordOrgRep)){
                        
                        System.out.println("Input a valid username and password");
                        System.out.print("Username: ");
                        usernameOrgRep = kbd.next();
                        System.out.print("Password: ");
                        passwordOrgRep = kbd.next();
                    }
                    System.out.println(helpaid.getOrgRepInfo(usernameOrgRep));
                    //System.out.println("\n" + output);
                    System.out.println("1. Register applicant");
                    System.out.println("2. Record a new appeal for aid");
                    System.out.println("3. Record contribution");
                    System.out.println("4. Record aid disbursement");
                    System.out.print("Your choice (1-4): " );
                    int choiceForOrgRep = kbd.nextInt();
                    
                    if (choiceForOrgRep == 1){
                        int generatedID = helpaid.getApplicantID() + 1;
                        System.out.println("Applicant registration: ");
                        System.out.print("Full Name  : ");
                        String appName = kbd.next();
                        System.out.print("ID No      : " + generatedID + "\n");
                       
                        System.out.print("Address    : ");
                        String appAddress = kbd.next();
                        System.out.print("Income     : ");
                        int appIncome = kbd.nextInt();
                        System.out.println("Enter your document information: ");
                        System.out.print("Document ID            : " + generatedID + "\n");
                        
                        System.out.print("Document Name          : ");
                        String docName = kbd.next();
                        System.out.print("Document Description   : ");
                        String docDesc = kbd.next();
                        
                        
                        String applicantUsername = helpaid.randomPasswordGenerator(8);
                        String applicantPassword = helpaid.randomPasswordGenerator(8);
                        
                        helpaid.addDocument(generatedID, docName, docDesc);
                        //System.out.println(helpaid.showDocument());
                        //System.out.println(helpaid.selectedDocument(docID - 1));
                        Applicant appl = new Applicant(applicantUsername, applicantPassword, appName, "", "", generatedID, appAddress, appIncome);
                        helpaid.setApplicantData(appl);
                        Document docs = helpaid.getDocument(generatedID - 1);
                        docs.setApplicant(appl);
                        System.out.println("You are successfully registered!");
                        System.out.println("Generated Username: " + applicantUsername);
                        System.out.println("Generated Password: " + applicantPassword);
                        System.out.println(helpaid.getApplicantInfo(applicantUsername));
                        Organization org = helpaid.getOrganization(helpaid.getOrgIDBasedOnOrgRep(usernameOrgRep) - 1);
                        org.setApplicant(appl);
                        
                        
                        
                    }
                    if (choiceForOrgRep == 2){
                        System.out.println("Record a new appeal for aid");
                        System.out.print("From Date      : ");
                        String fromDate = kbd.next();
                        System.out.print("To Date        : ");
                        String toDate = kbd.next();
                        System.out.print("Description    : ");
                        String appealDesc = kbd.next();
                        int generatedID = helpaid.getAppealID() + 1;
                        System.out.print("Generated ID   : " + generatedID + ". ");
                        //helpaid.addAppeal(generatedID, fromDate, toDate, appealDesc);
                        System.out.println(helpaid.showAppeal());
                        
                        int orgIDToRecordAid;
                        orgIDToRecordAid = helpaid.getOrganizationID(usernameOrgRep);
                        Appeal APPEAL = new Appeal(generatedID, fromDate, toDate, appealDesc, "");
                        helpaid.setAppealData(APPEAL);
                        Organization Org = helpaid.getOrganization(orgIDToRecordAid -1 );
                        Org.setAppeal(APPEAL);
                    }  
                    if (choiceForOrgRep == 3){
                        System.out.println("Record Contribution");
                        System.out.println(helpaid.showAppeal());
                        System.out.print("Select one appeal based on appeal ID: ");
                        int appealChoice = kbd.nextInt();
                        System.out.println("Your choice is: " + helpaid.showAppeal(appealChoice - 1));
                        System.out.println("What kind of contribution do you want to make?");
                        System.out.println("1. Goods Donation");
                        System.out.println("2. Cash Donation");
                        System.out.print("Your choice: ");
                        int choiceForDonation = kbd.nextInt();
                        
                        if(choiceForDonation == 1){
                            int contriID = helpaid.getGoodsID() + 1;
                            System.out.print("Goods description : ");
                            String goodsDesc = kbd.next();
                            System.out.print("Est Value : ");
                            String estValue = kbd.next();
                            System.out.print("Contribution ID: " + contriID + "\n");
                            
                            System.out.println("Received date: " + dateString + "\n");
                            String contriDate = dateString;
                            Goods goods = new Goods(goodsDesc, estValue, dateString, contriID);
                            helpaid.setGoodsData(goods);
                            Appeal appeals = helpaid.getAppeal(appealChoice - 1);
                            appeals.setGoods(goods);
                            System.out.println("Your Goods contribution has been recorded");
                        }
                        if (choiceForDonation == 2){
                            int cashDonID = helpaid.getCashDonationID() + 1;
                            System.out.print("Contribution date: " + dateString + "\n");
                            String contriDate = dateString;
                            System.out.print("Contribution ID: " + cashDonID + "\n");
                            
                            System.out.print("Amount : ");
                            int donationAmount = kbd.nextInt();
                            System.out.print("Payment Channel : ");
                            String paymentChannel = kbd.next();
                            System.out.print("Reference Number : ");
                            String refNumber = kbd.next();
                            CashDonation cashDon = new CashDonation(contriDate, cashDonID, donationAmount, paymentChannel, refNumber);
                            helpaid.setCashDonationData(cashDon);
                            Appeal appeals = helpaid.getAppeal(appealChoice - 1);
                            appeals.setCashDonation(cashDon);
                            System.out.println("Your cash donation contribution has been recorded");
                        }
                        
                        
                    }
                    
                    if(choiceForOrgRep == 4){
                        //need to do
                        System.out.println("Record Aid Disbursement");
                        //show current appeal
                        System.out.println(helpaid.showAppeal());
                        //select appeal ID
                        System.out.print("Select one appeal by typing its Appeal ID: ");
                        int appealIDChoice = kbd.nextInt();
                        //the appeal info is shown, also with list of contributions
                        System.out.println(helpaid.showAppeal(appealIDChoice - 1));
                        System.out.println(helpaid.getDonationInfo(appealIDChoice));
                        //select to view applicant
                        System.out.println("Applicant registered with organization: ");
                        //list of applicant registered in organization is shown
                        System.out.println(helpaid.getApplicantBasedOnOrg(helpaid.getOrgRepOrgID(usernameOrgRep)));
                        //select the id of applicant
                        System.out.print("Select applicant by typing its ID: ");
                        int applicantID = kbd.nextInt();
                        //applicant name, address and household income is shown
                        System.out.println(helpaid.getApplicant(applicantID-1));
                        //enter the disbursement date, cash amount and the goods
                        //provided to the applicant
                        System.out.println("Enter the disbursement information: ");
                        System.out.print("Disbursement date: ");
                        String disDate = kbd.next();
                        System.out.print("Cash amount: ");
                        double disAmount = kbd.nextDouble();
                        System.out.print("Goods: ");
                        String disGoods = kbd.next();
                        //disbursement is recorded for the applicant
                        Disbursement disb = new Disbursement(disDate, disAmount, disGoods);
                        helpaid.setDisbursementData(disb);
                        Applicant appl = helpaid.getApplicant(applicantID-1);
                        appl.setDisbursement(disb);
                        //orgRep records the outcome of the appeal
                        System.out.println("The disbursement is recorded for the applicant.");
                        System.out.print("Outcome for the appeal: ");
                        String outcomeForAppeal = kbd.next();
                        helpaid.recordOutcome(outcomeForAppeal, applicantID-1);
                        helpaid.getDisbursement();
                    }
                    break;
                case 4:
                    System.out.println("\nLogin as Applicant");
                    System.out.println
                        ("-----------------------------------");
                    System.out.println("Enter a valid username and password");
                    System.out.print("Username: ");
                    String appUsername = kbd.next();
                    System.out.print("Password: ");
                    String appPassword = kbd.next();

                    //validating the username and password with the
                    // data in ArrayList.
                    if (helpaid.applicantLoginChecker(appUsername, appPassword)==false)
                    {
                        System.out.println("Login failed!");

                    }     
                    System.out.println("\nLogin Success");
                    System.out.println(helpaid.getApplicantInfo(appUsername));
                    System.out.println("Menu for Applicant");
                    System.out.println("1. View given disbursement");
                    System.out.println("Your choice: ");
                    int choiceApplicant = kbd.nextInt();
                    if (choiceApplicant == 1){
                        System.out.println("View given disbursement");
                        System.out.println(helpaid.getDisbursementInfo(appUsername));
                    }
                    break;
                    
                case 5:
                    System.out.println("Menu for donors");
                    System.out.println("What do you want to do?");
                    System.out.println("1. Record a contribution");
                    System.out.println("2. View Aid Appeal");
                    System.out.println("3. Go back");
                    System.out.println("Your choice (1-3): ");
                    int donorsChoice = kbd.nextInt();
                    switch(donorsChoice){
                        case 1: 
                            System.out.println("Record Contribution");
                            System.out.println(helpaid.showAppeal());
                            System.out.print("Select one appeal based on appeal ID: ");
                            int appealChoice = kbd.nextInt();
                            System.out.println("Your choice is: " + helpaid.showAppeal(appealChoice - 1));
                            System.out.println("What kind of contribution do you want to make?");
                            System.out.println("1. Goods Donation");
                            System.out.println("2. Cash Donation");
                            System.out.print("Your choice: ");
                            int choiceForDonation = kbd.nextInt();

                            if(choiceForDonation == 1){
                                int contriID = helpaid.getGoodsID() + 1;
                                System.out.print("Goods description : ");
                                String goodsDesc = kbd.next();
                                System.out.print("Est Value : ");
                                String estValue = kbd.next();
                                System.out.print("Contribution ID: " + contriID + "\n");

                                System.out.print("Received date: " + dateString + "\n");
                                String contriDate = dateString;
                                Goods goods = new Goods(goodsDesc, estValue, contriDate, contriID);
                                helpaid.setGoodsData(goods);
                                Appeal appeals = helpaid.getAppeal(appealChoice - 1);
                                appeals.setGoods(goods);
                                System.out.println("Your Goods contribution has been recorded");
                                break;
                            }
                            if (choiceForDonation == 2){
                                int cashDonID = helpaid.getCashDonationID() + 1;
                                System.out.print("Contribution date: " + dateString + "\n");
                                String contriDate = dateString;
                                System.out.print("Contribution ID: " + cashDonID + "\n");

                                System.out.print("Amount : ");
                                int donationAmount = kbd.nextInt();
                                System.out.print("Payment Channel : ");
                                String paymentChannel = kbd.next();
                                System.out.print("Reference Number : ");
                                String refNumber = kbd.next();
                                CashDonation cashDon = new CashDonation(contriDate, cashDonID, donationAmount, paymentChannel, refNumber);
                                helpaid.setCashDonationData(cashDon);
                                Appeal appeals = helpaid.getAppeal(appealChoice - 1);
                                appeals.setCashDonation(cashDon);
                                System.out.println("Your cash donation contribution has been recorded");
                                break;
                            }
                            break;
                        case 2:
                            System.out.println(helpaid.showAppeal());
                            System.out.print("Select one appeal by typing its number: ");
                            int donorsChoiceToShowAppeal = kbd.nextInt();
                            System.out.println(helpaid.getAppealInfo(donorsChoiceToShowAppeal));
                        case 3:
                            break;
                     
                    }
                          
                    
            }
        }
        //closing statement
        System.out.println
            ("\n=Closing the program.....");
        System.out.println
                ("Thank you!");
        }
}
