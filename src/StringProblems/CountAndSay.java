package StringProblems;

/* The count-and-say sequence is the sequence of integers beginning as follows:
 * 1, 11, 21, 1211, 111221, ...
 * 1 is read off as "one 1" or 11
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 * Given an integer n, generate the nth sequence.
 * Note: The sequence of integers will be represented as a string. */

public class CountAndSay {

	public static void main(String args[]) {
		
		System.out.println(countAndSay(5));

	}

	public static String countAndSay(int n) {
		if (n <= 0) {
			return null;
		}
		if (n == 1) {
			return "1";
		}
		String result = "1";
		int i = 1;

		while (i < n) {
			StringBuilder sb = new StringBuilder();
			int count = 1;
			for (int j = 1; j < result.length(); j++) {
				// if consecutive same number, keep counting
				if (result.charAt(j) == result.charAt(j - 1)) {
					count++;
				}
				// end of a consecutive series, append the count for that series
				// and restart counter for current new number
				else {
					sb.append(count);
					sb.append(result.charAt(j - 1));
					count = 1;
				}
			}
			// Add the last number
			sb.append(count);
			sb.append(result.charAt(result.length() - 1));
			result = sb.toString();
			i++;
		}
		return result;
	}
}
