package eight;

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
		return point.x == x && point.y ==y;
	}
	
	// Broken - violates Liskov substitution principle - Pages 39-40
		// @Override public boolean equals(Object o) {
		// if (o == null || o.getClass() != getClass())
		// return false;
		// Point p = (Point) o;
		// return p.x == x && p.y == y;
		// }

		// See Item 9
	
	@Override
	public int hashCode() {
		
		return 31 * x + y;
	}
}
