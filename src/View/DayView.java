package View;
import java.awt.Component;
import java.awt.Dimension;
import java.sql.Date;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class DayView extends JPanel{
	
	private JButton testButton = new JButton("Test Button");

	/**
	 * JLabel at top of panel 
	 */
	private JLabel dayLabel;
	
	private Date day;
	
	/**
	 * Constructor that creates the visible panel 
	 */
	public DayView(Date d) { 
		day = d;
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		setPreferredSize(new Dimension(800,600));
		fillContentPane();
	}
	

	/**
	 * Helper method to add components to the JFrame
	 */
	private void fillContentPane() {

		dayLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		dayLabel.setText(""+ day.getMonth() + day.getDate() + day.getYear());
		add(dayLabel);

		add(Box.createRigidArea(new Dimension(0,10))); //empty spacing

		add(GuiUtilities.centeredJLabel("Day:")); // TODO name of day

		testButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(testButton);
	}
	
}
