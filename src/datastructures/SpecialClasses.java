package datastructures;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
// @formatter:off

public class SpecialClasses {
	public static void main(String[] args) {
		//SpecialClasses.linkedHashMap();
		List<String> stringList = Stream
				.generate(() -> RandomStringUtils.randomAlphabetic(5))
				.limit(1000000)
				.toList();
		SpecialClasses.stringBuilder(stringList);
	}
	
	static void linkedHashMap() {
		// Create LinkedHashMap with initial capacity 100, load factor of 0.75, and
		// specify that the map is ordered by access order instead of insertion order.
		LinkedHashMap<String, String> map = new LinkedHashMap<>(100, 0.75f, true);
		map.putAll(Map.of("Matthew", "Young", "Caleb", "Bell", "James", "Murray"));
		System.out.println("Initial: " + map.entrySet());
		map.get("Caleb");
		System.out.println("After get 'Caleb'" + map.entrySet());
		map.get("James");
		System.out.println("After get 'James'" + map.entrySet());
	}
	
	/**
	 * Concatenate list of words to form a sentence.
	 * Comparing
	 * @param words words to concatenate
	 */
	static void stringBuilder(List<String> words) {
		String badSentence = "";
		
		// O(n^2)
		System.out.println("Concatenating strings badly...");
		long currentTime = System.nanoTime();
		for (String word : words) {
			badSentence += word;
			//System.out.println(word);
		}
		long endTime = System.nanoTime();
		System.out.println("Bad way to concatenate strings took " +
		                   (endTime - currentTime) / Math.pow(10, 9) +
		                   " seconds.");
		
		// O(n)
		System.out.println("Concatenating strings efficiently...");
		currentTime = System.nanoTime();
		StringBuilder sentenceBuilder = new StringBuilder(""); // pass string to constructor
		for (String word : words) {
			sentenceBuilder.append(word);
		}
		endTime = System.nanoTime();
		String result = sentenceBuilder.toString(); // NB: convert back to string
		System.out.println("Good way to concatenate strings took " +
		                   (endTime - currentTime) / Math.pow(10, 9) +
		                   " seconds.");
	}
}
