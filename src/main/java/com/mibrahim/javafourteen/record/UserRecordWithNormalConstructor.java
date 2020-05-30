package com.mibrahim.javafourteen.record;

import java.time.LocalDate;
import java.time.Period;

/**
 * This is a JDK-14 record type class with a normal constructors (so it overrites default constructor)
 * 
 * @author Mohamed-Ibrahim
 *
 */
public record UserRecordWithNormalConstructor(String firstname, String lastname) {

	public UserRecordWithNormalConstructor(String firstname, String lastname) {
		if (firstname == null || lastname == null)
			throw new IllegalArgumentException("Firstname or lastname mustn't be null");
		// You must assign parameter value to class fields (explicitly)
		this.firstname = firstname;
		this.lastname = lastname;

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

}
