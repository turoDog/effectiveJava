package item_29;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;

public class PrintAnnotation {
	//使用asSubclass安全地转换为有界类型的标记
	static Annotation getAnnotation(AnnotatedElement element,
			String annotationTypeName) {
		Class<?> annotationType = null; //无限制类型令牌
		try {
			annotationType = Class.forName(annotationTypeName);
		} catch (Exception e) {
			// TODO: handle exception
			throw new IllegalArgumentException(e);
		}
		return element.getAnnotation(annotationType
				.asSubclass(Annotation.class));
	}
	
	public static void main(String[] args) {
		if (args.length != 2) {
			System.out
			.println("Usage: java PrintAnnotation <class> <annotation>");
			System.exit(1);
		}
		String className = args[0];
		String annotationTypeName = args[1];
		Class<?> klass;
		try {
			klass = Class.forName(className);
			System.out.println(getAnnotation(klass, annotationTypeName));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

}
