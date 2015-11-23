package StringProblems;

/* Given a string S, you are allowed to convert it to a palindrome by adding characters in 
 * front of it. Find and return the shortest palindrome you can find by performing this 
 * transformation. For example: 
 * Given "aacecaaa", return "aaacecaaa".
 * Given "abcd", return "dcbabcd". */

public class ShortestPalindrome {

	public static void main(String args[]) {

		String test1 = "aacecaaa";
		String test2 = "abcd";
		String test3 = "aba";

		System.out.println(buildShortestPalindrome(test1));
		System.out.println(buildShortestPalindrome(test2));
		System.out.println(buildShortestPalindrome(test3));
	}

	public static boolean isPalindrome(String s) {
		if (s == null || s.length() == 1 || s.trim().length() == 0) {
			return true;
		}
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

	/*
	 * Method 1: check the longest palindrome starts from head, reverse the
	 * rest, append the revered string to head of original string to build a
	 * palindrome. Gets TIME OUT in leetcode.
	 */

	public static String getShortestPalindrome(String s) {

		if (s.isEmpty() || s.length() == 1) {
			return s;
		}
		if (isPalindrome(s)) {
			return s;
		}
		int pointer = s.length() - 1;
		while (pointer >= 0) {
			String sub = s.substring(0, pointer);
			if (isPalindrome(sub)) {
				String palindromePart = sub;
				String unPalindromePartReversed = new StringBuilder(s.substring(pointer)).reverse().toString();
				String newPalindrome = unPalindromePartReversed + s;
				return newPalindrome;
			}
			pointer--;
		}
		return null;
	}

	/*
	 * Method 2: TIME OUT
	 */
	public static String buildShortestPalindrome(String s) {
		if (s.isEmpty() || s.length() == 1) {
			return s;
		}
		if (isPalindrome(s)) {
			return s;
		}
		int pointer = s.length() - 1;
		while (pointer >= 0) {
			String prefix = new StringBuilder(s.substring(pointer)).reverse().toString();
			String newStr = prefix + s;
			if (isPalindrome(newStr)) {
				return newStr;
			}
			pointer--;

		}
		return null;
	}
}
