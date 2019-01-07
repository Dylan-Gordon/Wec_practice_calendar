package Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import SharedObjects.Event;
import SharedObjects.Months;
import SharedObjects.Time;
import SharedObjects.Date;


//singleton

public class Calendar {

	private static Calendar instance = null;
	private ArrayList<Event> events;
	
	private static Map<Integer, String> nameOfMonth = new HashMap<>();
	private static Map<Integer, Integer> daysInMonth = new HashMap<>();

	
	
	private Calendar() {
		makeMonths();
		
		events = new ArrayList<Event>();
		
		//test some premade events		
		events.add(new Event(new Date(2019, 1, 7), new Time(10, 0), new Time(1, 30), "TestEvent1"));
		events.add(new Event(new Date(2019, 1, 7), new Time(19, 0), new Time(1, 20), "TestEvent2"));
		events.add(new Event(new Date(2019, 1, 7), new Time(12, 20), new Time(2, 30), "TestEvent3"));
		events.add(new Event(new Date(2019, 1, 8), new Time(11, 50), new Time(0, 30), "TestEvent4"));
		events.add(new Event(new Date(2019, 1, 9), new Time(2, 10), new Time(1, 50), "TestEvent5"));

	}

	public static Calendar getInstance() {
		if(instance == null){
			instance = new Calendar();
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
	

	public void makeMonths() {
		nameOfMonth.put(Months.JANUARY,"January");
		nameOfMonth.put(Months.FEBRUARY,"February");
		nameOfMonth.put(Months.MARCH,"March");
		nameOfMonth.put(Months.APRIL,"April");
		nameOfMonth.put(Months.MAY,"May");
		nameOfMonth.put(Months.JUNE,"June");
		nameOfMonth.put(Months.JULY,"July");
		nameOfMonth.put(Months.AUGUST,"August");
		nameOfMonth.put(Months.SEPTEMBER,"September");
		nameOfMonth.put(Months.OCTOBER,"October");
		nameOfMonth.put(Months.NOVEMBER,"November");
		nameOfMonth.put(Months.DECEMBER,"December");
		
		daysInMonth.put(Months.JANUARY, 31);
		daysInMonth.put(Months.FEBRUARY, 28);
		daysInMonth.put(Months.MARCH, 31);
		daysInMonth.put(Months.APRIL, 30);
		daysInMonth.put(Months.MAY, 31);
		daysInMonth.put(Months.JUNE, 30);
		daysInMonth.put(Months.JULY, 31);
		daysInMonth.put(Months.AUGUST, 31);
		daysInMonth.put(Months.SEPTEMBER, 30);
		daysInMonth.put(Months.OCTOBER, 31);
		daysInMonth.put(Months.NOVEMBER, 30);
		daysInMonth.put(Months.DECEMBER, 31);
	}

	public Map<Integer, String> getNameOfMonth() {
		return nameOfMonth;
	}

	public Map<Integer, Integer> getDaysInMonth() {
		return daysInMonth;
	}

	
}
