package ArrayProlems;

/* Given an array of n elements, and index k, rotate the array to the right by k elements 
 * Example: array = [1,2,3,4,5,6,7], n= 7, k = 3, array after rotate is [5,6,7,1,2,3,4] */

public class ArrayRotate {

	public static void main(String args[]) {
		int[] array_original = { 1, 2, 3, 4, 5, 6, 7, 8 };
		int steps = 2;
		printElements(bubbleRotate(array_original, steps));
		reset(array_original);
		printElements(rotateWithOffset(array_original, steps));
		reset(array_original);
		printElements(reversalRotate(array_original, steps));
	}

	private static void reset(int[] array) {
		for (int i = 0; i < array.length; i++) {
			array[i] = i + 1;
		}
	}

	// Like a bubble sort. Time O(n*k), space O(1)
	public static int[] bubbleRotate(int[] array, int step) {

		if (array.length == 0 || array.length == 1 || array != null && step == 0) {
			return array;
		}
		if (array == null || step < 0) {
			throw new IllegalArgumentException("Illegal argument!");
		}

		if (step > array.length) {
			step = step % array.length;
		}

		for (int i = 0; i < step; i++) {
			for (int j = array.length - 1; j > 0; j--) {
				int temp = array[j];
				array[j] = array[j - 1];
				array[j - 1] = temp;
			}
		}
		return array;
	}

	public static int[] rotateWithOffset(int[] array, int step) {

		if (array.length == 0 || array.length == 1 || array != null && step == 0) {
			return array;
		}
		if (array == null || step < 0) {
			throw new IllegalArgumentException("Illegal argument!");
		}

		if (step > array.length) {
			step = step % array.length;
		}

		int size = array.length;
		int[] afterRotate = new int[size];
		for (int i = 0; i < size; i++) {
			afterRotate[(i + step) % size] = array[i];
		}
		return afterRotate;
	}

	// Time O(n), space O(1)
	public static int[] reversalRotate(int[] array, int step) {

		if (array.length == 0 || array.length == 1 || array != null && step == 0) {
			return array;
		}
		if (array == null || step < 0) {
			throw new IllegalArgumentException("Illegal argument!");
		}

		if (step > array.length) {
			step = step % array.length;
		}

		reverse(array, 0, array.length - 1);
		reverse(array, 0, step - 1);
		reverse(array, step, array.length - 1);
		/*
		 * IF put reverse whole array at last, the rotate direction will be
		 * opposite (anti-clockwise); Can deal with NEGATIVE reverse steps
		 */
		return array;
	}

	public static void reverse(int[] array, int start, int end) {
		if (array == null || array.length == 1) {
			return;
		} else {
			while (start < end) {
				int temp = array[start];
				array[start] = array[end];
				array[end] = temp;
				start++;
				end--;
			}
		}
	}

	public static void printElements(int[] array) {

		System.out.println("Result:");
		int index = 0;
		while (index < array.length) {
			System.out.print(array[index] + " ");
			index++;
		}
		System.out.println();
	}
}
