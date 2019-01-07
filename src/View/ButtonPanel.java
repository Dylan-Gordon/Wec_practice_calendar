package View;

import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ButtonPanel extends JPanel {
	private JButton monthButton = new JButton("Month View");
	private JButton weekButton = new JButton("Week View");

	
	public ButtonPanel() {
		
		setPreferredSize(new Dimension(800,40));
		
		add(monthButton);
		add(weekButton);
	}
	
	/**
	 * Helper functions for the CONTROLLER to initialize the listeners
	 * @param e the actionListener
	 */
	public void setMonthButtonListener(ActionListener e) {
		monthButton.addActionListener(e);
	}
	/**
	 * Helper functions for the CONTROLLER to initialize the listeners
	 * @param e the actionListener
	 */
	public void setWeekButtonListener(ActionListener e) {
		weekButton.addActionListener(e);
	}

	
	
}
