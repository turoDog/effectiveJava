package item_39;

import java.util.Date;

public class Attack {
	public static void main(String[] args) {
		//Attack the internals of a period instance
		//����һ������ʵ�����ڲ�
		Date start = new Date();
		Date end = new Date();
		Period period = new Period(start, end);
		end.setYear(78);//�޸�P���ڲ���
		System.out.println(period);
		
		//Second attack on the internals of a Period instance
		//��ʵ���ڲ��ĵڶ��ι���
		start = new Date();
		end = new Date();
		period = new Period(start, end);
		period.end().setYear(78);//�޸�p���ڲ�
		System.out.println(period);
	}

}
