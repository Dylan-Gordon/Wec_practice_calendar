package View;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Model.Date;

@SuppressWarnings("serial")
public class MonthView extends JPanel{
	
//	private JButton testButton = new JButton("Test Button");

	/**
	 * JLabel at top of panel 
	 */
	private JLabel monthLabel= new JLabel();
	
	
	/**
	 * Constructor that creates the visible panel 
	 */
	public MonthView() { 
		
		 
		setLayout(new GridLayout(6,7));
		setPreferredSize(new Dimension(800,600));
		fillContentPane();
	}
	

	/**
	 * Helper method to add components to the JFrame
	 */
	private void fillContentPane() {
//		add(Box.createRigidArea(new Dimension(0,10))); //empty spacing
//
		monthLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(monthLabel);
//
//		add(Box.createRigidArea(new Dimension(0,10))); //empty spacing
//
//		add(GuiUtilities.centeredJLabel("Month:")); // TODO name of month
////		setupCourseList();
//
//		testButton.setAlignmentX(Component.CENTER_ALIGNMENT);
//		add(testButton);
		
		for(int i=0; i<6*7; i++) {
			add(new DayButton(new Date(2019, 1, i)));
		}
	}
	
	public void setMonthLabel(String s) {
		monthLabel.setText(s);
	}
	
}
