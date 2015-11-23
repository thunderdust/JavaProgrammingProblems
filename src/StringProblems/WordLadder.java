package StringProblems;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/* Given two words (start and end), and a dictionary, find the 
 * length of shortest transformation sequence from start to end, 
 * such that only one letter can be changed at a time and each 
 * intermediate word must exist in the dictionary. For example, 
 * given:
 * start = "hit"
 * end = "cog"
 * dict = ["hot","dot","dog","lot","log"]
 * One shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog", 
 * the program should return its length 5. */

public class WordLadder {

	class WordNode {
		String word;
		int numSteps;

		public WordNode(String word, int numSteps) {
			this.word = word;
			this.numSteps = numSteps;
		}
	}

	public static void main(String args[]) {

		WordLadder wl = new WordLadder();
		Set<String> wordDict = new HashSet<String>();
		wordDict.add("hot");
		wordDict.add("dot");
		wordDict.add("dog");
		wordDict.add("lot");
		wordDict.add("log");
		String start = "hit";
		String end = "cog";
		System.out.println("Shortest ladder length from " + start + " to " + end + " is: "
				+ wl.ladderLength(start, end, wordDict));
	}

	public int ladderLength(String beginWord, String endWord, Set<String> wordDict) {
		LinkedList<WordNode> queue = new LinkedList<WordNode>();
		queue.add(new WordNode(beginWord, 1));
		wordDict.add(endWord);

		while (!queue.isEmpty()) {
			WordNode top = queue.remove();
			String word = top.word;
			if (word.equals(endWord)) {
				return top.numSteps;
			}
			char[] arr = word.toCharArray();
			// check if current node is one letter away from another
			for (int i = 0; i < arr.length; i++) {
				for (char c = 'a'; c < 'z'; c++) {
					char temp = arr[i];
					if (arr[i] != c) {
						arr[i] = c;
					}
					String newWord = new String(arr);
					if (wordDict.contains(newWord)) {
						queue.add(new WordNode(newWord, top.numSteps + 1));
						wordDict.remove(newWord);
					}
					arr[i] = temp;
				}
			}
		}
		return 0;
	}
}