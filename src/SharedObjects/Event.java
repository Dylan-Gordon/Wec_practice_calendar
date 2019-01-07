package SharedObjects;


public class Event {
	private Date startDate;
	private Time startTime;
	private Time duration;
	private String name;
	
	
	
	public Event(Date startDate, Time startTime, Time duration, String name) {
		super();
		this.startDate = startDate;
		this.startTime = startTime;
		this.duration = duration;
		this.name = name;
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
<<<<<<< HEAD

	@Override
	public String toString() {
		return "Event [startDate=" + startDate + ", startTime=" + startTime + ", duration=" + duration + "]";
	}
	
	
=======
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
>>>>>>> eba361202c3f3bd1be5d1a478648a5d722c12240
	
	
}
