package StringProblems;

/* Insert c; Delete c; Swap c d */
public class StringTransformation {

	public static void main(String args[]) {

		String S = "apples";
		String T = "apple";
		String result = solution(S, T);
		System.out.println("Result: " + result);
	}

	public static String solution(String S, String T) {

		if (S.length() == 0 && T.length() > 1) {
			return "IMPOSSIBLE";
		}
		if (T.length() == 0 && S.length() > 1) {
			return "IMPOSSIBLE";
		}

		if (S.compareTo(T) == 0) {
			return "NOTHING";
		}
		// Insertion
		if (T.length() - S.length() == 1) {
			for (int i = 0; i < T.length(); i++) {
				String T1 = T.substring(0, i);
				String T2 = T.substring(i + 1, T.length());
				String newT = T1 + T2;
				// System.out.println(newT);
				if (newT.compareTo(S) == 0) {
					char insertion = T.charAt(i);
					// System.out.println(insertion);
					return "INSERT " + insertion;
				}
			}
		}
		// Deletion
		if (S.length() - T.length() == 1) {
			for (int i = 0; i < S.length(); i++) {
				String S1 = S.substring(0, i);
				String S2 = S.substring(i + 1, S.length());
				String newS = S1 + S2;
				// System.out.println(newT);
				if (newS.compareTo(T) == 0) {
					char deletion = S.charAt(i);
					// System.out.println(insertion);
					return "DELETE " + deletion;
				}
			}
		}
		// Swap
		if (S.length() == T.length()) {
			for (int i = 0; i < S.length() - 1; i++) {
				char swap1 = S.charAt(i);
				char swap2 = S.charAt(i + 1);
				String part1 = S.substring(0, i);
				String part2 = S.substring(i + 2, S.length());
				String newS = part1 + swap2 + swap1 + part2;
				if (newS.compareTo(T) == 0) {
					return "SWAP " + swap1 + " " + swap2;

				}
			}
		}
		
		return "IMPOSSIBLE";
	}

}
