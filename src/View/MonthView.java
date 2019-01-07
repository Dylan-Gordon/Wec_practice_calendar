package View;
import java.awt.Component;
import SharedObjects.Months;
import Model.Calendar;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;


import SharedObjects.Date;

@SuppressWarnings("serial")
public class MonthView extends JPanel{
	
	/**
	 * JLabel at top of panel 
	 */
	
	private Calendar calendar;
	
	private JLabel monthLabel= new JLabel();
	private ArrayList<DayButton> dayButtonList;
	
	private int currentMonth = Months.JANUARY;
	private int currentYear = 2019;
	private int currentMonthIndex = Months.JANUARY_START_INDEX; //day of the week
	private int currentMonthEndIndex;
	private JPanel dayButtonsPanel;
	
	public JPanel getDayButtonsPanel() {
		return dayButtonsPanel;
	}


	/**
	 * Constructor that creates the visible panel 
	 */
	public MonthView() { 
		calendar = Calendar.getInstance();
		currentMonthEndIndex = (currentMonthIndex + (calendar.getDaysInMonth().get(currentMonth)))%7-1;
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		monthLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		setMonthLabel(Calendar.getInstance().getNameOfMonth().get(currentMonth)+ " "+currentYear);
		add(monthLabel);
		
		dayButtonsPanel = new JPanel( new GridLayout(6, 7));
		
		setPreferredSize(new Dimension(800,600));
		makeButtonsPanel();
	}
	

	/**
	 * Helper method to add components to the JFrame
	 */
	public void makeButtonsPanel() {
//		add(Box.createRigidArea(new Dimension(0,10))); //empty spacing
		dayButtonList = new ArrayList<>();


		//adding the day buttons
		int daysAdded = 0;
		for(int currentDate=0; currentDate<6*7; currentDate++) {
			
			DayButton temp;
			if(currentDate < currentMonthIndex) {	// Before month starts during first week

				temp = new DayButton(new Date(0, 0, 0));
				temp.setEnabled(false);
			}
			else if(currentDate > (currentMonthIndex + calendar.getDaysInMonth().get(currentMonth)-1))
			{
		
				// After month has completed during last week
				temp = new DayButton(new Date(0, 0, 0));
				temp.setEnabled(false);
			}
			else {
				// during week, valid days
				temp = new DayButton(new Date(currentYear, currentMonth, daysAdded + 1));
				daysAdded++;
				dayButtonList.add(temp);
				if(currentDate+1 > currentMonthIndex + calendar.getDaysInMonth().get(currentMonth)-1) {
					//today is the last day of the month 
					currentMonthEndIndex = (currentDate)%7;
				}
			}
			dayButtonsPanel.add(temp);

		}
		
		add(dayButtonsPanel);
	}
	
	public void setMonthLabel(String s) {
		monthLabel.setText(s);
	}
	
	public void setDayButtonListeners(ActionListener e) {
		for(DayButton dayButton : dayButtonList) {
			dayButton.addActionListener(e);
		}
	}


	public int getCurrentMonth() {
		return currentMonth;
	}


	public void setCurrentMonth(int currentMonth) {
		this.currentMonth = currentMonth;
	}


	public int getCurrentYear() {
		return currentYear;
	}


	public void setCurrentYear(int currentYear) {
		this.currentYear = currentYear;
	}


	public int getCurrentMonthIndex() {
		return currentMonthIndex;
	}


	public void setCurrentMonthIndex(int currentMonthIndex) {
		this.currentMonthIndex = currentMonthIndex;
	}


	public int getCurrentMonthEndIndex() {
		return currentMonthEndIndex;
	}


	public void setCurrentMonthEndIndex(int currentMonthEndIndex) {
		this.currentMonthEndIndex = currentMonthEndIndex;
	}

	
}
