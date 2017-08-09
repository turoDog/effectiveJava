package three.field;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

public class Elvis {
	public static final Elvis INSTANCE = new Elvis();
	
	private Elvis() {
	}
	
	public void leaveTheBuilging() {
		System.out.println("Whoa baby, I'm outta here!");
	}
	
	// This code would normally appear outside the class!
	public static void main(String[] args) {
		Elvis elvis = Elvis.INSTANCE;
		elvis.leaveTheBuilging();
	}
}
