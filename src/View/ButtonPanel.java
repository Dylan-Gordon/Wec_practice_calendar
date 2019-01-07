package View;

import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ButtonPanel extends JPanel {
	
	private JButton monthButton = new JButton("Month View");

	private JButton prevMonthButton = new JButton("Previous month");
	private JButton nextMonthButton = new JButton("Next Month");
	
	public ButtonPanel() {
		
		setPreferredSize(new Dimension(800,40));
		add(prevMonthButton);
		add(Box.createRigidArea(new Dimension(90,0)));
		add(monthButton);
		add(Box.createRigidArea(new Dimension(90,0)));
		add(nextMonthButton);
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

	public void setPrevMonthButtonListener(ActionListener e) {
		prevMonthButton.addActionListener(e);
	}
	
	public void setNextMonthButtonListener(ActionListener e) {
		nextMonthButton.addActionListener(e);
	}
	
}
