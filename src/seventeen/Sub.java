package seventeen;

import java.util.Date;

public class Sub extends Super {
	private final Date date;//空的final，由构造函数设置
	
	public Sub() {
		date = new Date();
	}
	
	//超类构造函数调用的覆盖方法
	@Override
	public void overrideMe() {
		System.out.println(date);
	}

	public static void main(String[] args) {
		Sub sub = new Sub();
		sub.overrideMe();
	}
}
