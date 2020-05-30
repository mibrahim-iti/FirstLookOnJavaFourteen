package com.mibrahim.javafourteen.record;

import java.time.LocalDate;
import java.time.Period;

/**
 * This is a JDK-14 record type class with no constructors (with a default constructor)
 * 
 * @author Mohamed-Ibrahim
 *
 */
public record UserRecordWithDefaultConstructor(String firstname, String lastname) {

	/*
	 * We don't need to do this, the compiler will automatically generate it
	 
	 	public User(String firstName, String lastName) {
	 		this.firstName = firstName;
	 		this.lastName = lastName;
	 	}
     */
	
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

}
