/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.helpaid;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author felix
 */
//class signUpApplicant which extends with JFrame
public class SignUpApplicant extends JFrame{
    private HELPAid helpaid;
    private JPanel signUpPanel;
    //a method which takes helpaid and also username of organization rep
    public SignUpApplicant(HELPAid helpaid, String usernameOrgRep){
        // to set the title 
        setTitle("Sign Up Administrator");
        // to make the windows not resizeable
	setResizable(false);
        // to set the background color
	setBackground(new Color(255, 255, 255));
        // to dispose on close
	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        // to set the position and size
	setBounds(200, 100, 1200, 600);
        
        //initialization of panel
	signUpPanel = new JPanel();
        // to add a border
	signUpPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(signUpPanel);
        // not using a layout manager
	signUpPanel.setLayout(null);
	           
        //initialization of JPanel
	JPanel panelBackground = new JPanel();
	panelBackground.setBounds(0, 0, 700, 600);
	signUpPanel.add(panelBackground);
	panelBackground.setLayout(null);
        
        //initialization of new label
	JLabel SignUp = new JLabel("Sign Up Applicant");
	SignUp.setForeground(new Color(181, 29, 29));
	SignUp.setFont(new Font("Segoe UI", Font.BOLD, 50));
	SignUp.setBounds(100, 350, 600, 200);
	panelBackground.add(SignUp);
        
        
        
        JLabel background = new JLabel("");
	background.setIcon(new ImageIcon(SignUpGUI.class.getResource("/register.jpg")));
	background.setBounds(0, 0, 700, 600);
	panelBackground.add(background);
        //initialization of new label
        JLabel enterInfoLbl = new JLabel("Enter Applicant's Data");
	enterInfoLbl.setFont(new Font("Segoe UI", Font.BOLD, 18));
	enterInfoLbl.setBounds(820, 40, 270, 25);
        enterInfoLbl.setForeground(new Color(181, 29, 29));
	signUpPanel.add(enterInfoLbl);
	//initialization of new label	
        JLabel fullnameLbl = new JLabel("Full Name");
	fullnameLbl.setHorizontalAlignment(SwingConstants.RIGHT);
	fullnameLbl.setFont(new Font("Segoe UI", Font.PLAIN, 14));
	fullnameLbl.setBounds(900, 82, 218, 13);
	signUpPanel.add(fullnameLbl);
	//initialization of text field	
	JTextField nameField = new JTextField();
	nameField.setFont(new Font("Segoe UI", Font.PLAIN, 18));
	nameField.setBounds(820, 100, 300, 40);
	signUpPanel.add(nameField);
	
        //initialization of new label
        JLabel addressLbl = new JLabel("Address");
	addressLbl.setHorizontalAlignment(SwingConstants.RIGHT);
        addressLbl.setFont(new Font("Segoe UI", Font.PLAIN, 14));
	addressLbl.setBounds(900, 142, 218, 13);
	signUpPanel.add(addressLbl);
        //initialization of text field
        JTextField addressField = new JTextField();
	addressField.setFont(new Font("Segoe UI", Font.PLAIN, 18));
	addressField.setBounds(820, 160, 300, 40);
	signUpPanel.add(addressField);
        //initialization of new label
        JLabel incomeLabel = new JLabel("Income");
	incomeLabel.setHorizontalAlignment(SwingConstants.RIGHT);
	incomeLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
	incomeLabel.setBounds(900, 202, 218, 13);
	signUpPanel.add(incomeLabel);
	//initialization of text field	
	JTextField incomeField = new JTextField();
	incomeField.setFont(new Font("Segoe UI", Font.PLAIN, 18));
	incomeField.setBounds(820, 220, 300, 40);
	signUpPanel.add(incomeField);
	//initialization of new label
        JLabel documentLbl = new JLabel("Enter Document Information");
	documentLbl.setFont(new Font("Segoe UI", Font.BOLD, 18));
	documentLbl.setBounds(820, 275, 270, 25);
        documentLbl.setForeground(new Color(181, 29, 29));
	signUpPanel.add(documentLbl);
        //initialization of new label
        JLabel docnameLabel = new JLabel("Document name");
	docnameLabel.setHorizontalAlignment(SwingConstants.RIGHT);
	docnameLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
	docnameLabel.setBounds(900, 318, 218, 13);
	signUpPanel.add(docnameLabel);
	//initialization of text field	
        
	JTextField docnameField = new JTextField();
	docnameField.setFont(new Font("Segoe UI", Font.PLAIN, 18));
	docnameField.setBounds(820, 336, 300, 40);
	signUpPanel.add(docnameField);
	
        //initialization of new label
        JLabel docDescLabel = new JLabel("Document Desc.");
	docDescLabel.setHorizontalAlignment(SwingConstants.RIGHT);
	docDescLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
	docDescLabel.setBounds(900, 378, 218, 13);
	signUpPanel.add(docDescLabel);
	//initialization of text field	
	JTextField docDescField = new JTextField();
	docDescField.setFont(new Font("Segoe UI", Font.PLAIN, 18));
	docDescField.setBounds(820, 396, 300, 40);
	signUpPanel.add(docDescField);
	
        //initialization of button
        JButton registerButton = new JButton("Register");
	registerButton.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
            //action performed after the button is pressed
            String docName = docnameField.getText();
            String docDesc = docDescField.getText();
            String appName = nameField.getText();
            String appAddress = addressField.getText();
            String appInc = incomeField.getText();
            int appIncome = Integer.parseInt(appInc);
            int generatedID = helpaid.getApplicantID() + 1;
            String applicantUsername = helpaid.randomPasswordGenerator(8);
            String applicantPassword = helpaid.randomPasswordGenerator(8);
            
            helpaid.addDocument(generatedID, docName, docDesc);
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
            // a message dialog will appear if success
            JOptionPane.showMessageDialog(null, "Registration Success with following information:\n" + "Generated Username: " + applicantUsername + "\n" +"Generated Password: " + applicantPassword + "\n" + helpaid.getApplicantInfo(applicantUsername));
            dispose();
            
	}
		});
                // to set the layout and position of the button
		registerButton.setForeground(new Color(255, 255, 255));
		registerButton.setBackground(new Color(181, 29, 29));
		registerButton.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		registerButton.setBounds(820, 480, 273, 48);
		signUpPanel.add(registerButton);
    }
}
