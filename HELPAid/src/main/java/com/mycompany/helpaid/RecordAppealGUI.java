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
import javax.swing.border.EmptyBorder;
/**
 *
 * @author felix
 */
//class recordAppealGUI which extends with JFrame
public class RecordAppealGUI  extends JFrame{
    private HELPAid helpaid;
    private JPanel registrationPanel;
    //a method which takes helpaid and username of org rep
    public RecordAppealGUI(HELPAid helpaid, String usernameOrgRep){
        // to set the title
        setTitle("Record Aid Appeal");
        // to make the windows not resizeable
	setResizable(false);
        // to make sure the entire program is not closeds
        // after one window is closed
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        // to set the size of the frame and also the position
        setBounds(200, 100, 480, 500);
         // initialization of panel
        registrationPanel = new JPanel();
        //to set a border
        registrationPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(registrationPanel);   
        registrationPanel.setLayout(null);

        
                //initialization of label
                JLabel titleLabel = new JLabel("Record a new appeal for aid");
                titleLabel.setBounds(50, 75, 250, 20);
                titleLabel.setForeground(Color.BLACK);
                titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
                registrationPanel.add(titleLabel);
                //initialization of label
                JLabel fromDateLabel = new JLabel("From Date");
                fromDateLabel.setBounds(50, 135, 80, 20);
                fromDateLabel.setForeground(Color.BLACK);
                fromDateLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
                registrationPanel.add(fromDateLabel);
                //initialization of text field
                JTextField fromDateTextField = new JTextField();
                fromDateTextField.setBounds(180, 135, 200, 30);
                registrationPanel.add(fromDateTextField);
                //initialization of label    
                JLabel toDateLabel = new JLabel("To Date");
                toDateLabel.setBounds(50, 195, 80, 20);
                toDateLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
                registrationPanel.add(toDateLabel);
                //initialization of text field
                JTextField toDateTextField = new JTextField();
                toDateTextField.setBounds(180, 195, 200, 30);
                registrationPanel.add(toDateTextField);
                //initialization of label
                JLabel descLabel = new JLabel("Description");
                descLabel.setBounds(50, 255, 80, 20);
                descLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
                registrationPanel.add(descLabel);
                //initialization of text field
                JTextField descTextField = new JTextField();
                descTextField.setBounds(180, 255, 200, 30);
                registrationPanel.add(descTextField);

                
                //initialization of button
                JButton recordButton = new JButton("Record");
                
                recordButton.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        //action performed after the button is pressed
                        String fromDate = fromDateTextField.getText();
                        String toDate = toDateTextField.getText();
                        String description = descTextField.getText();
                        int generatedID = helpaid.getAppealID() + 1;
                        int orgIDToRecordAid;
                        orgIDToRecordAid = helpaid.getOrganizationID(usernameOrgRep);
                        Appeal APPEAL = new Appeal(generatedID, fromDate, toDate, description, "");
                        helpaid.setAppealData(APPEAL);
                        Organization Org = helpaid.getOrganization(orgIDToRecordAid -1 );
                        Org.setAppeal(APPEAL);
                        JOptionPane.showMessageDialog(null, "Record Success! With Appeal ID: " + generatedID );
                        dispose();
                    }
                });
                //to modify the style and position of the button
                recordButton.setForeground(new Color(255, 255, 255));
		recordButton.setBackground(new Color(181, 29, 29));
		recordButton.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		recordButton.setBounds(80, 350, 300, 40);
                registrationPanel.add(recordButton);
    
                //layeredPane.setVisible(true);
    }
  
}

