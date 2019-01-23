
/**
 * File    : Date.java
 * Purpose : Denotes a date object
 * @author Virendra
 *
 */

public class Date {
	
	/**
	 * day part of a simple date
	 */
	private int day;
	
	/**
	 * month part of a simple date
	 */
	private int month;
	
	/**
	 * year part of a simple date
	 */
	private int year;
	
	/**
	 * Return the date concatenated by '-'
	 * @return the date concatenated by '-'
	 */
	public String getDateString()
	{
		return this.day+"-"+this.month+"-"+this.year;
	}

	public Date(int day, int month, int year) {
		super();
		this.day = day;
		this.month = month;
		this.year = year;
	}
	
	
}
