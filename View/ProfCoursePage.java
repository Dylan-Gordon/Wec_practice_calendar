

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

import javax.swing.*;

import SharedObjects.Assignment;
import SharedObjects.Course;



/**
 * Creates the ProfCoursePage GUI panel -  the course page as viewed from a Professor
 * @author 	Ross Bartlett, Antoine Bizon
 */
public class ProfCoursePage extends JPanel{
    /**
     * The course represented on the GUI
     */
    private Course course;
	/**
	 * The button to return to the prof homepage
	 */
    private JButton homepageButton = new JButton("Back to Homepage");
    /**
	 * The create new course button
	 */
    private JButton viewStudentsButton = new JButton("View Students");
    /**
	 * The create new course button
	 */
    private JButton emailButton = new JButton("Email Students");
    /**
	 * The create new course button
	 */
    private JButton newAssignmentButton = new JButton("Create New Assignment");
    /**
	 * The create new course button
	 */
    private JButton changeActiveButton = new JButton("Change Active Status");

    /**
     *  tells if course is active/inactive
     */
    private JLabel statusMessage = new JLabel();
    /**
     *  tells course name
     */
    private JLabel courseNameText = new JLabel();
   
    /**
	 * The list of the course's assignments
	 */
	 private DefaultListModel<Assignment> listModel = new DefaultListModel<>(); 
     private JList<Assignment> assignmentList;
    


	/**
	 * Constructor that creates the visible panel 
	 */
	public ProfCoursePage() {
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		setPreferredSize(new Dimension(800,600));
        fillContentPane();
	}


	/**
	 * Helper method to add components to the panel
	 */
	private void fillContentPane() {
        add(Box.createRigidArea(new Dimension(0,10))); //empty spacing 
        
        setCourseNameText("testCourseName"); //TODO remove? the cardChanger sets this when go to this page
        courseNameText.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(courseNameText);
        add(Box.createRigidArea(new Dimension(0,10))); //empty spacing

        setButtonPanel();
        add(Box.createRigidArea(new Dimension(0,10))); //empty spacing
        
        
        add(GuiUtilities.centeredJLabel("Assignments:"));
        setupAssignmentsList();

        newAssignmentButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(newAssignmentButton);

        setActiveStatusText(false); // start as saying inactive //TODO remove?
        add(Box.createRigidArea(new Dimension(0,50))); //empty spacing 

        statusMessage.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(statusMessage);
        changeActiveButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(changeActiveButton);
        
    }

    

    /**
     * make a panel of the top buttons on the frame
     */
    public void setButtonPanel(){
        JPanel buttonPanel = new JPanel();
        buttonPanel.setMaximumSize(new Dimension(800,40));
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.add(homepageButton);
        buttonPanel.add(viewStudentsButton);
        buttonPanel.add(emailButton);
        add(buttonPanel);
        add(GuiUtilities.horizontalLine());
    }

    /**
     * Generate a scrollable JList of assignemts 
     */
    private void setupAssignmentsList(){
        assignmentList = new JList<>(listModel);
		assignmentList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		assignmentList.setLayoutOrientation(JList.VERTICAL);

		JScrollPane scroller = new JScrollPane(assignmentList);
        scroller.setMaximumSize(new Dimension(400,300));
		add(scroller);
    }
    
	/**
	 * Helper functions for the CONTROLLER to initialize the listeners
	 * @param e the actionListener
	 */
	public void setHomepageButtonListener(ActionListener e) {
        homepageButton.addActionListener(e);
    }
	public void setViewStudentsButtonListener(ActionListener e) {
        viewStudentsButton.addActionListener(e);
    }
	public void setEmailButtonListener(ActionListener e) {
        emailButton.addActionListener(e);
    }
	public void setNewAssignmentButtonListener(ActionListener e) {
        newAssignmentButton.addActionListener(e);
    }
	public void setChangeActiveButtonListener(ActionListener e) {
        changeActiveButton.addActionListener(e);
    }
	public void setListListener(MouseAdapter e) {
		assignmentList.addMouseListener(e);
	}
    

    /**
	 * helper method to set and update the course list 
	 * @param c the list of results to display 
	 */
	public void updateAssignmentList(DefaultListModel<Assignment> c) { 
		listModel=c;
		assignmentList.setModel(listModel);
    }
	
	/**
     * Changes the frame to tell whether the course is active or not
     * @param status true means active, else means inactive
     */
    public void setActiveStatusText(boolean status){
        String message = "This course is currently ";
        message+= (status==true)? "ACTIVE":"INACTIVE";
        statusMessage.setText(message);
    }
    /**
     * changes the JLabel that tells the course name
	 * @param name the course name
	 */
	private void setCourseNameText(String name) {
		String message = "Course Page: ";
        message+= name;
        courseNameText.setText(message);
	}

    /**
     * @return the course
     */
    public Course getCourse() { 
        return course;
    }

    /**
     * @param c the course to set
     */
    public void setCourse(Course c) {
        course = c;
        setCourseNameText(c.getName());//update the course name JLabel
    }


	/**
	 * @return the assignmentList
	 */
	public JList<Assignment> getAssignmentList() {
		return assignmentList;
	}


}
