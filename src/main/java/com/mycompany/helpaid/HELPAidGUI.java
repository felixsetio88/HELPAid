/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.helpaid;

/**
 *
 * @author felix
 */
//necessary imports
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
//class declaration which extends with JFrame
public class HELPAidGUI extends JFrame{
    private HELPAid helpaid;
    JFrame loginFrame;
    private JPanel loginPanel;
    private JTextField usernameTextField;
    private JPasswordField passwordField;
    private final JPanel panel = new JPanel();
    //main method
    public static void main(String[] args){
        HELPAid helpaid = new HELPAid();
        JFrame helpaidGUI = new HELPAidGUI(helpaid);
        helpaidGUI.setVisible(true);
    }
    // HELPAidGUI method which takes helpaid
    HELPAidGUI(HELPAid helpaid){
       //to set the title
        setTitle("HELPAid Menu");
        // to make sure the windows is not resizeable
        setResizable(false);
        // to set the size and position
        setBounds(200,150,1100,427);
        
        //initialization of label
        JLabel Background = new JLabel("");
        // to import images from local
	Background.setIcon(new ImageIcon(HELPAidGUI.class.getResource("/helpaid.jpg")));
        //to set the size 
	Background.setBounds(0, 0, 640, 427);
        // to add to panel
	panel.add(Background);
		
        // initialization of loginpanel        
        loginPanel = new JPanel();
        // to give border
        loginPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(loginPanel);
        loginPanel.setLayout(null);
        
        // initialization of welcome label
        JLabel welcomeLabel = new JLabel("HELPAid");
	welcomeLabel.setFont(new Font("Segoe UI", Font.BOLD, 48));
	welcomeLabel.setForeground(SystemColor.text);
	welcomeLabel.setHorizontalAlignment(SwingConstants.LEFT);
	welcomeLabel.setBounds(100, 223, 362, 68);
	loginPanel.add(welcomeLabel);
        
        // initialization of we care label 
        JLabel wecareLabel = new JLabel("We Care For Each Other");
	wecareLabel.setHorizontalAlignment(SwingConstants.LEFT);
	wecareLabel.setForeground(Color.WHITE);
	wecareLabel.setFont(new Font("Segoe UI", Font.PLAIN, 24));
	wecareLabel.setBounds(100, 280, 362, 50);
        loginPanel.add(wecareLabel);
                
        //initialization of login menu label
        JLabel loginLabel = new JLabel("Login Menu");
	loginLabel.setHorizontalAlignment(SwingConstants.RIGHT);
	loginLabel.setFont(new Font("Segoe UI", Font.BOLD, 38));
	loginLabel.setBounds(631, 22, 376, 54);
	loginPanel.add(loginLabel);
		
        //initialization of username label
	JLabel usernameLabel = new JLabel("Username");
	usernameLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
	usernameLabel.setHorizontalAlignment(SwingConstants.RIGHT);
	usernameLabel.setBounds(701, 82, 306, 30);
	loginPanel.add(usernameLabel);      
        
        //initialization of JTextField
        usernameTextField = new JTextField();
	usernameTextField.setHorizontalAlignment(SwingConstants.RIGHT);
	usernameTextField.setFont(new Font("Segoe UI", Font.PLAIN, 18));
	usernameTextField.setBounds(631, 112, 376, 35);
        loginPanel.add(usernameTextField);
	usernameTextField.setColumns(10);
                
        //initialization of password
        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setHorizontalAlignment(SwingConstants.RIGHT);
	passwordLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
	passwordLabel.setBounds(701, 162, 306, 30);
	loginPanel.add(passwordLabel);
		
        //initialization of password field
	passwordField = new JPasswordField();
	passwordField.setHorizontalAlignment(SwingConstants.RIGHT);
	passwordField.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        passwordField.setBounds(631, 192, 376, 35);
	loginPanel.add(passwordField);
        
        //initialization of button
        JButton loginAdminBtn = new JButton("Login as Admin");
	loginAdminBtn.addMouseListener(new MouseAdapter() {
	@Override
	public void mouseClicked(MouseEvent e) {
            //adtion performed after the button is pressed
	if (!helpaid.administratorLoginChecker(usernameTextField.getText(), passwordField.getText())){
            JOptionPane.showMessageDialog(usernameTextField, "Wrong password or username is not available, please try again!");
            }
	else if(usernameTextField.getText().isEmpty()||passwordField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(usernameTextField, "You must enter both username and password field");
            }
	else {
            JOptionPane.showMessageDialog(usernameTextField, "Login Success!");
            AdministratorGUI admin = new AdministratorGUI(helpaid);
            admin.setVisible(true);
            }
	}
        });
        // to set the style, position, and size of the button
        loginAdminBtn.setFont(new Font("Segoe UI", Font.PLAIN, 16));
	loginAdminBtn.setBackground(new Color(50, 168, 64));
	loginAdminBtn.setForeground(new Color(230, 230, 250));
	loginAdminBtn.setBounds(631, 257, 185, 30);
	loginPanel.add(loginAdminBtn);
        
        //initialization of button 
        JButton registerBtn = new JButton("Create Account");
	registerBtn.addMouseListener(new MouseAdapter() {
	@Override
	public void mouseClicked(MouseEvent e) {
            //action performed after button is pressed
                SignUpGUI signup = new SignUpGUI(helpaid);
		signup.setVisible(true);
	
            }
	});
	// to set the style of the button, position, and size	
        registerBtn.setForeground(new Color(255,255,255));
	registerBtn.setFont(new Font("Segoe UI", Font.PLAIN, 16));
	registerBtn.setBackground(new Color(181, 166, 29));
	registerBtn.setBounds(816, 257, 185, 30);
	loginPanel.add(registerBtn);
	panel.setBounds(0, 0, 552, 547);
	loginPanel.add(panel);
	panel.setLayout(null);
        
        //initialization of button
        JButton loginOrgRepBtn = new JButton("Login as Org Rep");
	loginOrgRepBtn.addMouseListener(new MouseAdapter() {
	@Override
	public void mouseClicked(MouseEvent e) {
            //action performed after the button is pressd
	if (!helpaid.loginOrganizationRepresentative(usernameTextField.getText(), passwordField.getText())){
            JOptionPane.showMessageDialog(usernameTextField, "Wrong password or username is not available, please try again!");
            }
	else if(usernameTextField.getText().isEmpty()||passwordField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(usernameTextField, "You must enter both username and password field");
            }
	else if (helpaid.loginOrganizationRepresentative(usernameTextField.getText(), passwordField.getText())){
            JOptionPane.showMessageDialog(usernameTextField, "Login Success! Welcome " + helpaid.getOrgRepInfo(usernameTextField.getText()));
            OrgRepGUI orgrep = new OrgRepGUI(helpaid, usernameTextField.getText());
            orgrep.setVisible(true);

            }
	}
        });
        // to set the style, size, etc of the button
        loginOrgRepBtn.setFont(new Font("Segoe UI", Font.PLAIN, 16));
	loginOrgRepBtn.setBackground(new Color(181, 29, 29));
	loginOrgRepBtn.setForeground(new Color(255,255,255));
	loginOrgRepBtn.setBounds(631, 287, 185, 30);
	loginPanel.add(loginOrgRepBtn);
        
        // initialization of the button
        JButton loginApplicantBtn = new JButton("Login as Applicant");
	loginApplicantBtn.addMouseListener(new MouseAdapter() {
	@Override
	public void mouseClicked(MouseEvent e) {
	if (!helpaid.applicantLoginChecker(usernameTextField.getText(), passwordField.getText())){
            JOptionPane.showMessageDialog(usernameTextField, "Wrong password or username is not available, please try again!");
            }
	else if(usernameTextField.getText().isEmpty()||passwordField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(usernameTextField, "You must enter both username and password field");
            }
	else if (helpaid.applicantLoginChecker(usernameTextField.getText(), passwordField.getText())){
            JOptionPane.showMessageDialog(usernameTextField, "Login Success! Welcome " + helpaid.getApplicantInfo(usernameTextField.getText()));
            ApplicantGUI appGUI = new ApplicantGUI(helpaid, usernameTextField.getText());
            appGUI.setVisible(true);
            }
	}
        });
        // to set the style, size and position of the button
        loginApplicantBtn.setFont(new Font("Segoe UI", Font.PLAIN, 16));
	loginApplicantBtn.setBackground(new Color(0, 122, 156));
	loginApplicantBtn.setForeground(new Color(255,255,255));
	loginApplicantBtn.setBounds(816, 287, 185, 30);
	loginPanel.add(loginApplicantBtn);
        
        //initialization of button
        JButton donorMenuBtn = new JButton("Donor's Menu");
	donorMenuBtn.addMouseListener(new MouseAdapter() {
	@Override
	public void mouseClicked(MouseEvent e) {
            //action performed after button is pressed
            DonorsMenu donor = new DonorsMenu(helpaid);
            donor.setVisible(true);
	}
        });
        //to set the style, size and position of the button
        donorMenuBtn.setFont(new Font("Segoe UI", Font.PLAIN, 16));
	donorMenuBtn.setBackground(new Color(237, 135, 255));
	donorMenuBtn.setForeground(new Color(255,255,255));
	donorMenuBtn.setBounds(631, 317, 370, 30);
	loginPanel.add(donorMenuBtn);
    }
}
