package ArrayProlems;

import java.util.HashSet;

/* Given an array of integers, find if the array contains any duplicates. 
 * Your function should return true if any value appears at least twice 
 * in the array, and it should return false if every element is distinct. */

public class ContainsDuplicate {

	public static void main(String args[]) {
		int[] test = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 11, 12, 13 };
		System.out.println(hasDuplicate(test) ? "Have duplicate" : "No duplicates");
	}

	// Method: HashSet
	public static boolean hasDuplicate(int nums[]) {
		if (nums == null || nums.length == 0)
			return false;

		HashSet<Integer> set = new HashSet<Integer>();
		for (int i : nums) {
			if (!set.add(i)) {
				return true;
			}
		}
		return false;
	}
}
