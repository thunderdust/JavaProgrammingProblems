package ArrayProlems;

/* There are two sorted arrays A and B of size m and n respectively. 
 * Find the median of the two sorted arrays. The overall run time 
 * complexity should be O(log (m+n)). */

public class MedianOfTwoSortedArrays {

	public static void main(String args[]) {

		int[] A = { 1 };
		int[] B = { 1 };
		System.out.println("Median of sorted array A and B is: " + getMedian(A, B));
	}

	// Find the kth element from 2 sorted array
	public static int findKth(int A[], int B[], int k, int aStart, int aEnd, int bStart, int bEnd) {

		int aLen = aEnd - aStart + 1;
		int bLen = bEnd - bStart + 1;
		// Special cases
		if (aLen == 0) {
			return B[bStart + k];
		}
		if (bLen == 0) {
			return A[aStart + k];
		}
		if (k == 0) {
			return Math.max(A[aStart], B[bStart]);
		}
		
		int aMid = aLen*k / (aLen + bLen);

	}
}
