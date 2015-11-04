package StringProblems;
/* Given a string, permute all the combinations of the characters from the string. 
 * Assuming there is no duplicated characters in the string. */

public class StringPermutationWithoutDuplicateChars {

	public static void main(String args[]) {
		permutateStringRecursively("", "ABCD");

	}

	// Set prefix as "" as the beginning
	public static void permutateStringRecursively(String prefix, String sample) {

		int length = sample.length();
		if (length == 0) {
			System.out.println(prefix);
		} 
		else {
			for (int i = 0; i < length; i++) {
				// append every single char from sample to current prefix as the
				// new prefix
				permutateStringRecursively(prefix + sample.charAt(i),
						sample.substring(0, i) + sample.substring(i + 1, length));
			}
		}
	}
	
	//TO-DO: None-recursive method
}
