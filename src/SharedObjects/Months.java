package SharedObjects;

import java.util.HashMap;
import java.util.Map;


//  public constants 
abstract public class Months {
	
	static Map<Integer, String> nameOfMonth = new HashMap<>();
	static Map<String, Integer> daysInMonth = new HashMap<>();

	public static int JANUARY = 1;
	public static int FEBRUARY = 2;
	public static int MARCH = 3;
	public static int APRIL = 4;
	public static int MAY = 5;
	public static int JUNE = 6;
	public static int JULY = 7;
	public static int AUGUST = 8;
	public static int SEPTEMBER = 9;
	public static int OCTOBER = 10;
	public static int NOVEMBER = 11;
	public static int DECEMBER = 12;
	
	public static void makeMonths() {
		nameOfMonth.put(JANUARY,"January");
		nameOfMonth.put(FEBRUARY,"February");
		nameOfMonth.put(MARCH,"March");
		nameOfMonth.put(APRIL,"April");
		nameOfMonth.put(MAY,"May");
		nameOfMonth.put(JUNE,"June");
		nameOfMonth.put(JULY,"July");
		nameOfMonth.put(AUGUST,"August");
		nameOfMonth.put(SEPTEMBER,"September");
		nameOfMonth.put(OCTOBER,"October");
		nameOfMonth.put(NOVEMBER,"November");
		nameOfMonth.put(DECEMBER,"December");
		
		daysInMonth.put(JANUARY, 31);
		


	}

	
	
	public int JANUARY_DAYS = 31;
	public int FEBUARY_DAYS = 28;
	public int MARCH_DAYS = 31;
	public int APRIL_DAYS = 30;
	public int MAY_DAYS = 31;
	public int JUNE_DAYS = 30;
	public int JULY_DAYS = 31;
	public int AUGUST_DAYS = 31;
	public int SEPTEMBER_DAYS = 30;
	public int OCTOBER_DAYS = 31;
	public int NOVEMBER_DAYS = 30;
	public int DECEMBER_DAYS = 31;
	
}
