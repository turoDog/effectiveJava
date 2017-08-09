package five;

import java.util.concurrent.ForkJoinPool.ForkJoinWorkerThreadFactory;

import javax.swing.text.StyledEditorKit.ForegroundAction;

public class Sum {
	// Hideously slow program! Can you spot the object creation?
	public static void main(String[] args) {
		Long sum = 0L;
		for(long i = 0; i < Integer.MAX_VALUE; i++) {
			sum += i;
		}
		System.out.println(sum);
	}
}

