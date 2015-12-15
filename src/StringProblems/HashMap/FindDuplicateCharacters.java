package StringProblems.HashMap;
/* Description: Enter a string, return with duplicate characters and times of occurrence. */

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FindDuplicateCharacters {

	public static void main (String args[]){
		System.out.println("Please enter a string as sample:");
		Scanner sc = new Scanner(System.in);
		String sample = sc.nextLine();
		printDuplicateChars(sample);
	}

	public static void printDuplicateChars(String sample){
		// Special cases where input is null or empty or blank spaces
		if (sample==null || sample.isEmpty() || sample.length()==1 || sample.trim().isEmpty()){
			return;
		}
		else {
			char[] characters = sample.toCharArray();
			Map<Character, Integer> charMap = new HashMap<Character, Integer>();
			for (Character ch : characters){
				if (charMap.containsKey(ch)) {
				    charMap.put(ch, charMap.get(ch)+1);					
				}
				else {
					charMap.put(ch, 1);
				}
			}
			for (Map.Entry<Character, Integer> entry : charMap.entrySet()) {
				if (entry.getValue()>1){
					System.out.println(entry.getKey() + ": " + entry.getValue());
				}
			}
		}
	}
}