package Model;

import SharedObjects.Date;
import java.util.ArrayList;

<<<<<<< HEAD
//singleton
import SharedObjects.*;

=======
import SharedObjects.*;


>>>>>>> eba361202c3f3bd1be5d1a478648a5d722c12240
public class Calender {

	private static Calender instance = null;
	private ArrayList<Event> events;
	
	
	private Calender() {
		events = new  ArrayList<Event>();
	}

	public static Calender getInstance() {
		if(instance == null)
		{
			instance = new Calender();
		}
		
		return instance;
	}
	
	public ArrayList<Event> getDayEvents(Date givenDate) {
		ArrayList<Event> foundEvents = new ArrayList<>();
		for(int event = 0; event < this.events.size(); event ++) {
			if(this.events.get(event).getStartDate().equals(givenDate)) {
				foundEvents.add(this.events.get(event));
			}
		}
		return foundEvents;
	}
	
	public void addEvent(Event newEvent) {
		events.add(newEvent);
	}
	
}
