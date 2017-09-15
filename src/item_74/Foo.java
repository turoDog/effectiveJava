package item_74;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import org.omg.CORBA.PRIVATE_MEMBER;
import org.omg.CORBA.PUBLIC_MEMBER;

public class Foo extends AbstractFoo implements Serializable{
	
	private void readObject(ObjectInputStream s) throws IOException,
			ClassNotFoundException {
		s.defaultReadObject();
		
		// Manually deserialize and initialize superclass state
		//手动反序列化和初始化超类状态
		int x = s.readInt();
		int y = s.readInt();
		initialize(x, y);
	}
	
	private void writeObject(ObjectOutputStream s) throws IOException {
		s.defaultWriteObject();
		
		// Manually serialize superclass state
		//手动序列化超类状态
		s.writeInt(getX());
		s.writeInt(getY());
	}
	
	// Constructor does not use the fancy mechanism
	//构造函数不使用花哨的机制
	public Foo(int x, int y) {
		super(x, y);
	}
	
	private static final long serialVersionUID = 1856835860954L;
	
}
