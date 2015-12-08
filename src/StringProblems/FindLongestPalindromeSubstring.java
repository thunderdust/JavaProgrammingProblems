package StringProblems;
/* Given a string, return the longest substring of it which is palindrome. */

public class FindLongestPalindromeSubstring {

	public static void main(String args[]) {
		
		System.out.println(longestPalindromeString("1234"));
        System.out.println(longestPalindromeString("12321"));
        System.out.println(longestPalindromeString("9912321456"));
        System.out.println(longestPalindromeString("9912333321456"));
        System.out.println(longestPalindromeString("12145445499"));
        System.out.println(longestPalindromeString("1223213"));
        System.out.println(longestPalindromeString("abb"));
        System.out.print(longestPalindromeString("     "));System.out.print("|");
	}

	public static String longestPalindromeString(String sample) {
		
		if (sample.length()==0 || sample.length()==1 || sample.trim().length()==0){
			//System.out.println("Direct return");
			return sample;
		}
		
		String longestPalindrome = "";
		for (int i=0; i< sample.length();i++){
			String intermediateLongest = "";
			// odd case
		    intermediateLongest = getLongestPalindrome(sample,i, i);
			if (intermediateLongest.length()>longestPalindrome.length()){
				longestPalindrome = intermediateLongest;
			}
			// even case
			intermediateLongest = getLongestPalindrome(sample,i, i+1);
			if (intermediateLongest.length()>longestPalindrome.length()){
				longestPalindrome = intermediateLongest;
			}
		}
		return longestPalindrome;
	}

	public static String getLongestPalindrome(String sample, int leftStart, int rightStart) {

		if (leftStart > rightStart) {
			return null;
		} else {
			while (leftStart >= 0 && rightStart < sample.length()
					&& sample.charAt(leftStart) == sample.charAt(rightStart)) {
				leftStart--;
				rightStart++;
			}
			// after while loop the two index are for substring which is NOT palindrome anymore.
			// So 1 place back from this is the longest palindrome indexes. 
			return sample.substring(leftStart+1, rightStart);
		}
	}
}
