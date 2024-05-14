/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.helpaid;

/**
 *
 * @author felix
 */
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import javax.swing.JRadioButton;

//class SignUpGUI which extends with JFrame
public class SignUpGUI extends JFrame{
    
    //initialization of JPanel and TextField
    private HELPAid helpaid;
    private JPanel signUpPanel;
    private JTextField usernameField;
    private JTextField emailField;
    private JTextField fullnameField;
    private JTextField phonenumberField;
    //a method which takes helpaid
    public SignUpGUI(HELPAid helpaid){
        // to set the title
        setTitle("Sign Up Administrator");
        // to make the windows not resizable
	setResizable(false);
        // to set the background color
	setBackground(new Color(255, 255, 255));
        // to dispose on close
	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        // to set the size and position
	setBounds(200, 100, 1200, 600);
        
        //initialization of new panel
	signUpPanel = new JPanel();
	signUpPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(signUpPanel);
	signUpPanel.setLayout(null);
	//initialization of new panel           
	JPanel panelBackground = new JPanel();
	panelBackground.setBounds(0, 0, 700, 600);
	signUpPanel.add(panelBackground);
	panelBackground.setLayout(null);
        //initialization of label
	JLabel SignUp = new JLabel("Sign Up");
	SignUp.setForeground(new Color(181, 166, 29));
	SignUp.setFont(new Font("Segoe UI", Font.BOLD, 70));
	SignUp.setBounds(100, 350, 600, 200);
	panelBackground.add(SignUp);
        //initialization of label
        JLabel asAdmin = new JLabel("as Administrator");
	asAdmin.setForeground(new Color(181, 166, 29));
	asAdmin.setFont(new Font("Segoe UI", Font.ITALIC, 20));
	asAdmin.setBounds(100, 400, 600, 200);
	panelBackground.add(asAdmin);
        //initialization of label for background
        JLabel background = new JLabel("");
	background.setIcon(new ImageIcon(SignUpGUI.class.getResource("/register.jpg")));
	background.setBounds(0, 0, 700, 600);
	panelBackground.add(background);
        
	//initialization of label	
        JLabel usernameLbl = new JLabel("Username");
	usernameLbl.setHorizontalAlignment(SwingConstants.RIGHT);
	usernameLbl.setFont(new Font("Segoe UI", Font.PLAIN, 14));
	usernameLbl.setBounds(900, 50, 218, 13);
	signUpPanel.add(usernameLbl);
	//initialization of text field
        
	usernameField = new JTextField();
	usernameField.setFont(new Font("Segoe UI", Font.PLAIN, 18));
	usernameField.setBounds(820, 75, 300, 40);
	signUpPanel.add(usernameField);
	usernameField.setColumns(10);
        //initialization of label
        JLabel passwordLbl = new JLabel("Password");
	passwordLbl.setHorizontalAlignment
	(SwingConstants.RIGHT);passwordLbl.setFont(new Font("Segoe UI", Font.PLAIN, 14));
	passwordLbl.setBounds(900, 125, 218, 13);
	signUpPanel.add(passwordLbl);
        //initialization of text field
        JPasswordField passwordField = new JPasswordField();
	passwordField.setFont(new Font("Segoe UI", Font.PLAIN, 18));
	passwordField.setBounds(820, 150, 300, 40);
	signUpPanel.add(passwordField);
        //initialization of label
        JLabel emailLabel = new JLabel("Email");
	emailLabel.setHorizontalAlignment(SwingConstants.RIGHT);
	emailLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
	emailLabel.setBounds(900, 200, 218, 13);
	signUpPanel.add(emailLabel);
	//initialization of text field	
	emailField = new JTextField();
	emailField.setFont(new Font("Segoe UI", Font.PLAIN, 18));
	emailField.setBounds(820, 225, 300, 40);
	signUpPanel.add(emailField);
	emailField.setColumns(10);
        //initialization of label
        JLabel fullnameLabel = new JLabel("Full name ");
	fullnameLabel.setHorizontalAlignment(SwingConstants.RIGHT);
	fullnameLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
	fullnameLabel.setBounds(900, 275, 218, 13);
	signUpPanel.add(fullnameLabel);
	//initialization of text field	
	fullnameField = new JTextField();
	fullnameField.setFont(new Font("Segoe UI", Font.PLAIN, 18));
	fullnameField.setBounds(820, 300, 300, 40);
	signUpPanel.add(fullnameField);
	emailField.setColumns(10);
        //initialization of label
        JLabel phonenumberLabel = new JLabel("Phone number ");
	phonenumberLabel.setHorizontalAlignment(SwingConstants.RIGHT);
	phonenumberLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
	phonenumberLabel.setBounds(900, 350, 218, 13);
	signUpPanel.add(phonenumberLabel);
	//initialization of text field	
	phonenumberField = new JTextField();
	phonenumberField.setFont(new Font("Segoe UI", Font.PLAIN, 18));
	phonenumberField.setBounds(820, 375, 300, 40);
	signUpPanel.add(phonenumberField);
	phonenumberField.setColumns(10);
        //initialization of button
        JButton registerButton = new JButton("Register");
	registerButton.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
            // action performed after button is pressed
            String usernameInput = usernameField.getText();
            String passwordInput = passwordField.getText();
            String emailInput = emailField.getText();
            String fullNameInput = fullnameField.getText();
            String phonenumber = phonenumberField.getText();
		while(helpaid.isUsernameAvailable(usernameInput) && helpaid.isOrgRepAvailable(usernameInput)) {
                    JOptionPane.showMessageDialog(passwordField, "Your Username has been taken, cboose another username!");
               
                    usernameField.setText("");
                    
                    return;
		}
		while (usernameField.getText().isEmpty()||
		passwordField.getText().isEmpty()||
		emailField.getText().isEmpty()||
		fullnameField.getText().isEmpty()||
                phonenumberField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(passwordField, "You must fill all of the blank!");
                    return;
		}
                User User = new User(usernameInput, passwordInput, fullNameInput, emailInput, phonenumber);
                helpaid.setHelpAid(User);
                
                JOptionPane.showMessageDialog(null, "Registration success!");
                dispose();
		
	}
		});
        // to set the layout, and design of the button
		registerButton.setForeground(new Color(255, 255, 255));
		registerButton.setBackground(new Color(181, 166, 29));
		registerButton.setFont(new Font("Segoe UI", 
				Font.PLAIN, 18));
		registerButton.setBounds(820, 450, 300, 40);
		signUpPanel.add(registerButton);
    }
}
