package com.mibrahim.javafourteen.switchexpression;

import java.io.Serializable;

/**
 * 
 * This is a class showing how to use JDK-14 switch expressions and not provide a real production code
 * 
 * Just showing a ways of how to use switch expressions from JDK-14
 * 
 * You can read my LinkedIn article https://www.linkedin.com/pulse/quick-look-java-14-switch-expressions-mohamed-ibrahim-ali/
 * 
 * @author Mohamed-Ibrahim
 *
 */
public class SwitchExpression {

	public static String RED_SKIOS = "Red Skios Ltd.";
	public static String GOOGLE_OR_APPLE = "Google or Apple.";
	public static String FACEBOOK = "Facebook.";
	public static String DEFAULT = "No company matched.";
	public static String MULTI_LINES = "Supports multi line block!";

	/**
	 * A simple method with return a name of company using switch statement with break
	 * 
	 * @param company
	 * @return the name of passed company
	 */
	public String switchStatementWithBreak(Company company) {
		String result = null;
		switch (company) {
			case RED_SKIOS:
			// do something...
			result = RED_SKIOS;
				break;
			case GOOGLE, APPLE:
			// do something...
			result = GOOGLE_OR_APPLE;
				break;
			case FACEBOOK:
			// do something...
			result = FACEBOOK;
				break;
			default:
			result = DEFAULT;
		}
		return result;
	}

	/**
	 * A simple method with return a name of company using switch statement with block of code and break
	 * 
	 * @param company
	 * @return the name of passed company
	 */
	public String switchStatementWithBlock(Company company) {
		String result = null;
		switch (company) {
			case RED_SKIOS: {
				// do something...
				result = RED_SKIOS;
				break;
			}
			case GOOGLE, APPLE: {
				// do something...
				result = GOOGLE_OR_APPLE;
				break;
			}
			case FACEBOOK: {
				// do something...
				result = FACEBOOK;
				break;
			}
			default:
			result = DEFAULT;
		}
		return result;
	}

	/**
	 * A simple method with return a name of company using switch statement with arrow
	 * 
	 * @param company
	 * @return the name of passed company
	 */
	public String switchStatementWithArrow(Company company) {
		String result = null;
		switch (company) {
			case RED_SKIOS -> result = RED_SKIOS;
			case GOOGLE, APPLE -> result = GOOGLE_OR_APPLE;
			case FACEBOOK -> result = FACEBOOK;
			default -> result = DEFAULT;
		}
		return result;
	}

	/**
	 * A simple method with return a name of company using switch statement without using default And in case no case matched a null result will
	 * return
	 * 
	 * @param company
	 * @return the name of passed company
	 */
	public String switchStatementWithArrowAndWithoutDefault(Company company) {
		String result = null;
		// Look, the IDE may show a warning in next line because switch doesn't have a default, but it will not show an error
		switch (company) {
			case RED_SKIOS -> result = RED_SKIOS;
			case GOOGLE, APPLE -> result = GOOGLE_OR_APPLE;
			case FACEBOOK -> result = FACEBOOK;
		}
		return result;
	}

	/**
	 * A simple method with return a name of company using switch expression and it do necessarily needs a default
	 * 
	 * @param company
	 * @return the name of passed company
	 */
	// Java 14, Switch expression do necessarily needs a default
	public String switchExpression(Company company) {
		// Switch expression return a value
		return switch (company) {
			case RED_SKIOS -> RED_SKIOS;
			case GOOGLE, APPLE -> GOOGLE_OR_APPLE;
			case FACEBOOK -> FACEBOOK;
			default -> DEFAULT;// Must add a default or a compiler error will appears
		};
	}

	/**
	 * A simple method to test supporting multi lines in switch expression
	 * 
	 * @param company
	 * @return the name of passed company or "Supports multi line block!" in case of FACEBOOK passed
	 */
	public String switchExpressionSupportMultiLines(Company company) {
		return switch (company) {
			case RED_SKIOS -> RED_SKIOS;
			case GOOGLE, APPLE -> GOOGLE_OR_APPLE;
			case FACEBOOK -> {// a block of multiple lines
				// do something
				System.out.println("Hey, I can support multiple lines :P");
				yield "Supports multi line block!";
			}
			default -> DEFAULT;
		};
	}

	/**
	 * A simple method to show that it's possible to use result return from switch expression in code
	 * 
	 * @param company
	 * @return the name of passed company
	 */
	public String doSomethingWithSwitchExpressionResult(Company company) {
		String result = switch (company) {
			case RED_SKIOS -> RED_SKIOS;
			case GOOGLE, APPLE -> GOOGLE_OR_APPLE;
			case FACEBOOK -> FACEBOOK;
			default -> DEFAULT;
		};
		// Do something with the result
		return String.format("Company name is %s", result);
	}

