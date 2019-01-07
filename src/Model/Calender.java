package Model;

import java.util.ArrayList;
import SharedObjects.Event;
import SharedObjects.Time;
import SharedObjects.Date;


//singleton

public class Calender {

	private static Calender instance = null;
	private ArrayList<Event> events;
	
	
	private Calender() {
		events = new ArrayList<Event>();
		
		
		//test some premade events		
		events.add(new Event(new Date(2019, 1, 7), new Time(10, 0), new Time(1, 30), "TestEvent1"));
		events.add(new Event(new Date(2019, 1, 7), new Time(19, 0), new Time(1, 20), "TestEvent2"));
		events.add(new Event(new Date(2019, 1, 7), new Time(12, 20), new Time(2, 30), "TestEvent3"));
		events.add(new Event(new Date(2019, 1, 8), new Time(11, 50), new Time(0, 30), "TestEvent4"));
		events.add(new Event(new Date(2019, 1, 9), new Time(2, 10), new Time(1, 50), "TestEvent5"));

	}

	public static Calender getInstance() {
		if(instance == null){
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
