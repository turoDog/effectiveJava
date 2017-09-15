package item_74;

import java.lang.Thread.State;
import java.util.concurrent.atomic.AtomicReference;

import org.omg.CORBA.INITIALIZE;

public abstract class AbstractFoo {
	private int x, y;//our state
	
	//this enum and field are used to track initialzation
	private enum State {
		NEW, INITIALIZING, INITIALIZED
	};
	
	private final AtomicReference<State> init = new AtomicReference<State>(
			State.NEW);
	
	public AbstractFoo(int x, int y) {
		initialize(x, y);
	}
	
	//This constructor and the following method allow
	// subclass's readObject method to initialize our state.
	//������캯��������ķ������������readObject������ʼ�����ǵ�״̬��
	protected AbstractFoo() {};
	
	protected final void initialize(int x, int y) {
		if (!init.compareAndSet(State.NEW, State.INITIALIZING)) {
			throw new IllegalStateException("Already initialized");
		}
		this.x = x;
		this.y = y;
		//Do anything else the original constructor did
		//���κ�����ԭʼ���캯��
		init.set(State.INITIALIZED);
	}
	
	// These methods provide access to internal state so it can
	// be manually serialized by subclass's writeObject method.
	//��Щ�����ṩ���ڲ�״̬�ķ��ʣ���˿���ͨ�������writeObject�����ֶ����л���
	protected final int getX() {
		checkInit();
		return x;
	}
	
	protected final int getY() {
		checkInit();
		return y;
	}
	
	// Must call from all public and protected instance methods
	//��������й������ܱ�����ʵ����������
	private void checkInit() {
		if (init.get() != State.INITIALIZED) {
			throw new IllegalStateException("Uninitialized");
		}
	}
	//Remainder omitted
}
