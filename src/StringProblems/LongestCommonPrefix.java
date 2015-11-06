package StringProblems;

public class LongestCommonPrefix {

	public static void main(String args[]) {
		String strs[] = { "    ", "abcdefgh", "abdfc", "abcdefg" };
		System.out.println("Longest common prefix: " + getLongestCommonPrefix(strs));
	}

	public static String getLongestCommonPrefix(String[] strs) {

		if (strs == null || strs.length==0) {
			return "";
		}
		if (strs.length == 1) {
			return strs[0];
		}
		int minLength = Integer.MAX_VALUE;
		// Get length of shorted string
		for (String s : strs) {
			if (s.length() < minLength) {
				minLength = s.length();
			}
		}
		if (minLength == 0)
			return "";

		for (int index = 0; index < minLength; index++) {

			char current = ' ';
			for (int i = 0; i < strs.length; i++) {
				if (i == 0) {
					current = strs[i].charAt(index);
					continue;
				}
				if (strs[i].charAt(index) != current) {
					return strs[i].substring(0, index);
				}
			}
		}
		return strs[0].substring(0, minLength);
	}
}
