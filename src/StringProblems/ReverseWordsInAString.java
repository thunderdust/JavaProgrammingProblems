package StringProblems;

public class ReverseWordsInAString {

	public static void main(String args[]) {

		String test = " a";
		System.out.println(test + " gets reversed is :" + getReversed(test) + "|");

	}

	public static String getReversed(String s) {
		if (s == null || s.length() == 0)
			return s;
		s.trim();
		String[] words = s.split(" ");
		//System.out.println(words.length);

		StringBuilder sb = new StringBuilder();
		for (int i = words.length - 1; i >= 0; i--) {
			//System.out.println("|" + words[i] + "|");
			if (!words[i].isEmpty()) {
				sb.append(words[i]);
				if (i > 0) {
					sb.append(" ");
				}
			}
		}
		return sb.length() == 0 ? "" : sb.toString().trim();
	}
}
