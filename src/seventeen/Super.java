package seventeen;

public class Super {
	// Broken - constructor invokes an overridable method
	// Broken - ���캯������һ���ɸ��ǵķ���
	public Super() {
		overrideMe();
	}
	
	public void overrideMe() {
		
	}
}
