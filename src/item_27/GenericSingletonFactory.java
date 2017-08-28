package item_27;

import java.security.PublicKey;
import java.util.Iterator;

public class GenericSingletonFactory {

	private static UnaryFunction<Object> IDENTITY_FUNCTION = new UnaryFunction<Object>() {
		public Object apply(Object arg) {
			return arg;
		}
	};
	
	// IDENTITY_FUNCTION����״̬�ģ������Ͳ���Ϊ
	//�����ƣ����Կ��԰�ȫ������������֮�乲��һ��ʵ����
	@SuppressWarnings("unchecked")
	public static <T> UnaryFunction<T> identityFunction(){
		return (UnaryFunction<T>) IDENTITY_FUNCTION;
	}
	
	public static void main(String[] args) {
		String [] strings = {"jute","hemp","nylon"};
		UnaryFunction<String> sameString = identityFunction();
		for (String string : strings) {
			System.out.println(sameString.apply(string));
		}
		Number[] numbers = {1,2.0,3L};
		UnaryFunction<Number> sameNumber = identityFunction();
		for (Number number : numbers) {
			System.out.println(sameNumber.apply(number));
		}
	}
}
