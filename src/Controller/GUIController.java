package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;

import Model.Calender;
import SharedObjects.Date;
import SharedObjects.Event;
import View.*;

/**
 * Sets all the button listeners on the Prof GUIs
 * @author 	Ross Bartlett, Antoine Bizon
 */
public class GUIController{
	
	private GUI gui;
	private Calender userCalender;

	/**
	 * constructor that inits the page and the socketCommunicator and sets all the listeners
	 * @param pg the GUI
	 * @param c the socketCommunicator
	 */
	public GUIController(GUI g) {//, ClientSocketCommunicator c){
		gui = g;
		//		setHomepageButtons(pg);
		//		setBackButtons(pg);

		//set other navigator buttons
		g.getButtonPanel().setMonthButtonListener(new CardChangerListener("MONTHPANEL"));
		g.getButtonPanel().setWeekButtonListener(new CardChangerListener("WEEKPANEL"));
		g.getButtonPanel().setDayButtonListener(new CardChangerListener("DAYPANEL"));
		
		userCalender = Calender.getInstance();
		
		g.getMonthPanel().setDayButtonListeners(new DayButtonListener());
	}
	
	/**
	 * Inner class listener for dayButtons on MonthlyView
	 */
	class DayButtonListener implements ActionListener {
	
		@Override
		public void actionPerformed(ActionEvent e) {
			Object obj = e.getSource();
			if( obj instanceof DayButton) {
				DayButton dButton = (DayButton)obj;
				gui.setActiveCard("DAYPANEL");
				
			}

		}
	}
	/**
	 * Inner class listener to switch the active card on the ProfGUI using either the BackToHomepage or Back buttons
	 */
	class CardChangerListener implements ActionListener {
		String card;
		public CardChangerListener(String c) {
			card = c;
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			if(card.equals("MONTHPANEL")){
//				refreshProfAssignmentPage(pg);
			}
			else if(card.equals("WEEKPANEL")){
//				refreshProfCoursePage(pg);
			}
			else if(card.equals("DAYPANEL")){
//				fillHomePageCourseList(pg.getProfHomePagePanel()); // update/refresh the course list
			}
			gui.setActiveCard(card);
		}
	} //end of inner class ChagneCardListener
	
	
	
	public void refreshDayView(Date d) {
		DayView panel = gui.getDayPanel();
		panel.setDay(d);
		panel.setDayLabel();
		//refresh the JList of events
		DefaultListModel<Event> listModel = new DefaultListModel<>();
		for(Event e : userCalender.getDayEvents(d)) {
			listModel.addElement(e);
		}
		// then do the update: 
		panel.updateEventsList(listModel);
	}

	
}

