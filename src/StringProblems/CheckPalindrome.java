package StringProblems;
import java.util.Scanner;

/* Check if a given string is palindrome */

public class CheckPalindrome {

	public static void main(String args[]) {
		System.out.println("Please enter a string");
		Scanner sc = new Scanner(System.in);
		String sample = sc.nextLine();

		System.out.println("By method 1>");
		if (isPalindrome1(sample)) {
			System.out.println(sample + " is palindrome.");
		} else {
			System.out.println(sample + " is not palindrome");
		}

		System.out.println("By method 2>");
		if (isPalindrome2(sample)) {
			System.out.println(sample + " is palindrome.");
		} else {
			System.out.println(sample + " is not palindrome");
		}

		System.out.println("By method 3>");
		if (isPalindrome3(sample)) {
			System.out.println(sample + " is palindrome.");
		} else {
			System.out.println(sample + " is not palindrome");
		}
	}

	// Method 1: with reverse function O(n)
	public static boolean isPalindrome1(String sample) {
		if (sample.length() == 0 || sample.length() == 1 || sample.trim().length() == 0) {
			return true;
		}

		else {
			StringBuffer sb = new StringBuffer(sample).reverse();
			String reversedSample = sb.toString();
			if (sample.compareTo(reversedSample) == 0) {
				return true;
			} else {
				return false;
			}
		}
	}

	// Method 2: Without extra class or data structure O(n)
	public static boolean isPalindrome2(String sample) {

		if (sample.length() == 0 || sample.length() == 1 || sample.trim().length() == 0) {
			return true;
		}

		else {
			int x = 0, y = sample.length() - 1;
			while (x < y) {
				if (sample.charAt(x) == sample.charAt(y)) {
					x++;
					y--;
				} else {
					return false;
				}
			}
			return true;
		}
	}

	// Method 3: Recursive
	public static boolean isPalindrome3(String sample) {

		if (sample.length() == 0 || sample.length() == 1 || sample.trim().length() == 0)
			return true;
		if (sample.charAt(0) == sample.charAt(sample.length() - 1)) {
			return isPalindrome3(sample.substring(1, sample.length() - 1));
		} else
			return false;
	}

}
