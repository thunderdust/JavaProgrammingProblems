package ArrayProlems;

/* Same as 2 sum problem, just that input array is sorted. */

public class TwoSum_SortedInputArray {

	public static void main(String args[]) {
		int[] numbers = { -3, 2, 7, 8, 11, 15 };
		int target = 4;
		int[] answer = twoSumSorted(numbers, target);
		System.out.println("index1: " + answer[0] + " index2: " + answer[1]);
	}

	public static int[] twoSumSorted(int[] numbers, int target) {
		int head = 0;
		int tail = numbers.length - 1;
		while (head < tail) {
			int sum = numbers[head] + numbers[tail];
			if (sum < target) {
				head++;
			} else if (sum > target) {
				tail--;
			} else {
				return new int[] { head + 1, tail + 1 };
			}
		}
		return null;
	}
}
