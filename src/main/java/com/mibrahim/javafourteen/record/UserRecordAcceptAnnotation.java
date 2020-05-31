package com.mibrahim.javafourteen.record;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import com.mibrahim.javafourteen.record.Annotation.OnClassAnnotation;
import com.mibrahim.javafourteen.record.Annotation.OnFieldAnnotation;
import com.mibrahim.javafourteen.record.Annotation.OnMethodAnnotation;
import com.mibrahim.javafourteen.record.Annotation.RepeatableAnnotation;

/**
 * Record class accepts annotations on fields and methods
 * 
 * BTW Java 14 intorduced new target element type @Target({ ElementType.RECORD_COMPONENT })
 * 
 * You can read my LinkedIn article https://www.linkedin.com/pulse/quick-look-java-14-records-mohamed-ibrahim-ali/
 * 
 * @author Mohamed-Ibrahim
 *
 */
@OnClassAnnotation
public record UserRecordAcceptAnnotation(String firstname, @OnFieldAnnotation String lastname) {

	/**
	 * This method is a pure dummy test of accepting annotation
	 * 
	 * So don't expect anything from it as it uses reflection to return used or injected annotation used with it
	 * 
	 * @throws NoSuchFieldException
	 * @throws SecurityException
	 * @throws NoSuchMethodException
	 */
	@OnMethodAnnotation(message = "First annotation.")
	@OnMethodAnnotation(message = "Second annotation.")
	public static Map<String, Annotation> recordMethod()
			throws NoSuchFieldException, SecurityException, NoSuchMethodException {
		Map<String, Annotation> annotationsMap = new HashMap<>();

		UserRecordAcceptAnnotation obj = new UserRecordAcceptAnnotation("", "");

		Class<?> klass = obj.getClass();

		// Obtain the annotation for newMethod
		Method method = klass.getMethod("recordMethod");

		Annotation anno = method.getAnnotation(RepeatableAnnotation.class);
		System.out.println("Method name: " + method.getName() + " Annotations: " + anno);
		annotationsMap.put(method.getName(), anno);

		Field[] fields = klass.getDeclaredFields();

		for (int i = 0; i < fields.length; i++) {
			System.out.println("Field name: " + fields[i].getName() + " Annotations: "
					+ fields[i].getAnnotation(OnFieldAnnotation.class));
			annotationsMap.put(fields[i].getName(), fields[i].getAnnotation(OnFieldAnnotation.class));
		}

		return annotationsMap;
	}

	// Just a simple testing to see console logs instead of reading Map
	public static void main(String[] args) throws NoSuchFieldException, SecurityException, NoSuchMethodException {
		recordMethod();
	}

}
