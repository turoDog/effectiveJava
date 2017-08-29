package item_28;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class Stack<E> {
	private E[] elements;
	private int size = 0;
	private static final int DEFAULT_INITIAL_CAPACITY = 16;
	
	//元素数组只包含来自push（E）的E实例。
	//这足以确保类型安全，但运行时
	//数组类型不会是E []; 它将永远是Object []！
	
	@SuppressWarnings("unchecked")
	public Stack() {
		elements = (E[]) new Object[DEFAULT_INITIAL_CAPACITY];
	}
	
	public void push(E e) {
		ensureCapacity();
		elements[size++] = e;
	}
	
	public E pop() {
		if (size == 0) {
			throw new EmptyStackException();
		}
		E result = elements[--size];
		elements[size] = null; //消除过时的引用
		return result;
	}

	public boolean isEmpty() {
		return size == 0;
	}
	
	private void ensureCapacity() {
		if (elements.length == size)
			elements = Arrays.copyOf(elements, 2 * size + 1);
	}
	
	// pushAll method without wildcard type - deficient!
	// public void pushAll(Iterable<E> src) {
	// for (E e : src)
	// push(e);
	// }
	
	// Wildcard type for parameter that serves as an E producer
	public void pushAll(Iterable<? extends E> src) {
		for (E e : src)
			push(e);
	}
	
	// popAll method without wildcard type - deficient!
	// public void popAll(Collection<E> dst) {
	// while (!isEmpty())
	// dst.add(pop());
	// }
	
	// Wildcard type for parameter that serves as an E consumer
	public void popAll(Collection<? super E> dst) {
		while (!isEmpty())
			dst.add(pop());
	}
	
	// Little program to exercise our generic Stack
	public static void main(String[] args) {
		Stack<Number> numberStack = new Stack<Number>();
		Iterable<Integer> integers = Arrays.asList(3, 1, 4, 1, 5, 9);
		numberStack.pushAll(integers);

		Collection<Object> objects = new ArrayList<Object>();
		numberStack.popAll(objects);

		System.out.println(objects);
	}
}
