package Model;

import java.util.ArrayList;

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
	
}
