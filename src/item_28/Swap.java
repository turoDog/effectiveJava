package item_28;

import java.util.Arrays;
import java.util.List;

public class Swap {
	public static void swap(List<?> list, int i, int j) {
		swapHelper(list, i, j);
	}
	
	//ͨ��������˽�����ַ���
	private static <E> void swapHelper(List<E> list, int i, int j) {
		list.set(i, list.set(j, list.get(i)));
	}
	
	public static void main(String[] args) {
		//������һ�������һ����������ӡ����б�
		List<String> argList = Arrays.asList(args);
		swap(argList, 0, argList.size() - 1);
		System.out.println(argList);
	}

}
