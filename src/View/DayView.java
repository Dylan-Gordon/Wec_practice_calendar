package View;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import Model.Calendar;
import SharedObjects.Date;
import SharedObjects.Event;

@SuppressWarnings("serial")
public class DayView extends JPanel{
	
	private JButton addEventButton = new JButton("New Event");
	private JButton viewEventInfoButton = new JButton("View Event Info");


	/**
	 * JLabel at top of panel 
	 */
	private JLabel dayLabel;
	
	private Date day;
	
	 /**
	 * The list of the day's events
	 */
	 private DefaultListModel<Event> listModel = new DefaultListModel<>(); 
     private JList<Event> eventList;
	
	/**
	 * Constructor that creates the visible panel 
	 */
	public DayView() { 
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		setPreferredSize(new Dimension(800,600));
		dayLabel = new JLabel();
		day = new Date(1996, 9, 21); // temp default date
		
		fillContentPane();
	}
	

	/**
	 * Helper method to add components to the JFrame
	 */
	private void fillContentPane() {

		dayLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		setDayLabel();
		add(dayLabel);
		
		setupEventsList();
	
		viewEventInfoButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(viewEventInfoButton);
		
		addEventButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(addEventButton);
	}
	
	  /**
     * Generate a scrollable JList of events 
     */
    private void setupEventsList(){
        eventList = new JList<>(listModel);
        eventList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        eventList.setLayoutOrientation(JList.VERTICAL);
		// assignmentList.addListSelectionListener(new ListListener(this)); //  TODO make ListListener, double click to go to assignment page. update JLabel of assignmentPage to show the assignment name
		JScrollPane scroller = new JScrollPane(eventList);
        scroller.setMaximumSize(new Dimension(400,300));
		add(scroller);
    }
    
    public void setListListener(MouseAdapter e) {
		eventList.addMouseListener(e);
	}
    

    /**
	 * helper method to set and update the event list 
	 * @param c the list of results to display 
	 */
	public void updateEventsList(DefaultListModel<Event> c) { 
		listModel=c;
		eventList.setModel(listModel);
    }
	

	/**
	 * @return the event
	 */
	public JList<Event> getEventList() {
		return eventList;
	}
	
	public void setViewEventInfoButtonListener(ActionListener e) {
        viewEventInfoButton.addActionListener(e);
    }
	public void setNewEventButtonListener(ActionListener e) {
        addEventButton.addActionListener(e);
    }
	

	public void setDay(Date d) {
		day = d;
	}
	public void setDayLabel() {
		dayLabel.setText(""+ Calendar.getInstance().getNameOfMonth().get(day.getMonth()) + " " +day.getDay() + ", "+day.getYear());
	}
	
	public Date getDate() {
		return day;
	}

	
}
