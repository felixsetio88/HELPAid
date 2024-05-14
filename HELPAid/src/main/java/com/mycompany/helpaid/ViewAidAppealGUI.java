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
//class viewAidAppealGUI which extends with JFrame
public class ViewAidAppealGUI extends JFrame{
    // to add local date today
    LocalDate today = LocalDate.now();
    String dateString = today.toString();
    private HELPAid helpaid;
    //initialization of JPanel
    private JPanel viewPanel;
    private JPanel AppealInfoPanel;
    //a method which takes helpaid
    public ViewAidAppealGUI(HELPAid helpaid){
        // to set the title
        setTitle("View Aid Appeal");
        // to make the windows not resizable
	setResizable(false);
        // to dispose on close
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        // to set the size and position
        setBounds(200, 100, 525, 562);
          
        //initialization of JPanel
        viewPanel = new JPanel();
        viewPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(viewPanel); 
        viewPanel.setLayout(null);
        viewPanel.setBounds(0,0,500, 300);
        //initialization of JLabel
        JLabel displayLabel = new JLabel("Displaying all appeal");
        displayLabel.setBounds(50, 20, 250, 30);
        displayLabel.setForeground(new Color(237, 135, 255));
        displayLabel.setFont(new Font("Segoe UI", Font.BOLD, 20));
        viewPanel.add(displayLabel);
        //initialization of JScroollPAne
        JScrollPane showAppealPane = new JScrollPane();
        showAppealPane.setBounds(50, 80, 400, 120);
        viewPanel.add(showAppealPane);
                
        String appealList = helpaid.showAppeal();
        JTextArea appealTextArea = new JTextArea(appealList);
        appealTextArea.setLineWrap(true);
        appealTextArea.setWrapStyleWord(true);
        showAppealPane.setViewportView(appealTextArea);
        //initialization of label
        JLabel selectLabel = new JLabel("Input appeal ID:  ");
        selectLabel.setBounds(50, 225, 150, 20);
        selectLabel.setForeground(Color.BLACK);
        selectLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        viewPanel.add(selectLabel);
        //initialization of text field
        JTextField selectTextField = new JTextField();
        selectTextField.setBounds(250, 225, 200, 25);
        viewPanel.add(selectTextField);
        //initialization of button
        JButton nextButton = new JButton("Next");
        nextButton.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            // action performed after the button is pressed
            String donorChoice = selectTextField.getText();
            int donorChoiceInt = Integer.parseInt(donorChoice);
            AppealInfoPanel = new JPanel();
            AppealInfoPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
            setContentPane(AppealInfoPanel);   
            AppealInfoPanel.setLayout(null);
            AppealInfoPanel.setBounds(0,0,500, 500);
            //initialization of JLabel
            JLabel appealInfoLabel = new JLabel("Organization Information");
            appealInfoLabel.setBounds(50, 50, 250, 20);
            appealInfoLabel.setForeground(new Color(237, 135, 255));
            appealInfoLabel.setFont(new Font("Segoe UI", Font.BOLD, 20));
            AppealInfoPanel.add(appealInfoLabel);
                        
            JScrollPane printPane = new JScrollPane();
            printPane.setBounds(50, 100, 400, 120);
            AppealInfoPanel.add(printPane);

            String appealList = helpaid.getAppealInfo(donorChoiceInt);
            JTextArea appealTextArea = new JTextArea(appealList);
            appealTextArea.setLineWrap(true);
            appealTextArea.setWrapStyleWord(true);
            printPane.setViewportView(appealTextArea);
            revalidate();

        }
                    
                    
        });
        // To modify the looks and position of the button
        nextButton.setForeground(new Color(255, 255, 255));
	nextButton.setBackground(new Color(237, 135, 255));
	nextButton.setFont(new Font("Segoe UI", Font.PLAIN, 18));
	nextButton.setBounds(100, 300, 300, 40);
        viewPanel.add(nextButton);

    }
}
