package ArrayProlems;

/* Given a sorted array of integers, find the starting and ending position 
 * of a given target value. Your algorithm's runtime complexity must be in 
 * the order of O(log n). If the target is not found in the array, return 
 * [-1, -1]. For example, given [5, 7, 7, 8, 8, 10] and target value 8, 
 * return [3, 4]. */

public class SearchForARange {

	public static void main(String args[]) {
		int[] test = { 5, 7, 7, 8, 8, 8, 10 };
		int[] result = new int[2];
		int target = 8;
		result = searchRange(test, target);
		for (Integer index : result) {
			System.out.print(index + " ");
		}
	}

	public static int[] searchRange(int[] nums, int target) {

		if (nums.length == 0 || nums == null) {
			return null;
		}

		int[] result = new int[2];
		result[0] = -1;
		result[1] = -1;

		if (nums.length == 1) {

			if (nums[0] == target) {
				result[0] = 0;
				result[1] = 0;
				return result;
			} else {
				return result;
			}
		}

		binarySearch(nums, target, result, 0, nums.length - 1);
		return result;
	}

	public static void binarySearch(int[] nums, int target, int[] result, int left, int right) {
		if (right < left)
			return;
		if (nums[left] == nums[right] && nums[left] == target) {
			result[0] = left;
			result[1] = right;
			return;
		}
		int mid = left + (right - left) / 2;

		if (nums[mid] < target) {
			binarySearch(nums, target, result, mid + 1, right);
		} else if (nums[mid] > target) {
			binarySearch(nums, target, result, left, mid - 1);
		} else {
			result[0] = mid;
			result[1] = mid;
			int pointer1 = mid;
			while (pointer1 >= left && nums[pointer1] == target) {
				result[0] = pointer1;
				pointer1--;
			}

			int pointer2 = mid;
			while (pointer2 <= right && nums[pointer2] == target) {
				result[1] = pointer2;
				pointer2++;
			}
			return;
		}
	}
}
