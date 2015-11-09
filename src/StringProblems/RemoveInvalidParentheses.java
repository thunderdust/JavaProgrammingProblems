package StringProblems;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class RemoveInvalidParentheses {
	
	
	public static List<String> removeInvalidParentheses(String s){
		return null;
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
			else {
				// other characters
			}
		}
		return stack.empty();
	}
}
