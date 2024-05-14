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
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author felix
 */
//Manage organization class
public class ManageOrganization extends JFrame{
    private HELPAid helpaid;
    private JPanel manageOrgPanel;
    private JPanel addOrgPanel;
    private JPanel deleteOrgPanel;
    private JTable orgTable;
    private DefaultTableModel orgTableModel;
    // ManageOrganization method which takes helpaid
    public ManageOrganization(HELPAid helpaid){
        
        //to set the layout, title of the JFrame
        setTitle("Manage Organization");
		
	setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(200, 100, 525, 550);
          
        //initialization of JPanel
        manageOrgPanel = new JPanel();
        manageOrgPanel.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(manageOrgPanel); 
        manageOrgPanel.setLayout(null);
        // To set the position and size of the panel
        manageOrgPanel.setBounds(0,0,500, 300);

        
                // array of string
                String[] columnnames = {"Name", "Address", "ID"};
                orgTableModel = new DefaultTableModel(columnnames, 0);

                // to create a JTable with the model
                orgTable = new JTable(orgTableModel);

                // to populate the table from date on helpaid
                for (Organization org : helpaid.getOrganization()) {
                    Object[] rowData = {
                            org.getOrgName(),
                            org.getAddress(),
                            org.getOrgID(),
                    };
                    orgTableModel.addRow(rowData);
                }

                // add the table to a JScrollPane
                JScrollPane orgPane = new JScrollPane(orgTable);
                orgPane.setBounds(50, 70, 400, 120);  // Adjust the bounds accordingly
                manageOrgPanel.add(orgPane);
                
                //initialization of label
                JLabel listLabel = new JLabel("List of registered organization");
                listLabel.setBounds(50, 20, 300, 30);
                listLabel.setForeground(new Color(50, 168, 64));
                listLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
                manageOrgPanel.add(listLabel);
                
                //initialization of label
                JLabel toDoLabel = new JLabel("What do you want to do?");
                toDoLabel.setBounds(50, 215, 220, 20);
                toDoLabel.setForeground(Color.BLACK);
                toDoLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
                manageOrgPanel.add(toDoLabel);

                
                //initialization of button
                JButton addNewButton = new JButton("Add");
                addNewButton.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        addOrgPanel = new JPanel();
                        addOrgPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
                        setContentPane(addOrgPanel);   
                        addOrgPanel.setLayout(null);
                        addOrgPanel.setBounds(0,0,500, 500);
                         
                        JLabel addOrgLabel = new JLabel("Add a New Organization");
                        addOrgLabel.setBounds(50, 50, 250, 20);
                        addOrgLabel.setForeground(Color.BLACK);
                        addOrgLabel.setFont(new Font("Segoe UI", Font.BOLD, 20));
                        addOrgPanel.add(addOrgLabel);
                        
                        JLabel orgNameLabel = new JLabel("Organization name ");
                        orgNameLabel.setBounds(50, 120, 150, 20);
                        orgNameLabel.setForeground(Color.BLACK);
                        orgNameLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
                        addOrgPanel.add(orgNameLabel);

                        JTextField orgNameTextField = new JTextField();
                        orgNameTextField.setBounds(230, 120, 200, 25);
                        addOrgPanel.add(orgNameTextField);
                        
                        JLabel orgAddLabel = new JLabel("Organization Address ");
                        orgAddLabel.setBounds(50, 165, 150, 20);
                        orgAddLabel.setForeground(Color.BLACK);
                        orgAddLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
                        addOrgPanel.add(orgAddLabel);

                        JTextField orgAddTextField = new JTextField();
                        orgAddTextField.setBounds(230, 165, 200, 25);
                        addOrgPanel.add(orgAddTextField);
                        
                        JButton addButton = new JButton("Add");
                        addButton.setBounds(180, 340, 100, 30);
                        addButton.addMouseListener(new MouseAdapter() {
                            @Override
                            public void mouseClicked(MouseEvent e) {
                                String orgname = orgNameTextField.getText();
                                String orgadd = orgAddTextField.getText();
                                while (helpaid.isOrganizationAvailable(orgname) == true){
                                    JOptionPane.showMessageDialog(null, "Organization " + orgname + " is already registered.");
                                    return;
                                }
                                
                                int newID = helpaid.getLastOrgID() + 1;
                                helpaid.addOrganization(newID, orgname, orgadd);
                                JOptionPane.showMessageDialog(null, "Registration Success! The generated ID: " + newID);
                                dispose();
                            }
                        });
                        addButton.setForeground(new Color(255, 255, 255));
                        addButton.setBackground(new Color(0, 255, 0));
                        addButton.setFont(new Font("Segoe UI", Font.PLAIN, 18));
                        addButton.setBounds(100, 400, 273, 48);
                        addOrgPanel.add(addButton);
             
                        revalidate();
                    }
                    
                    
                });
                addNewButton.setForeground(new Color(255, 255, 255));
		addNewButton.setBackground(new Color(50, 255, 50));
		addNewButton.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		addNewButton.setBounds(100, 250, 100, 30);
                manageOrgPanel.add(addNewButton);
    
    JButton deleteButton = new JButton("Delete");
    //deleteButton.setBounds(50, 340, 100, 30);
    deleteButton.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            deleteOrgPanel = new JPanel();
            deleteOrgPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
            setContentPane(deleteOrgPanel);   
            deleteOrgPanel.setLayout(null);
            deleteOrgPanel.setBounds(0,0,500, 500);
                         
            JLabel addOrgLabel = new JLabel("Delete Organization");
            addOrgLabel.setBounds(50, 50, 250, 20);
            addOrgLabel.setForeground(Color.BLACK);
            addOrgLabel.setFont(new Font("Segoe UI", Font.BOLD, 20));
            deleteOrgPanel.add(addOrgLabel);
                        
            JLabel orgIDLabel = new JLabel("Input Organization ID");
            orgIDLabel.setBounds(50, 120, 150, 20);
            orgIDLabel.setForeground(Color.BLACK);
            orgIDLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
            deleteOrgPanel.add(orgIDLabel);

            JTextField orgIDTextField = new JTextField();
            orgIDTextField.setBounds(230, 120, 200, 25);
            deleteOrgPanel.add(orgIDTextField);
                        
            JButton delButton = new JButton("Delete");
            delButton.setBounds(180, 340, 100, 30);
            delButton.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    String OrgID = orgIDTextField.getText();
                    int orgid = Integer.parseInt(OrgID);
                    while (helpaid.deleteOrganization(orgid) == false){
                        JOptionPane.showMessageDialog(null, "Organization does not exist!");
                        return;
                    }
                                
   
                    JOptionPane.showMessageDialog(null, "Organization has been removed!");
                    dispose();
                }
            });
            delButton.setForeground(new Color(255, 255, 255));
            delButton.setBackground(new Color(255, 0, 0));
            delButton.setFont(new Font("Segoe UI", Font.PLAIN, 18));
            delButton.setBounds(100, 400, 273, 48);
            deleteOrgPanel.add(delButton);
        }
    });
    deleteButton.setForeground(new Color(255, 255, 255));
    deleteButton.setBackground(new Color(255, 0, 0));
    deleteButton.setFont(new Font("Segoe UI", Font.PLAIN, 18));
    deleteButton.setBounds(300, 250, 100, 30);
    manageOrgPanel.add(deleteButton);            
                //layeredPane.setVisible(true);
    }
}
