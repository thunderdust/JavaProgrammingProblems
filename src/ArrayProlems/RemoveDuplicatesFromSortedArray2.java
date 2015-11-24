package ArrayProlems;

/* Follow up for "Remove Duplicates": What if duplicates are allowed at most twice? 
 * For example, given sorted array A = [1,1,1,2,2,3], your function should return 
 * length = 5, and A is now [1,1,2,2,3]. */

public class RemoveDuplicatesFromSortedArray2 {

	public static int removeDuplicates(int[] A) {
		if (A == null || A.length == 0)
			return 0;
		int pre = A[0];
		// boolean flag to mark if there are already 2 items with same value
		boolean alreadyDuplicate = false;
		// count for value appears more than 2 times
		int count = 0;
		// index for updating
		int o = 1;
		for (int i = 1; i < A.length; i++) {
			int curr = A[i];
			if (curr == pre) {
				if (!alreadyDuplicate) {
					alreadyDuplicate = true;
					A[o++] = curr;
					continue;
				} else {
					// already 2 same value appeared, count this one
					count++;
				}
			} else {
				pre = curr;
				A[o++] = curr;
				alreadyDuplicate = false;
			}
		}
		return A.length - count;
	}

	public static int removeDuplicatesBetter(int[] nums) {
		if (nums.length <= 2) {
			return nums.length;
		}
		int prev = 1;
		int curr = 2;
		while (curr < nums.length) {
			// consecutive 3 duplicates
			if (nums[curr] == nums[prev] && nums[curr] == nums[prev - 1]) {
				curr++;
			} else {
				prev++;
				nums[prev] = nums[curr];
				curr++;
			}
		}
		return prev + 1;
	}

	public static void main(String args[]) {
		int[] test = { 1, 1, 1, 2, 2, 3 };
		System.out.println(removeDuplicates(test));
		int[] test2 = { 1, 1, 1, 2, 2, 3 };
		System.out.println(removeDuplicatesBetter(test2));
	}
}
