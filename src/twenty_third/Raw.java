package twenty_third;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Raw {
	
	public static void main(String[] args) {
		// Uses raw type (List) - fails at runtime!
		//ʹ��ԭʼ���ͣ�List�� - ������ʱʧ�ܣ�
		List<String> strings = new ArrayList<String>();
		unsafeAdd(strings, new Integer(666));
		//Compiler-generated cast
		//���������ɵ�ת��
		String string = strings.get(0);
	}
	
	private static void unsafeAdd(List list, Object o) {
		list.add(o);
	}
	
	// Use of raw type for unknown element type - don't do this!
	//ʹ��δ֪Ԫ�����͵�ԭʼ���� - ��Ҫ��������
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
	//����ͨ������� - ���Ͱ�ȫ���
	static int numElementsInCommon(Set<?> s1, Set<?> s2) {
		int result = 0;
		for (Object o1 : s1)
			if (s2.contains(o1))
				result++;
		return result;
	}
}
