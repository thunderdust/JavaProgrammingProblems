package StringProblems;

import java.util.HashMap;
import java.util.Map.Entry;

/* This is a problem asked by [Google].
 * Given a string, find the longest substring that contains only two unique characters. 
 * For example, given "abcbbbbcccbdddadacb", the longest substring that contains 2 unique 
 * character is "bcbbbbcccb". */

public class LongestSubstringContains2UniqueCharacters {

	public static String maxSubString2UniqueChars(String s) {

		int maxLen = 0;
		String maxSubstr = "";
		int m = 0;
		char[] chars = s.toCharArray();
		// track rightmost position for each character
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();

		for (int i = 0; i < chars.length; i++) {
			char currentChar = chars[i];
			// if the third unique character appears
			if (map.size() == 2 && !map.containsKey(currentChar)) {
				/*
				 * update if this new character builds a longer qualified
				 * substring
				 */
				if (i - m > maxLen) {
					maxLen = i - m;
					maxSubstr = s.substring(m, i);
				}
				int leftMost = s.length();
				// Get the left most position stored in the map
				for (Entry<Character, Integer> entry : map.entrySet()) {
					if (entry.getValue() < leftMost) {
						leftMost = entry.getValue();
					}
				}
				m = leftMost + 1;
				map.remove(chars[leftMost]);
			}
			map.put(currentChar, i);
		}
		if (map.size() == 2 && maxLen == 0) {
			return s;
		}
		return maxSubstr;
	}
	// More general case for K Unique Characters
}
