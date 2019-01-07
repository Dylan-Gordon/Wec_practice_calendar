package View;

import java.awt.Button;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class ButtonPanel extends JPanel {
	private JButton monthButton = new JButton("Month View");
	private JButton weekButton = new JButton("Week View");
	private JButton dayButton = new JButton("Day View");

	
	public ButtonPanel() {
		
		setPreferredSize(new Dimension(800,40));
		
		add(monthButton);
		add(weekButton);
		add(dayButton);
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
	/**
	 * Helper functions for the CONTROLLER to initialize the listeners
	 * @param e the actionListener
	 */
	public void setDayButtonListener(ActionListener e) {
		dayButton.addActionListener(e);
	}
	
	
	
}
