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
		//�ֶ������л��ͳ�ʼ������״̬
		int x = s.readInt();
		int y = s.readInt();
		initialize(x, y);
	}
	
	private void writeObject(ObjectOutputStream s) throws IOException {
		s.defaultWriteObject();
		
		// Manually serialize superclass state
		//�ֶ����л�����״̬
		s.writeInt(getX());
		s.writeInt(getY());
	}
	
	// Constructor does not use the fancy mechanism
	//���캯����ʹ�û��ڵĻ���
	public Foo(int x, int y) {
		super(x, y);
	}
	
	private static final long serialVersionUID = 1856835860954L;
	
}
