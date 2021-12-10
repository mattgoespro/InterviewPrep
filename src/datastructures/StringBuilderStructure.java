package datastructures;

public class StringBuilderStructure {
	/**
	 * O(n^2)
	 * @param words
	 */
	String joinWords(String[] words) {
		String sentence = "";
		for (String word : words) {
			sentence += word;
		}
		return sentence;
	}
	
	/**
	 * O(n)
	 * @param words
	 */
	String betterJoinWords(String[] words) {
		StringBuilder sentence = new StringBuilder();
		for (String word : words) {
			sentence.append(word);
		}
		return sentence.toString();
	}
}
