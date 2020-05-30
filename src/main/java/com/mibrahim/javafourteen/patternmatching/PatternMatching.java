package com.mibrahim.javafourteen.patternmatching;

/**
 * This is a class showing how to use JDK-14 pattern matching and not provide a real production code
 * 
 * Just showing a way of how to use patter matching in JDK-14
 * 
 * @author Mohamed-Ibrahim
 *
 */
public class PatternMatching {

	public static String NOT_STRING_MSG = "Not a string.";

	/**
	 * A mthod with old Java way to match pattern or use instanceof to match patterns
	 * 
	 * @param object
	 * @return same passed string or not a string message if the object passed type is not a string
	 */
	public String beforeJavaFourteen(Object object) {
		// 1- First doing instanceof check
		if (object instanceof String) {
			// 2- a conversion (casting obj to String)
			// 3- and the declaration of a new local variable (castedString), so we can use it
			String castedString = (String) object; // cast and assign to a new local variable
			return castedString;
		}
		return NOT_STRING_MSG;
	}

	/**
	 * A mthod with a new Java 14 way to match pattern or use instanceof to match patterns
	 * 
	 * @param object
	 * @return same passed string or not a string message if the object passed type is not a string
	 */
	public String inJavaFourteen(Object object) {
		// in Next line java allows to do testing, casting and provides a variable to use in one line
		if (object instanceof String castedString)
			// do something...
			return castedString;
		return NOT_STRING_MSG;
	}

	/**
	 * A mthod to get perimeter using a new Java 14 way to match pattern or use instanceof to match patterns
	 * 
	 * @param shape
	 * @return a perimeter of passed shape
	 * @throws IllegalArgumentException if the shape passed is not matched any checked pattern
	 */
	// Focus on scope of each variable in comments
	public double getPerimeter(Shape shape) throws IllegalArgumentException {
		if (shape instanceof Rectangle rectangle) {

			// You can use the binding variable rectangle (of type Rectangle) here.
			return 2 * rectangle.length() + 2 * rectangle.width();

		} else if (shape instanceof Circle circle) {

			// You can use the binding variable circle (of type Circle) here
			// but not the binding variable rectangle (of type Rectangle).
			return 2 * circle.radius() * Math.PI;

		} else {

			// You cannot use either binding variable here.
			throw new IllegalArgumentException("Unrecognized shape");
		}
	}

	/**
	 * A mthod to check if rectangle shape passed is big or not using a new Java 14 way to match pattern or use instanceof to match patterns
	 * 
	 * @param shape
	 * @return a boolean true if rectangle length is greater than 100
	 */
	public boolean isBigRectangle(Shape shape) {

		if (!(shape instanceof Rectangle rectangle)) {

			// You cannot use the binding variable rectangle here.
			return false;
		}
		// You can use rectangle here. (awesome)
		return rectangle.length() > 100;
	}

	/**
	 * This is a method which do nothing, it's just to improve combination conditions with match patterns
	 * 
	 * @param shape
	 */
	public void fineExpression(Shape shape) {
		if (shape instanceof Rectangle rect && rect.length() > 100) {
			// do something
		}
	}

//	public void wrongExpression(Shape shape) {
//		// This will show a compiler error as you see
//		// With message "The pattern variable rect is not in scope in this location"
//		if (shape instanceof Rectangle rect || rect.length() > 100) {
//			//
//		}
//	}

}
