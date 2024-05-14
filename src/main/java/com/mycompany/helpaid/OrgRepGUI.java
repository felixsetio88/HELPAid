/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.helpaid;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author felix
 */
// class orgRepGUI which extends with JFrame
public class OrgRepGUI extends JFrame{
    private HELPAid helpaid;
    private JPanel signUpPanel;
    //orgRepGui method which takes helpaid, and orgrep
    public OrgRepGUI(HELPAid helpaid,String orgRep){
        // to make the frame visible
        setVisible(true);
        // to make sure the frame is not resizeable
	setResizable(false);
        // to set the title
        setTitle("Organization Representative Menu");
        // to set the background color
        setBackground(new Color(255, 255, 255));
        // to make sure not the entire program is closed
	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        // to set the position and size
        setBounds(200, 100, 750, 427);
        
        //initialization of panel
        signUpPanel = new JPanel();
	signUpPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(signUpPanel);
	signUpPanel.setLayout(null);
                
        //initialization of panel
        JPanel panelBackground = new JPanel();
	panelBackground.setBounds(0, 0, 400, 427);
	signUpPanel.add(panelBackground);
	panelBackground.setLayout(null);
                
        
        //initialization of label
        JLabel orgRepLabel = new JLabel("Organization Representative");
	orgRepLabel.setForeground(new Color(181, 29, 29));
	orgRepLabel.setFont(new Font("Segoe UI", Font.BOLD, 22));
	orgRepLabel.setBounds(50, 200, 300, 200);
        panelBackground.add(orgRepLabel);
        signUpPanel.setVisible(true);
        
        //initialization of label
        JLabel background = new JLabel("");
	background.setIcon(new ImageIcon(AdministratorGUI.class.getResource("/administrator.jpg")));
	background.setBounds(0, 0, 400, 427);
	panelBackground.add(background);
        
        
        //initialization of label
        JLabel toDoLabel = new JLabel("What do you want to do?");
	toDoLabel.setHorizontalAlignment(SwingConstants.RIGHT);
	toDoLabel.setFont(new Font("Segoe UI", Font.PLAIN, 18));
	toDoLabel.setBounds(450, 20, 218, 20);
	signUpPanel.add(toDoLabel);
        
        //initialization of button
        JButton regApplicantBtn = new JButton("Sign Up Applicant");
	regApplicantBtn.addMouseListener(new MouseAdapter() {
	@Override
	public void mouseClicked(MouseEvent e) {
                //need new class named "SignUpApplicant"
		SignUpApplicant appl = new SignUpApplicant(helpaid, orgRep);
                appl.setVisible(true);
            }
	});
        // to modify how the button looks, feels and positioned
	regApplicantBtn.setFont(new Font("Segoe UI", Font.PLAIN, 15));
	regApplicantBtn.setBackground(new Color(181, 29, 29));
	regApplicantBtn.setForeground(new Color(230, 230, 250));
	regApplicantBtn.setBounds(450, 65, 225, 53);
	signUpPanel.add(regApplicantBtn);
        
        //initialization of new button
        JButton recordAppealBtn = new JButton("Record new appeal for aid");
	recordAppealBtn.addMouseListener(new MouseAdapter() {
	@Override
	public void mouseClicked(MouseEvent e) {
                // Action performed after the button is pressed
                RecordAppealGUI recAppeal = new RecordAppealGUI(helpaid, orgRep);
                recAppeal.setVisible(true);
            }
	});
        recordAppealBtn.setFont(new Font("Segoe UI", Font.PLAIN, 15));
	recordAppealBtn.setBackground(new Color(181, 29, 29));
	recordAppealBtn.setForeground(new Color(230, 230, 250));
	recordAppealBtn.setBounds(450, 125, 225, 53);
	signUpPanel.add(recordAppealBtn);
        
        //initialization of button
        JButton recordContributionBtn = new JButton("Record contribution");
	recordContributionBtn.addMouseListener(new MouseAdapter() {
	@Override
	public void mouseClicked(MouseEvent e) {
                RecordContributionGUI rec = new RecordContributionGUI(helpaid);
                rec.setVisible(true);
            }
	});
        recordContributionBtn.setFont(new Font("Segoe UI", Font.PLAIN, 15));
	recordContributionBtn.setBackground(new Color(181, 29, 29));
	recordContributionBtn.setForeground(new Color(230, 230, 250));
	recordContributionBtn.setBounds(450, 185, 225, 53);
	signUpPanel.add(recordContributionBtn);
        
        //initialization of button
        JButton recordAidDisBtn = new JButton("Record Aid Disbursement");
	recordAidDisBtn.addMouseListener(new MouseAdapter() {
	@Override
	public void mouseClicked(MouseEvent e) {
                RecordAidDisbursementGUI disb = new RecordAidDisbursementGUI(helpaid, orgRep);
                disb.setVisible(true);
            }
	});
        recordAidDisBtn.setFont(new Font("Segoe UI", Font.PLAIN, 15));
	recordAidDisBtn.setBackground(new Color(181, 29, 29));
	recordAidDisBtn.setForeground(new Color(230, 230, 250));
	recordAidDisBtn.setBounds(450, 245, 225, 53);
	signUpPanel.add(recordAidDisBtn);
    }
   
}