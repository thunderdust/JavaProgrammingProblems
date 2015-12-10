package ArrayProlems;

/* Given a sorted array of integers, find the starting and ending position 
 * of a given target value. Your algorithm's runtime complexity must be in 
 * the order of O(log n). If the target is not found in the array, return 
 * [-1, -1]. For example, given [5, 7, 7, 8, 8, 10] and target value 8, 
 * return [3, 4]. */

public class SearchForARange {

	public static void main(String args[]) {
		int[] test = { 5, 7, 7, 8, 8, 10 };
		int[] result = new int[2];
		int target = 8;
		result = searchRange(test, target);
		for (Integer index : result) {
			System.out.print(index+" ");
		}
	}

	public static int[] searchRange(int[] nums, int target) {

		if (nums.length == 0 || nums == null) {
			return null;
		}

		return binarySearch(nums, target);
	}

	public static int[] binarySearch(int[] nums, int target) {

		int startIndex = (nums.length - 1) / 2;
		int[] result = new int[2];
		while (startIndex >= 0 && startIndex < nums.length) {
			if (nums[startIndex] == target) {
				int pointer1 = startIndex;
				int pointer2 = startIndex;

				while (pointer1 >= 0 && nums[pointer1] == target) {
					pointer1--;
				}
				result[0] = pointer1 + 1;

				while (pointer2 < nums.length && nums[pointer2] == target) {
					pointer1++;
				}
				result[1] = pointer2 - 1;
				return result;
			} else if (nums[startIndex] > target) {
				startIndex = (startIndex + nums.length - 1) / 2;
			} else if (nums[startIndex] < target) {
				startIndex = startIndex / 2;
			}
		}
		result[0] = result[1] = -1;
		return result;
	}
}
