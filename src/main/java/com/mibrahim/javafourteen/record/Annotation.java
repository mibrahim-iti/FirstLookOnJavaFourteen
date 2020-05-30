package com.mibrahim.javafourteen.record;

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * This is a class to group all annotations in one class, just to simplify the code
 * 
 * Note: This is not a production code, and it's not recommended doing this.
 * but as this project is just for testing new JDK-14 features so it's fine for me
 * 
 * @author Mohamed-Ibrahim
 *
 */
public class Annotation {
	@Retention(RetentionPolicy.RUNTIME)
	@Target({ ElementType.FIELD })
	public @interface OnFieldAnnotation {
	}

	@Retention(RetentionPolicy.RUNTIME)
	@Repeatable(RepeatableAnnotation.class)
	public @interface OnMethodAnnotation {
		String message();
	}

	@Retention(RetentionPolicy.RUNTIME)
	@Target({ ElementType.METHOD })
	public @interface RepeatableAnnotation {
		OnMethodAnnotation[] value(); // Just for testing
	}

	@Retention(RetentionPolicy.RUNTIME)
	@Target({ ElementType.RECORD_COMPONENT })
	public @interface RecordComponentAnnotation {
	}

	@Retention(RetentionPolicy.RUNTIME)
	public @interface OnClassAnnotation {
	}
}
