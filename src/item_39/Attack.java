package item_39;

import java.util.Date;

public class Attack {
	public static void main(String[] args) {
		//Attack the internals of a period instance
		//攻击一个周期实例的内部
		Date start = new Date();
		Date end = new Date();
		Period period = new Period(start, end);
		end.setYear(78);//修改P的内部！
		System.out.println(period);
		
		//Second attack on the internals of a Period instance
		//对实例内部的第二次攻击
		start = new Date();
		end = new Date();
		period = new Period(start, end);
		period.end().setYear(78);//修改p的内部
		System.out.println(period);
	}

}
