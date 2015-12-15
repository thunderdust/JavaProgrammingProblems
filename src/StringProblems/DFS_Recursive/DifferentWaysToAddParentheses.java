package StringProblems.DFS_Recursive;

import java.util.ArrayList;
import java.util.List;

/* Given a string of numbers and operators, return all possible results from computing
 * all the different possible ways to group numbers and operators. The valid operators 
 * are +, - and *.
 * Example 1
 * Input: "2-1-1".
 * ((2-1)-1) = 0
 * (2-(1-1)) = 2
 * Output: [0, 2]
 * 
 * Example 2
 * Input: "2*3-4*5"
 * (2*(3-(4*5))) = -34
 * ((2*3)-(4*5)) = -14
 * ((2*(3-4))*5) = -10
 * (2*((3-4)*5)) = -10
 * (((2*3)-4)*5) = 10
 * Output: [-34, -14, -10, -10, 10] */

public class DifferentWaysToAddParentheses {

	public List<Integer> diffWaysToCompute(String input) {

		ArrayList<Integer> results = new ArrayList<Integer>();
		for (int i = 0; i < input.length(); i++) {
			char currentChar = input.charAt(i);
			// Divide by operator positions
			if (currentChar == '+' || currentChar == '-' || currentChar == '*') {
				ArrayList<Integer> leftRes = (ArrayList<Integer>) diffWaysToCompute(input.substring(0, i));
				ArrayList<Integer> rightRes = (ArrayList<Integer>) diffWaysToCompute(input.substring(i + 1));
				for (int m = 0; m < leftRes.size(); m++) {
					for (int n = 0; n < rightRes.size(); n++) {
						if (currentChar == '+') {
							results.add(leftRes.get(m) + rightRes.get(n));
						} else if (currentChar == '-') {
							results.add(leftRes.get(m) - rightRes.get(n));
						} else {
							results.add(leftRes.get(m) * rightRes.get(n));
						}
					}
				}
			}
		}
		if (results.isEmpty())
			results.add(Integer.parseInt(input));
		return results;
	}

}