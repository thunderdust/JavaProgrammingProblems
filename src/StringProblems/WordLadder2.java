package StringProblems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/* Given two words (start and end), and a dictionary, find all shortest transformation sequence(s) 
 * from start to end, such that: 1) Only one letter can be changed at a time, 2) Each intermediate 
 * word must exist in the dictionary.
 * For example, given: start = "hit", end = "cog", and dict = ["hot","dot","dog","lot","log"], return:
 * [
 *   ["hit","hot","dot","dog","cog"],
     ["hit","hot","lot","log","cog"]
   ] */

public class WordLadder2 {

	class WordNode {
		String word;
		int numSteps;
		WordNode pre;

		public WordNode(String word, int numSteps, WordNode pre) {
			this.word = word;
			this.numSteps = numSteps;
			this.pre = pre;
		}
	}

	public static void main(String args[]) {

	}

	public List<List<String>> findLadders(String start, String end, Set<String> dict) {
		List<List<String>> result = new ArrayList<List<String>>();
		LinkedList<WordNode> queue = new LinkedList<WordNode>();
		queue.add(new WordNode(start, 1, null));
		dict.add(end);
		int minStep = 0;

		HashSet<String> visited = new HashSet<String>();
		HashSet<String> unvisited = new HashSet<String>();
		unvisited.addAll(dict);

		int preNumSteps = 0;

		while (!queue.isEmpty()) {
			WordNode top = queue.remove();
			String word = top.word;
			int currentNumSteps = top.numSteps;

			if (word.equals(end)) {
				if (minStep != 0) {
					minStep = currentNumSteps;
				}
				if (top.numSteps == minStep && minStep != 0) {
					ArrayList<String> route = new ArrayList<String>();
					route.add(top.word);
					// Tracing back, build the word ladder
					while (top.pre != null) {
						route.add(0, top.pre.word);
						top = top.pre;
					}
					result.add(route);
					continue;
				}
			}
			if (preNumSteps < currentNumSteps) {
				unvisited.removeAll(visited);
			}
			preNumSteps = currentNumSteps;
			char[] arr = word.toCharArray();
			for (int i = 0; i < arr.length; i++) {
				for (char c = 'a'; c <= 'z'; c++) {
					char temp = arr[i];
					if (arr[i] != c) {
						arr[i] = c;
					}

					String newWord = new String(arr);
					if (unvisited.contains(newWord)) {
						queue.add(new WordNode(newWord, top.numSteps + 1, top));
						visited.add(newWord);
					}

					arr[i] = temp;
				}
			}
		}
	}
}
