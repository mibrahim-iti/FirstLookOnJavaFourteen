package com.mibrahim.javafourteen.record;

import java.time.LocalDate;
import java.time.Period;

/**
 * This is a JDK-14 record type class with overload constructors (so it default constructor still exist)
 * 
 * You can read my LinkedIn article https://www.linkedin.com/pulse/quick-look-java-14-records-mohamed-ibrahim-ali/
 * 
 * @author Mohamed-Ibrahim
 *
 */
public record UserRecordWithOverloadConstructor(String firstname, String lastname) {

	// This is overload constructor, and still default two parameters constructor still exist
	public UserRecordWithOverloadConstructor(String fullname) {
		this(fullname.split(" ")[0], fullname.split(" ")[1]);
	}

	// Extra fields must be static fields, if not a compiler error will appears
	public static LocalDate birthDate;

	// Extra methds with non static keyword
	public int getAge() {
		return Period.between(birthDate, LocalDate.now()).getYears();
	}

	// Extra methods with a static keyword
	public static int getAgeFromStaticMethod() {
		return Period.between(birthDate, LocalDate.now()).getYears();
	}

	// Just testing two constructor is working fine and check it in console
	public static void main(String[] args) {
		UserRecordWithOverloadConstructor user = new UserRecordWithOverloadConstructor("Mohamed Ibrahim");
		System.out.println(String.format("Firstname: %s\tLastname: %s", user.firstname, user.lastname));

		user = new UserRecordWithOverloadConstructor("Mohamed", "Ibrahim");
		System.out.println(String.format("Firstname: %s\tLastname: %s", user.firstname, user.lastname));
	}

}
