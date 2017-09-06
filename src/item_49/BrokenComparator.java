package item_49;

import java.util.Comparator;

public class BrokenComparator {
	public static void main(String[] args) {
		//Comparator<Integer> naturalOrder = new Comparator<Integer>() {
		//	public int compare(Integer first, Integer second) {
		//		return first < second ? -1 : (first == second ? 0 : 1);
		//	}
		//};
		
		Comparator<Integer> naturalOrder = new Comparator<Integer>() {
			 public int compare(Integer first, Integer second) {
				 int f = first; // Auto-unboxing
				 int s = second; // Auto-unboxing
				 return f < s ? -1 : (f == s ? 0 : 1); // No unboxing
			 	}
			 };
		
		int result = naturalOrder.compare(new Integer(42), new Integer(42));
		System.out.println(result);
	}
}
