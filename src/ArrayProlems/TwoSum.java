package ArrayProlems;

import java.util.HashMap;

/* Given an array of integers, find two numbers such that they 
 * add up to a specific target number.The function twoSum should 
 * return indices of the two numbers such that they add up to the 
 * target, where index1 must be less than index2. Please note that 
 * your returned answers (both index1 and index2) are not zero-based.
 * For example: 
 * Input: numbers={2, 7, 11, 15}, target=9
 * Output: index1=1, index2=2 */

public class TwoSum {

	public static void main(String args[]) {
		int[] numbers = { 2, 7, 11, 15, -3, 2, 8 };
		int target = -1;
		int[] answer = twoSum(numbers, target);
		System.out.println("index1: " + answer[0] + " index2: " + answer[1]);
	}

	public static int[] twoSum(int[] numbers, int target) {

		// Key=difference of a element from target, value=index of the element
		HashMap<Integer, Integer> sumMap = new HashMap<Integer, Integer>();
		int[] result = new int[2];
		for (int i = 0; i < numbers.length; i++) {
			if (sumMap.containsKey(numbers[i])) {
				int index = sumMap.get(numbers[i]);
				// index will always <= i
				result[0] = index + 1;
				result[1] = i + 1;
				break;
			} else {
				sumMap.put(target - numbers[i], i);
			}
		}
		return result;
	}

}
