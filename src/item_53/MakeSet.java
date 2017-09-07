package item_53;

import java.util.Arrays;
import java.util.Set;

public class MakeSet {
	public static void main(String[] args) {
		Class<?> c1 = null;
		try {
			c1 = Class.forName(args[0]);
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			System.out.println("Class not found");
			System.exit(1);
		}
		
		// Instantiate the class
		Set<String> s = null;
		try {
			s = (Set<String>) c1.newInstance();
		} catch (IllegalAccessException e) {
			System.err.println("Class not accessible.");
			System.exit(1);
		} catch (InstantiationException e) {
			System.err.println("Class not instantiable.");
			System.exit(1);
		}

		// Exercise the set
		s.addAll(Arrays.asList(args).subList(1, args.length));
		System.out.println(s);
	}

}
