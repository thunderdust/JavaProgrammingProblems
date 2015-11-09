package ArrayProlems;

/* Given two sorted integer arrays A with size m, and B with size n, 
 * merge B into A as one sorted array. */

public class MergeTwoSortedArray {

	public static void main(String args[]) {

		int m = 6, n = 3;
		int[] A = new int[m + n];
		A[0] = 1;
		A[1] = 3;
		A[2] = 5;
		A[3] = 10;
		A[4] = 14;
		A[5] = 30;
		int[] B = { 2, 8, 22 };
		merge2(A, m, B, n);

		for (int item : A) {
			System.out.print(item + " ");
		}
	}

	public static void merge(int A[], int m, int B[], int n) {

		while (m > 0 && n > 0) {
			// Compare current biggest from 2 arrays
			if (A[m - 1] > B[n - 1]) {
				A[m + n - 1] = A[m - 1];
				m--;
			} else {
				A[m + n - 1] = B[n - 1];
				n--;
			}
		}

		while (n > 0) {
			A[m + n - 1] = B[n - 1];
			n--;
		}
	}

	// Solution 2: another loop condition
	public static void merge2(int A[], int m, int B[], int n) {
		int endA = m - 1;
		int endB = n - 1;
		int endAll = m + n - 1;

		while (endAll >= 0) {
			if (endB < 0 || (endA > 0 && A[endA] > B[endB])) {
				A[endAll--] = A[endA--];
			} else {
				A[endAll--] = B[endB--];
			}
		}
	}
}
