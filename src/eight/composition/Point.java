package eight.composition;

public class Point {
	private final int x;
	private final int y;
	
	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Point)) {
			return false;
		}
		Point point = (Point) obj;
		return point.x == x && point.y == y;
	}
	
	@Override
	public int hashCode() {
		
		return 31 * x + y;
	}
}
