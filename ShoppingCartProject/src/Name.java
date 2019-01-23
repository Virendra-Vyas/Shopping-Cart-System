
/**
 * 
 * File    : Name.java
 * Purpose : Denotes a simple name comprising of first name and family name
 * @author Virendra Vyas
 *
 */

public class Name {
	
	/**
	 * first name of a person's name
	 */
	private String firstName;
	
	/**
	 * family name of a person's name
	 */
	private String familyName;
	
	/**
	 * Return the full name of the person first+family
	 * @return the full name of the person first+family
	 */
	public String getFullName()
	{
		return this.firstName+" "+this.familyName;
	}

	public Name(String firstName, String familyName) {
		super();
		this.firstName = firstName;
		this.familyName = familyName;
	}
	
	

}
