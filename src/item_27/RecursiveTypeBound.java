package item_27;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class RecursiveTypeBound {
	//返回列表中的最大值 - 使用递归类型bound
	public static <T extends Comparable<T>> T max(List<T> list) {
		Iterator<T> iterator = list.iterator();
		T result = iterator.next();
		while (iterator.hasNext()) {
			T t = iterator.next();
			if (t.compareTo(result) > 0) {
				result = t;
			}
		}
		return result;
	}
	public static void main(String[] args) {
		List<String> argList = Arrays.asList(args);
		System.out.println(max(argList));
	}
}
