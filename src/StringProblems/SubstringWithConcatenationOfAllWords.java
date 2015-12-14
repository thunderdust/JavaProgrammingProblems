package StringProblems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* You are given a string, s, and a list of words, words, that are all of the 
 * SAME length. Find all starting indices of substring(s) in s that is a 
 * concatenation of each word in words exactly once and without any intervening 
 * characters. For example, given: s="barfoothefoobarman" & words=["foo", "bar"],
 * return [0,9] */

public class SubstringWithConcatenationOfAllWords {

	public List<Integer> findSubstring(String s, String[] words) {

		ArrayList<Integer> result = new ArrayList<Integer>();
		if (s == null || s.length() == 0 || words == null || words.length == 0) {
			return result;
		}

		// Record frequency of target words
		HashMap<String, Integer> wordsFrequencyMap = new HashMap<String, Integer>();
		for (String w : words) {
			if (wordsFrequencyMap.containsKey(w)) {
				wordsFrequencyMap.put(w, wordsFrequencyMap.get(w) + 1);
			} else {
				wordsFrequencyMap.put(w, 1);
			}
		}

		// all words same length
		int len = words[0].length();

		for (int j = 0; j < len; j++) {
			HashMap<String, Integer> currentMap = new HashMap<String, Integer>();
			int start = j;
			int count = 0; // count total qualified words so far
			for (int i = j; i <= s.length() - len; i = i + len) {
				String sub = s.substring(i, i + len);
				// For qualified substrings
				if (wordsFrequencyMap.containsKey(sub)) {
					if (currentMap.containsKey(sub)) {
						currentMap.put(sub, currentMap.get(sub) + 1);
					} else {
						currentMap.put(sub, 1);
					}
					count++;

					while (currentMap.get(sub) > wordsFrequencyMap.get(sub)) {
						String left = s.substring(start, start + len);
						currentMap.put(left, currentMap.get(left) - 1);
						count--;
						start = start + len;
					}

					if (count == words.length) {
						result.add(start);
						// shift right and reset currentMap, count & start point
						String left = s.substring(start, start + len);
						currentMap.put(left, currentMap.get(left) - 1);
						count--;
						start = start + len;
					}
				} else {
					currentMap.clear();
					start = i + len;
					count = 0;
				}
			}
		}
		return result;
	}
}
