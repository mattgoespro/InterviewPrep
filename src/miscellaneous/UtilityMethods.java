package miscellaneous;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UtilityMethods {
	public static void main(String[] args) {
		// Integer class.
		// convert int to binary string padded with spaces on the left.
		String binaryString = Integer.toBinaryString(123);
		
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
		// sort array with Comparator
		Arrays.sort(intList.toArray(), (num1, num2) -> {
			int n1 = (int) num1, n2 = (int) num2;
			if (n1 > n2) {
				return 1;
			}
			return n1 == n2 ? 0 : -1;
		});
		
		// Random
		Random random = new Random();
		random.ints(10).toArray(); // Generate random int[]
		
		// Collectors
		Collectors.toList(); // collect to list
		Collectors.toSet(); // collect to set
		
		// collect to map using key and value mapper functions
		String x = "abcdef";
		Map m = List.of(1, 2, 3, 4, 5).stream().collect(Collectors.toMap(x::charAt, v -> v));
		System.out.println(m);
		
		// UUIDs
		UUID randomUUID = UUID.randomUUID(); // generate random UUID
		System.out.println("Random UUID: " + randomUUID);
		UUID myUUID = new UUID(234, 45675674); // generate manually
		System.out.println("My UUID: " + myUUID);
		UUID UUIDfromString = UUID.fromString("27110ca2-09c0-4ebf-a08d-2a0f744ed764");
		System.out.println("Convert from String to UUID: " + UUIDfromString);
		
		// Scanner
		Scanner scanner = new Scanner("1,2,false").useDelimiter(",");
		System.out.format("Scanning values: %d %d %s", scanner.nextInt(), scanner.nextInt(), scanner.nextBoolean());
		
		scanner = new Scanner("4, 4, 4, 3, 2.5, 3.25, 5.5, 4,5, 5, 3, 2, 2.5, 1, 5, 7, 4, 3, 3, 3, 3, 4, 4, 4, 6, 6, " + "3, 3").useDelimiter(
				",");
		int s = 0;
		while (scanner.hasNext()) {
			s += Double.parseDouble(scanner.next().trim());
		}
	}
	
	public static List<String> generateRandomStrings(int stringLength, int listLength) {
		return Stream.generate(() -> RandomStringUtils.randomAlphabetic(stringLength).toLowerCase())
				.limit(listLength)
				.toList();
	}
}
