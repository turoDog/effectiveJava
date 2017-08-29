package eight;

public class ColorPoint extends Point {

	private final Color color;
	
	public ColorPoint(int x, int y, Color color) {
		super(x, y);
		this.color = color;
	}
	
	
	public boolean equals(Object obj) {
		if (!(obj instanceof ColorPoint)) {
			return false;
		}
		return super.equals(obj)&&((ColorPoint)obj).color == color;
	}

	//破碎 - 违反传染性！
	// @Override public boolean equals（Object o）{
	// if（！（o instanceof Point））
	// return false;
	//
	// //如果o是一个普通点，做一个色盲比较
	// if（！（o instanceof ColorPoint））
	// return o.equals（this）;
	//
	// // o是ColorPoint; 做一个完整的比较
	// return super.equals（o）&&（（ColorPoint）o）.color == color;
	//}
	
	public static void main(String[] args) {
		//第一等于函数违反对称性
		Point p = new Point(1, 2);
		ColorPoint cp = new ColorPoint(1, 2, Color.RED);
		System.out.println(p.equals(cp) + " " + cp.equals(p));
	
		// Second equals函数违反传递性
		ColorPoint p1 = new ColorPoint(1, 2, Color.RED);
		Point p2 = new Point(1, 2);
		ColorPoint p3 = new ColorPoint(1, 2, Color.BLUE);
		System.out.printf("%s %s %s%n", p1.equals(p2), p2.equals(p3),
				p1.equals(p3));
	}
}