	/**
	 * A simple method to show that it's possible to use result return from switch expression in code and in same time using a block of multiple lines
	 * 
	 * @param company
	 * @return the name of passed company or "Supports multi line block!" in case of FACEBOOK passed
	 */
	public String doSomethingWithSwitchExpressionResultAndUseMultiLines(Company company) {
		String result = switch (company) {
			case RED_SKIOS -> RED_SKIOS;
			case GOOGLE, APPLE -> GOOGLE_OR_APPLE;
			case FACEBOOK -> {// a block of multiple lines
				// do something
				System.out.println("Hey, I can support multiple lines :P");
				yield "Supports multi line block!";
			}
			default -> DEFAULT;
		};
		// Do something with the result
		return String.format("Company name is %s", result);
	}

	/**
	 * A simple method to show how to use a yield and multi lines with switch expression
	 * 
	 * @param company
	 * @return a number based on company name
	 */
	public int switchExpressionUsesYieldAndMultiLines(Company company) {
		int viaYield = switch (company) {
			case RED_SKIOS:
				yield 5;
			case GOOGLE, APPLE:
				yield 4;
			case FACEBOOK:
			System.out.println("Its Facebook.");
				yield 3;
			default:
			// do something...
			System.out.println("Supports multi line block!");
				yield 0;
		};

		return viaYield;
	}

//	//	Illegal jump through a switch expression
//	public void switchExpressionWithIllegalJump(Company company) {
//		int cont = Integer.MAX_VALUE;
//		for (int i = 0; i < Integer.MAX_VALUE; ++i) {
//			int value = switch (company) {
//				case RED_SKIOS:
//					yield 5;
//				case GOOGLE, APPLE:
//					yield 4;
//				case FACEBOOK:
//					yield 3;
//				default:
//				continue cont;
//				// ERROR! Illegal jump through a switch expression
//			};
//		}
//	}

	/**
	 * A simple method to show how to use switch expression with label rules or arrow
	 * 
	 * @param company
	 * @return a number based on company name
	 */
	public int switchExpressionUsesLabelRuleOrArrowAndMultiLines(Company company) {
		int viaArrow = switch (company) {
			case RED_SKIOS -> 5;
			case GOOGLE, APPLE -> 4;
			case FACEBOOK -> 3;
			default -> {
				// Supports multi-line block :)
				System.out.println(DEFAULT + " :(");
				yield 0;
			}
		};
		return viaArrow;
	}

	/**
	 * A simple method to show how switch expression could return only one type
	 * 
	 * @param bool
	 * @return a string of True or False or not matched condition found.
	 */
	public String switchExpressionReturnOneType(String bool) {
		return switch (bool) {
			case "TRUE" -> "True";
			case "FALSE" -> "False";
			// note that we don't throw the exception!
			default -> "No matched condition found.";
		};
	}

	/**
	 * A simple method to show how switch expression could return a poly types
	 * 
	 * @param bool
	 * @return a string of True a boolean false or IllegalArgumentException for default.
	 */
	public Serializable switchExpressionReturnPolyType(String bool) {
		Serializable serializableResult = switch (bool) {
			case "TRUE" -> "True";
			case "FALSE" -> false;
			default -> throw new IllegalArgumentException("Unexpected value: " + bool);

		};
		return serializableResult;
	}

	/**
	 * A simple method to show how switch expression could return unknown targets like var type
	 * 
	 * @param bool
	 * @return a string of True a boolean false or IllegalArgumentException for default.
	 */
	public Serializable switchExpressionWithUnknownTargets(String bool) {
		// Return unknown targets, for example "var" type
		var varResult = switch (bool) {
			case "TRUE" -> "True";
			case "FALSE" -> false;
			default -> new IllegalArgumentException("No matched condition found."); // In this case method will not throw any exception but return
																					// IllegalArgumentException as a serializable object
		};
		// When return var type, a type is computed by finding the most specific supertype of the types that the branches produce.
		return varResult;
	}

	/**
	 * A simple method to show how to use a generics with switch expression
	 * 
	 * @param num
	 * @return a generic class
	 */
	// This expression will return Integer.class if arg value is Integer;
	// and return String.class if num=2
	// and Serializable.class if num any intger else
	// See how you can return different results from the same switch
	public Class<? extends Serializable> switchExpressionWithGeneric(int num) {
		Class<? extends Serializable> genericResult = switch (num) {
			case 1 -> Integer.class;
			case 2 -> String.class;
			default -> Serializable.class;
		};
		System.out.println(genericResult.getTypeName());
		return genericResult;
	}
}
