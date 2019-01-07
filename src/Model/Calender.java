package Model;

import java.util.ArrayList;

public class Calender {

	private static Calender instance = null;
	private ArrayList<Event> events;
	
	
	private Calender() {
		events = new  ArrayList<Event>();
	}

	public Calender getInstance() {
		if(instance == null)
		{
			instance = new Calender();
		}
		
		return instance;
	}
	
	public ArrayList<Event> getDayEvents(Date givenDate) {
		ArrayList<Event> foundEvents = new ArrayList<>();
		for(int event = 0; event < this.events.size(); event ++) {
			if(this.events.get(event).getStartDate() == givenDate) {
				foundEvents.add(this.events.get(event));
			}
		}
		return foundEvents;
	}
	
}
