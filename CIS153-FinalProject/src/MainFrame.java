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
	JLabel aniPanelSpace1;
	JLabel aniPanelSpace2;
	JLabel aniPanelSpace3;
	JLabel aniPanelSpace4;
	JLabel aniPanelSpace5;
	// View Next Items Menu frame buttons
	JTextField	travelOutputVniField;
	JTextField	expOutputVniField;
	JTextField	pgOutputVniField;
	JButton returnMainVniButton;
	JLabel vniPanelSpace1;
	JLabel vniPanelSpace2;
	JLabel vniPanelSpace3;
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
	JButton sortAlphaButton;
	JButton returnMainVcButton;
	// View By Category frame buttons
	JButton returnByCatButton;
	JTextArea byCategoryTextArea;
	// View By Completion frame buttons
	JButton returnByDateButton;
	JTextArea byCompletedTextArea;
	// View By Completion frame buttons
	JButton returnByAlphaButton;
	JTextArea byAlphaTextArea;
	// Initialize Panels
	JPanel mainPanel;
	JPanel addNewItemPanel;
	JPanel viewNextItemPanel;
	JPanel markCompletedPanel;
	JPanel viewCompletedPanel;
	JPanel byCategoryPanel;
	JPanel byCompletedPanel;
	JPanel byAlphaPanel;
	
	int itemCategory;  // Travel = 1, Experience = 2, Personal Growth = 3
	int itemPriority;  // Urgent = 1, High = 2, Medium = 3, Low = 4, Minor = 5
	
	public MainFrame() {
// Main Menu Panel		
		FlowLayout mainPanelLayout = new FlowLayout();
		mainPanelLayout.setHgap(95);
		mainPanelLayout.setVgap(35);
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
		addNewItemPanelLayout.setHgap(25);
		addNewItemPanelLayout.setVgap(15);
		JLabel aniPanelTitle = new JLabel("***********   Add New Bucket List Item   ***********");
		Font pwTitleFont = aniPanelTitle.getFont().deriveFont(Font.BOLD, 16f);
		aniPanelTitle.setFont(pwTitleFont);
		JLabel aniPanelInstruction1 = new JLabel("                                     Choose the new item category                                     ");
		Font aniInstFont = aniPanelInstruction1.getFont().deriveFont(Font.BOLD, 13f);
		aniPanelInstruction1.setFont(aniInstFont);
		JLabel aniPanelInstruction2 = new JLabel("Description: ");
		aniPanelInstruction2.setFont(aniInstFont);
		JLabel aniPanelInstruction3 = new JLabel("                                     Choose the new item priority                                     ");
		aniPanelInstruction3.setFont(aniInstFont);
		descriptionField = new JTextField(20);
		Font aniBoldFont = descriptionField.getFont().deriveFont(Font.BOLD, 16f);
		descriptionField.setFont(aniBoldFont);
		descriptionField.setHorizontalAlignment(SwingConstants.CENTER);
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
		aniPanelSpace1 = new JLabel("                                                           ");
		aniPanelSpace1.setFont(new Font("Monospaced", Font.BOLD, 14));
		aniPanelSpace2 = new JLabel("                                            ");
		aniPanelSpace2.setFont(new Font("Monospaced", Font.BOLD, 18));
		aniPanelSpace2.setForeground(Color.RED);
		aniPanelSpace3 = new JLabel("                                                           ");
		aniPanelSpace3.setFont(new Font("Monospaced", Font.BOLD, 14));
		aniPanelSpace4 = new JLabel("                 ");
		aniPanelSpace4.setFont(new Font("Monospaced", Font.BOLD, 14));
		aniPanelSpace5 = new JLabel("                 ");
		aniPanelSpace5.setFont(new Font("Monospaced", Font.BOLD, 14));
		
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
		
		travelCatButton.doClick();		// Sets travelCatButton as the default (Travel Category)
		priority5Button.doClick();		// Sets priority5Button as the default (minor)
		
		addNewItemPanel = new JPanel();
		addNewItemPanel.setBackground(new Color(55,235,235));
		addNewItemPanel.setLayout(addNewItemPanelLayout);
		addNewItemPanel.add(aniPanelTitle);
		addNewItemPanel.add(aniPanelInstruction1);
		addNewItemPanel.add(travelCatButton);
		addNewItemPanel.add(expCatButton);
		addNewItemPanel.add(pgCatButton);
		addNewItemPanel.add(aniPanelSpace1);
		addNewItemPanel.add(aniPanelInstruction2);
		addNewItemPanel.add(descriptionField);
		addNewItemPanel.add(aniPanelSpace2);
		addNewItemPanel.add(aniPanelInstruction3);
		addNewItemPanel.add(priority1Button);
		addNewItemPanel.add(priority2Button);
		addNewItemPanel.add(priority3Button);
		addNewItemPanel.add(priority4Button);
		addNewItemPanel.add(priority5Button);
		addNewItemPanel.add(aniPanelSpace3);
		addNewItemPanel.add(aniPanelSpace4);
		addNewItemPanel.add(enterItemAniButton);
		addNewItemPanel.add(aniPanelSpace5);
		addNewItemPanel.add(returnMainAniButton);

// View Next Items Panel
		FlowLayout viewNextItemPanelLayout = new FlowLayout();
		viewNextItemPanelLayout.setHgap(60);
		viewNextItemPanelLayout.setVgap(15);
		JLabel vniPanelTitle = new JLabel("*********  Next Items On Your Bucket List  *********");
		Font vniPanelTitleFont = vniPanelTitle.getFont().deriveFont(Font.BOLD, 16f);
		vniPanelTitle.setFont(vniPanelTitleFont);
		JLabel vniPanelLabel1 = new JLabel("                                  TRAVEL                                  ");
		Font vniLabelFont = vniPanelLabel1.getFont().deriveFont(Font.BOLD, 13f);
		vniPanelLabel1.setFont(vniLabelFont);
		travelOutputVniField = new JTextField(20);
		Font vniBoldFont = travelOutputVniField.getFont().deriveFont(Font.BOLD, 16f);
		travelOutputVniField.setFont(vniBoldFont);
		travelOutputVniField.setHorizontalAlignment(SwingConstants.CENTER);
		JLabel vniPanelLabel2 = new JLabel("                                EXPERIENCE                                ");
		vniPanelLabel2.setFont(vniLabelFont);
		expOutputVniField = new JTextField(20);
		expOutputVniField.setFont(vniBoldFont);
		expOutputVniField.setHorizontalAlignment(SwingConstants.CENTER);
		JLabel vniPanelLabel3 = new JLabel("                              PERSONAL GROWTH                             ");
		vniPanelLabel3.setFont(vniLabelFont);
		pgOutputVniField = new JTextField(20);
		pgOutputVniField.setFont(vniBoldFont);
		pgOutputVniField.setHorizontalAlignment(SwingConstants.CENTER);
		returnMainVniButton = new JButton("Return To Main Menu");
		returnMainVniButton.setPreferredSize(new Dimension(200,25));
		vniPanelSpace1 = new JLabel("                                            ");
		vniPanelSpace1.setFont(new Font("Monospaced", Font.BOLD, 14));
		vniPanelSpace2 = new JLabel("                                            ");
		vniPanelSpace2.setFont(new Font("Monospaced", Font.BOLD, 14));
		vniPanelSpace3 = new JLabel("                                            ");
		vniPanelSpace3.setFont(new Font("Monospaced", Font.BOLD, 14));
		
		returnMainVniButton.addActionListener(this);
	
		viewNextItemPanel = new JPanel();
		viewNextItemPanel.setBackground(new Color(150,150,150));
		viewNextItemPanel.setLayout(viewNextItemPanelLayout);
		viewNextItemPanel.add(vniPanelTitle);
		viewNextItemPanel.add(vniPanelLabel1);
		viewNextItemPanel.add(travelOutputVniField);
		viewNextItemPanel.add(vniPanelSpace1);
		viewNextItemPanel.add(vniPanelLabel2);
		viewNextItemPanel.add(expOutputVniField);
		viewNextItemPanel.add(vniPanelSpace2);
		viewNextItemPanel.add(vniPanelLabel3);
		viewNextItemPanel.add(pgOutputVniField);
		viewNextItemPanel.add(vniPanelSpace3);
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
		travelOutputMcField.setHorizontalAlignment(SwingConstants.CENTER);
		expCompleteButton = new JButton("EXPERIENCE - Mark Complete");
		expCompleteButton.setPreferredSize(new Dimension(250,25));
		expOutputMcField = new JTextField(20);
		expOutputMcField.setFont(mcBoldFont);
		expOutputMcField.setHorizontalAlignment(SwingConstants.CENTER);
		pgCompleteButton = new JButton("PERSONAL GROWTH - Mark Complete");
		pgCompleteButton.setPreferredSize(new Dimension(250,25));
		pgOutputMcField = new JTextField(20);
		pgOutputMcField.setFont(mcBoldFont);
		pgOutputMcField.setHorizontalAlignment(SwingConstants.CENTER);
		returnMainMcButton = new JButton("Return To Main Menu");
		returnMainMcButton.setPreferredSize(new Dimension(200,25));
		JLabel mcPanelSpace1 = new JLabel("                                                                                                                                                                    ");
		Font mcSpaceFont = mcPanelSpace1.getFont().deriveFont(Font.BOLD, 10f);
		mcPanelSpace1.setFont(mcSpaceFont);
		JLabel mcPanelSpace2 = new JLabel("                                                                                                                                                                    ");
		mcPanelSpace2.setFont(mcSpaceFont);
		JLabel mcPanelSpace3 = new JLabel("                                                                                                                                                                    ");
		mcPanelSpace3.setFont(mcSpaceFont);
		JLabel mcPanelSpace4 = new JLabel("                                                                                                                                                                    ");
		mcPanelSpace3.setFont(mcSpaceFont);
		
		travelCompleteButton.addActionListener(this);
		expCompleteButton.addActionListener(this);
		pgCompleteButton.addActionListener(this);
		returnMainMcButton.addActionListener(this);
		
		markCompletedPanel = new JPanel();
		markCompletedPanel.setBackground(new Color(255,255,0));
		markCompletedPanel.setLayout(markCompletedPanelLayout);
		markCompletedPanel.add(markCompletedPanelTitle);
		markCompletedPanel.add(mcPanelSpace1);
		markCompletedPanel.add(travelCompleteButton);
		markCompletedPanel.add(travelOutputMcField);
		markCompletedPanel.add(mcPanelSpace2);
		markCompletedPanel.add(expCompleteButton);
		markCompletedPanel.add(expOutputMcField);
		markCompletedPanel.add(mcPanelSpace3);
		markCompletedPanel.add(pgCompleteButton);
		markCompletedPanel.add(pgOutputMcField);
		markCompletedPanel.add(mcPanelSpace4);
		markCompletedPanel.add(returnMainMcButton);
		
// View Completed Items Panel	
		FlowLayout viewCompletedPanelLayout = new FlowLayout();
		viewCompletedPanelLayout.setVgap(15);
		JLabel viewCompletedPanelTitle = new JLabel(" *****  Sort And View Your Completed Items  ***** ");
		Font vcPanelTitleFont = viewCompletedPanelTitle.getFont().deriveFont(Font.BOLD, 16f);
		viewCompletedPanelTitle.setFont(vcPanelTitleFont);
		sortCategoryButton = new JButton("View By Category");
		sortCategoryButton.setPreferredSize(new Dimension(235,25));
		sortCompletedButton = new JButton("View By Date Completed");
		sortCompletedButton.setPreferredSize(new Dimension(235,25));
		sortAlphaButton = new JButton("View Alphabetically by Description");
		sortAlphaButton.setPreferredSize(new Dimension(235,25));
		returnMainVcButton = new JButton("Return To Main Menu");
		returnMainVcButton.setPreferredSize(new Dimension(235,25));
		JLabel vcPanelSpace1 = new JLabel("                                                                                                                            ");
		Font vcSpaceFont = vcPanelSpace1.getFont().deriveFont(Font.BOLD, 13f);
		vcPanelSpace1.setFont(vcSpaceFont);
		JLabel vcPanelSpace2 = new JLabel("                                                                                                                            ");
		vcPanelSpace2.setFont(vcSpaceFont);
		JLabel vcPanelSpace3 = new JLabel("                                                                                                                            ");
		vcPanelSpace3.setFont(vcSpaceFont);
		JLabel vcPanelSpace4 = new JLabel("                                                                                                                            ");
		vcPanelSpace4.setFont(vcSpaceFont);
		
		sortCategoryButton.addActionListener(this);
		sortCompletedButton.addActionListener(this);
		sortAlphaButton.addActionListener(this);
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
		viewCompletedPanel.add(sortAlphaButton);
		viewCompletedPanel.add(vcPanelSpace4);
		viewCompletedPanel.add(returnMainVcButton);
			
// View By Category Panel
		FlowLayout byCategoryPanelLayout = new FlowLayout();
		byCategoryPanelLayout.setVgap(15);
		JLabel byCategoryPanelTitle = new JLabel("       Items Listed By Category       ");
		Font byCategoryPanelTitleFont = byCategoryPanelTitle.getFont().deriveFont(Font.BOLD, 16f);
		byCategoryPanelTitle.setFont(byCategoryPanelTitleFont);
		byCategoryTextArea = new JTextArea(" ", 16, 80);
		byCategoryTextArea.setEditable(false);
		byCategoryTextArea.setFont(new Font("Monospaced", Font.BOLD, 12));
		
		returnByCatButton = new JButton("Return To View Completed Menu");
		returnByCatButton.setPreferredSize(new Dimension(225,25));
		
		returnByCatButton.addActionListener(this);
		
		byCategoryPanel = new JPanel();
		byCategoryPanel.setBackground(new Color(250,200,50));
		byCategoryPanel.setLayout(byCategoryPanelLayout);
		byCategoryPanel.add(byCategoryPanelTitle);
		byCategoryPanel.add(byCategoryTextArea);
		byCategoryPanel.add(returnByCatButton);
		
// View By Completed Panel		
		FlowLayout byCompletedPanelLayout = new FlowLayout();
		byCompletedPanelLayout.setVgap(15);
		JLabel byCompletedPanelTitle = new JLabel("       Items Listed By Date Completed       ");
		Font byCompletedPanelTitleFont = byCompletedPanelTitle.getFont().deriveFont(Font.BOLD, 16f);
		byCompletedPanelTitle.setFont(byCompletedPanelTitleFont);
		byCompletedTextArea = new JTextArea(" ", 16, 80);
		byCompletedTextArea.setEditable(false);
		byCompletedTextArea.setFont(new Font("Monospaced", Font.BOLD, 12));
		
		returnByDateButton = new JButton("Return To View Completed Menu");
		returnByDateButton.setPreferredSize(new Dimension(225,25));
		
		returnByDateButton.addActionListener(this);
		
		byCompletedPanel = new JPanel();
		byCompletedPanel.setBackground(new Color(250,200,50));
		byCompletedPanel.setLayout(byCompletedPanelLayout);
		byCompletedPanel.add(byCompletedPanelTitle);
		byCompletedPanel.add(byCompletedTextArea);
		byCompletedPanel.add(returnByDateButton);
		
// View By Alphabetical Panel		
		FlowLayout byAlphaPanelLayout = new FlowLayout();
		byAlphaPanelLayout.setVgap(15);
		JLabel byAlphaPanelTitle = new JLabel("       Items Listed Alphabetically By Description       ");
		Font byAlphaPanelTitleFont = byAlphaPanelTitle.getFont().deriveFont(Font.BOLD, 16f);
		byAlphaPanelTitle.setFont(byAlphaPanelTitleFont);
		byAlphaTextArea = new JTextArea(" ", 16, 80);
		byAlphaTextArea.setEditable(false);
		byAlphaTextArea.setFont(new Font("Monospaced", Font.BOLD, 12));
		
		returnByAlphaButton = new JButton("Return To View Completed Menu");
		returnByAlphaButton.setPreferredSize(new Dimension(225,25));
		
		returnByAlphaButton.addActionListener(this);
		
		byAlphaPanel = new JPanel();
		byAlphaPanel.setBackground(new Color(250,200,50));
		byAlphaPanel.setLayout(byAlphaPanelLayout);
		byAlphaPanel.add(byAlphaPanelTitle);
		byAlphaPanel.add(byAlphaTextArea);
		byAlphaPanel.add(returnByAlphaButton);

// Frame Build
		this.setTitle("Bucket List App");
		this.setSize(600, 465);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(mainPanel);
		this.setVisible(true);
	}

