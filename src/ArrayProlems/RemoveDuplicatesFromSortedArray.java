package ArrayProlems;

import java.util.Arrays;

/* Given a sorted array, remove the duplicates in place such that each element appear 
 * only once and return the new length. Do not allocate extra space for another array, 
 * you must do this in place with constant memory.
 * For example, given input array A = [1,1,2], your function should return length = 2, 
 * and A is now [1,2]. */

public class RemoveDuplicatesFromSortedArray {

	public static void main(String args[]) {

		int[] arr = { 1, 2, 2, 3, 3 };
		int length = removeDuplicates(arr);
		int length2 = countUnique(arr);
		System.out.println(length);
		System.out.println(length2);

	}

	public static int removeDuplicates(int[] A) {

		if (A.length < 2)
			return A.length;

		int j = 0;
		int i = 1;

		while (i < A.length) {
			if (A[i] == A[j]) {
				i++;
			} else {
				j++;
				A[j] = A[i];
				i++;
			}
		}
		int[] B = Arrays.copyOf(A, j + 1);
		return B.length;
	}

	/*
	 * If we only want to count the number of unique elements, the following
	 * method is good enough.
	 */
	public static int countUnique(int[] A) {
		int count = 0;
		for (int i = 0; i < A.length - 1; i++) {
			if (A[i] == A[i + 1]) {
				count++;
			}
		}
		return (A.length - count);
	}

}
