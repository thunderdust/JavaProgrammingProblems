package ArrayProlems;

import java.util.Stack;

/* Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * Valid operators are +, -, *, /. Each operand may be an integer or another
 * expression. For example:
 * 
	  ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
	  ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
   Given an array of elements in such notation, return the result calculated
*/

public class ReversePolishNotationCalculator {

	public static void main(String args[]) {
		String[] tokens = new String[] { "2", "1", "+", "3", "*" };
		String[] tokens2 = new String[] { "4", "13", "5", "/", "+" };
		System.out.println(calculate(tokens));
		System.out.println(calculate(tokens2));
	}

	public static int calculate(String tokens[]) {

		String operators = "+-*/";
		Stack<String> stack = new Stack<String>();
		for (String t : tokens) {
			// current token is a operator
			if (operators.contains(t)) {
				int a = Integer.valueOf(stack.pop());
				int b = Integer.valueOf(stack.pop());
				int index = operators.indexOf(t);
				switch (index) {
				case 0:
					stack.push(Integer.toString(a + b));
					break;
				case 1:
					stack.push(Integer.toString(b - a));
					break;
				case 2:
					stack.push(Integer.toString(a * b));
					break;
				case 3:
					stack.push(Integer.toString(b / a));
					break;
				}
			}
			// current token is number
			else {
				stack.push(t);
			}
		}
		return Integer.valueOf(stack.pop());
	}
}
