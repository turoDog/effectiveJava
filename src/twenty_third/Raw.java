package twenty_third;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Raw {
	
	public static void main(String[] args) {
		// Uses raw type (List) - fails at runtime!
		//使用原始类型（List） - 在运行时失败！
		List<String> strings = new ArrayList<String>();
		unsafeAdd(strings, new Integer(666));
		//Compiler-generated cast
		//编译器生成的转换
		String string = strings.get(0);
	}
	
	private static void unsafeAdd(List list, Object o) {
		list.add(o);
	}
	
	// Use of raw type for unknown element type - don't do this!
	//使用未知元素类型的原始类型 - 不要这样做！
	static int rawNumElementsInCommon(Set s1, Set s2) {
		int result = 0;
		for(Object o1 : s1) {
			if (s2.contains(o1)) {
				result++;
			}
		}
		return result;
	}
	// Unbounded wildcard type - typesafe and flexible
	//无限通配符类型 - 类型安全灵活
	static int numElementsInCommon(Set<?> s1, Set<?> s2) {
		int result = 0;
		for (Object o1 : s1)
			if (s2.contains(o1))
				result++;
		return result;
	}
}
