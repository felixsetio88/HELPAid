/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.helpaid;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.time.LocalDate;
/**
 *
 * @author felix
 */
//class RecordContributionGUI which extends with JFrame
public class RecordContributionGUI extends JFrame{
    LocalDate today = LocalDate.now();
    String dateString = today.toString();
    private HELPAid helpaid;
    //initialiation of JPanel
    private JPanel recordPanel;
    private JPanel goodsDonationPanel;
    private JPanel CashDonationPanel;
    //a method which takes helpaid
    public RecordContributionGUI(HELPAid helpaid){
        // to set the title of the JFrame
        setTitle("Record Contribution");
        // to make the windows not resizable
	setResizable(false);
        // to make the windows dispose when closed
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        // to set the size and position
        setBounds(200, 100, 525, 562);
          
        //initialization of panel
        recordPanel = new JPanel();
        recordPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(recordPanel); 
        recordPanel.setLayout(null);
        recordPanel.setBounds(0,0,500, 300);
        
        //initialiation of pane
        JScrollPane applicantPane = new JScrollPane();
        applicantPane.setBounds(50, 20, 400, 120);
        recordPanel.add(applicantPane);
                
        //initialization variable which takes a data from helpaid class
        String appealList = helpaid.showAppeal();
        JTextArea appealTextArea = new JTextArea(appealList);
        appealTextArea.setLineWrap(true);
        appealTextArea.setWrapStyleWord(true);
        applicantPane.setViewportView(appealTextArea);
        
        //initialization of label
        JLabel selectLabel = new JLabel("Select appeal ID:  ");
        selectLabel.setBounds(50, 165, 150, 20);
        selectLabel.setForeground(Color.BLACK);
        selectLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        recordPanel.add(selectLabel);
        //initialization of text field
        JTextField selectTextField = new JTextField();
        selectTextField.setBounds(250, 165, 200, 25);
        recordPanel.add(selectTextField);
        //initialization of label
        JLabel toDoLabel = new JLabel("What kind of donation?");
        toDoLabel.setBounds(50, 200, 150, 20);
        toDoLabel.setForeground(Color.BLACK);
        toDoLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        recordPanel.add(toDoLabel);
        //initialization of button
        JButton goodsButton = new JButton("Goods");
        goodsButton.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
                        //action performed after the button is presseed
                        goodsDonationPanel = new JPanel();
                        goodsDonationPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
                        setContentPane(goodsDonationPanel);   
                        goodsDonationPanel.setLayout(null);
                        goodsDonationPanel.setBounds(0,0,500, 500);
                         //initialization of label
                        JLabel goodsDonationLabel = new JLabel("Goods donation");
                        goodsDonationLabel.setBounds(50, 50, 250, 20);
                        goodsDonationLabel.setForeground(Color.BLACK);
                        goodsDonationLabel.setFont(new Font("Segoe UI", Font.BOLD, 20));
                        goodsDonationPanel.add(goodsDonationLabel);
                         //initialization of label
                        JLabel goodDescLabel = new JLabel("Goods Description ");
                        goodDescLabel.setBounds(50, 120, 150, 20);
                        goodDescLabel.setForeground(Color.BLACK);
                        goodDescLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
                        goodsDonationPanel.add(goodDescLabel);
                        //initialization of textfield
                        JTextField goodDescTextField = new JTextField();
                        goodDescTextField.setBounds(230, 120, 200, 25);
                        goodsDonationPanel.add(goodDescTextField);
                         //initialization of label
                        JLabel estValLabel = new JLabel("Est Value ");
                        estValLabel.setBounds(50, 165, 150, 20);
                        estValLabel.setForeground(Color.BLACK);
                        estValLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
                        goodsDonationPanel.add(estValLabel);
                        //initialization of textfield
                        JTextField estValTextField = new JTextField();
                        estValTextField.setBounds(230, 165, 200, 25);
                        goodsDonationPanel.add(estValTextField);
                        //initialization of button
                        JButton addButton = new JButton("Add");
                        addButton.addMouseListener(new MouseAdapter() {
                            @Override
                            public void mouseClicked(MouseEvent e) {
                                //action performed after the button is pressed
                                String goodDesc = goodDescTextField.getText();
                                String estVal = estValTextField.getText();
                                String appealCh = selectTextField.getText();
                                int appealChoice = Integer.parseInt(appealCh);
                                String contriDate = dateString;
                                int contriID = helpaid.getGoodsID() + 1;
                                Goods goods = new Goods(goodDesc, estVal, dateString, contriID);
                                helpaid.setGoodsData(goods);
                                Appeal appeals = helpaid.getAppeal(appealChoice - 1);
                                appeals.setGoods(goods);
                                JOptionPane.showMessageDialog(null, "Your goods successfully registered! Contribution date set to " + dateString + " With contribution ID : " + contriID);
                                dispose();
                            }
                        });
                        // to modify the position and looks of button
                        addButton.setForeground(new Color(255, 255, 255));
                        addButton.setBackground(new Color(154, 205, 50));
                        addButton.setFont(new Font("Segoe UI", Font.PLAIN, 18));
                        addButton.setBounds(100, 300, 273, 48);
                        goodsDonationPanel.add(addButton);
                        revalidate();

                    }
                    
                    
                });
                goodsButton.setForeground(new Color(255, 255, 255));
		goodsButton.setBackground(new Color(50, 255, 50));
		goodsButton.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		goodsButton.setBounds(100, 250, 100, 30);
                recordPanel.add(goodsButton);
    
    JButton cashButton = new JButton("Cash");
    //deleteButton.setBounds(50, 340, 100, 30);
    cashButton.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            CashDonationPanel = new JPanel();
            CashDonationPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
            setContentPane(CashDonationPanel);   
            CashDonationPanel.setLayout(null);
            CashDonationPanel.setBounds(0,0,500, 500);
                         
            JLabel cashLabel = new JLabel("Cash Contribution");
            cashLabel.setBounds(50, 50, 250, 20);
            cashLabel.setForeground(Color.BLACK);
            cashLabel.setFont(new Font("Segoe UI", Font.BOLD, 20));
            CashDonationPanel.add(cashLabel);
                        
            JLabel amountLabel = new JLabel("Amount");
            amountLabel.setBounds(50, 95, 150, 20);
            amountLabel.setForeground(Color.BLACK);
            amountLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
            CashDonationPanel.add(amountLabel);

            JTextField amountTextField = new JTextField();
            amountTextField.setBounds(230, 95, 200, 25);
            CashDonationPanel.add(amountTextField);
                        
            JLabel paymentChLabel = new JLabel("Payment Channel");
            paymentChLabel.setBounds(50, 140, 150, 20);
            paymentChLabel.setForeground(Color.BLACK);
            paymentChLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
            CashDonationPanel.add(paymentChLabel);

            JTextField paymentChTextField = new JTextField();
            paymentChTextField.setBounds(230, 140, 200, 25);
            CashDonationPanel.add(paymentChTextField);
            
            JLabel refLabel = new JLabel("Reference Number");
            refLabel.setBounds(50, 185, 150, 20);
            refLabel.setForeground(Color.BLACK);
            refLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
            CashDonationPanel.add(refLabel);

            JTextField refTextField = new JTextField();
            refTextField.setBounds(230, 185, 200, 25);
            CashDonationPanel.add(refTextField);
            
            JButton delButton = new JButton("Add");
            delButton.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    int cashDonID = helpaid.getCashDonationID() + 1;
                    String contriDate = dateString;
                    String appealCh = selectTextField.getText();
                    int appealChoice = Integer.parseInt(appealCh);
                    String donAmount = amountTextField.getText();
                    int donationAmount = Integer.parseInt(donAmount);
                    String paymentChannel = paymentChTextField.getText();
                    String refNumber = refTextField.getText();
                    CashDonation cashDon = new CashDonation(contriDate, cashDonID, donationAmount, paymentChannel, refNumber);
                    helpaid.setCashDonationData(cashDon);
                    Appeal appeals = helpaid.getAppeal(appealChoice - 1);
                    appeals.setCashDonation(cashDon);
   
                    JOptionPane.showMessageDialog(null, "Cash donation successfully registered! With ID : " + cashDonID + " Date set to: " + dateString);
                    dispose();
                }
            });
            delButton.setForeground(new Color(255, 255, 255));
            delButton.setBackground(new Color(255, 0, 0));
            delButton.setFont(new Font("Segoe UI", Font.PLAIN, 18));
            delButton.setBounds(100, 300, 273, 48);
            CashDonationPanel.add(delButton);
        }
    });
    cashButton.setForeground(new Color(255, 255, 255));
    cashButton.setBackground(new Color(255, 0, 0));
    cashButton.setFont(new Font("Segoe UI", Font.PLAIN, 18));
    cashButton.setBounds(300, 250, 100, 30);
    recordPanel.add(cashButton);            
                //layeredPane.setVisible(true);
    }
}