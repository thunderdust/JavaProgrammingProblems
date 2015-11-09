package StringProblems;

import java.util.Stack;

/* Given a string containing just the characters '(' and ')', find the length 
 * of the longest valid (well-formed) parentheses substring.
 * For "(()", the longest valid parentheses substring is "()", which has length = 2.
 * Another example is ")()())", where the longest valid parentheses substring is "()()", 
 * which has length = 4. */

public class LongestValidParentheses {

	public static void main(String args[]) {

		String sample = ")()())";
		String sample2 = "(()";
		String sample3 = ")(";

		System.out.println(longestValidParentheses(sample));
		System.out.println(longestValidParentheses(sample2));
		System.out.println(longestValidParentheses(sample3));

		System.out.println(longestValidParentheses2(sample));
		System.out.println(longestValidParentheses2(sample2));
		System.out.println(longestValidParentheses2(sample3));
	}

	// O(n^2)
	public static int longestValidParentheses(String s) {

		if (s.length() == 0 || s.length() == 1) {
			return 0;
		}

		if (s.length() == 2 && s.equals("()")) {
			return 2;
		} else if (s.length() == 2 && s.equals(")(")) {
			return 0;
		}

		int maxLen = 0;
		for (int i = 0; i < s.length(); i++) {
			int count = 0;
			int currentValidLength = 0;
			for (int k = i; k < s.length(); k++) {
				if (s.charAt(k) == '(') {
					count++;
				} else if (s.charAt(k) == ')') {
					count--;
				}
				if (count < 0) {
					break;
				} else if (count == 0) {
					currentValidLength = k - i + 1;
				} else {
				}
			}
			if (currentValidLength > maxLen)
				maxLen = currentValidLength;
		}
		return maxLen;
	}

	// O(n)
	public static int longestValidParentheses2(String s) {

		if (s.length() == 0 || s.length() == 1) {
			return 0;
		}

		if (s.length() == 2 && s.equals("()")) {
			return 2;
		} else if (s.length() == 2 && s.equals(")(")) {
			return 0;
		}

		Stack<int[]> stack = new Stack<int[]>();
		int result = 0;

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			// Open bracket: push to stack
			if (c == '(') {
				// i is the position, 0 for open
				int[] a = { i, 0 };
				stack.push(a);
			}
			// Close bracket
			else {
				// if no open bracket to close
				if (stack.isEmpty() || stack.peek()[1] == 1) {
					int[] a = { i, 1 };
					stack.push(a);
				}
				// combine this close bracket with the open bracket
				// and update the longest parenthese length
				else {
					int currentLen = 0;
					stack.pop();
					// All brackets closed. A valid parenthese
					if (stack.empty()) {
						// because i starts at 0
						currentLen = i + 1;
					}
					// Still have open bracket
					// current longest length = distance from here to the
					// nearest open bracket
					else {
						currentLen = i - stack.peek()[0];
					}
					result = Math.max(result, currentLen);
				}
			}
		}
		return result;
	}
}
