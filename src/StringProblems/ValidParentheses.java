package StringProblems;

import java.util.HashMap;
import java.util.Stack;

/* Given a string containing just the characters '(', ')', '{', '}', '[' and ']', 
 * determine if the input string is valid. 
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid 
 * but "(]" and "([)]" are not. */

public class ValidParentheses {

	public static void main(String args[]) {

		String s1 = "{}[]()";
		String s2 = "([)]";
		String s3 = "{([])}";

		String result1 = isValid(s1) ? " is a valid parenthese. " : "is NOT valid";
		String result2 = isValid(s2) ? " is a valid parenthese. " : "is NOT valid";
		String result3 = isValid(s3) ? " is a valid parenthese. " : "is NOT valid";
		System.out.println(s1 + result1);
		System.out.println(s2 + result2);
		System.out.println(s3 + result3);
	}

	public static boolean isValid(String s) {

		HashMap<Character, Character> parentheseMap = new HashMap<Character, Character>();
		parentheseMap.put('(', ')');
		parentheseMap.put('{', '}');
		parentheseMap.put('[', ']');
		Stack<Character> stack = new Stack<Character>();

		for (int i = 0; i < s.length(); i++) {
			char current = s.charAt(i);
			// if open bracket
			if (parentheseMap.keySet().contains(current)) {
				stack.push(current);
			}
			// if close bracket
			else if (parentheseMap.values().contains(current)) {
				// if current char is a closing bracket for the last open
				// bracket
				if (!stack.isEmpty() && parentheseMap.get(stack.peek()) == current) {
					// close this bracket by removing the opening bracket from
					// the stack
					stack.pop();
				} else {
					return false;
				}
			}

		}
		return stack.empty();
	}
}
