/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.helpaid;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import static java.nio.file.Files.size;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author felix
 */
// class signUpORgRep extends with JFrame
public class SignUpOrgRep  extends JFrame{
    private HELPAid helpaid;
    //initialization of JPanel, JTable, and DefaultTableModel
    private JPanel registrationPanel;
    private JTable orgTable;
    private DefaultTableModel orgTableModel;
    public SignUpOrgRep(HELPAid helpaid){
        // To set the title
        setTitle("Sign Up Organization Representative");
        // to make the windows not resizable
	setResizable(false);
        // To dispose on close
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
                // To change position and size
                setBounds(200, 100, 525, 500);
                 //initialiation of JPanel
                registrationPanel = new JPanel();
                registrationPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
                setContentPane(registrationPanel);   
                registrationPanel.setLayout(null);

                // initialization of label
                JLabel availableLabel = new JLabel("Available Organization");
                availableLabel.setBounds(50, 20, 250, 20);
                availableLabel.setForeground(new Color(50, 168, 64));
                availableLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
                registrationPanel.add(availableLabel);
                //array of string
                String[] columnnames = {"Name", "Address", "ID"};
                orgTableModel = new DefaultTableModel(columnnames, 0);

                // to create a JTable with the model
                orgTable = new JTable(orgTableModel);

                // to fill the table with data from HelpAid
                for (Organization org : helpaid.getOrganization()) {
                    Object[] rowData = {
                            org.getOrgName(),
                            org.getAddress(),
                            org.getOrgID(),
                    };
                    orgTableModel.addRow(rowData);
                }

                // to add the table to a JScrollPane
                JScrollPane orgPane = new JScrollPane(orgTable);
                orgPane.setBounds(50, 50, 400, 120);  // Adjust the bounds accordingly
                registrationPanel.add(orgPane);
                // initialization of label
                JLabel usernameLabel = new JLabel("Username:");
                usernameLabel.setBounds(50, 185, 80, 20);
                usernameLabel.setForeground(Color.BLACK);
                usernameLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
                registrationPanel.add(usernameLabel);
                // initializatiohn of text field
                JTextField usernameTextField = new JTextField();
                usernameTextField.setBounds(180, 185, 200, 25);
                registrationPanel.add(usernameTextField);
                // initialization of label
                JLabel fullnameLabel = new JLabel("Full Name:");
                fullnameLabel.setBounds(50, 220, 80, 20);
                fullnameLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
                registrationPanel.add(fullnameLabel);
                // initializatiohn of text field
                JTextField fullnameTextField = new JTextField();
                fullnameTextField.setBounds(180, 220, 200, 25);
                registrationPanel.add(fullnameTextField);
                // initialization of label
                JLabel mobileLabel = new JLabel("Mobile No:");
                mobileLabel.setBounds(50, 255, 80, 20);
                mobileLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
                registrationPanel.add(mobileLabel);
                // initializatiohn of text field
                JTextField mobileTextField = new JTextField();
                mobileTextField.setBounds(180, 255, 200, 25);
                registrationPanel.add(mobileTextField);
                // initialization of label
                JLabel jobTitleLabel = new JLabel("Job Title:");
                jobTitleLabel.setBounds(50, 290, 80, 20);
                jobTitleLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
                registrationPanel.add(jobTitleLabel);
                // initializatiohn of text field
                JTextField jobTitleTextField = new JTextField();
                jobTitleTextField.setBounds(180, 290, 200, 25);
                registrationPanel.add(jobTitleTextField);
                // initialization of label
                JLabel selectedOrgLabel = new JLabel("Selected Org (ID)");
                selectedOrgLabel.setBounds(50, 325, 110, 20);
                selectedOrgLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
                registrationPanel.add(selectedOrgLabel);
                // initializatiohn of text field
                JTextField selectedOrgTextField = new JTextField();
                selectedOrgTextField.setBounds(180, 325, 200, 25);
                registrationPanel.add(selectedOrgTextField);
                //initialization of button
                JButton registerButton = new JButton("Register");
                registerButton.setBounds(180, 350, 100, 30);
                registerButton.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        String username = usernameTextField.getText();
                        String password = helpaid.randomPasswordGenerator(8);
                        String fullname = fullnameTextField.getText();
                        String phoneNumber = mobileTextField.getText();
                        String jobtitle = jobTitleTextField.getText();
                        String orgID = selectedOrgTextField.getText();
                        int orgid = Integer.parseInt(orgID);
                        while (helpaid.isOrgRepAvailable(username) == true && helpaid.isUsernameAvailable(username)){
                                //make a sorry that the username is not available
                                JOptionPane.showMessageDialog(null, "Username " + username + " is already taken.");
                                return;
                            }
                            OrganizationRep orgRep = new OrganizationRep(username, password, fullname, "", phoneNumber, jobtitle);
                            helpaid.setOrgRepData(orgRep);
                            Organization Org = helpaid.getOrganization(orgid -1);
                            Org.setRepresentative(orgRep);
                            JOptionPane.showMessageDialog(null, "Registration Success! Generated Password: " + password + " You are registered at " + helpaid.selectedOrganization(orgid -1));
                            dispose();
                    }
                });
                //to change the layout of the button
                registerButton.setForeground(new Color(255, 255, 255));
		registerButton.setBackground(new Color(50, 168, 64));
		registerButton.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		registerButton.setBounds(100, 380, 300, 40);
                registrationPanel.add(registerButton);
    
                //layeredPane.setVisible(true);
    }
  
}
