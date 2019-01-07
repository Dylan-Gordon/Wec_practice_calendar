package Model;

public class Time {
	private int hours = 0;
	private int minutes = 0;	

	public Time(int hours, int minutes) {
		this.hours = hours;
		this.minutes = minutes;
	}

	public int getHours() {
		return hours;
	}

	public void setHours(int hours) {
		this.hours = hours;
	}

	public int getMinutes() {
		return minutes;
	}

	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}
	
	
}
