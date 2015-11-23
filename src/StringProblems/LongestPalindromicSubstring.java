package StringProblems;

/* Given a string S, find the longest palindromic substring in S. You may assume that 
 * the maximum length of S is 1000, and there exists one unique longest palindromic substring */

public class LongestPalindromicSubstring {

	public static void main(String args[]) {

		String test = "longesttsegdhsajkdsahfkjas";
		String LPS = longestPalindrome(test);
		System.out.println("Longest palindromic substring for " + test + " is: " + LPS);

	}

	public static String longestPalindrome(String s) {
		if (s.isEmpty() || s.length() == 1) {
			return s;
		}
		String longest = s.substring(0, 1);
		for (int i = 0; i < s.length(); i++) {
			String tempLongest1 = getLongestFromCenter(s, i, i);
			if (tempLongest1.length() > longest.length()) {
				longest = tempLongest1;
			}

			String tempLongest2 = getLongestFromCenter(s, i, i + 1);
			if (tempLongest2.length() > longest.length()) {
				longest = tempLongest2;
			}
		}
		return longest;
	}

	// Given a center letter or two (when one letter, center1 = center2),
	public static String getLongestFromCenter(String s, int center1, int center2) {

		while (center1 >= 0 && center2 < s.length() && s.charAt(center1) == s.charAt(center2)) {
			center1--;
			center2++;
		}
		return s.substring(center1 + 1, center2);
	}
}
