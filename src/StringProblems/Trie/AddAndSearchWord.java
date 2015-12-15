package StringProblems.Trie;

import java.util.HashMap;
import java.util.Map;

/* Design a data structure that supports the following two operations:
 * void addWord(word)
 * bool search(word)
 * search(word) can search a literal word or a regular expression string 
 * containing only letters a-z or .. A . means it can represent any one 
 * letter.
 * For example:
 * addWord("bad")
 * addWord("dad")
 * addWord("mad")
 * search("pad") -> false
 * search("bad") -> true
 * search(".ad") -> true
 * search("b..") -> true
 * Note:
 * You may assume that all words are consist of lowercase letters a-z. */

/* This problem is similar with Implement Trie. The solution 1 below uses the 
 * same definition of a trie node. To handle the "." case for this problem, 
 * we need to search all possible paths, instead of one path. */

public class AddAndSearchWord {

	public class WordDictionary {

		private TrieNode root;

		public WordDictionary() {
			root = new TrieNode();
		}

		// Adds a word into the data structure.
		public void addWord(String word) {

			HashMap<Character, TrieNode> children = root.children;
			for (int i = 0; i < word.length(); i++) {

				TrieNode t;
				if (children.containsKey(word.charAt(i))) {
					t = children.get(word.charAt(i));
				} else {
					t = new TrieNode(word.charAt(i));
					children.put(word.charAt(i), t);
				}
				children = t.children;
				// set leaf node
				if (i == word.length() - 1) {
					t.isLeaf = true;
				}
			}
		}

		// Returns if the word is in the data structure. A word could
		// contain the dot character '.' to represent any one letter.
		public boolean search(String word) {
			if (word == null || word.length() == 0) {
				return true;
			} else if (word.length() == 1 && word.equals(".")) {
				// true if root has one child node regardless its character
				return (root.children != null && root.children.values().size() == 1);
			}
			return dfsSearch(root.children, word, 0);
		}

		public boolean dfsSearch(HashMap<Character, TrieNode> children, String word, int start) {
			if (start == word.length()) {
				// search end at a leaf
				if (children.size() == 0) {
					return true;
				} else {
					return false;
				}
			}
			char c = word.charAt(start);
			if (children.containsKey(c)) {
				// last character is found and located at a leaf, means the word
				// is
				// matched
				if (start == word.length() - 1 && children.get(c).isLeaf) {
					return true;
				}
				return dfsSearch(children.get(c).children, word, start + 1);
			}

			else if (c == '.') {
				boolean isFound = false;
				for (Map.Entry<Character, TrieNode> child : children.entrySet()) {
					// word end with '.'
					if (start == word.length() - 1 && child.getValue().isLeaf) {
						return true;
					}
					if (dfsSearch(child.getValue().children, word, start + 1)) {
						isFound = true;
						return isFound;
					}
				}
				return isFound;
			}

			else {
				return false;
			}
		}
	}

	// Your WordDictionary object will be instantiated and called as such:
	// WordDictionary wordDictionary = new WordDictionary();
	// wordDictionary.addWord("word");
	// wordDictionary.search("pattern");

	class TrieNode {
		char c;
		HashMap<Character, TrieNode> children = new HashMap<Character, TrieNode>();
		boolean isLeaf;

		public TrieNode() {
		}

		public TrieNode(char c) {
			this.c = c;
		}
	}

}
