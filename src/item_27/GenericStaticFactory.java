package item_27;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GenericStaticFactory {
	//ͨ�þ�̬��������
	public static <K, V> HashMap<K, V>  newHashMap(){
		return new HashMap<K, V>();
	}
	
	public static void main(String[] args) {
	//ʹ�þ�̬������������������ʵ��
		Map<String, List<String>> anagrams = newHashMap();
	}
}
