package SharedObjects;


public class Event implements Comparable<Object>{
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

	
	public String getName() {
		return name;
	}
	public void setName(String name){
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}
	@Override
	public int compareTo(Object o) {
		return this.startTime.compareTo(((Event)o).startTime);
	}
	
}
