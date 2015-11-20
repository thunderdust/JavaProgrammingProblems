package ArrayProlems;

import java.util.Arrays;

/* Find the kth largest element in an unsorted array. Note that it is the kth largest 
 * element in the sorted order, not the kth distinct element.
 * For example, given [3,2,1,5,6,4] and k = 2, return 5.
 * Note: You may assume k is always valid, 1 ≤ k ≤ array's length. */

public class FindKthLargestElementInUnsortedArray {

	public static void main(String args[]) {

		int[] array = { 2, 3, 4, 2, 1, 0, 32, 25 };
		int k = 4;
		System.out.println("In the array the " + k + "th largest number is: " + findKthLargestArrayUtil(array, k));
		System.out.println("In the array the " + k + "th largest number is: " + findKthLargestQuickSelect(array, k));
	}

	// O(NlogN)
	public static int findKthLargestArrayUtil(int[] nums, int k) {
		Arrays.sort(nums);
		return nums[nums.length - k];
	}

	public static int findKthLargestQuickSelect(int[] nums, int k) {
		if (k < 1 || nums == null) {
			return 0;
		}
		return getKth(nums.length - k + 1, nums, 0, nums.length - 1);
	}

	public static int getKth(int k, int[] nums, int start, int end) {

		int pivot = nums[end];
		int left = start;
		int right = end;
		while (true) {
			while (nums[left] < pivot && left < right) {
				left++;
			}
			while (nums[right] >= pivot && right > left) {
				right--;
			}
			if (left == right) {
				break;
			}
			swap(nums, left, right);
		}
		swap(nums, left, end);
		if (k == left + 1) {
			return pivot;
		} else if (k < left + 1) {
			return getKth(k, nums, start, left - 1);
		} else {
			return getKth(k, nums, left + 1, end);
		}
	}

	public static void swap(int[] nums, int n1, int n2) {
		int tmp = nums[n1];
		nums[n1] = nums[n2];
		nums[n2] = tmp;
	}

}
