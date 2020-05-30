package com.mibrahim.javafourteen.record;

interface RecordInterface {
	String asJson();
}

/**
 * 
 * Record type class implements interface
 * 
 * @author Mohamed-Ibrahim
 *
 */
public record UserRecordImplementsInterface(String firstname, String lastname) implements RecordInterface {

	public static void main(String[] args) {
		UserRecordImplementsInterface record = new UserRecordImplementsInterface(null, "Ibrahim");
		// It will print: {"firstParam": Mohamed, "secondParam": Ibrahim}
		System.out.println(record.asJson());
	}

	@Override
	public String asJson() {
		return String.format("{\"firstname\": %s, \"lastname\": %s}", firstname, lastname);
	}

}
