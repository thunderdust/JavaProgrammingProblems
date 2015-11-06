package ArrayProlems;

import java.util.HashSet;

/* Given an unsorted array of integers, find the
 * LENGTH of the longest consecutive elements sequence.
 * For example, given [100, 4, 200, 1, 3, 2], the 
 * longest consecutive elements sequence should be 
 * [1, 2, 3, 4]. Its length is 4. Your algorithm 
 * should run in O(n) complexity. */

public class LongestConsecutiveSequence {

	public static void main(String args[]) {
		int[] numbers = { 100, 4, 200, 1, 3, 2 };
		System.out.println("Longest consecutive sequence length: " + getLongestConsecutiveSeqLength(numbers));
	}

	public static int getLongestConsecutiveSeqLength(int[] numbers) {

		if (numbers == null) {
			return 0;
		} else if (numbers.length == 1) {
			return 1;
		}

		HashSet<Integer> numberSet = new HashSet<Integer>();
		int maxLength = 1;

		// O(n)
		for (int number : numbers) {
			numberSet.add(number);
		}
        // O(n)
		for (int number : numbers) {
			int left = number - 1;
			int right = number + 1;
			int count = 1;
            // O(1)
			while (numberSet.contains(left)) {
				count++;
				numberSet.remove(left);
				left--;
			}
            // O(1)
			while (numberSet.contains(right)) {
				count++;
				numberSet.remove(right);
				right++;
			}
			maxLength = Math.max(maxLength, count);
		}
		return maxLength;
	}
}
