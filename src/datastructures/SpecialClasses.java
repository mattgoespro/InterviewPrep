package datastructures;

import miscellaneous.UtilityMethods;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.*;
import java.util.stream.Stream;

public class SpecialClasses {
	public static void main(String[] args) {
		//@formatter:off
		Map<String, String> map = Map.of(
		 "Matthew",
	     "Young",
	     "Caleb",
	     "Bell",
	     "James",
	     "Murray",
	     "Andre",
	     "Venter",
	     "Eric",
	     "Dai",
	     "Robby",
	     "Bodley",
	     "Chris",
	     "Marrow",
	     "Robert",
	     "Edwards"
		);
		SpecialClasses.normalHashMap(map);
		SpecialClasses.linkedHashMap(map);
		SpecialClasses.treeMap(map);
		SpecialClasses.queues();
		System.out.print("Test StringBuilder performance? (y/n) ");
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		if (s.toUpperCase().startsWith("Y")) {
			sc.close();
			List<String> stringList = Stream
					.generate(() -> RandomStringUtils.randomAlphabetic(5))
					.limit(1000000)
					.toList();
			SpecialClasses.stringBuilder(stringList);
		}
		//@formatter:on
	}
	
	static void normalHashMap(Map<String, String> data) {
		// Creates a regular hash map with random access order.
		HashMap<String, String> hashMap = new HashMap<>(data);
		System.out.println("Initial: " + data.entrySet());
		hashMap.get("Caleb");
		System.out.println("After get 'Caleb'" + data.entrySet());
		hashMap.get("James");
		System.out.println("After get 'James'" + data.entrySet());
	}
	
	static void linkedHashMap(Map<String, String> data) {
		// Create LinkedHashMap with initial capacity 100, load factor of 0.75, and
		// specify that the data is ordered by access order instead of insertion order.
		LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>(100, 0.75f, true);
		linkedHashMap.putAll(data);
		System.out.println("Initial: " + data.entrySet());
		linkedHashMap.get("Caleb");
		System.out.println("After get 'Caleb'" + data.entrySet());
		linkedHashMap.get("James");
		System.out.println("After get 'James'" + data.entrySet());
	}
	
	static void treeMap(Map<String, String> data) {
		// Creates a hash map with keys sorted/ordered.
		System.out.println("Initial entries: " + data.entrySet());
		TreeMap<String, String> treeMap = new TreeMap<>(data);
		System.out.println("Tree map entries: " + treeMap.entrySet());
	}
	
	static void queues() {
		List<String> items = List.of("Matt", "Erin", "James", "Eric");
		// Regular queue
		Queue<String> queue = new ArrayDeque<>(items);
		System.out.println(queue.peek());
		System.out.println("Next: " + queue.poll());
		// Priority queue - min heap
		Queue<String> minHeap = new PriorityQueue<>(items);
		System.out.println(minHeap.peek());
		System.out.println("Next: " + minHeap.poll());
		// Priority queue - max heap (reverse comparator)
		Queue<String> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
		maxHeap.addAll(items);
		System.out.println(maxHeap.peek());
		System.out.println("Next: " + maxHeap.poll());
		Comparator<String> compareLastChar = (string1, string2) -> {
			int last1 = string1.charAt(string1.length() - 1);
			int last2 = string2.charAt(string2.length() - 1);
			return last1 - last2;
		};
		Queue<String> orderedByLastLetter = new PriorityQueue<>(compareLastChar);
		List<String> randomStrings = UtilityMethods.generateRandomStrings(10, 5);
		System.out.println("Random strings: " + randomStrings);
		orderedByLastLetter.addAll(randomStrings);
		System.out.println("Ordered list: " + orderedByLastLetter);
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
		}
		long endTime = System.nanoTime();
		System.out.println("Bad way to concatenate strings took " + (endTime - currentTime) / Math.pow(10,
		                                                                                               9
		) + " seconds.");
		
		// O(n)
		System.out.println("Concatenating strings efficiently...");
		currentTime = System.nanoTime();
		StringBuilder sentenceBuilder = new StringBuilder(""); // pass string to constructor
		for (String word : words) {
			sentenceBuilder.append(word);
		}
		endTime = System.nanoTime();
		String result = sentenceBuilder.toString(); // NB: convert back to string
		System.out.println("Good way to concatenate strings took " + (endTime - currentTime) / Math.pow(10,
		                                                                                                9
		) + " seconds.");
	}
}
