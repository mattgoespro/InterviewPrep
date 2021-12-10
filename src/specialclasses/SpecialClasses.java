package specialclasses;

import java.util.LinkedHashMap;
import java.util.Map;

public class SpecialClasses {
	public static void main(String[] args) {
		SpecialClasses.linkedHashMap();
	}
	
	static void linkedHashMap() {
		LinkedHashMap<String, String> map = new LinkedHashMap(100, 0.75f, true);
		map.putAll(Map.of("Matthew", "Young", "Caleb", "Bell", "James", "Murray"));
		System.out.println("Initial: " + map.entrySet());
		map.get("Caleb");
		System.out.println(map.entrySet());
		map.get("James");
		System.out.println(map.entrySet());
	}
}
