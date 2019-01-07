package View;
import java.awt.Button;
import java.awt.CardLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Controller.GUIController;


public class GUI extends JFrame{
	/**
	 * The JPanel on the JFrame that can switch between different pages/cards
	 */
	private JPanel cards; // a panel that uses CardLayout
	
	
	
	/**
	 * The different pages/panels that the JFrame will display
	 */
	private ButtonPanel buttonPanel;

	private MonthView monthPanel;
	private WeekView weekPanel;
	private DayView dayPanel;
	private EventView eventPanel;

	
	public GUI() {
		setTitle("Calendar");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setLayout(new FlowLayout());
		
		buttonPanel = new ButtonPanel();
		add(buttonPanel);
		
		
		cards = new JPanel(new CardLayout());
		
		monthPanel = new MonthView(); 
		cards.add(monthPanel, "MONTHPANEL"); //the cardName
		
		weekPanel = new WeekView(); 
		cards.add(weekPanel, "WEEKPANEL"); //the cardName
		
		dayPanel = new DayView(); 
		cards.add(dayPanel, "DAYPANEL"); //the cardName
		
		eventPanel = new EventView(); 
		cards.add(eventPanel, "EVENTPANEL"); //the cardName
		
		add(cards);
		pack();
		setResizable(false);
		setLocationRelativeTo(null); // center the JFram
		setVisible(true);
	}

	public ButtonPanel getButtonPanel() {
		return buttonPanel;
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

}
