package item_29;

import java.util.HashMap;
import java.util.Map;

public class Favorites {
	//类型安全异类容器模式 - 实现
	private Map<Class<?>, Object> favorites = new HashMap<Class<?>, Object>();
	
	public <T> void putFavorite(Class<T> type, T instance) {
		if (type == null) {
			throw new NullPointerException("Type is null");
		}
		favorites.put(type, instance);	
	}
	
	public <T> T getFavorite(Class<T> type) {
		return type.cast(favorites.get(type));
	}
	
	//类型安全异构容器模式 - 客户端
	public static void main(String[] args) {
		Favorites favorites = new Favorites();
		favorites.putFavorite(String.class, "Python");
		favorites.putFavorite(Integer.class, 0xcafebabe);
		favorites.putFavorite(Class.class, Favorites.class);
		
		String favoriteString = favorites.getFavorite(String.class);
		int favoriteInteger = favorites.getFavorite(Integer.class);
		Class<?> favoriteClass = favorites.getFavorite(Class.class);
		System.out.printf("%s %x %S%n", favoriteString,favoriteInteger,
				favoriteClass.getName());
	}

}
