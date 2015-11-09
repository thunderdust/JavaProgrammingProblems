package ArrayProlems;

/* Given a sorted array, remove the duplicates in place such that each element appear 
 * only once and return the new length. Do not allocate extra space for another array, 
 * you must do this in place with constant memory.
 * For example, given input array A = [1,1,2], your function should return length = 2, 
 * and A is now [1,2]. */

public class RemoveDuplicatesFromSortedArray {

	public static void main(String args[]) {

	}

	public static int[] removeDuplicates(int[] A) {
		if (A.length < 2) {
			return A;
		}
		int current = 0;
		int next = current + 1;
		while (next < A.length) {
			if (A[current] == A[next]) {
				next++;
			}
			else {
				current ++;
				A[current] = A[next];
				next ++;
			}
		}
	}
}
