package specialclasses;

import java.util.*;
import java.util.stream.Collectors;

public class UtilityMethods {
	public static void main(String[] args) {
		// Integer class.
		// convert int to binary string padded with spaces on the left.
		String binaryString = Integer.toBinaryString(123);
		
		// String class.
		String welcome = String.format("My name is %s and I am %d years old.", "Matt", 25);
		
		// Collections class.
		List<Integer> list = Arrays.asList(1, 2, 3);
		Collections.sort(list); // sort list
		Collections.shuffle(list); // shuffle list
		Collections.swap(list, 0, list.size() / 2); // swap list elements at indices
		int index = Collections.binarySearch(list, 1); // binary search sorted list
		Collections.reverse(list); // reverse a list
		Comparator<Integer> reverser = Collections.reverseOrder(); // returns Comparator to reverse list order.
		
		// Arrays class.
		List<Integer> intList = Arrays.asList(4, 6, 23, 765, 23, 2565, 456, 213); // create List.
		int[] nativeInts = new Random().ints(10).toArray();
		Arrays.sort(intList.toArray()); // sort array.
		Arrays.sort(intList.toArray(), (num1, num2) -> (int) num1 >= (int) num2 ? -1 : 1); // sort array with Comparator
		
		// Random
		Random random = new Random();
		random.ints(10).toArray(); // Generate random int[]
		
		// Collectors
		Collectors.toList(); // collect to list
		Collectors.toSet(); // collect to set
		Collectors.toMap(k -> k, v -> v); // collect to map using key and value mapper functions
	}
}
