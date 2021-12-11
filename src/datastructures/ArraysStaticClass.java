package datastructures;

import java.util.*;

public class ArraysStaticClass {
	public static void main(String[] args) {
		Random generator = new Random();
		int[] integers = generator.ints().limit(10).map(v -> v % 10).toArray();
		List<Integer> integersList = Arrays.stream(integers).boxed().toList();
		System.out.println("Generated integers: " + Arrays.stream(integers).boxed().toList());
		
		Arrays.sort(integers);
		System.out.println("Sorted integers: " + Arrays.stream(integers).boxed().toList());
	}
}
