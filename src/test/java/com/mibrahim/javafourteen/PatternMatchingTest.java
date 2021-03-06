/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package com.mibrahim.javafourteen;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Test;

import com.mibrahim.javafourteen.patternmatching.Circle;
import com.mibrahim.javafourteen.patternmatching.PatternMatching;
import com.mibrahim.javafourteen.patternmatching.Rectangle;
import com.mibrahim.javafourteen.patternmatching.Shape;

/**
 * A test class just to test methods quickly and not a production tests
 * 
 * So it's not follow a good examples of writing tests
 * 
 * for example i am doing a combination of sucess and failer tests under one test case which shouldn't be a case for a production tests
 * 
 * and even it doesn't cover all possible test cases
 * 
 * @author Mohamed-Ibrahim
 *
 */
public class PatternMatchingTest {
	private static final double DELTA = 1e-15;

	PatternMatching pm = new PatternMatching();

	@Test
	public void testPatternMatchingBeforeJavaFourteen() {
		String hi = "Hi Everyone";
		Assert.assertEquals("Failure - Not a string object :(", pm.beforeJavaFourteen(hi), hi);
		Assert.assertEquals("Failure - A string object found :(", pm.beforeJavaFourteen(Double.MIN_VALUE),
				PatternMatching.NOT_STRING_MSG);
	}

	@Test
	public void testGetPerimeter() {
		// Using a Rectangle shape
		Shape shape = new Rectangle(10, 5);
		assertEquals(30.0d, pm.getPerimeter(shape), DELTA);
		// Using a Circle shape
		shape = new Circle(15);
		assertEquals(94.24777960769379, pm.getPerimeter(shape), DELTA);
	}

	@Test
	public void testIsBigRectangle() {
		Shape shape = new Rectangle(101, 5);
		assertTrue("Failure - Not a big Rectangle.", pm.isBigRectangle(shape));
		shape = new Rectangle(100, 5);
		assertFalse("Failure - It's a big Rectangle.", pm.isBigRectangle(shape));
	}
}
