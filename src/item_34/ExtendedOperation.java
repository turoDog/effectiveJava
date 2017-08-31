package item_34;

import java.util.Arrays;
import java.util.Collection;

import one.Test;

public enum ExtendedOperation implements Operation{
	EXP("^") {
		public double apply(double x, double y) {
			return Math.pow(x, y);
		}
	},
	REMAINDER("%") {
		public double apply(double x, double y) {
			return x % y;
		}
	};
	
	private final String symnol;
	
	ExtendedOperation(String symbol) {
		this.symnol = symbol;
	}
	
	public static void main(String[] args) {
		double x = Double.parseDouble(args[0]);
		double y = Double.parseDouble(args[1]);
		test(ExtendedOperation.class, x, y);
		
		System.out.println();//Print a blank line between tests
		test2(Arrays.asList(ExtendedOperation.values()), x, y);
	}
	
	// test parameter is a bounded type token
	//测试参数是有界类型的标记
	private static <T extends Enum<T> & Operation> void test(Class<T> opSet,
			double x, double y) {
		for (Operation op : opSet.getEnumConstants())
			System.out.printf("%f %s %f = %f%n", x, op, y, op.apply(x, y));
	}
	
	// test parameter is a bounded wildcard type
	// test parameter是一个有界的通配符类型
	private static void test2(Collection<? extends Operation> opSet, double x, 
			double y) {
		for (Operation op : opSet)
			System.out.printf("%f %s %f = %f%n", x, op, y, op.apply(x, y));
	}
}
