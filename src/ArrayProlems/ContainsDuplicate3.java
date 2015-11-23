package ArrayProlems;

import java.util.SortedSet;
import java.util.TreeSet;

/* Given an array of integers, find out whether there are two distinct indices 
 * i and j in the array such that the difference between nums[i] and nums[j] 
 * is at most t and the difference between i and j is at most k. */

public class ContainsDuplicate3 {

	/*
	 * Method 1: Using a treeset. Add/remove/contains takes O(Log(N)), but the
	 * element inside is sorted. It offers several methods to deal with the
	 * ordered set like first(), last(), headSet(), tailSet(), etc. Time
	 * Complexity: O(nLog(k))
	 */
	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		if (k < 1 || t < 0)
			return false;
		TreeSet<Integer> set = new TreeSet<Integer>();
		for (int i = 0; i < nums.length; i++) {
			int current = nums[i];
			// if the diff between one item and its floor/ceiling item <= t,
			if ((set.floor(current) != null && current <= set.floor(current) + t)
					|| (set.ceiling(current) != null && current >= set.ceiling(current) - t))
				return true;
			set.add(current);
			if (i >= k)
				set.remove(nums[i - k]);
		}
		return false;
	}

	public boolean containsNearbyAlmostDuplicate2(int[] nums, int k, int t) {
		if (k < 1 || t < 0)
			return false;
		SortedSet<Long> set = new TreeSet<Long>();
		for (int i = 0; i < nums.length; i++) {
			long leftBound = (long) nums[i] - t;
			long rightBound = (long) nums[i] + t + 1;
			SortedSet<Long> subSet = set.subSet(leftBound, rightBound);

			if (!subSet.isEmpty()) {
				return true;
			}
			set.add((long) nums[i]);
			if (i >= k) {
				set.remove((long) nums[i - k]);
			}
		}
		return false;
	}
}
