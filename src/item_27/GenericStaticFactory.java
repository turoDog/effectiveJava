package item_27;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GenericStaticFactory {
	//通用静态工厂方法
	public static <K, V> HashMap<K, V>  newHashMap(){
		return new HashMap<K, V>();
	}
	
	public static void main(String[] args) {
	//使用静态工厂创建参数化类型实例
		Map<String, List<String>> anagrams = newHashMap();
	}
}
