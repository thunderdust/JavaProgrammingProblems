package StringProblems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* Given two strings s and t, write a function to determine if t 
 * is an anagram of s. For example, s = "anagram", t = "nagaram", 
 * return true. s = "rat", t = "car", return false. You may assume 
 * the string contains only lowercase alphabets.
 * */

public class ValidAnagram {

	public static void main(String args[]) {

		String sample = "tree";
		String tester = "reet";
		if (isAnagramMap(sample, tester)) {
			System.out.println(tester + " is anagram of " + sample);
		} else {
			System.out.println(tester + " is NOT anagram of " + sample);
		}
	}

	// O(NlogN)
	// Solution 1: Use arrays.sort and arrays.equals
	public static boolean isAnagram(String s, String t) {

		// Special cases
		if (s == null || t == null) {
			return false;
		}
		if (s.length() != t.length()) {
			return false;
		}
		if (s.length() == 1 && t.length() == 1) {
			if (s.equals(t)) {
				return true;
			} else {
				return false;
			}
		}

		char[] charFromS = s.toCharArray();
		char[] charFromT = t.toCharArray();
		Arrays.sort(charFromS);
		Arrays.sort(charFromT);
		return Arrays.equals(charFromS, charFromT);
	}

	/*
	 * Solution 2: Fastest algorithm would be to map each of the 26 English
	 * characters to a unique prime number. Then calculate the product of the
	 * string. By the fundamental theorem of arithmetic, 2 strings are anagrams
	 * if and only if their products are the same.
	 */
	/* However this method fails when the string is super long (overflow) */
	// O(N)
	public static boolean isAnagramPrimeProduct(String s, String t) {

		// Special cases
		if (s == null || t == null) {
			return false;
		}
		if (s.length() != t.length()) {
			return false;
		}
		if (s.length() == 1 && t.length() == 1) {
			if (s.equals(t)) {
				return true;
			} else {
				return false;
			}
		}

		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		map.put('a', 2);
		map.put('b', 3);
		map.put('c', 5);
		map.put('d', 7);
		map.put('e', 101);
		map.put('f', 11);
		map.put('g', 13);
		map.put('h', 17);
		map.put('i', 19);
		map.put('j', 23);
		map.put('k', 29);
		map.put('l', 31);
		map.put('m', 37);
		map.put('n', 41);
		map.put('o', 43);
		map.put('p', 47);
		map.put('q', 53);
		map.put('r', 59);
		map.put('s', 61);
		map.put('t', 67);
		map.put('u', 71);
		map.put('v', 73);
		map.put('w', 79);
		map.put('x', 83);
		map.put('y', 89);
		map.put('z', 97);

		int productS = 1;
		for (int i = 0; i < s.length(); i++) {
			productS *= map.get(s.charAt(i));
		}

		int productT = 1;
		for (int j = 0; j < t.length(); j++) {
			productT *= map.get(t.charAt(j));
		}

		return productS == productT;
	}

	/*
	 * Solution 3 time complexity O(N) use hashmap to check occurrence of
	 * letters if totally match means it is a anagram.
	 */
	public static boolean isAnagramMap(String s, String t) {

		// Special cases
		if (s == null || t == null) {
			return false;
		}
		if (s.length() != t.length()) {
			return false;
		}
		if (s.length() == 1 && t.length() == 1) {
			if (s.equals(t)) {
				return true;
			} else {
				return false;
			}
		}

		HashMap<Character, Integer> occurrenceMap = new HashMap<Character, Integer>();
		// Record char occurrence in s
		for (int i = 0; i < s.length(); i++) {
			char currentChar = s.charAt(i);
			if (occurrenceMap.containsKey(currentChar)) {
				int occurrence = occurrenceMap.get(currentChar);
				occurrenceMap.put(currentChar, occurrence + 1);
			} else {
				occurrenceMap.put(currentChar, 1);
			}
		}

		// Check char occurrence in t
		for (int i = 0; i < t.length(); i++) {
			char currentChar = t.charAt(i);
			if (occurrenceMap.containsKey(currentChar)) {
				int occurrence = occurrenceMap.get(currentChar);
				occurrenceMap.put(currentChar, occurrence - 1);
			} else {
				return false;
			}
		}

		for (Map.Entry<Character, Integer> entry : occurrenceMap.entrySet()) {
			if (entry.getValue() != 0) {
				return false;
			}
		}
		return true;
	}

}