// BEGINNING OF ACTION LISTENERS
	@Override
	public void actionPerformed(ActionEvent e) {		
// Main Menu Panel Buttons
		// Add New Bucket List Item Button
		if(e.getSource()==newItemButton) {
			remove(mainPanel);
			add(addNewItemPanel);
			revalidate();
	    	repaint();
		}
		// View Next Items Button
		if(e.getSource()==viewNextItemButton) {
			remove(mainPanel);
			add(viewNextItemPanel);
			if (ListManager.myTravelList.isEmpty()) {
				travelOutputVniField.setText("** THIS LIST IS EMPTY **");
			}
			else {
				travelOutputVniField.setText(ListManager.myTravelList.peek().getDescription());
			}
			if (ListManager.myExperienceList.isEmpty()) {
				expOutputVniField.setText("** THIS LIST IS EMPTY **");
			}
			else {
				expOutputVniField.setText(ListManager.myExperienceList.peek().getDescription());
			}
			if (ListManager.myPersonalGrowthList.isEmpty()) {
				pgOutputVniField.setText("** THIS LIST IS EMPTY **");
			}
			else {
				pgOutputVniField.setText(ListManager.myPersonalGrowthList.peek().getDescription());
			}
			revalidate();
	    	repaint();
		}
		// Mark Item As Completed Button
		if(e.getSource()==markItemButton) {
			remove(mainPanel);
			add(markCompletedPanel);
			if (ListManager.myTravelList.isEmpty()) {
				travelOutputMcField.setText("** THIS LIST IS EMPTY **");
				travelCompleteButton.setEnabled(false);	// Disable "Travel Complete" button
			}
			else {
				travelOutputMcField.setText(ListManager.myTravelList.peek().getDescription());
			}
			if (ListManager.myExperienceList.isEmpty()) {
				expOutputMcField.setText("** THIS LIST IS EMPTY **");
				expCompleteButton.setEnabled(false);	// Disable "Experience Complete" button
			}
			else {
				expOutputMcField.setText(ListManager.myExperienceList.peek().getDescription());
			}
			if (ListManager.myPersonalGrowthList.isEmpty()) {
				pgOutputMcField.setText("** THIS LIST IS EMPTY **");
				pgCompleteButton.setEnabled(false);	// ReEnable "Personal Growth Complete" button
			}
			else {
				pgOutputMcField.setText(ListManager.myPersonalGrowthList.peek().getDescription());
			}
			revalidate();
	    	repaint();
		}
		// View Completed Items Button
		if(e.getSource()==viewCompletedButton) {
			remove(mainPanel);
			add(viewCompletedPanel);
			revalidate();
	    	repaint();
		}
		// Exit Program Button
		if(e.getSource()==exitButton) {
			this.dispose();
		}

// View Next Items Panel Buttons
		// Return To Main Menu Button
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
		// TRAVEL - Mark Complete Button
		if(e.getSource()==travelCompleteButton) {
			ListManager.completeTravelItem();
			travelOutputMcField.setText("SUCCESS!");
			travelCompleteButton.setEnabled(false);  // Disable "Travel Complete" button
		}
		// EXPERIENCE - Mark Complete Button
		if(e.getSource()==expCompleteButton) {
			ListManager.completeExperienceItem();
			expOutputMcField.setText("SUCCESS!");
			expCompleteButton.setEnabled(false);  // Disable "Experience Complete" button
		}
		// PERSONAL GROWTH - Mark Complete Button
		if(e.getSource()==pgCompleteButton) {
			ListManager.completePersonalGrowthItem();
			pgOutputMcField.setText("SUCCESS!");
			pgCompleteButton.setEnabled(false);  // Disable "Personal Growth Complete" button
		}
		// Return To Main Menu Button
		if(e.getSource()==returnMainMcButton) {
			travelOutputMcField.setText(" ");	// Clear the Travel Field
			expOutputMcField.setText(" ");		// Clear the Experience Field
			pgOutputMcField.setText(" ");		// Clear the Personal Growth Field
			travelCompleteButton.setEnabled(true);	// ReEnable "Travel Complete" button
			expCompleteButton.setEnabled(true);	// ReEnable "Experience Complete" button
			pgCompleteButton.setEnabled(true);	// ReEnable "Personal Growth Complete" button
			remove(markCompletedPanel);
			add(mainPanel);
			revalidate();
	    	repaint();
		}

// View Completed Items Panel Buttons
		// View By Category Button
		if(e.getSource()==sortCategoryButton) {
			remove(viewCompletedPanel);
			add(byCategoryPanel);
			byCategoryTextArea.setText(ListManager.byCategoryString());
			revalidate();
	    	repaint();
		}
		// View By Date Completed Button
		if(e.getSource()==sortCompletedButton) {
			remove(viewCompletedPanel);
			add(byCompletedPanel);
			byCompletedTextArea.setText(ListManager.byCompletedString());
			revalidate();
	    	repaint();
		}
		// View Alphabetically By Description Button
		if(e.getSource()==sortAlphaButton) {
			remove(viewCompletedPanel);
			add(byAlphaPanel);
			byAlphaTextArea.setText(ListManager.byAlphebiticalString());
			revalidate();
	    	repaint();
		}
		// Return To Main Menu Button
		if(e.getSource()==returnMainVcButton) {
			remove(viewCompletedPanel);
			add(mainPanel);
			revalidate();
	    	repaint();
		}

// Sort By Category Panel Buttons
		// Return To View Completed Menu Button
		if(e.getSource()==returnByCatButton) {
			remove(byCategoryPanel);
			add(viewCompletedPanel);
			revalidate();
	    	repaint();
		}	

// Sort By Completed Panel Buttons
		// Return To View Completed Menu Button
		if(e.getSource()==returnByDateButton) {
			remove(byCompletedPanel);
			add(viewCompletedPanel);
			revalidate();
	    	repaint();
		}
		
// Sort By Completed Panel Buttons
		// Return To View Completed Menu Button
		if(e.getSource()==returnByAlphaButton) {
			remove(byAlphaPanel);
			add(viewCompletedPanel);
			revalidate();
	    	repaint();
		}
		
// Add New Bucket List Item Panel Buttons
		// Category Choice Radio Buttons
		if(e.getSource()==travelCatButton) {
			itemCategory = 1;
		}
		if(e.getSource()==expCatButton) {
			itemCategory = 2;
		}
		if(e.getSource()==pgCatButton) {
			itemCategory = 3;
		}
		
		// Priority Choice Radio Buttons
		if(e.getSource()==priority1Button) {
			itemPriority = 1;
		}
		if(e.getSource()==priority2Button) {
			itemPriority = 2;
		}
		if(e.getSource()==priority3Button) {
			itemPriority = 3;
		}
		if(e.getSource()==priority4Button) {
			itemPriority = 4;
		}
		if(e.getSource()==priority5Button) {
			itemPriority = 5;
		}
		// Save New Item Button
		if(e.getSource()==enterItemAniButton) {
			if (descriptionField.getText().isBlank() || descriptionField.getText().isEmpty()) {
				aniPanelSpace2.setText("DESCRIPTION CANNOT BE BLANK");
				descriptionField.setText("");
			}
			else {
				if (itemCategory == 1) {
					ListManager.myTravelList.add(new TravelItem(descriptionField.getText(), itemPriority));
				}
				if (itemCategory == 2) {
					ListManager.myExperienceList.add(new ExperienceItem(descriptionField.getText(), itemPriority));
				}
				if (itemCategory == 3) {
					ListManager.myPersonalGrowthList.add(new PersonalGrowthItem(descriptionField.getText(), itemPriority));
				}
				descriptionField.setText("SUCCESS!");
				aniPanelSpace2.setText("                                    ");
				enterItemAniButton.setEnabled(false);	// Disable "Save New Item" button
			}
		}
		// Return To Main Menu Button			
		if(e.getSource()==returnMainAniButton) {
			travelCatButton.doClick();				// Reset the travelCatButton default
			priority5Button.doClick();				// Reset the priority5Button default
			descriptionField.setText(" ");			// Clear the descriptionField
			enterItemAniButton.setEnabled(true);	// ReEnable "Save New Item" button
			remove(addNewItemPanel);
			add(mainPanel);
			revalidate();
	    	repaint();
		}	
	}
}