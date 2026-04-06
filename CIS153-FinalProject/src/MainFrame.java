/**
 * Final Project - Bucket List App - MainFrame (GUI)
 * @author	Jon Heimer
 * @version 1.0
 * @since	1.0
 */
/*  
* OS: Windows 10 Pro
* IDE: Eclipse IDE 4.32.0
* Copyright : This is my own original work 
* based on specifications issued by our instructor
* Academic Honesty: I attest that this is my original work.
* I have not used unauthorized source code, either modified or
* unmodified, nor used generative AI as a final draft. 
* I have not given other fellow student(s) access to my program.
*/

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class MainFrame extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L; // Added by Eclipse IDE
	// Main Menu frame buttons
	JButton newItemButton;
	JButton viewNextItemButton;
	JButton markItemButton;
	JButton viewCompletedButton;
	JButton exitButton;
	// Add New Item Menu frame buttons
	JRadioButton travelCatButton;
	JRadioButton expCatButton;
	JRadioButton pgCatButton;
	JTextField descriptionField;
	JRadioButton priority1Button;
	JRadioButton priority2Button;
	JRadioButton priority3Button;
	JRadioButton priority4Button;
	JRadioButton priority5Button;
	JButton enterItemAniButton;
	JButton returnMainAniButton;
	// View Next Items Menu frame buttons
	JTextField	travelOutputVniField;
	JTextField	expOutputVniField;
	JTextField	pgOutputVniField;
	JButton returnMainVniButton;
	// Mark Items Complete Menu frame buttons
	JButton travelCompleteButton;
	JButton expCompleteButton;
	JButton pgCompleteButton;
	JTextField	travelOutputMcField;
	JTextField	expOutputMcField;
	JTextField	pgOutputMcField;
	JButton returnMainMcButton;
	// View Completed Items Menu frame buttons
	JButton sortCategoryButton;
	JButton sortCompletedButton;
	JButton returnMainVcButton;
	// View By Category frame buttons
	JButton returnByCatButton;
	
	// View By Completion frame buttons
	JButton returnByDateButton;
	
	// Initialize Panels
	JPanel mainPanel;
	JPanel addNewItemPanel;
	JPanel viewNextItemPanel;
	JPanel markCompletedPanel;
	JPanel viewCompletedPanel;
	JPanel byCategoryPanel;
	JPanel byCompletedPanel;
	
	int passLength;
	int pinLength;
	
	public MainFrame() {
// Main Menu Panel		
		FlowLayout mainPanelLayout = new FlowLayout();
		mainPanelLayout.setHgap(25);
		mainPanelLayout.setVgap(20);
		JLabel mainPanelTitle = new JLabel("**********   Main Menu   **********");
		Font mainTitleFont = mainPanelTitle.getFont().deriveFont(Font.BOLD, 16f);
		mainPanelTitle.setFont(mainTitleFont);
		newItemButton = new JButton("Add New Bucket List Item");
		newItemButton.setPreferredSize(new Dimension(200,25));
		viewNextItemButton = new JButton("View Next Items");
		viewNextItemButton.setPreferredSize(new Dimension(200,25));
		markItemButton = new JButton("Mark Item As Completed");
		markItemButton.setPreferredSize(new Dimension(200,25));
		viewCompletedButton = new JButton("View Completed Items");
		viewCompletedButton.setPreferredSize(new Dimension(200,25));
		exitButton = new JButton("Exit Program");
		exitButton.setPreferredSize(new Dimension(200,25));
		newItemButton.addActionListener(this);
		viewNextItemButton.addActionListener(this);
		markItemButton.addActionListener(this);
		viewCompletedButton.addActionListener(this);
		exitButton.addActionListener(this);

		mainPanel = new JPanel();
		mainPanel.setBackground(new Color(200,50,250));
		mainPanel.setLayout(mainPanelLayout);
		mainPanel.add(mainPanelTitle);
		mainPanel.add(newItemButton);
		mainPanel.add(viewNextItemButton);
		mainPanel.add(markItemButton);
		mainPanel.add(viewCompletedButton);
		mainPanel.add(exitButton);

// Add New Bucket List Item Panel
		FlowLayout addNewItemPanelLayout = new FlowLayout();
		addNewItemPanelLayout.setVgap(15);
		JLabel aniPanelTitle = new JLabel("***********   Add New Bucket List Item   ***********");
		Font pwTitleFont = aniPanelTitle.getFont().deriveFont(Font.BOLD, 16f);
		aniPanelTitle.setFont(pwTitleFont);
		JLabel aniPanelInstruction1 = new JLabel("                 Choose the new item category                 ");
		Font aniInstFont = aniPanelInstruction1.getFont().deriveFont(Font.BOLD, 13f);
		aniPanelInstruction1.setFont(aniInstFont);
		JLabel aniPanelInstruction2 = new JLabel("Description: ");
		aniPanelInstruction2.setFont(aniInstFont);
		JLabel aniPanelInstruction3 = new JLabel("                 Choose the new item priority                 ");
		aniPanelInstruction3.setFont(aniInstFont);
		descriptionField = new JTextField(20);
		Font aniBoldFont = descriptionField.getFont().deriveFont(Font.BOLD, 16f);
		descriptionField.setFont(aniBoldFont);
		enterItemAniButton = new JButton("Save New Item");
		enterItemAniButton.setPreferredSize(new Dimension(200,25));
		returnMainAniButton = new JButton("Return To Main Menu");
		returnMainAniButton.setPreferredSize(new Dimension(200,25));
		travelCatButton = new JRadioButton("Travel");
		travelCatButton.setPreferredSize(new Dimension(120,25));
		expCatButton = new JRadioButton("Experience");
		expCatButton.setPreferredSize(new Dimension(120,25));
		pgCatButton = new JRadioButton("Personal Growth");
		pgCatButton.setPreferredSize(new Dimension(120,25));
		priority1Button = new JRadioButton("Urgent");
		priority1Button.setPreferredSize(new Dimension(70,25));
		priority2Button = new JRadioButton("High");
		priority2Button.setPreferredSize(new Dimension(70,25));
		priority3Button = new JRadioButton("Medium");
		priority3Button.setPreferredSize(new Dimension(70,25));
		priority4Button = new JRadioButton("Low");
		priority4Button.setPreferredSize(new Dimension(70,25));
		priority5Button = new JRadioButton("Minor");
		priority5Button.setPreferredSize(new Dimension(70,25));
		
		ButtonGroup itemCategory = new ButtonGroup();
		itemCategory.add(travelCatButton);
		itemCategory.add(expCatButton);
		itemCategory.add(pgCatButton);
		
		ButtonGroup itemPriority = new ButtonGroup();
		itemPriority.add(priority1Button);
		itemPriority.add(priority2Button);
		itemPriority.add(priority3Button);
		itemPriority.add(priority4Button);
		itemPriority.add(priority5Button);
		
		travelCatButton.addActionListener(this);
		expCatButton.addActionListener(this);
		pgCatButton.addActionListener(this);
		priority1Button.addActionListener(this);
		priority2Button.addActionListener(this);
		priority3Button.addActionListener(this);
		priority4Button.addActionListener(this);
		priority5Button.addActionListener(this);
		enterItemAniButton.addActionListener(this);
		returnMainAniButton.addActionListener(this);
		
		travelCatButton.doClick();			// Sets travelCatButton as the default (Travel Category)
		priority5Button.doClick();			// Sets priority5Button as the default (minor)
		
		addNewItemPanel = new JPanel();
		addNewItemPanel.setBackground(new Color(55,235,235));
		addNewItemPanel.setLayout(addNewItemPanelLayout);
		addNewItemPanel.add(aniPanelTitle);
		addNewItemPanel.add(aniPanelInstruction1);
		addNewItemPanel.add(travelCatButton);
		addNewItemPanel.add(expCatButton);
		addNewItemPanel.add(pgCatButton);
		addNewItemPanel.add(aniPanelInstruction2);
		addNewItemPanel.add(descriptionField);
		addNewItemPanel.add(aniPanelInstruction3);
		addNewItemPanel.add(priority1Button);
		addNewItemPanel.add(priority2Button);
		addNewItemPanel.add(priority3Button);
		addNewItemPanel.add(priority4Button);
		addNewItemPanel.add(priority5Button);
		addNewItemPanel.add(enterItemAniButton);
		addNewItemPanel.add(returnMainAniButton);

// View Next Items Panel
		FlowLayout viewNextItemPanelLayout = new FlowLayout();
		viewNextItemPanelLayout.setVgap(15);
		JLabel vniPanelTitle = new JLabel("*********  Next Items On Your Bucket List  *********");
		Font vniPanelTitleFont = vniPanelTitle.getFont().deriveFont(Font.BOLD, 16f);
		vniPanelTitle.setFont(vniPanelTitleFont);
		JLabel vniPanelLabel1 = new JLabel("              TRAVEL              ");
		Font vniLabelFont = vniPanelLabel1.getFont().deriveFont(Font.BOLD, 13f);
		vniPanelLabel1.setFont(vniLabelFont);
		travelOutputVniField = new JTextField(20);
		Font vniBoldFont = travelOutputVniField.getFont().deriveFont(Font.BOLD, 16f);
		travelOutputVniField.setFont(vniBoldFont);
		JLabel vniPanelLabel2 = new JLabel("            EXPERIENCE            ");
		vniPanelLabel2.setFont(vniLabelFont);
		expOutputVniField = new JTextField(20);
		expOutputVniField.setFont(vniBoldFont);
		JLabel vniPanelLabel3 = new JLabel("         PERSONAL GROWTH          ");
		vniPanelLabel3.setFont(vniLabelFont);
		pgOutputVniField = new JTextField(20);
		pgOutputVniField.setFont(vniBoldFont);
		returnMainVniButton = new JButton("Return To Main Menu");
		returnMainVniButton.setPreferredSize(new Dimension(200,25));
		
		returnMainVniButton.addActionListener(this);
		
		viewNextItemPanel = new JPanel();
		viewNextItemPanel.setBackground(new Color(150,150,150));
		viewNextItemPanel.setLayout(viewNextItemPanelLayout);
		viewNextItemPanel.add(vniPanelTitle);
		viewNextItemPanel.add(vniPanelLabel1);
		viewNextItemPanel.add(travelOutputVniField);
		viewNextItemPanel.add(vniPanelLabel2);
		viewNextItemPanel.add(expOutputVniField);
		viewNextItemPanel.add(vniPanelLabel3);
		viewNextItemPanel.add(pgOutputVniField);
		viewNextItemPanel.add(returnMainVniButton);

// Mark Item Completed Panel
		FlowLayout markCompletedPanelLayout = new FlowLayout();
		markCompletedPanelLayout.setVgap(15);
		JLabel markCompletedPanelTitle = new JLabel("    ***********  Mark Items As Completed  ***********    ");
		Font mcPanelTitleFont = markCompletedPanelTitle.getFont().deriveFont(Font.BOLD, 16f);
		markCompletedPanelTitle.setFont(mcPanelTitleFont);
		travelCompleteButton = new JButton("TRAVEL - Mark Complete");
		travelCompleteButton.setPreferredSize(new Dimension(250,25));
		travelOutputMcField = new JTextField(20);
		Font mcBoldFont = travelOutputMcField.getFont().deriveFont(Font.BOLD, 16f);
		travelOutputMcField.setFont(mcBoldFont);
		expCompleteButton = new JButton("EXPERIENCE - Mark Complete");
		expCompleteButton.setPreferredSize(new Dimension(250,25));
		expOutputMcField = new JTextField(20);
		expOutputMcField.setFont(mcBoldFont);
		pgCompleteButton = new JButton("PERSONAL GROWTH - Mark Complete");
		pgCompleteButton.setPreferredSize(new Dimension(250,25));
		pgOutputMcField = new JTextField(20);
		pgOutputMcField.setFont(mcBoldFont);
		returnMainMcButton = new JButton("Return To Main Menu");
		returnMainMcButton.setPreferredSize(new Dimension(200,25));
		
		travelCompleteButton.addActionListener(this);
		expCompleteButton.addActionListener(this);
		pgCompleteButton.addActionListener(this);
		returnMainMcButton.addActionListener(this);
		
		markCompletedPanel = new JPanel();
		markCompletedPanel.setBackground(new Color(255,255,0));
		markCompletedPanel.setLayout(markCompletedPanelLayout);
		markCompletedPanel.add(markCompletedPanelTitle);
		markCompletedPanel.add(travelCompleteButton);
		markCompletedPanel.add(travelOutputMcField);
		markCompletedPanel.add(expCompleteButton);
		markCompletedPanel.add(expOutputMcField);
		markCompletedPanel.add(pgCompleteButton);
		markCompletedPanel.add(pgOutputMcField);
		markCompletedPanel.add(returnMainMcButton);
		
// View Completed Items Panel	
		FlowLayout viewCompletedPanelLayout = new FlowLayout();
		viewCompletedPanelLayout.setVgap(15);
		JLabel viewCompletedPanelTitle = new JLabel(" *****  Sort And View Your Completed Items  ***** ");
		Font vcPanelTitleFont = viewCompletedPanelTitle.getFont().deriveFont(Font.BOLD, 16f);
		viewCompletedPanelTitle.setFont(vcPanelTitleFont);
		sortCategoryButton = new JButton("View By Category");
		sortCategoryButton.setPreferredSize(new Dimension(200,25));
		sortCompletedButton = new JButton("View By Date Completed");
		sortCompletedButton.setPreferredSize(new Dimension(200,25));
		returnMainVcButton = new JButton("Return To Main Menu");
		returnMainVcButton.setPreferredSize(new Dimension(200,25));
		JLabel vcPanelSpace1 = new JLabel("                                                         ");
		Font vcSpaceFont = vcPanelSpace1.getFont().deriveFont(Font.BOLD, 13f);
		vcPanelSpace1.setFont(vcSpaceFont);
		JLabel vcPanelSpace2 = new JLabel("                                                         ");
		vcPanelSpace2.setFont(vcSpaceFont);
		JLabel vcPanelSpace3 = new JLabel("                                                         ");
		vcPanelSpace3.setFont(vcSpaceFont);
		
		
		sortCategoryButton.addActionListener(this);
		sortCompletedButton.addActionListener(this);
		returnMainVcButton.addActionListener(this);
		
		viewCompletedPanel = new JPanel();
		viewCompletedPanel.setBackground(new Color(250,200,50));
		viewCompletedPanel.setLayout(viewCompletedPanelLayout);
		viewCompletedPanel.add(viewCompletedPanelTitle);
		viewCompletedPanel.add(vcPanelSpace1);
		viewCompletedPanel.add(sortCategoryButton);
		viewCompletedPanel.add(vcPanelSpace2);
		viewCompletedPanel.add(sortCompletedButton);
		viewCompletedPanel.add(vcPanelSpace3);
		viewCompletedPanel.add(returnMainVcButton);
		
// View By Category Panel	
		FlowLayout byCategoryPanelLayout = new FlowLayout();
		byCategoryPanelLayout.setVgap(15);
		JLabel byCategoryPanelTitle = new JLabel("       Items Listed By Category       ");
		Font byCategoryPanelTitleFont = byCategoryPanelTitle.getFont().deriveFont(Font.BOLD, 16f);
		byCategoryPanelTitle.setFont(byCategoryPanelTitleFont);
		
		returnByCatButton = new JButton("Return To View Completed");
		returnByCatButton.setPreferredSize(new Dimension(200,25));
		
		returnByCatButton.addActionListener(this);
		
		byCategoryPanel = new JPanel();
		byCategoryPanel.setBackground(new Color(250,200,50));
		byCategoryPanel.setLayout(byCategoryPanelLayout);
		byCategoryPanel.add(byCategoryPanelTitle);
		byCategoryPanel.add(returnByCatButton);
		
// View By Completed Panel		
		FlowLayout byCompletedPanelLayout = new FlowLayout();
		byCompletedPanelLayout.setVgap(15);
		JLabel byCompletedPanelTitle = new JLabel("       Items Listed By Date Completed       ");
		Font byCompletedPanelTitleFont = byCompletedPanelTitle.getFont().deriveFont(Font.BOLD, 16f);
		byCompletedPanelTitle.setFont(byCompletedPanelTitleFont);
		
		returnByDateButton = new JButton("Return To View Completed");
		returnByDateButton.setPreferredSize(new Dimension(200,25));
		
		returnByDateButton.addActionListener(this);
		
		byCompletedPanel = new JPanel();
		byCompletedPanel.setBackground(new Color(250,200,50));
		byCompletedPanel.setLayout(byCompletedPanelLayout);
		byCompletedPanel.add(byCompletedPanelTitle);
		byCompletedPanel.add(returnByDateButton);

// Frame Build
		this.setTitle("Bucket List App");
		this.setSize(400, 375);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(mainPanel);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {		
// Main Menu Panel Buttons		
		if(e.getSource()==newItemButton) {
			remove(mainPanel);
			add(addNewItemPanel);
			revalidate();
	    	repaint();
		}
		if(e.getSource()==viewNextItemButton) {
			remove(mainPanel);
			add(viewNextItemPanel);
			revalidate();
	    	repaint();
		}
		if(e.getSource()==markItemButton) {
			remove(mainPanel);
			add(markCompletedPanel);
			revalidate();
	    	repaint();
		}
		if(e.getSource()==viewCompletedButton) {
			remove(mainPanel);
			add(viewCompletedPanel);
			revalidate();
	    	repaint();
		}
		if(e.getSource()==exitButton) {
			this.dispose();
		}


// Add New Bucket List Item Panel Buttons			
		if(e.getSource()==returnMainAniButton) {
			travelCatButton.doClick();		// Reset the travelCatButton default
			priority5Button.doClick();		// Reset the priority5Button default
			descriptionField.setText(" ");	// Clear the descriptionField
			remove(addNewItemPanel);
			add(mainPanel);
			revalidate();
	    	repaint();
		}

		
// View Next Items Panel Buttons			
		if(e.getSource()==returnMainVniButton) {
			travelOutputVniField.setText(" ");	// Clear the Travel Field
			expOutputVniField.setText(" ");		// Clear the Experience Field
			pgOutputVniField.setText(" ");		// Clear the Personal Growth Field
			remove(viewNextItemPanel);
			add(mainPanel);
			revalidate();
	    	repaint();
		}
		

		
// Mark Item Completed Panel Buttons			
		if(e.getSource()==returnMainMcButton) {
			travelOutputMcField.setText(" ");	// Clear the Travel Field
			expOutputMcField.setText(" ");		// Clear the Experience Field
			pgOutputMcField.setText(" ");		// Clear the Personal Growth Field
			remove(markCompletedPanel);
			add(mainPanel);
			revalidate();
	    	repaint();
		}


// View Completed Items Panel Buttons			
		if(e.getSource()==sortCategoryButton) {
			remove(viewCompletedPanel);
			add(byCategoryPanel);
			revalidate();
	    	repaint();
		}
		
		if(e.getSource()==sortCompletedButton) {
			remove(viewCompletedPanel);
			add(byCompletedPanel);
			revalidate();
	    	repaint();
		}
		
		if(e.getSource()==returnMainVcButton) {
			remove(viewCompletedPanel);
			add(mainPanel);
			revalidate();
	    	repaint();
		}


// Sort By Category Panel Buttons			
		if(e.getSource()==returnByCatButton) {
			remove(byCategoryPanel);
			add(viewCompletedPanel);
			revalidate();
	    	repaint();
		}	
		

// Sort By Completed Panel Buttons			
		if(e.getSource()==returnByDateButton) {
			remove(byCompletedPanel);
			add(viewCompletedPanel);
			revalidate();
	    	repaint();
		}

	}
	
}
