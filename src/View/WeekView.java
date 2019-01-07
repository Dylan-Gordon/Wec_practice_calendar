package View;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class WeekView extends JPanel{
	
	private JButton testButton = new JButton("Test Button");

	/**
	 * JLabel at top of panel 
	 */
	private JLabel welcomeText= new JLabel();
	
	
	/**
	 * Constructor that creates the visible panel 
	 */
	public WeekView() { 
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		setPreferredSize(new Dimension(800,600));
		fillContentPane();
	}
	

	/**
	 * Helper method to add components to the JFrame
	 */
	private void fillContentPane() {
		add(Box.createRigidArea(new Dimension(0,10))); //empty spacing

		welcomeText.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(welcomeText);

		add(Box.createRigidArea(new Dimension(0,10))); //empty spacing

		add(GuiUtilities.centeredJLabel("Week:")); // TODO name of week

		testButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(testButton);
	}
	
}
