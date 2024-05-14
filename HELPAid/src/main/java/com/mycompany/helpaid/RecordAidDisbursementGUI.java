/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.helpaid;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author felix
 */
//recordAidDisbursementGUI class which extends JFrame
public class RecordAidDisbursementGUI extends JFrame{
    
    //to add a localdate today
    LocalDate today = LocalDate.now();
    String dateString = today.toString();
    //initialization of JPanel
    private HELPAid helpaid;
    private JPanel recordAidPanel;
    private JPanel AppealInfoPanel;
    //a method which takes helpaid and username of orgrep
    public RecordAidDisbursementGUI(HELPAid helpaid, String usernameOrgRep){
        //to set the title of the frame
        setTitle("Record Aid Disbursement");
        // to make the window not resizeable
	setResizable(false);
        // to make sure the program doesn't close after window is closed
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        // to set the position and size of the frame
        setBounds(200, 100, 500, 700);
          
        //initialization of new panel
        recordAidPanel = new JPanel();
        // to set border
        recordAidPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(recordAidPanel); 
        recordAidPanel.setLayout(null);
        // to set position and size
        recordAidPanel.setBounds(0,0,500, 300);
        
        //initialization of scrollpane
        JScrollPane applicantPane = new JScrollPane();
        // to set the size and position
        applicantPane.setBounds(50, 20, 400, 120);
        // to add the pane to panel
        recordAidPanel.add(applicantPane);
                
        String appealList = helpaid.showAppeal();
        JTextArea appealTextArea = new JTextArea(appealList);
        appealTextArea.setLineWrap(true);
        appealTextArea.setWrapStyleWord(true);
        applicantPane.setViewportView(appealTextArea);
        
        //initialization of label
        JLabel selectLabel = new JLabel("Select appeal ID:  ");
        //to set the size and position of label
        selectLabel.setBounds(50, 165, 150, 20);
        // to set the color of foreground
        selectLabel.setForeground(Color.BLACK);
        // to set font, size, and sty;e
        selectLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        // to add the label to panel
        recordAidPanel.add(selectLabel);

        //initialization of text field
        JTextField selectTextField = new JTextField();
        // set the size and position
        selectTextField.setBounds(250, 165, 200, 25);
        recordAidPanel.add(selectTextField);

        //initialization of button
        JButton nextButton = new JButton("Next");
        nextButton.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
                        //action performed after the button is pressed
                        String select = selectTextField.getText();
                        int appealIDChoice = Integer.parseInt(select);
                        
                        //initialization of panel
                        AppealInfoPanel = new JPanel();
                        AppealInfoPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
                        setContentPane(AppealInfoPanel);   
                        AppealInfoPanel.setLayout(null);
                        AppealInfoPanel.setBounds(0,0,600, 600);
                         //initialization of label
                        JLabel AppealInfoLabel = new JLabel("Appeal Information: ");
                        AppealInfoLabel.setBounds(50, 30, 250, 20);
                        AppealInfoLabel.setForeground(Color.BLACK);
                        AppealInfoLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
                        AppealInfoPanel.add(AppealInfoLabel);
                        //correction
                        String appealInfo = helpaid.showAppeal(appealIDChoice -1);
                        JScrollPane infoPane = new JScrollPane();
                        infoPane.setBounds(50, 60, 400, 120);
                        JTextArea infoTextArea = new JTextArea(appealInfo);
                        infoTextArea.setLineWrap(true);
                        infoTextArea.setWrapStyleWord(true);
                        infoPane.setViewportView(infoTextArea);

                        AppealInfoPanel.add(infoPane);
                
                        //initialization of label
                        JLabel goodDescLabel = new JLabel("Donation Information: ");
                        goodDescLabel.setBounds(50, 210, 150, 20);
                        goodDescLabel.setForeground(Color.BLACK);
                        goodDescLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
                        AppealInfoPanel.add(goodDescLabel);
                        //string variable which takes from a method
                        String donInfo = helpaid.getDonationInfo(appealIDChoice);
                        JScrollPane donPane = new JScrollPane();
                        donPane.setBounds(50, 240, 400, 120);
                        JTextArea donTextArea = new JTextArea(donInfo);
                        donTextArea.setLineWrap(true);
                        donTextArea.setWrapStyleWord(true);
                        donPane.setViewportView(donTextArea);
                        // to add pane to panel
                        AppealInfoPanel.add(donPane);
                        
                        //label initialization
                        JLabel applicantRegLabel = new JLabel("Applicant Registered with Organization ");
                        applicantRegLabel.setBounds(50, 380, 250, 20);
                        applicantRegLabel.setForeground(Color.BLACK);
                        applicantRegLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
                        AppealInfoPanel.add( applicantRegLabel);

                        //string variable which takes from a method
                        String applicantReg = helpaid.getApplicantBasedOnOrg(helpaid.getOrgRepOrgID(usernameOrgRep));
                        JScrollPane applicantPane = new JScrollPane();
                        applicantPane.setBounds(50, 410, 400, 120);
                        JTextArea applicantRegTextArea = new JTextArea(applicantReg);
                        applicantRegTextArea.setLineWrap(true);
                        applicantRegTextArea.setWrapStyleWord(true);
                        applicantPane.setViewportView(applicantRegTextArea);
                        // to  add a pane to panel
                        AppealInfoPanel.add(applicantPane);
                        // label initializatioon
                        JLabel applicantLabel = new JLabel("Select Applicant by its ID:   ");
                        applicantLabel.setBounds(50, 550, 180, 20);
                        applicantLabel.setForeground(Color.BLACK);
                        applicantLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
                        AppealInfoPanel.add(applicantLabel);
                        //initialization of textfield
                        JTextField applicantTextField = new JTextField();
                        applicantTextField.setBounds(250, 550, 200, 25);
                        AppealInfoPanel.add(applicantTextField);
                        //initialization of button
                        JButton NextButton = new JButton("Next");
                        NextButton.addMouseListener(new MouseAdapter() {
                            @Override
                            public void mouseClicked(MouseEvent e) {
                                //action performed after the button is pressed
                                String applicantid = applicantTextField.getText();
                                int applicantID = Integer.parseInt(applicantid);
                                JPanel applicantInfoPanel = new JPanel();
                                applicantInfoPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
                                setContentPane(applicantInfoPanel);   
                                applicantInfoPanel.setLayout(null);
                                applicantInfoPanel.setBounds(0,0,600, 600);

                                //label initialization
                                JLabel appInfoLabel = new JLabel("Applicant Information");
                                appInfoLabel.setBounds(50, 50, 400, 20);
                                appInfoLabel.setForeground(Color.BLACK);
                                appInfoLabel.setFont(new Font("Segoe UI", Font.BOLD, 20));
                                applicantInfoPanel.add(appInfoLabel);

                                // a string which takes a data from method in helpaid
                                String applicantInfo = helpaid.getApplicantString(applicantID-1);
                                JScrollPane applicantInfoPane = new JScrollPane();
                                applicantInfoPane.setBounds(50, 100, 400, 120);
                                JTextArea applicantInfoTextArea = new JTextArea(applicantInfo);
                                applicantInfoTextArea.setLineWrap(true);
                                applicantInfoTextArea.setWrapStyleWord(true);
                                applicantInfoPane.setViewportView(applicantInfoTextArea);
                                applicantInfoPanel.add(applicantInfoPane);
                                
                                //initialization of label
                                JLabel disInfoLabel = new JLabel("Enter Disbursement Information:  ");
                                disInfoLabel.setBounds(50, 250, 250, 25);
                                disInfoLabel.setForeground(Color.BLACK);
                                disInfoLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
                                applicantInfoPanel.add(disInfoLabel);
                                //initialization of label
                                JLabel dateLabel = new JLabel("Date:  ");
                                dateLabel.setBounds(50, 285, 150, 20);
                                dateLabel.setForeground(Color.BLACK);
                                dateLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
                                applicantInfoPanel.add(dateLabel);
                                //initialization of text field
                                JTextField dateTextField = new JTextField();
                                dateTextField.setBounds(250, 285, 200, 25);
                                applicantInfoPanel.add(dateTextField);
                                //initialization of label
                                JLabel cashAmountLabel = new JLabel("Cash Amount: ");
                                cashAmountLabel.setBounds(50, 320, 150, 20);
                                cashAmountLabel.setForeground(Color.BLACK);
                                cashAmountLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
                                applicantInfoPanel.add(cashAmountLabel);
                                //initialization of text field
                                JTextField cashAmountTextField = new JTextField();
                                cashAmountTextField.setBounds(250, 320, 200, 25);
                                applicantInfoPanel.add(cashAmountTextField);
                                //initialization of label
                                JLabel goodsLabel = new JLabel("Goods:  ");
                                goodsLabel.setBounds(50, 355, 150, 20);
                                goodsLabel.setForeground(Color.BLACK);
                                goodsLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
                                applicantInfoPanel.add(goodsLabel);

                                JTextField goodsTextField = new JTextField();
                                goodsTextField.setBounds(250, 355, 200, 25);
                                applicantInfoPanel.add(goodsTextField);
                                //initialization of label
                                JLabel outcomeLabel = new JLabel("Outcome:  ");
                                outcomeLabel.setBounds(50, 390, 150, 20);
                                outcomeLabel.setForeground(Color.BLACK);
                                outcomeLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
                                applicantInfoPanel.add(outcomeLabel);

                                JTextField outcomeTextField = new JTextField();
                                outcomeTextField.setBounds(250, 390, 200, 25);
                                applicantInfoPanel.add(outcomeTextField);
                            //initialization of button
                            JButton addButton = new JButton("Register");
                            addButton.addMouseListener(new MouseAdapter() {
                            @Override
                            public void mouseClicked(MouseEvent e) {
                                String disDate = dateTextField.getText();
                                String Amount = cashAmountTextField.getText();
                                Double disAmount = Double.parseDouble(Amount);
                                String disGoods = goodsTextField.getText();
                                Disbursement disb = new Disbursement(disDate, disAmount, disGoods);
                                helpaid.setDisbursementData(disb);
                                Applicant appl = helpaid.getApplicant(applicantID-1);
                                appl.setDisbursement(disb);
                                String outcomeForAppeal = outcomeTextField.getText();
                                helpaid.recordOutcome(outcomeForAppeal, applicantID-1);
                                helpaid.getDisbursement();
                                JOptionPane.showMessageDialog(null, "Your Disbursement is recorded for the applicant." );
                                dispose();
                                
                            }
                            });
                            // to modify the style of the button, also the position and size
                            addButton.setForeground(new Color(255, 255, 255));
                            addButton.setBackground(new Color(181, 29, 29));
                            addButton.setFont(new Font("Segoe UI", Font.PLAIN, 18));
                            addButton.setBounds(100, 450, 273, 48);
                            applicantInfoPanel.add(addButton);
                            revalidate();
                                
                                
                            }
                        });
                        NextButton.setForeground(new Color(255, 255, 255));
                        NextButton.setBackground(new Color(181, 29, 29));
                        NextButton.setFont(new Font("Segoe UI", Font.PLAIN, 18));
                        NextButton.setBounds(100, 600, 300, 40);
                        AppealInfoPanel.add(NextButton);
                        revalidate();
                    }
                });
                nextButton.setForeground(new Color(255, 255, 255));
		nextButton.setBackground(new Color(181, 29, 29));
		nextButton.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		nextButton.setBounds(100, 250, 300, 40);
                recordAidPanel.add(nextButton);
    }
}
