package ArrayProlems;

/* Given an array of n elements, and index k, rotate the array to the right by k elements 
 * Example: array = [1,2,3,4,5,6,7], n= 7, k = 3, array after rotate is [5,6,7,1,2,3,4] */

public class ArrayRotate {

	public static void main(String args[]) {
		int[] array_original = {1,2,3,4,5,6,7,8};
		int[] result = new int[array_original.length];
		result = rotateArray1(array_original, 5);
		printElements(result); 

	}

	public static int[] rotateArray1(int[] array, int step) {

		if (step > array.length) {
			step = step % array.length;
		}
		int[] result = new int[array.length];

		for (int i = 0; i < step; i++) {
			result[i] = array[array.length-step+i];
		}
		int j = 0;
		for (int i = step; i < array.length; i++) {
			result[i] = array[j];
			j++;
		}
		return result;
	}
	
	public static void printElements(int[] array){
		
		System.out.println("Result:");
		int index = 0;
		while (index < array.length){
			System.out.print(array[index]+" ");
			index++;
		}
	}
}
