/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.helpaid;
//necessary imports
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
//class declaration, which extends to JFrame
public class ApplicantGUI extends JFrame{
    //initialization of JPanel and class
    private HELPAid helpaid;
    private JPanel ApplicantPanel;
    //initialization of method which takes HELPAid and applicant String
    public ApplicantGUI(HELPAid helpaid,String applicant){
        //to make the frame visible
        setVisible(true);
        //to prevent the frame from resized
        //so the layout will not changed
	setResizable(false);
        //to set the title of the frame
        setTitle("Applicant Menu");
        //to set the background color
        setBackground(new Color(255, 255, 255));
        //to make sure not the entire program is closed
	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //to set the position and the size of the fr5ame
        setBounds(200, 100, 775, 427);
        
        //initialization of panel
        ApplicantPanel = new JPanel();
        //to set the border 
	ApplicantPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(ApplicantPanel);
        //to set the layout to null
	ApplicantPanel.setLayout(null);
                
        
        //initialiation of JPanel
        JPanel panelBackground = new JPanel();
        //to set the position and size of the panel
	panelBackground.setBounds(0, 0, 400, 427);
        //to add the panel to another panel
	ApplicantPanel.add(panelBackground);
        //not using any layout
	panelBackground.setLayout(null);
                
        //initialization  of JLabel
        JLabel applicantMenuLabel = new JLabel("Applicant menu");
        //to set the foreground color of the JLabel
	applicantMenuLabel.setForeground(new Color(0, 122, 156));
        //to set the font, style, and font size
	applicantMenuLabel.setFont(new Font("Segoe UI", Font.BOLD, 30));
        //to set the position and size of the label
	applicantMenuLabel.setBounds(50, 200, 300, 200);
        //to add the label into panel
        panelBackground.add(applicantMenuLabel);
        
        //to set the applicantPanel visible
        ApplicantPanel.setVisible(true);
        
        //initialization of JLabel
        JLabel sidePhoto = new JLabel("");
        //to import the file 
	sidePhoto.setIcon(new ImageIcon(AdministratorGUI.class.getResource("/administrator.jpg")));
        //to set the size and position
	sidePhoto.setBounds(0, 0, 400, 427);
        //to add the photo into panel
	panelBackground.add(sidePhoto);
        
        //initialization of JLAbel
        JLabel toDoLabel = new JLabel("What do you want to do?");
        //to set the allignment to the right
	toDoLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        //to set the font, style and size
	toDoLabel.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        //to set the position and size
	toDoLabel.setBounds(450, 20, 218, 20);
        //to add the label into panel
	ApplicantPanel.add(toDoLabel);
        
        //initialization of button
        JButton viewButton = new JButton("View Given Disbursement");
	viewButton.addMouseListener(new MouseAdapter() {
	@Override
	public void mouseClicked(MouseEvent e) {
            //action that will be performed after the button is pressed
                
                //initialization of panel
                JPanel applicantInfoPanel = new JPanel();
                //border
                applicantInfoPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
                setContentPane(applicantInfoPanel);   
                //the layout is set to null
                applicantInfoPanel.setLayout(null);
                //to set the position of the JPanel
                applicantInfoPanel.setBounds(0,0,600, 600);

                //initialization of JLabel
                JLabel appInfoLabel = new JLabel("View Given Disbursement");
                //to set the size and position
                appInfoLabel.setBounds(125, 50, 400, 20);
                //to set the color of the Label
                appInfoLabel.setForeground(new Color(0, 122, 156));
                //to set the font, style and size 
                appInfoLabel.setFont(new Font("Segoe UI", Font.BOLD, 20));
                //to add the label into panel
                applicantInfoPanel.add(appInfoLabel);

                //initialization of variable, which takes string from getDisbursementInfo() method
                String applicantInfo = helpaid.getDisbursementInfo(applicant);
                //initialization of JScrollPane
                JScrollPane applicantInfoPane = new JScrollPane();
                //to set the size and position 
                applicantInfoPane.setBounds(125, 100, 500, 200);
                //initialization of JTextArea
                JTextArea applicantInfoTextArea = new JTextArea(applicantInfo);
                applicantInfoTextArea.setLineWrap(true);
                applicantInfoTextArea.setWrapStyleWord(true);
                applicantInfoPane.setViewportView(applicantInfoTextArea);
                //to add the the pane into the panel
                applicantInfoPanel.add(applicantInfoPane);
		
                revalidate();
            }
	});
        //to set the font, style and size
	viewButton.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        //to set the background color
	viewButton.setBackground(new Color(0, 122, 156));
        //to set the foreground color
	viewButton.setForeground(new Color(255,255,255));
        //to set the position and size
	viewButton.setBounds(450, 65, 225, 53);
        //tp add the button into the panel
	ApplicantPanel.add(viewButton);
        
        
    }
   
}