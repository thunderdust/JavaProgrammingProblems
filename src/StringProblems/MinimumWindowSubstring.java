package StringProblems;

import java.util.HashMap;

/* Given a string S and a string T, find the minimum window in S which will contain 
 * all the characters in T in complexity O(n).
 * For example, S = "ADOBECODEBANC", T = "ABC", Minimum window is "BANC". */

public class MinimumWindowSubstring {

	public static void main(String args[]) {

		String test = "acbbaca";
		String needle = "aba";
		String minWindow = minWindow(test, needle);
		System.out.println(minWindow);

	}

	public static String minWindow(String s, String t) {

		if (t.length() > s.length())
			return "";
		if (s.contains(t)) {
			return t;
		}
		String result = "";

		// Character count for t
		HashMap<Character, Integer> charCountMapT = new HashMap<Character, Integer>();
		char[] tChars = t.toCharArray();
		for (Character c : tChars) {
			if (charCountMapT.containsKey(c)) {
				int count = charCountMapT.get(c);
				charCountMapT.put(c, count + 1);
			} else {
				charCountMapT.put(c, 1);
			}
		}

		// Character count for s
		HashMap<Character, Integer> charCountMapS = new HashMap<Character, Integer>();
		// starting index of matched substring in s
		int windowStart = 0;
		// ensure it is larger than any possible substring of s initially
		int minLen = s.length() + 1;
		// number of mapped chars
		int count = 0;

		for (int i = 0; i < s.length(); i++) {
			char current = s.charAt(i);

			if (charCountMapT.containsKey(current)) {
				if (charCountMapS.containsKey(current)) {
					// required number of maps for this char is not reached yet,
					// number +1
					if (charCountMapS.get(current) < charCountMapT.get(current)) {
						count++;
					}
					// occurrence +1
					charCountMapS.put(current, charCountMapS.get(current) + 1);
				} else {
					charCountMapS.put(current, 1);
					count++;
				}
			}
			// All occurrence in t is satisfied
			if (count == t.length()) {
				char windowStartChar = s.charAt(windowStart);
				while (!charCountMapS.containsKey(windowStartChar)
						|| charCountMapS.get(windowStartChar) > charCountMapT.get(windowStartChar)) {
					if (charCountMapS.containsKey(windowStartChar)
							&& charCountMapS.get(windowStartChar) > charCountMapT.get(windowStartChar)) {
						charCountMapS.put(windowStartChar, charCountMapS.get(windowStartChar) - 1);
					}
					windowStart++;
					windowStartChar = s.charAt(windowStart);
				}

				// update minimum window
				if (i - windowStartChar + 1 < minLen) {
					result = s.substring(windowStart, i + 1);
					minLen = i - windowStartChar + 1;
				}
			}
		}
		return result;
	}
}
