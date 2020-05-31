package com.mibrahim.javafourteen.record;

/**
 * This is a normal Java class which uses only a final fields
 * 
 * You can read my LinkedIn article https://www.linkedin.com/pulse/quick-look-java-14-records-mohamed-ibrahim-ali/
 * 
 * @author Mohamed-Ibrahim
 *
 */
public class UserInOldWay {

	private final String firstname;
	private final String lastname;

	/*
	 * Rememeber if you didn't initialize final fields You will got a message with closable meaning:
	 * "The blank final field firstname may not have been initialized" OR "The blank final field lastname may not have been initialized"
	 */
	public UserInOldWay() {
		// Of course this is better
		// this("", ""); // Calling two parameter constructor

		// But lets do it that way to show the idea clearly
		this.firstname = "";
		this.lastname = "";
	}

	public UserInOldWay(String firstname, String lastname) {
		this.firstname = firstname;
		this.lastname = lastname;
	}

	public String getFirstname() {
		return firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public static void main(String[] args) {
		System.out.println(Integer.toBinaryString(0));
		System.out.println(Integer.toBinaryString(1));
	}

	// equals()
	// hashCode()
	// toString()
}
