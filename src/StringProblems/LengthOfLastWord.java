package StringProblems;

/* Given a string s consists of upper/lower-case alphabets and empty space characters ' ', 
 * return the length of last word in the string. If the last word does not exist, return 0.
 * Note: A word is defined as a character sequence consists of non-space characters only.
 * For example, Given s = "Hello World", return 5. */

public class LengthOfLastWord {

	public static void main(String args[]) {
		String test = "Hello world ";
		System.out.println("Length of last word in " + test + " is: " + getLastWordLength(test));
	}

	public static int getLastWordLength(String s) {
		if (s == null || s.length() == 0)
			return 0;

		int length = s.length();
		int index = length - 1;
		int count = 0;
		boolean wordStarted = false;

		while (index >= 0) {
			char currentChar = s.charAt(index);
			// current char is a letter
			if (currentChar >= 'a' && currentChar <= 'z' || currentChar >= 'A' && currentChar <= 'Z') {
				wordStarted = true;
				count++;
			}
			// current char is not a letter - can be end of the last word
			else {
				if (wordStarted) {
					return count;
				}
			}
			index--;
		}
		return count;
	}
}
