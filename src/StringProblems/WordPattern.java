package StringProblems;

import java.util.HashMap;

/* Given a pattern and a string str, find if str follows the same pattern.
 * Here follow means a full match, such that there is a bijection between 
 * a letter in pattern and a non-empty word in str.
 * Examples:
 * pattern = "abba", str = "dog cat cat dog" should return true.
 * pattern = "abba", str = "dog cat cat fish" should return false.
 * pattern = "aaaa", str = "dog cat cat dog" should return false.
 * pattern = "abba", str = "dog dog dog dog" should return false.
 * Notes:
 * You may assume pattern contains only lowercase letters, and str contains 
 * lowercase letters separated by a single space. */

public class WordPattern {

	public static void main(String args[]) {

		String pattern = "abba";
		String sample = "dog cat cat dog";
		if (wordPattern(pattern, sample)) {
			System.out.println("Matched");
		} else {
			System.out.println("Unmatched");
		}
	}

	public static boolean wordPattern(String pattern, String str) {

		if (pattern == null || pattern.length() == 0) {
			return false;
		}
		char[] patternChars = pattern.toCharArray();
		String[] words = str.split(" ");
		if (patternChars.length != words.length) {
			return false;
		} else {
			HashMap<Character, String> map = new HashMap<Character, String>();
			for (int i = 0; i < words.length; i++) {

				if (map.containsKey(patternChars[i])) {
					if (!map.get(patternChars[i]).equals(words[i])) {
						return false;
					} else {
						continue;
					}
				} else {
					if (map.containsValue(words[i])) {
						return false;
					} else {
						map.put(patternChars[i], words[i]);
					}
				}
			}
			return true;
		}
	}
}
