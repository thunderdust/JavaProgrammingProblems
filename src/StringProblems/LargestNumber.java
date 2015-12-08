package StringProblems;

import java.util.Arrays;
import java.util.Comparator;

/* Given a list of non negative integers, arrange them such that they form 
 * the largest number. For example, given [3, 30, 34, 5, 9], the largest 
 * formed number is 9534330. Note: The result may be very large, so you 
 * need to return a string instead of an integer. */

public class LargestNumber {

	public static void main(String args[]) {

		int[] test = { 3, 30, 34, 5, 9 };
		System.out.println(getLargestNum(test));
	}

	public static String getLargestNum(int[] nums) {

		// Load nums as strings
		String[] strs = new String[nums.length];
		for (int i = 0; i < nums.length; i++) {
			strs[i] = String.valueOf(nums[i]);
		}
        
		// sort by first number, reversely (decreasing)
		Arrays.sort(strs, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				String combine1 = s1+s2;
				String combine2 = s2+s1;
				return -combine1.compareTo(combine2);
			}
		});
		
		StringBuilder sb = new StringBuilder();
		for (String s: strs){
			sb.append(s);
		}
		// remove leading 0s
		while (sb.charAt(0)=='0' && sb.length()>1){
			sb.deleteCharAt(0);
		}
		return sb.toString();

	}
}
