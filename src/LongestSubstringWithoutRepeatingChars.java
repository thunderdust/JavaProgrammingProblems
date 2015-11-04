import java.util.HashMap;
import java.util.Map;

/* Given a string, return its longest substring whose characters are all unique */

public class LongestSubstringWithoutRepeatingChars {

	public static void main(String args[]) {
		System.out.println(getLongestSubstringWithoutRepeatingChars(" ")+"|");
		System.out.println(getLongestSubstringWithoutRepeatingChars("a12345a1234c"));
		System.out.println(getLongestSubstringWithoutRepeatingChars("abcadeftgh"));
		System.out.println(getLongestSubstringWithoutRepeatingChars("pineapple"));
	}
	
    // O(n)
	public static String getLongestSubstringWithoutRepeatingChars(String sample) {

		if (sample.length() == 0 || sample.length() == 1) {
			return sample;
		} 
		
		else {
			Map<Character, Integer> charPositionMap = new HashMap<Character, Integer>();
			int maxLength = 0;
			int leftPtr = 0;
			String currentLongestSubStr = sample.substring(0, 1);
			int rightPtr = 0;	
			while (rightPtr < sample.length()){
				
				char currentChar = sample.charAt(rightPtr);
				if (charPositionMap.containsKey(currentChar)){
					leftPtr = Math.max(leftPtr, charPositionMap.get(currentChar)+1);
				}
				charPositionMap.put(currentChar, rightPtr);
				if (maxLength < rightPtr-leftPtr){
					maxLength = rightPtr-leftPtr;
					currentLongestSubStr = sample.substring(leftPtr, rightPtr+1);
				}
				rightPtr++;
			}
			return currentLongestSubStr;
		}
	}
}
