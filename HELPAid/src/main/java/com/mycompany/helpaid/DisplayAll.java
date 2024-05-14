/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.helpaid;
//necessary import 
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
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
//class declaration that extends to JFrame
public class DisplayAll extends JFrame{
    
    //initialization of superclass
    private HELPAid helpaid;
    
    //initialization of JPanel
    private JPanel mainPanel;
    private JPanel adminPanel;
    private JPanel orgRepPanel;
    private JPanel applPanel;
    //initialization of JTable
    private JTable Applicanttable;
    private JTable orgRepTable;
    private JTable adminTable;
    //initialization of DefaultTableModel
    private DefaultTableModel ApplicanttableModel;
    private DefaultTableModel orgRepTableModel;
    private DefaultTableModel adminTableModel;
    //method which takes helpaid
    public DisplayAll(HELPAid helpaid){
        //to set the title of the JFrame
        setTitle("Display All Registered User");
        //to make sure that the frame is not resizeable
	setResizable(false);
        //to make sure that not the whole program is closed
        //after the frame is closed
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //to set the size and position 
        setBounds(0, 0, 800, 426);
          
        //initialization of JPanel
        mainPanel = new JPanel();
        //to make a border
        mainPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(mainPanel); 
        //to set the layout to null
        mainPanel.setLayout(null);
        //to set the size and position
        mainPanel.setBounds(400,0,500, 300);
             
        //JPanel initialization
        JPanel panelBackground = new JPanel();
        //to set the position and size of the panel;
	panelBackground.setBounds(0, 0, 400, 427);
        //to add the panel into the mainpanel
	mainPanel.add(panelBackground);
        //to set layout to null
	panelBackground.setLayout(null);
        
        //initialization of JLabel
        JLabel background = new JLabel("");
        //to get the image from files
	background.setIcon(new ImageIcon(AdministratorGUI.class.getResource("/notes.jpg")));
        //to set the position and size
	background.setBounds(0, 0, 400, 427);
        //to add the label to the panel
	panelBackground.add(background);

        //initialization of JLabel
        JLabel toDoLabel = new JLabel("What do you want to do?");
        //to set the position and size
        toDoLabel.setBounds(475, 25, 250, 40);
        //to set the foreground color
        toDoLabel.setForeground(Color.BLACK);
        //to set the font, style and size
        toDoLabel.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        //to add the label into panel
        mainPanel.add(toDoLabel);

                
        //initialization of button
        JButton adminButton = new JButton("Display All Administrator");

        adminButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //action that will be performed after the button is clicked
                
                //initialization of panel
                adminPanel = new JPanel();
                //to set the border of the panel
                adminPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
                setContentPane(adminPanel);   
                //to set the layout to null
                adminPanel.setLayout(null);
                //to set the position and the size of panel
                adminPanel.setBounds(0,0,800, 426);
                         
                //initialization of label
                JLabel adminLabel = new JLabel("Display all registered administrator");
                //to set the size and position of the label
                adminLabel.setBounds(50, 30, 400, 30);
                //to set the foreground color
                adminLabel.setForeground(new Color(50, 168, 64));
                //to set the font, style, and size
                adminLabel.setFont(new Font("Segoe UI", Font.BOLD, 20));
                //to add the label to panel
                adminPanel.add(adminLabel);
        
                //an array of string
                String[] columnnames = {"Username", "Full Name", "Email", "Mobile No"};
                //initialization of defaulttablemodel
                adminTableModel = new DefaultTableModel(columnnames, 0);

                // to create a jTable with model
                adminTable = new JTable(adminTableModel);

                // to fill the data in table
                for (User user : helpaid.getUserData()) {
                    Object[] rowData = {
                            user.getUsername(),
                            user.getFullName(),
                            user.getEmail(),
                            user.getMobileNo()
                    };
                    adminTableModel.addRow(rowData);
                }

                //to add the table into JScrollPane
                JScrollPane adminPane = new JScrollPane(adminTable);
                adminPane.setBounds(50, 100, 675, 250);  // Adjust the bounds accordingly

                // adding the scroll pane to the panel
                adminPanel.add(adminPane);
                //to refresh 
                revalidate();
                
                }
                    
                    
            });
        //to set the foreground color
        adminButton.setForeground(new Color(255, 255, 255));
        //to set the background color
	adminButton.setBackground(new Color(50, 168, 64));
        //to set the font, size, and style
	adminButton.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        //to set the size and position
	adminButton.setBounds(462, 100, 250, 53);
        //to add the button into panel
        mainPanel.add(adminButton);
    
        //to initialize the button
    JButton orgRepButton = new JButton("Display All Org Rep");
    orgRepButton.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            //action that will be done after the button is pressed
            
            //initialization of panel
            orgRepPanel = new JPanel();
            //to set the border of the panel
            orgRepPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
            setContentPane(orgRepPanel);   
            //to set the layout to null
            orgRepPanel.setLayout(null);
            //to set the size and position of the panel
            orgRepPanel.setBounds(0,0,800, 426);
                         
            //initialization of label
            JLabel dispOrgRepLabel = new JLabel("Display all registered Organization Rep");
            //to set the position and size
            dispOrgRepLabel.setBounds(50, 30, 400, 30);
            //to set foreground color
            dispOrgRepLabel.setForeground(new Color(50, 168, 64));
            //to set the font, style, and size
            dispOrgRepLabel.setFont(new Font("Segoe UI", Font.BOLD, 20));
            //to add the label into the panel
            orgRepPanel.add(dispOrgRepLabel);
         
            //array of string
            String[] ColumnNames = {"Username", "Full Name", "Mobile No", "Job Title"};
            //initialization of default table model
            orgRepTableModel = new DefaultTableModel(ColumnNames, 0);

            // to create a table from model
            orgRepTable = new JTable(orgRepTableModel);

            // to fill the table
            for (OrganizationRep orgrep : helpaid.getOrganizationRep()) {
                Object[] rowData = {
                        orgrep.getUsername(),
                        orgrep.getFullName(),
                        orgrep.getMobileNo(),
                        orgrep.getJobTitle()
                };
                orgRepTableModel.addRow(rowData);
            }

            // to add the table to a JScrollPane
            JScrollPane orgRepPane = new JScrollPane(orgRepTable);
            orgRepPane.setBounds(50, 80, 675, 250);  // Adjust the bounds accordingly

            // to add the scroll pane to the panel
            orgRepPanel.add(orgRepPane);
            
            revalidate();
                        
            
        }
    });
    //to set the foreground color
    orgRepButton.setForeground(new Color(255, 255, 255));
    //to set the background color
    orgRepButton.setBackground(new Color(50, 168, 64));
    //to set the font, style, and size
    orgRepButton.setFont(new Font("Segoe UI", Font.PLAIN, 18));
    //to set the size and position
    orgRepButton.setBounds(462, 170, 250, 53);
    //to add the button to panel
    mainPanel.add(orgRepButton);            
           
    //initialization of button
    JButton applButton = new JButton("Display All Applicant");
    applButton.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            //action that will be performed when the button is pressed
            
            //initialization of panel
            applPanel = new JPanel();
            //to set the border
            applPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
            setContentPane(applPanel);   
            //to set the layout
            applPanel.setLayout(null);
            //to set the position and size
            applPanel.setBounds(0,0,800, 426);
                         
            //initialization of label
            JLabel dispApplLabel = new JLabel("Display all registered applicant");
            //to set the size and psition
            dispApplLabel.setBounds(50, 30, 400, 30);
            //to set the foreground color
            dispApplLabel.setForeground(new Color(50, 168, 64));
            //to set the font, style, and size
            dispApplLabel.setFont(new Font("Segoe UI", Font.BOLD, 20));
            //to add the label into panel
            applPanel.add(dispApplLabel);
                        
            //array of string
            String[] columnNames = {"Full Name", "ID Number", "Address", "Household Income"};
            //initialization of defaulttablemodel
            ApplicanttableModel = new DefaultTableModel(columnNames, 0);

            // to create a JTable with the defaulttablemodel
            Applicanttable = new JTable(ApplicanttableModel);

            // to fill the table
            for (Applicant applicant : helpaid.getApplicant()) {
                Object[] rowData = {
                        applicant.getFullName(),
                        applicant.getIdNo(),
                        applicant.getAddress(),
                        applicant.getHouseholdIncome()
                };
                ApplicanttableModel.addRow(rowData);
            }

            // to add the table to a JScrollPane
            JScrollPane scrollPane = new JScrollPane(Applicanttable);
            //to set the size and position
            scrollPane.setBounds(50, 80, 675, 250); 

            // to add the scroll pane to the panel
            applPanel.add(scrollPane);
     
            // to update
            revalidate();
        }
    });
    //to set the foreground color
    applButton.setForeground(new Color(255, 255, 255));
    //to set the background panel
    applButton.setBackground(new Color(50, 168, 64));
    //to set the font, style, and size
    applButton.setFont(new Font("Segoe UI", Font.PLAIN, 18));
    //to set the position and size
    applButton.setBounds(462, 240, 250, 53);
    //to add the button into panel
    mainPanel.add(applButton);          
    }
 
}

