package View;

import javax.swing.JButton;

import SharedObjects.Date;

public class DayButton extends JButton{
	
	private Date day;
	
	public DayButton(Date d) {
		// TODO Auto-generated constructor stub
		super(""+d.getDay());
		day = d;
	}
	
	
	public Date getDate() {
		return day;
	}

}
