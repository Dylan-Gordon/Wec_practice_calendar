package SharedObjects;


public class Time implements Comparable<Object>{
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

	@Override
	public String toString() {
		return hours + ":" + minutes;
	}

	@Override
	public int compareTo(Object o) {
		Time other = (Time)o;
		if( this.hours == other.hours){
			return this.minutes - other.minutes;
		}
		else{
			return this.hours - other.hours;
		}		
	}

	
}
