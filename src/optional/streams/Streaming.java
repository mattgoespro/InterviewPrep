package optional.streams;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.*;
import java.util.function.*;
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
		
		// Generate from Random object
		Random random = new Random();
		IntStream ints = random.ints();
		
		// Number streams
		IntStream intStream = IntStream.generate(() -> new Random().nextInt() % 10).limit(10);
		DoubleStream doubleStream = DoubleStream.generate(() -> 1.1).limit(10);
		LongStream longStream = LongStream.generate(() -> 1).limit(10);
		
		// Convert to Stream object
		Stream<Integer> intsAsStream = intStream.boxed();
		
		// MapReduce - sum numbers
		int mapReduce = IntStream.generate(() -> new Random().nextInt() % 10)
				.limit(10)
				.map(num -> num * 2)
				.reduce(0, Integer::sum);
		System.out.println("Mapped sum: " + mapReduce + "\n");
		
		// Class method reference 'print' of 'System' class.
		Stream.of(123, "Hello", 30f, false).forEach(System.out::print);
		// Class constructor reference to create new StringBuilder object.
		Stream.of("123", "43", "-12", "0").map(StringBuilder::new);
		
		//@formatter:off
		
		Function<Integer, Integer> incrementer = val -> val + 1;
		Function<Object, String> wrapInQuotes = obj -> "\"" + obj + "\"";
		System.out.println(
			"Increment integers: " +
	        Stream.of(23, 76, 34, 87, 23)
	        .map(incrementer)
	        .toList()
		);
		Function<Integer, String> incrementThenWrapInParentheses = wrapInQuotes.compose(incrementer);
		System.out.println(
				"Increment integers then wrap in quotes: " +
                Stream.of(23, 76, 34, 87, 23)
                .map(incrementThenWrapInParentheses)
                .toList()
		);
		
		//@formatter:on
		//@formatter:off
		
		BiFunction<String, Integer, Integer> incrementMyAge =
				(name, oldValue) -> name.equals("Matt") ? oldValue + 1 : oldValue;
		HashMap<String, Integer> people = new HashMap<>(Map.of(
		"Matt", 25,
		"James", 27,
		"Ben", 26)
		);
		people.replaceAll(incrementMyAge);
		System.out.println(people.entrySet());
		
		Supplier<Integer> randomNumber = () -> new Random().nextInt() % 10;
		System.out.println("10 random numbers: " +
           Stream.generate(randomNumber)
           .limit(10)
           .toList()
		);
		
		//@formatter:off
		
		Consumer<String> printStrings = s -> System.out.print(s + ", ");
		Stream.of("Car", "Hat", "Keyboard", "Mug").forEach(printStrings);
		System.out.println();
		
		Predicate<String> isPalindrome = string ->
				new StringBuilder(string.toLowerCase())
				.reverse()
				.toString()
				.equals(string.toLowerCase());
		System.out.println(
				"Palindromes: " +
				Stream.of("Tacocat", "abb", "aba", "", "racecar")
               .filter(isPalindrome)
               .toList()
		);
		
		BinaryOperator<String> reverseStringStream =
				(string1, string2) -> string2.concat(string1);
		System.out.println("Reversing String stream: " +
				Stream.of(" Hello ", " cruel", " world! ")
				.reduce(reverseStringStream)
				.get()
		);
		
		UnaryOperator<Integer> reverseInt = number -> {
			int curr = number;
			int rev = 0;
			
			while (curr > 0) {
				rev = rev * 10 + curr % 10;
				curr /= 10;
			}
			
			return rev;
		};
		System.out.println(
			"Reversed numbers: " +
			Stream.of(6,43,123,6523)
            .map(reverseInt)
			.toList()
		);
		
		// Comparators can also be used as lambdas.
		Comparator<Integer> compareIntArray = (o1,o2)-> {
			if(o1 > o2) {
				return 1;
			} else if(o1 < o2) {
				return -1;
			}
			
			return 0;
		};
		
		System.out.println(
				Arrays.compare(
						new Integer[]{1, 2, 3, 4},
						new Integer[]{1, 2, 3, 2},
						compareIntArray
				)
		);
	}
}

@AllArgsConstructor
@Getter
class EmailPerson {
	String username;
	String emailProvider;
}

