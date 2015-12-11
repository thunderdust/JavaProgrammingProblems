package StringProblems;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/* Given a string which contains only lowercase letters, remove duplicate 
 * letters so that every letter appear once and only once. You must make 
 * sure your result is the smallest in lexicographical order among all 
 * possible results. 
 * Example:
 * Given "bcabc"
 * Return "abc"
 * 
 * Given "cbacdcbc"
 * Return "acdb"*/

public class RemoveDuplicateLetters {

	public static void main(String args[]) {

		String test = "bcabc";
		String test2 = "cbacdcbc";
		System.out.println(removeDuplicate(test));
		System.out.println(removeDuplicate(test2));
	}

	public static String removeDuplicate(String s) {
		if (s == null) {
			return null;
		} else if (s.length() < 2) {
			return s;
		}
		String answer = "";

		while (s.length() > 0) {
			char[] chars = s.toCharArray();
			HashMap<Character, Integer> occurrenceMap = countOccurrence(chars);
			char minChar = chars[0];
			int minIndex = 0;
			for (int i = 0; i < chars.length; i++) {
				if (chars[i] < minChar) {
					minChar = chars[i];
					minIndex = i;
				}
				int count = occurrenceMap.get(chars[i]);
				occurrenceMap.put(chars[i], count - 1);
				if (occurrenceMap.get(chars[i]) == 0) {
					break;
				}
			}
			answer += minChar;
			//System.out.println("Current answer: " + answer);
			s = s.substring(minIndex+1);
			s = removeTargetChar(s, minChar);
			//System.out.println("current string: " + s);
		}
		return answer;
	}

	public static HashMap<Character, Integer> countOccurrence(char[] chars) {

		HashMap<Character, Integer> occurenceMap = new HashMap<Character, Integer>();
		// count occurrence for each char
		for (Character c : chars) {
			if (occurenceMap.containsKey(c)) {
				int times = occurenceMap.get(c) + 1;
				occurenceMap.put(c, times);
			} else {
				occurenceMap.put(c, 1);
			}
		}
		return occurenceMap;
	}

	public static String removeTargetChar(String s, char c) {
		StringBuilder sb;
		int index = s.indexOf(c);
		while (index != -1) {
			sb = new StringBuilder(s);
			sb.deleteCharAt(index);
			s = sb.toString();
			index = s.indexOf(c);
		}
		return s;
	}
}
