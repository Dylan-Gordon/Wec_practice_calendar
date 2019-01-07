package View;
import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GUI extends JFrame{
	/**
	 * The JPanel on the JFrame that can switch between different pages/cards
	 */
	private JPanel cards; // a panel that uses CardLayout
	
	/**
	 * The different pages/panels that the JFrame will display
	 */
	private MonthView monthPanel;
	private WeekView weekPanel;
	private DayView dayPanel;
	private EventView eventPanel;

	
	public GUI() {
		setTitle("Calendar");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		GUI gui = new GUI();
	}

}
