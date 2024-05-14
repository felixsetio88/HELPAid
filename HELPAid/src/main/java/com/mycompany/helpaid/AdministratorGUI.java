/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.helpaid;

/**
 *
 * @author felix
 */
//neccessary imports for various classes
// and packages to make a GUI Application
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
//class declaration, which extends to JFrame
public class AdministratorGUI extends JFrame{
    private HELPAid helpaid;
    //initialization of JPanel named AdminPanel
    private JPanel AdminPanel;
    //method named AdministratorGUI which takes HELPAid
    public AdministratorGUI(HELPAid helpaid){
        //to make the frame visible
        setVisible(true);
        //to make the GUI application not resizeable
	setResizable(false);
        //The title
        setTitle("Administrator menu");
        //To set the background color of 255,255, 255 (White)
        setBackground(new Color(255, 255, 255));
        //To make sure the application will not closed 
        //If only this frame is closed
	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //set the size and position of the frame
        setBounds(200, 100, 750, 427);
        
        
        //new JPanel
        AdminPanel = new JPanel();
        //to make a margin of 5px for the top, left, bottom, and right
	AdminPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        //sets the content pane of the frame, tipically an area to put components
        //for example: buttons, panels, textField, etc.
	setContentPane(AdminPanel);
        //the layout is set to null
	AdminPanel.setLayout(null);
                
        //declaration of panelBackground
        JPanel panelBackground = new JPanel();
        //to set the position and size of the "panelBackground"
	panelBackground.setBounds(0, 0, 400, 427);
        //to add "panelBackground" into "AdminPanel"
	AdminPanel.add(panelBackground);
        //to set the layout to null
	panelBackground.setLayout(null);
             
        //a label with "Administrator"
        JLabel adminLabel = new JLabel("Administrator");
        //to set the foreground color of the adminPanel
	adminLabel.setForeground(new Color(50, 168, 64));
        //to set the font, style, and also the size
	adminLabel.setFont(new Font("Segoe UI", Font.BOLD, 40));
        //to set the position of the adminLabel
	adminLabel.setBounds(50, 200, 300, 200);
        //to add the adminLabel into panelBackground
        panelBackground.add(adminLabel);
        //to set the AdminPanel visible
        AdminPanel.setVisible(true);
        
        //JLabel named "sidePhoto"
        JLabel sidePhoto = new JLabel("");
        //to get the image from file
	sidePhoto.setIcon(new ImageIcon(AdministratorGUI.class.getResource("/administrator.jpg")));
        //to set where the photo will be positioned and also the size
	sidePhoto.setBounds(0, 0, 400, 427);
        //to add "sidePhoto" into panelBackground
	panelBackground.add(sidePhoto);
        
        //initialization of toDoLabel, with content: "What do you want to do?"
        JLabel toDoLabel = new JLabel("What do you want to do?");
        //to set the horizontal alligntment to right;
	toDoLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        //to set the font, style and also font size
	toDoLabel.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        //to set the size and position of the label
	toDoLabel.setBounds(450, 20, 218, 20);
        //to add the label into the frame
	AdminPanel.add(toDoLabel);
        
        //initialization of button 
        JButton signUpOrgRepBtn = new JButton("Sign Up Organization Representative");
	signUpOrgRepBtn.addMouseListener(new MouseAdapter() {
	@Override
	public void mouseClicked(MouseEvent e) {
            //action that will be performed when the button is pressed
            
                //initialization of class
		SignUpOrgRep signup = new SignUpOrgRep(helpaid);
                //to set it visible
                signup.setVisible(true);
            }
	});
        //to set the font, stylem and font size
	signUpOrgRepBtn.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        //to set the background color of the button
	signUpOrgRepBtn.setBackground(new Color(50, 168, 64));
        //to set the foreground color of the button
	signUpOrgRepBtn.setForeground(new Color(255,255,255));
        //to set the position and the size of the button
	signUpOrgRepBtn.setBounds(450, 65, 225, 53);
        // to add the button to the panel
	AdminPanel.add(signUpOrgRepBtn);
        
        //initialization of the button
        JButton manageOrgBtn = new JButton("Manage Organization");
	manageOrgBtn.addMouseListener(new MouseAdapter() {
	@Override
	public void mouseClicked(MouseEvent e) {
            //action performed after the button is pressed
            
                //initialization of class
                ManageOrganization manage = new ManageOrganization(helpaid);
                //to make it visible
                manage.setVisible(true);
            }
	});
        //to set the font, style and size of the text
        manageOrgBtn.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        //to set the background color of the button
	manageOrgBtn.setBackground(new Color(50, 168, 64));
        //to set the foreground color of the button
	manageOrgBtn.setForeground(new Color(255,255,255));
        //to set the size and the position of the button
	manageOrgBtn.setBounds(450, 125, 225, 53);
        //to add the button into the panel
	AdminPanel.add(manageOrgBtn);
        
        //initialization of a button
        JButton displayBtn = new JButton("Display All Registered User");
	displayBtn.addMouseListener(new MouseAdapter() {
	@Override
	public void mouseClicked(MouseEvent e) {
            //action that will be done after the button is pressed
            
                //initialization of class
                DisplayAll disp = new DisplayAll(helpaid);
                //to make it visible
                disp.setVisible(true);
            }
	});
        //to set the font, style and size
        displayBtn.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        //to set the background color
	displayBtn.setBackground(new Color(50, 168, 64));
        //to set the foreground color
	displayBtn.setForeground(new Color(255,255,255));
        //to set the position and the size of the button
	displayBtn.setBounds(450, 185, 225, 53);
        //to add the button to the adminPanel
	AdminPanel.add(displayBtn);
        
        //initialization of button
        JButton saveBtn = new JButton("Save Data");
	saveBtn.addMouseListener(new MouseAdapter() {
	@Override
	public void mouseClicked(MouseEvent e) {
            //will be performed after the button is pressed
            
                //initialization of variable that will be used
                //to add the .txt file
                String allAdmin = helpaid.showAllUser();
                String allOrgRep = helpaid.showAllOrgRep();
                String allApplicant = helpaid.showAllApplicant();
                String allAppeal = helpaid.showAppeal();
                String allOrg = helpaid.showOrganization();
                String allDocument = helpaid.showDocument();
                String allCashDon = helpaid.getCashDonation();
                String allGoods = helpaid.getGoods();
                //to set the name of the txt filed to "file.txt"
                Path txtFile = Paths.get("file.txt");
                try(BufferedWriter toWrite = Files.newBufferedWriter(txtFile, StandardCharsets.UTF_8)){
                    //the content of the file "file.txt"
                    toWrite.write("All registered administrator");
                    toWrite.newLine();
                    toWrite.write(allAdmin);
                    toWrite.newLine();
                    
                    toWrite.write("All registered Organization Representative");
                    toWrite.newLine();
                    toWrite.write(allOrgRep);
                    toWrite.newLine();
                    
                    toWrite.write("All registered Applicant");
                    toWrite.newLine();
                    toWrite.write(allApplicant);
                    toWrite.newLine();
                    
                    toWrite.write("All registered Appeal");
                    toWrite.newLine();
                    toWrite.write(allAppeal);
                    toWrite.newLine();
                    
                    toWrite.write("All registered Organization");
                    toWrite.newLine();
                    toWrite.write(allOrg);
                    toWrite.newLine();
                    
                    toWrite.write("All registered Document");
                    toWrite.newLine();
                    toWrite.write(allDocument);
                    toWrite.newLine();
                    
                    toWrite.write("All registered Cash Donation");
                    toWrite.newLine();
                    toWrite.write(allCashDon);
                    toWrite.newLine();
                    
                    toWrite.write("All registered Goods");
                    toWrite.newLine();
                    toWrite.write(allGoods);
                    toWrite.newLine();
                    JOptionPane.showMessageDialog(null, "Save to file success!");
                    
                }
                //to prevent the program from crashing when there is an error
                catch (IOException error){
                    error.printStackTrace();
                    //a dialog will showup when the saving is failed and there is an error
                    JOptionPane.showMessageDialog(null, "Save to file failed, error: " + error);
                }
            }
	});
        //to set the font, style and size of the text
        saveBtn.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        //to set the background color
	saveBtn.setBackground(new Color(50, 168, 64));
        //to set the foreground color
	saveBtn.setForeground(new Color(255,255,255));
        //to set the position of the button and the size of the button
	saveBtn.setBounds(450, 245, 225, 53);
        //to add the button to the panel
	AdminPanel.add(saveBtn);
    }
   
}
