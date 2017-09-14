package item_71;

public class Initialization {
	// Normal initialization of an instance field
	//实例字段的正常初始化
	private final FieldType field1 = computeFieldValue();
	
	// Lazy initialization of instance field - synchronized accessor
	//实例字段的延迟初始化 - 同步访问器
	private FieldType field2;
	
	synchronized FieldType getField2() {
		if (field2 == null) {
			field2 = computeFieldValue();
		}
		return field2;
	}
	
	// Lazy initialization holder class idiom for static fields
	//静态字段的Lazy初始化持有人类习语
	private static class FieldHolder{
		static final FieldType field = computeFieldValue();
	}
	
	static FieldType getField3() {
		return FieldHolder.field;
	}
	
	// Double-check idiom for lazy initialization of instance fields
	//双重检查成语用于实例字段的延迟初始化
	private volatile FieldType field4;
	
	FieldType getField4() {
		FieldType result = field4;
		if (result == null) { // First check (no locking)
			synchronized (this) {
				result = field4;
				if (result == null) // Second check (with locking)
					field4 = result = computeFieldValue();
			}
		}
		return result;
	}
	
	// Single-check idiom - can cause repeated initialization!
	//单一检查成语 - 可能会引起反复初始化！
	private volatile FieldType field5;
	
	private FieldType getField5() {
		FieldType result = field5;
		if (result == null)
			field5 = result = computeFieldValue();
		return result;
	}
	
	private static FieldType computeFieldValue() {
		return new FieldType();
	}
}

class FieldType {
}
