

import java.awt.*;
import javax.swing.*;

import SharedObjects.Professor;

/*
 * Ross Bartlett
 * ENSF 409 - project
 * March 24 2018
 */

/**
 * Creates the prof GUI 
 * @author 	Ross Bartlett, Antoine Bizon
 */
public class ProfGUI extends JFrame{
	/**
	 * The prof that logged in 
	 */
	private Professor prof;

	/**
	 * The JPanel on the JFrame that can switch between different pages/cards
	 */
	private JPanel cards; // a panel that uses CardLayout

	/**
	 * The different pages/panels that the JFrame will display
	 */
	private ProfHomepage profHomePagePanel;
	private ProfCoursePage profCoursePagePanel;
	private ViewStudentsPage viewStudentsPanel;
	private ProfAssignmentPage profAssignmentPanel;
	private EmailPage emailPage;
	private DropboxPage dropboxPage;

	/**
	 * Contructor that creates each page and adds it to the list of cards 
	 * @param p the professor 
	 */
	public ProfGUI(Professor p) {
		prof=p;
		setTitle("B&B Learning");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		cards = new JPanel(new CardLayout());

		profHomePagePanel = new ProfHomepage(); 
		profHomePagePanel.setProf(prof);
		cards.add(profHomePagePanel, "PROFHOMEPAGE"); //the cardName of the homePagePanel is PROFHOMEPAGE

		profCoursePagePanel = new ProfCoursePage();
		cards.add(profCoursePagePanel, "PROFCOURSEPAGE"); //the cardName of the homePagePanel is PROFCOURSEPAGE

		viewStudentsPanel = new ViewStudentsPage();
		cards.add(viewStudentsPanel, "VIEWSTUDENTSPAGE"); //the cardName is VIEWSTUDENTSPAGE

		profAssignmentPanel = new ProfAssignmentPage();
		cards.add(profAssignmentPanel, "PROFASSIGNMENTPAGE"); //the cardName is PROFASSIGNMENTPAGE

		emailPage = new EmailPage();
		cards.add(emailPage, "EMAILPAGE"); //the cardName is EMAILPAGE
		
		dropboxPage = new DropboxPage();
		cards.add(dropboxPage, "DROPBOXPAGE"); //the cardName is DROPBOXPAGE
		
		add(cards);
		pack();
		setResizable(false);
		setLocationRelativeTo(null); // center the JFram
		setVisible(true);
	}

	/**
	 * Changes the card/page shown on the JFrame
	 * @param cardname the name of the card to display
	 */
	public void setActiveCard(String cardname){
		CardLayout cl = (CardLayout)(cards.getLayout());
		cl.show(cards, cardname);
		//note: if cardname is passed in that doesnt exist, nothing happens
	}

	/**
	 * @return the profHomePagePanel
	 */
	public ProfHomepage getProfHomePagePanel() {
		return profHomePagePanel;
	}

	/**
	 * @return the profCoursePagePanel
	 */
	public ProfCoursePage getProfCoursePagePanel() {
		return profCoursePagePanel;
	}
	/**
	 * @return the viewStudentsPanel
	 */
	public ViewStudentsPage getViewStudentsPanel() {
		return viewStudentsPanel;
	}
	/**
	 * @return the profAssignmentPanel
	 */
	public ProfAssignmentPage getProfAssignmentPanel() {
		return profAssignmentPanel;
	}


	/**
	 * @return the emailPage
	 */
	public EmailPage getEmailPage() {
		return emailPage;
	}

	/**
	 * @return the dropboxPage
	 */
	public DropboxPage getDropboxPage() {
		return dropboxPage;
	}

	/**
	 * @return the prof
	 */
	public Professor getProf() {
		return prof;
	}



}
