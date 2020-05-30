package com.mibrahim.javafourteen.record;

import java.io.Serializable;

/**
 * A generic class with record type in JDK-14
 * 
 * @author Mohamed-Ibrahim
 *
 * @param <T>
 */
public record GenericRecord<T extends Serializable> (T firstParam, T secondParam) {
	// Check test cases for how you can use it
}
