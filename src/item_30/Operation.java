package item_30;

import java.util.HashMap;
import java.util.Map;

public enum Operation {
	PLUS("+") {
		double apply(double x, double y) {
			return x + y;
		}
	},
	
	MINUS("-") {
		double apply(double x, double y) {
			return x - y;
		}
	},
	
	TIMES("*") {
		double apply(double x, double y) {
			return x * y;
		}
	},
	
	DIVIDE("/") {
		double apply(double x, double y) {
			return x / y;
		}
	};
	private final String symbol;
	
	Operation(String symbol) {
		this.symbol = symbol;
	}
	
	@Override
	public String toString() {
		return symbol;
	}
	
	abstract double apply(double x, double y);
	
	//在枚举类型上实现一个fromString方法
	private static final Map<String, Operation> stringToEnum = new HashMap<String, Operation>();
	static {//从常量名称初始化映射到枚举常量
		for (Operation op : values()) {
			stringToEnum.put(op.toString(), op);
		}
	}
	
	//Returns Operation for string, or null if string is invalid
	////返回字符串的操作，如果字符串无效则返回null
	public static Operation fromString(String symbol) {
		return stringToEnum.get(symbol);
	}
	
	public static void main(String[] args) {
		double x = Double.parseDouble(args[0]);
		double y = Double.parseDouble(args[1]);
		for (Operation op : Operation.values()) {
			System.out.printf("%f %s %f = %f%n", x, op, y, op.apply(x, y));
		}
	}
}
