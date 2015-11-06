package StringProblems;

/* The function first discards as many whitespace characters as necessary
 * until the first non-whitespace character is found. Then, starting from 
 * this character, takes an optional initial plus or minus sign followed 
 * by as many numerical digits as possible, and interprets them as a numerical 
 * value.
 * The string can contain additional characters after those that form the integral
 * number, which are ignored and have no effect on the behavior of this function.
 * If the first sequence of non-whitespace characters in str is not a valid
 * integral number, or if no such sequence exists because either str is empty 
 * or it contains only whitespace characters, no conversion is performed.
 * 
 * If no valid conversion could be performed, a zero value is returned. If 
 * the correct value is out of the range of representable values, 
 * INT_MAX (2147483647) or INT_MIN (-2147483648) is returned.
 * */

public class StringToIntegerProblem {

	public static void main(String args[]) {
		String test;
		test = "+-3";
		System.out.println(test + " converts to integer as: " + myAtoi(test));
		test = "      010";
		System.out.println(test + " converts to integer as: " + myAtoi(test));
		test = "-30000   ";
		System.out.println(test + " converts to integer as: " + myAtoi(test));
		test = "  -0012a42";
		System.out.println(test + " converts to integer as: " + myAtoi(test));
		test = "-2147483648";
		System.out.println(test + " converts to integer as: " + myAtoi(test));
	}

	public static int myAtoi(String str) {

		if (str == null || str.trim().length() == 0) {
			return 0;
		}
		String s = str.trim();
		StringBuilder sb = new StringBuilder();
		int index = 0;
		boolean isNegative = false;
		String current = "";

		if (s.charAt(0) == '+') {
			s = s.substring(1);
		} else if (s.charAt(0) == '-') {
			s = s.substring(1);
			isNegative = true;
		}

		while (index < s.length()) {
			current = s.substring(index, index + 1);
			if (current.matches("^[0-9]$")) {
				sb.append(current);
			} else {
				break;
			}
			index++;
		}
		String result = sb.toString();
		if (result == null || result.isEmpty()) {
			return 0;
		}
		// Build integer
		int length = result.length();
		int number = 0;

		for (int i = length - 1; i >= 0; i--) {
			if (isNegative) {
				number -= Integer.parseInt(String.valueOf(result.charAt(length - i - 1))) * Math.pow(10, i);
			} else {
				number += Integer.parseInt(String.valueOf(result.charAt(length - i - 1))) * Math.pow(10, i);
			}
		}
		System.out.println("number: " + number);
		if (number > Integer.MAX_VALUE) {
			return Integer.MAX_VALUE;
		} else if (number < Integer.MIN_VALUE) {
			return Integer.MIN_VALUE;
		} else {
			return number;
		}
	}
}
