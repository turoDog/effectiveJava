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
	
	//�ʵ��ؽ�ֹδ�����ľ���
	public E pop() {
		if (size == 0) {
			throw new EmptyStackException();
		}
		// push��ҪԪ��ΪE�࣬����cast����ȷ��
		@SuppressWarnings("unchecked")
		E result = (E) elements[--size];
		
		elements[size] = null; //������ʱ�Ĳο�
		return result;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}

	private void ensureCapacity() {
		if (elements.length == size)
			elements = Arrays.copyOf(elements, 2 * size + 1);
	}
	
	//С�������������ǵ�ͨ�ö�ջ
	public static void main(String[] args) {
		Stack<String> stack = new Stack<String>();
		for(String arg : args)
			stack.push(arg);
		while (!stack.isEmpty()) {
			System.out.println(stack.pop().toUpperCase());
		}
	}
}
