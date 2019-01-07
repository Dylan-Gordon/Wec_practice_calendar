package View;
import java.awt.CardLayout;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;


@SuppressWarnings("serial")
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

	
	public GUI() {
		setTitle("Calendar");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		
		buttonPanel = new ButtonPanel();
		add(buttonPanel);
		
		
		cards = new JPanel(new CardLayout());
		
		monthPanel = new MonthView(); 
		cards.add(monthPanel, "MONTHPANEL"); //the cardName
		
		weekPanel = new WeekView(); 
		cards.add(weekPanel, "WEEKPANEL"); //the cardName
		
		dayPanel = new DayView(); 
		cards.add(dayPanel, "DAYPANEL"); //the cardName
		
		
		add(cards);
				
		pack();
		setResizable(false);
		setLocationRelativeTo(null); // center the JFram
		setVisible(true);
	}

	public ButtonPanel getButtonPanel() {
		return buttonPanel;
	}

	public MonthView getMonthPanel() {
		return monthPanel;
	}

	public WeekView getWeekPanel() {
		return weekPanel;
	}

	public DayView getDayPanel() {
		return dayPanel;
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
