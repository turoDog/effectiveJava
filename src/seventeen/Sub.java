package seventeen;

import java.util.Date;

public class Sub extends Super {
	private final Date date;//�յ�final���ɹ��캯������
	
	public Sub() {
		date = new Date();
	}
	
	//���๹�캯�����õĸ��Ƿ���
	@Override
	public void overrideMe() {
		System.out.println(date);
	}

	public static void main(String[] args) {
		Sub sub = new Sub();
		sub.overrideMe();
	}
}
