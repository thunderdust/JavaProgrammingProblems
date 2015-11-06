package StringProblems;

import java.util.HashMap;
import java.util.Map;

/* Given two (dictionary) words as Strings, determine if they are isomorphic.
Two words are called isomorphic if the letters in one word can be remapped 
to get the second word.Remapping a letter means replacing all occurrences of
it with another letter while the ordering of the letters remains unchanged.
No two letters may map to the same letter, but a letter may map to itself.
*/

public class IsomorphicStrings {

	public static void main(String args[]) {

		test("a", "d");
		test("ac", "def");
		test("", "");
		test("abb", "def");
		test("abb", "dee");
		test("abbcddacc", "deefggdff");
		test("ab", "aa");
	}

	public static void test(String s1, String s2) {
		if (isIsomorphic(s1, s2)) {
			System.out.println(s1 + " and " + s2 + " are isomorphic");
		} else {
			System.out.println(s1 + " and " + s2 + " are NOT isomorphic");
		}
	}

	public static Character getKey(HashMap<Character, Character> map, char value) {

		for (HashMap.Entry<Character, Character> entry : map.entrySet()) {
			// current value has its mapping
			if (entry.getValue() == value) {
				return entry.getKey();
			}
		}
		return null;
	}

	public static boolean isIsomorphic(String s1, String s2) {

		if (s1 == null || s2 == null || s1.length() == 0 || s2.length() == 0) {
			return true;
		}
		if (s1.length() != s2.length()) {
			return false;
		}
		if (s1.length() == 1 && s2.length() == 1) {
			return true;
		}
		HashMap<Character, Character> isomorphicMap = new HashMap<Character, Character>();
		int length = s1.length();
		for (int i = 0; i < length; i++) {

			char currentCharS1 = s1.charAt(i);
			char currentCharS2 = s2.charAt(i);
			// Assuming s1 as the key, s2 as the value
			Character key = getKey(isomorphicMap, currentCharS2);

			/*
			 * Remember to check BOTH way ! KEY => VALUE and VALUE => KEY
			 * counter example: "ab", "aa". if you only check KEY=>VALUE, then
			 * in first position you build a=>a, and in the second position you
			 * build b=>a without checking if a already has a key pair to it,
			 * resulting in 2 letters map to the same letter.
			 */

			// value is in the map, but its key is different
			if (key != null && key != currentCharS1) {
				return false;
			}
			// key is in the map, but its value if different
			else if (isomorphicMap.containsKey(currentCharS1) && currentCharS2 != isomorphicMap.get(currentCharS1)) {
				return false;
			}
			// new key, value pair. Put it into the map
			else {
				isomorphicMap.put(currentCharS1, currentCharS2);
			}
		}
		return true;
	}
}
