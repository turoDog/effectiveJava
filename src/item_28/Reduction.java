package item_28;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Reduction {
	//����E�����߲�����ͨ�������
	static <E> E reduce(List<? extends E> list, Function<E> f, E initVal) {
		List<E> snapshot;
		synchronized (list) {
			snapshot = new ArrayList<E>(list);
		}
		E result = initVal;
		for(E e : snapshot)
			result = f.apply(result, e);
		return result;
	}
	
	private static final Function<Number> MAX = new Function<Number>() {
		
		@Override
		public Number apply(Number arg1, Number arg2) {
			// TODO Auto-generated method stub
			return Double.compare(arg1.doubleValue(), arg2.doubleValue()) > 0 ? arg1 : arg2;
		}
	};
	
	public static void main(String[] args) {
		//���ǿ���ʹ��Number����������Integer��Double���б�
		List<Integer> inList = Arrays.asList(2,7,1,8,2,8,1,8,2,8);
		System.out.println(reduce(inList, MAX, Integer.MAX_VALUE));
		
		List<Double> doubleList = Arrays.asList(2.178281828, 3.141592654,
				1.61803399);
		System.out.println(reduce(doubleList, MAX, Double.NEGATIVE_INFINITY));
	}

}
