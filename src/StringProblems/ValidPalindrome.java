package StringProblems;

import java.util.Stack;

/* Upgrade versio of CheckPalindrome.
 * Given a string, determine if it is 
 * a palindrome, considering only alphanumeric 
 * characters and ignoring cases.
 * For example, "A man, a plan, a canal: Panama" 
 * is a palindrome. "race a car" is not a palindrome.*/

public class ValidPalindrome {

	public static void main(String args[]) {

		String sample1 = "Red rum, sir, is murder";
		String sample2 = "Programcreek is awesome";
		String sample3 = "A man, a plan, a canal: Panama";

		if (isPalindrome(sample1)) {
			System.out.println("Palindrome");
		} else {
			System.out.println("NOT Palindrome");
		}

		if (isPalindrome(sample2)) {
			System.out.println("Palindrome");
		} else {
			System.out.println("NOT Palindrome");
		}

		if (isPalindrome(sample3)) {
			System.out.println("Palindrome");
		} else {
			System.out.println("NOT Palindrome");
		}

		if (isPalindrome2(sample1)) {
			System.out.println("Palindrome");
		} else {
			System.out.println("NOT Palindrome");
		}

		if (isPalindrome2(sample2)) {
			System.out.println("Palindrome");
		} else {
			System.out.println("NOT Palindrome");
		}

		if (isPalindrome2(sample3)) {
			System.out.println("Palindrome");
		} else {
			System.out.println("NOT Palindrome");
		}
	}

	// Pre-process: remove non-alphanumeric letters, unify case
	public static String parse(String s) {

		return s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
	}

	// Use 2 pointers
	public static boolean isPalindrome(String s) {
		if (s == null || s.length() == 1 || s.trim().length() == 0) {
			return true;
		}
		s = parse(s);
		int length = s.length();
		int x = 0, y = length - 1;
		while (x < y) {
			if (s.charAt(x) == s.charAt(y)) {
				x++;
				y--;
			} else {
				return false;
			}
		}
		return true;
	}

	// Use stack
	public static boolean isPalindrome2(String s) {
		if (s == null || s.length() == 1 || s.trim().length() == 0) {
			return true;
		}
		s = parse(s);
		int length = s.length();
		Stack<Character> stack = new Stack<Character>();
		int pointer = 0;
		while (pointer < length / 2) {
			stack.push(s.charAt(pointer));
			pointer++;
		}
		if (length % 2 == 1) {
			pointer++;
		}
		while (pointer < length) {
			if (stack.empty()) {
				return false;
			} else {
				if (s.charAt(pointer) != stack.pop()) {
					return false;
				} else {
					pointer++;
				}
			}
		}
		return true;
	}
}
