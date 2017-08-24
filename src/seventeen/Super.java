package seventeen;

public class Super {
	// Broken - constructor invokes an overridable method
	// Broken - 构造函数调用一个可覆盖的方法
	public Super() {
		overrideMe();
	}
	
	public void overrideMe() {
		
	}
}
