package item_35;

import java.util.List;
import java.util.ArrayList;

public class Sample2 {
	@ExceptionTest(ArithmeticException.class)
	public static void m1() {//Tets should pass
		int  i= 0; 
		i = i / i;
	}
	
	@ExceptionTest(ArithmeticException.class)
	public static void m2() {//should fail (wropng exception)
		int [] a = new int[0];
		int i = a[1];
	}
	
	@ExceptionTest(ArithmeticException.class)
	public static void m3() {
	}//should fail (no exception)

	//Code containing an annnotation with an array parameter
	//������������������ע��
	@ExceptionTest({IndexOutOfBoundsException.class,
		NullPointerException.class})
	public static void doublyBad() {
		List<String> list = new ArrayList<String>();
		
		//The spec permits this method to throw either
		//�ù淶����˷����׳�
		//IndexOutBoundException or NullpointerException
		list.addAll(5,null);
	}
}
