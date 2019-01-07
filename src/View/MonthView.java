package View;
import java.awt.Component;
import SharedObjects.Months;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;

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
	private ArrayList<DayButton> dayButtonList = new ArrayList<>();
	
	private int currentMonth = Months.JANUARY;
	private int currentMonthIndex = Months.JANUARY_START_INDEX;
	private int currentMonthEndIndex;
	private JPanel dayButtonsPanel;
	
	/**
	 * Constructor that creates the visible panel 
	 */
	public MonthView() { 
		calendar = calendar.getInstance();
		currentMonthEndIndex; = (currentMonthIndex + calendar.getDaysInMonth.get(currentMonth))%7;
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		monthLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		setMonthLabel(currentMonth+"");
		add(monthLabel);
		
		dayButtonsPanel = new JPanel( new GridLayout(6, 7));
		
		setPreferredSize(new Dimension(800,600));
		fillContentPane();
	}
	

	/**
	 * Helper method to add components to the JFrame
	 */
	private void fillContentPane() {
//		add(Box.createRigidArea(new Dimension(0,10))); //empty spacing
//


		//adding the day buttons
		
		int daysAdded = 0;
		int prevEndDate = 0;
		for(int currentDate=0; currentDate<6*7; currentDate++) {
			
			

			if(currentDate < currentStartDate) {

				DayButton temp = new DayButton(new Date(0, 0, 0));
				dayButtonList.add(temp);
				add(temp);
			}
			
			
			DayButton temp = new DayButton(new Date(2019, 1, currentDate));
			dayButtonList.add(temp);
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

	
}
