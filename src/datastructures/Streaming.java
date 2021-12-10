package datastructures;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Streaming {
	public static void main(String[] args) {
		// Create stream
		String[] names = new String[]{"Matt", "Eric", "James", "Caleb"};
		Stream<String> arrayStream = Stream.of(names);
		Stream<Integer> generatorStream = Stream.generate(() -> new Random().nextInt());
		// Special Streams
		
		// Number streams
		IntStream intStream = IntStream.generate(() -> new Random().nextInt() % 10).limit(10);
		DoubleStream doubleStream = DoubleStream.generate(() -> 1.1).limit(10);
		LongStream longStream = LongStream.generate(() -> 1).limit(10);
		
		// Convert to Stream object
		Stream<Integer> intsAsStream = intStream.boxed();
		
		// MapReduce
		int mapReduce = IntStream.generate(() -> new Random().nextInt() % 10)
				.limit(10)
				.map(num -> num * 2)
				.reduce(0, Integer::sum);
		System.out.println("Mapped sum: " + mapReduce);
	}
}
