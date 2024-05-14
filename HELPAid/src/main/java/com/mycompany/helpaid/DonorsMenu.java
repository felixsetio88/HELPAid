/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.helpaid;

/**
 *
 * @author felix
 */
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

//necessary import
//to make sure the program run correctly
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
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author felix
 */
//class declaration which extends JFrame
public class DonorsMenu extends JFrame{
    private HELPAid helpaid;
    private JPanel DonorPanel;
    //method which takes helpaid 
    public DonorsMenu(HELPAid helpaid){
        
        //to set visible
        setVisible(true);
        //to make the window not resizeable
	setResizable(false);
        //to set the title
        setTitle("Donors Menu");
        //to set the background color
        setBackground(new Color(255, 255, 255));
        //to dispose insted of closing the whole program
	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //to set the position and size
        setBounds(200, 100, 775, 427);
        
        //initialization of panel
        DonorPanel = new JPanel();
        //to set border
	DonorPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        
	setContentPane(DonorPanel);
        //to set the layout to null
	DonorPanel.setLayout(null);
                
        //initialization of JPanel
        JPanel panelBackground = new JPanel();
        //to set the size and position
	panelBackground.setBounds(0, 0, 400, 427);
        //to add the panel to main panel
	DonorPanel.add(panelBackground);
        //to set the layout to null
	panelBackground.setLayout(null);
                
        //initialization of label
        JLabel applicantMenuLabel = new JLabel("Donors Menu");
        //to set the foreground color
	applicantMenuLabel.setForeground(new Color(237, 135, 255));
        //to set font, size, and style
	applicantMenuLabel.setFont(new Font("Segoe UI", Font.BOLD, 30));
        //tp set the position and size
	applicantMenuLabel.setBounds(50, 200, 300, 200);
        //to add the label into panel
        panelBackground.add(applicantMenuLabel);
        //to set the panel visible
        DonorPanel.setVisible(true);
        
        //initialization of JLabel
        JLabel background = new JLabel("");
        //to get image from local files
	background.setIcon(new ImageIcon(AdministratorGUI.class.getResource("/administrator.jpg")));
        //to set the position and size
	background.setBounds(0, 0, 400, 427);
        //to add the label into panel
	panelBackground.add(background);
        
        //initialization of label
        JLabel toDoLabel = new JLabel("What do you want to do?");
        //to set the allignment to right
	toDoLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        //to set the font, style, and size
	toDoLabel.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        //to set the position and size
	toDoLabel.setBounds(450, 20, 218, 20);
        //to add the label to the panel
	DonorPanel.add(toDoLabel);
        
        //initialization of button
        JButton recordButton = new JButton("Record Contribution");
	recordButton.addMouseListener(new MouseAdapter() {
	@Override
	public void mouseClicked(MouseEvent e) {
            //action that will be performed after the button is pressed
                RecordContributionGUI record = new RecordContributionGUI(helpaid);
                record.setVisible(true);
            }
	});
        //to set the font, style and size
	recordButton.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        //to set the background color
	recordButton.setBackground(new Color(237, 135, 255));
        //to set the foreground color
	recordButton.setForeground(new Color(255,255,255));
        //to set the position and size
	recordButton.setBounds(450, 65, 225, 53);
        //to add the button into panel
	DonorPanel.add(recordButton);
        
        //initialization of button
        JButton showAppealBtn = new JButton("Show Appeal");
	showAppealBtn.addMouseListener(new MouseAdapter() {
	@Override
	public void mouseClicked(MouseEvent e) {
            //action that will be performed after the button is pressed
                ViewAidAppealGUI view = new ViewAidAppealGUI(helpaid);
                view.setVisible(true);
            }
	});
        //to set the font, style and size
        showAppealBtn.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        //to set the background color
	showAppealBtn.setBackground(new Color(237, 135, 255));
        //to set the foreground color
	showAppealBtn.setForeground(new Color(255,255,255));
        //to set the position and size
	showAppealBtn.setBounds(450, 125, 225, 53);
        //to add the button into panel
	DonorPanel.add(showAppealBtn);
        
        
        
    }
   
}