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
	//这个构造函数和下面的方法允许子类的readObject方法初始化我们的状态。
	protected AbstractFoo() {};
	
	protected final void initialize(int x, int y) {
		if (!init.compareAndSet(State.NEW, State.INITIALIZING)) {
			throw new IllegalStateException("Already initialized");
		}
		this.x = x;
		this.y = y;
		//Do anything else the original constructor did
		//做任何其他原始构造函数
		init.set(State.INITIALIZED);
	}
	
	// These methods provide access to internal state so it can
	// be manually serialized by subclass's writeObject method.
	//这些方法提供对内部状态的访问，因此可以通过子类的writeObject方法手动序列化。
	protected final int getX() {
		checkInit();
		return x;
	}
	
	protected final int getY() {
		checkInit();
		return y;
	}
	
	// Must call from all public and protected instance methods
	//必须从所有公共和受保护的实例方法调用
	private void checkInit() {
		if (init.get() != State.INITIALIZED) {
			throw new IllegalStateException("Uninitialized");
		}
	}
	//Remainder omitted
}
