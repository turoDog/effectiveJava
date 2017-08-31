package item_33;

import java.util.EnumMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Herb {

	//简单的课堂代表烹饪草本
	public enum Type {
		ANNUAL,PERENNIAL,BIENNIAL
	}
	
	private final String name;
	private final Type type;
	
	public Herb(String name, Type type) {
		this.name = name;
		this.type = type;
	}
	
	@Override
	public String toString() {
		return name;
	}
	
	public static void main(String[] args) {
		Herb[] garden = {new Herb("Basic", Type.ANNUAL),
				new Herb("Carroway",Type.BIENNIAL),
				new Herb("Dill", Type.ANNUAL),
				new Herb("Lavendar", Type.PERENNIAL),
				new Herb("Parsley", Type.BIENNIAL),
				new Herb("Rosemary", Type.PERENNIAL)	
		};
		
		//Using an EnumMap to associate data with an enum
		Map<Herb.Type, Set<Herb>> herbByType = new EnumMap<Herb.Type,Set<Herb>>(
				Herb.Type.class);
		for (Herb.Type t : Herb.Type.values()){
			herbByType.put(t, new HashSet<Herb>());
		}
		for (Herb h : garden) {
			herbByType.get(h.type).add(h);
		}
		System.out.println(herbByType);
	}
}
