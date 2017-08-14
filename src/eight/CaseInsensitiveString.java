package eight;

public class CaseInsensitiveString {
	private final String s;

	public CaseInsensitiveString(String s) {
		super();
		this.s = s;
	}
	
	//���� - Υ���Գƣ�
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof CaseInsensitiveString) 
			return s.equalsIgnoreCase(((CaseInsensitiveString) obj).s);
		if (obj instanceof String) //���򻥲����ԣ�
			return s.equalsIgnoreCase((String) obj);
		return false;
	}
	
	// This version is correct.
	// @Override public boolean equals(Object o) {
	// return o instanceof CaseInsensitiveString &&
	// ((CaseInsensitiveString) o).s.equalsIgnoreCase(s);
	// }
	
	public static void main(String[] args) {
		CaseInsensitiveString ciString = new CaseInsensitiveString("Polish");
		String string = "polish";
		System.out.println(ciString.equals(string)+ " " +string.equals(ciString));
	}
}
