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

	//���� - Υ����Ⱦ�ԣ�
	// @Override public boolean equals��Object o��{
	// if������o instanceof Point����
	// return false;
	//
	// //���o��һ����ͨ�㣬��һ��ɫä�Ƚ�
	// if������o instanceof ColorPoint����
	// return o.equals��this��;
	//
	// // o��ColorPoint; ��һ�������ıȽ�
	// return super.equals��o��&&����ColorPoint��o��.color == color;
	//}
	
	public static void main(String[] args) {
		//��һ���ں���Υ���Գ���
		Point p = new Point(1, 2);
		ColorPoint cp = new ColorPoint(1, 2, Color.RED);
		System.out.println(p.equals(cp) + " " + cp.equals(p));
	
		// Second equals����Υ��������
		ColorPoint p1 = new ColorPoint(1, 2, Color.RED);
		Point p2 = new Point(1, 2);
		ColorPoint p3 = new ColorPoint(1, 2, Color.BLUE);
		System.out.printf("%s %s %s%n", p1.equals(p2), p2.equals(p3),
				p1.equals(p3));
	}
}
