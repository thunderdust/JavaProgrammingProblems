package ArrayProlems;

/* There are two sorted arrays A and B of size m and n respectively. 
 * Find the median of the two sorted arrays. The overall run time 
 * complexity should be O(log (m+n)). */

public class MedianOfTwoSortedArrays {

	public static void main(String args[]) {

		int[] A = { 1, 2, 3, 7, 12, 19 };
		int[] B = { 3, 8, 9, 10, 15 };
		System.out.println("Median of sorted array A and B is: " + getMedian(A, B));
	}

	public static double getMedian(int[] A, int[] B) {

		int sizeA = A.length;
		int sizeB = B.length;

		if (sizeA == 0) {
			if (sizeB % 2 == 0) {
				int medianIndex = sizeB / 2;
				return (B[medianIndex] + B[medianIndex - 1]) / 2.0;
			} else {
				int medianIndex = (sizeB / 2);
				return B[medianIndex];
			}
		}
		
		if (sizeB == 0) {
			if (sizeA % 2 == 0) {
				int medianIndex = sizeA / 2;
				return (A[medianIndex] + A[medianIndex - 1]) / 2.0;
			} else {
				int medianIndex = (sizeA / 2);
				return A[medianIndex];
			}
		}

		int sizeTotal = sizeA + sizeB;
		int[] newArray = new int[sizeTotal - 1];
		boolean isOdd = (sizeTotal % 2 == 1);
		int medianIndex = (sizeA + sizeB) / 2;
		if (isOdd)
			medianIndex++;
		int count = 0;
		int current = 0;
		int m = sizeA - 1;
		int n = sizeB - 1;
		while (count <= medianIndex) {
			count++;
			if (A[m] > B[n]) {
				current = A[m];
				m--;
			} else {
				current = B[n];
				n--;
			}
			newArray[count] = current;
		}
		if (isOdd)
			return current;
		else {
			int next = Math.max(A[m], B[n]);
			return (current + next) / 2;
		}
	}
}
