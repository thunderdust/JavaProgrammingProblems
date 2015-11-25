package ArrayProlems;

/* Given an array of n positive integers and a positive integer s, find 
 * the minimal length of a subarray of which the sum ≥ s. If there isn't 
 * one, return 0 instead. For example, given the array [2,3,1,2,4,3] and 
 * s = 7, the subarray [4,3] has the minimal length of 2 under the problem 
 * constraint. */

public class MinimumSizeSubarraySum {

	public int minSubArrayLen(int s, int[] nums) {

		if (nums == null || nums.length == 0) {
			return 0;
		}
		// initialize min length to be the input array length
		int result = nums.length;
		int left = 0;
		int sum = nums[0];
		for (int right = 0; right < nums.length;) {
			if (left == right) {
				if (nums[left] >= s) {
					return 1; // single element is big enough
				} else {
					right++;
					if (right < nums.length) {
						sum += nums[right];
					} else {
						return result;
					}
				}
			} else {
				// if sum is large enough, move left cursor
				if (sum >= s) {
					result = Math.min(right - left + 1, result);
					sum -= nums[left];
					left++;
				}
				// if sum is not enough, move right cursor
				else {
					right++;
					if (right < nums.length) {
						sum += nums[right];
					} else {
						// No result found
						if (left == 0) {
							return 0;
						}
						// Return the best result
						else {
							return result;
						}
					}
				}
			}
		}
		return result;
	}
}
