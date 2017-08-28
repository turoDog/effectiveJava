package twenty_six.secondtechnqiue;

import java.util.Arrays;

public class Stack<E> {
	private Object [] elements;
	private int size = 0;
	private static final int DEFAULT_INITIAL_CAPACITY = 16;
	
	public Stack(){
		elements = new Object[DEFAULT_INITIAL_CAPACITY];
	}

	public void push(E e) {
		ensureCapacity();
		elements[size++] = e;
	}
	
	//适当地禁止未经检查的警告
	public E pop() {
		if (size == 0) {
			throw new EmptyStackException();
		}
		// push需要元素为E类，所以cast是正确的
		@SuppressWarnings("unchecked")
		E result = (E) elements[--size];
		
		elements[size] = null; //消除过时的参考
		return result;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}

	private void ensureCapacity() {
		if (elements.length == size)
			elements = Arrays.copyOf(elements, 2 * size + 1);
	}
	
	//小程序来锻炼我们的通用堆栈
	public static void main(String[] args) {
		Stack<String> stack = new Stack<String>();
		for(String arg : args)
			stack.push(arg);
		while (!stack.isEmpty()) {
			System.out.println(stack.pop().toUpperCase());
		}
	}
}
