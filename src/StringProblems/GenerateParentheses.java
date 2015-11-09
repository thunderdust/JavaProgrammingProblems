package StringProblems;

import java.util.ArrayList;
import java.util.List;

/* Given n pairs of parentheses, write a function to generate all 
 * combinations of well-formed parentheses. 
 * For example, given n = 3, a solution set is:
 * "((()))", "(()())", "(())()", "()(())", "()()()" */

public class GenerateParentheses {

	public static void main(String args[]) {

		int n = 2;
		List<String> validParentheseSet = generateParenthesis(n);
		for (String validParenthese : validParentheseSet) {
			System.out.println(validParenthese);
		}
	}

	public static List<String> validSet = new ArrayList<String>();

	public static List<String> generateParenthesis(int n) {

		validSet.clear();
		
		if (n == 0) {
			return null;
		}

		else if (n == 1) {
			validSet.add("()");
			return validSet;
		}

		else {
			generateValidParenthesis("", 0, n * 2);
			return validSet;
		}
	}

	public static void generateValidParenthesis(String prefix, int count, int requiredLength) {

		// System.out.println("current prefix: " + prefix + "current count:" +
		// count);

		if (count < 0) {
			return;
		} else if (prefix.length() == requiredLength) {
			if (count == 0) {
				validSet.add(prefix);
			}
			return;
		} else {
			generateValidParenthesis(prefix + "(", count + 1, requiredLength);
			if (prefix.length() == 0) {

			} else {
				generateValidParenthesis(prefix + ")", count - 1, requiredLength);
			}
		}
	}
}
