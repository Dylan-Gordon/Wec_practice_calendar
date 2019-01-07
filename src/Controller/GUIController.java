package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JList;

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

		
		userCalender = Calender.getInstance();
		
		g.getMonthPanel().setDayButtonListeners(new DayButtonListener());
		g.getDayPanel().setNewEventButtonListener(new addEventButtonListener());
		g.getDayPanel().setViewEventInfoButtonListener(new showEventButtonListener());
	}
	
	/**
	 * 
	 *
	 */
	class addEventButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	class showEventButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			Event events = gui.getDayPanel().getEventList().getSelectedValue();
			
			JOptionPane.showMessageDialog(null, events.getName() + "\n Date: " + events.getStartDate() + "\n Time: " + events.getStartTime() + "\n Length: " + events.getDuration());
		}
		
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
				refreshDayView(dButton.getDate());
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
			gui.setActiveCard(card);
		}
	} //end of inner class ChagneCardListener
	
	
	
	public void refreshDayView(Date d) {
		DayView panel = gui.getDayPanel();
		panel.setDay(d);
		panel.setDayLabel();
		//refresh the JList of events
		refreshEventList(d, panel);
	}



	private void refreshEventList(Date d, DayView panel) {
		DefaultListModel<Event> listModel = new DefaultListModel<>();
		ArrayList<Event> sortedList = userCalender.getDayEvents(d);
		Collections.sort(sortedList);
		for(Object object : sortedList)
			listModel.addElement((Event) object);
		// then do the update: 
		panel.updateEventsList(listModel);
	}

	
}

