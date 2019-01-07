package Model;


public class Event {
	private Date startDate;
	private Time startTime;
	private Time duration;
	
	public Event(Date startDate, Time startTime, Time duration) {
		super();
		this.startDate = startDate;
		this.startTime = startTime;
		this.duration = duration;
	}
	
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Time getStartTime() {
		return startTime;
	}
	public void setStartTime(Time startTime) {
		this.startTime = startTime;
	}
	public Time getDuration() {
		return duration;
	}
	public void setDuration(Time duration) {
		this.duration = duration;
	}
	
	
	
}
