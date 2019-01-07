package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;


import Model.Calendar;
import SharedObjects.Date;
import SharedObjects.Event;
import SharedObjects.Time;
import View.*;


public class GUIController{
	
	private GUI gui;
	private Calendar userCalender;


	public GUIController(GUI g) {
		gui = g;

		g.getButtonPanel().setMonthButtonListener(new CardChangerListener("MONTHPANEL"));
		g.getButtonPanel().setWeekButtonListener(new CardChangerListener("WEEKPANEL"));
		g.getButtonPanel().setNextMonthButtonListener(new NextMonthButtonListener());
		g.getButtonPanel().setPrevMonthButtonListener(new PrevMonthButtonListener());

		userCalender = Calendar.getInstance();
		
		g.getMonthPanel().setDayButtonListeners(new DayButtonListener());
		g.getDayPanel().setNewEventButtonListener(new addEventButtonListener());
		g.getDayPanel().setViewEventInfoButtonListener(new showEventButtonListener());
	}
	
	
<<<<<<< HEAD
=======
	class NextMonthButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			
		}
		
	}
	
	class PrevMonthButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			
		}
		
	}
	
	/**
	 * 
	 *
	 */
>>>>>>> 47ca6998d0e7f3f158b2b2053e1a5b3ec2094ce5
	class addEventButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			String eventName = JOptionPane.showInputDialog( "What's the events name?");
			System.out.println(eventName);
			if(eventName.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Please enter a name", "Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
			
			String startTimeString = JOptionPane.showInputDialog( "What's the events start time (hh:mm)?");
			Time startTime = convertToTime(startTimeString);
			if(startTime == null) {
				return;
			}
			
			String durationString = JOptionPane.showInputDialog( "What's the events duration (hh:mm)?");
			Time duration =  convertToTime(durationString);
			if(duration == null) {
				return;
			}
			
			Date currentDay = gui.getDayPanel().getDate();
			
			userCalender.addEvent(new Event(currentDay, startTime, duration, eventName));
			refreshEventList(currentDay, gui.getDayPanel());

		}
		
		private Time convertToTime (String time) {
			Time returnVal = null;
			try {
				String[] parts = time.split(":");
				returnVal = new Time(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]));
			}
			catch(NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Improper time format", "Error", JOptionPane.ERROR_MESSAGE);
			}
			catch(NullPointerException e) {
				JOptionPane.showMessageDialog(null, "Please enter a value for the time", "Error", JOptionPane.ERROR_MESSAGE);
			}
			catch (ArrayIndexOutOfBoundsException e) {
				JOptionPane.showMessageDialog(null, "Improper time format", "Error", JOptionPane.ERROR_MESSAGE);
			}
			
			
			return returnVal;
		}
		
	}
	
	class showEventButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			Event selectedEvent = gui.getDayPanel().getEventList().getSelectedValue();
			if(selectedEvent != null) {
				JOptionPane.showMessageDialog(null, selectedEvent.getName() + "\n Date: " + selectedEvent.getStartDate() + "\n Time: " + selectedEvent.getStartTime() + "\n Length: " + selectedEvent.getDuration());
			}
			
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

