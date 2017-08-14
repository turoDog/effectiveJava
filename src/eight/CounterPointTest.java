package eight;

import java.util.HashSet;
import java.util.Set;

public class CounterPointTest {
	//初始化UnitCircle以包含单位圆上的所有点
	private static final Set<Point> unitCircle;
	
	static{
		unitCircle = new HashSet<Point>();
		unitCircle.add(new Point(1, 0));
		unitCircle.add(new Point(0, 1));
		unitCircle.add(new Point(-1, 0));
		unitCircle.add(new Point(0, -1));
	}
	
	public static boolean onUnitCircle(Point p) {
		return unitCircle.contains(p);
	}
	
	public static void main(String[] args) {
		Point p1 = new Point(1, 0);
		Point p2 = new CounterPoint(1, 0);
		
		// Prints true
		System.out.println(onUnitCircle(p1));

		// Should print true, but doesn't if Point uses getClass-based equals
		//应该打印true，但是如果Point使用基于getClass的equals则false
		System.out.println(onUnitCircle(p2));
	}
}
