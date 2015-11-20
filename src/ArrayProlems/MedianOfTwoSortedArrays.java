package ArrayProlems;

/* There are two sorted arrays A and B of size m and n respectively. 
 * Find the median of the two sorted arrays. The overall run time 
 * complexity should be O(log (m+n)). */

public class MedianOfTwoSortedArrays {

	public static void main(String args[]) {

		int[] A = { 1 };
		int[] B = { 1 };
		int totalSize = A.length + B.length;
		double median;
		// Find median based on odd/even
		if (totalSize % 2 == 1) {
			median = findKth(A, A.length, B, B.length, totalSize / 2 + 1);
		} else {
			median = (findKth(A, A.length, B, B.length, totalSize / 2 + 1)
					+ findKth(A, A.length, B, B.length, totalSize / 2)) / 2.0;
		}
		System.out.println("Median of sorted array A and B is: " + median);
	}

	public static double findKth(int a[], int m, int b[], int n, int k) {
		// always assume that m<= n
		if (m > n)
			return findKth(b, n, a, m, k);
		if (m == 0)
			return b[k - 1];
		if (k == 1)
			return Math.min(a[0], b[0]);
		// divide K into 2 parts
		int numberA = Math.min(k / 2, m), numberB = k - numberA;

		// first numberA number of elements from array a is less than K, remove
		// them from the search
		if (a[numberA - 1] < b[numberB - 1]) {
			int[] cropedA = arrayCrop(a, numberA);
			return findKth(cropedA, m - numberA, b, n, k - numberA);
		}
		// first numberB of elements from array b is less than K, remove them
		// from the search
		else if (a[numberA - 1] > b[numberB - 1]) {
			int[] cropedB = arrayCrop(b, numberB);
			return findKth(a, m, cropedB, n - numberB, k - numberB);
		} else
			return a[numberA - 1];
	}

	private static int[] arrayCrop(int originalArray[], int cropSize) {
		int newSize = originalArray.length - cropSize;
		int[] newArray = new int[newSize];
		for (int i = 0; i < newSize; i++) {
			newArray[i] = originalArray[i + cropSize];
		}
		return newArray;
	}
}
