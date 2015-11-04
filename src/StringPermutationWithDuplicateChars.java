import java.util.HashSet;

/* Given a string, permute all the combinations of the characters from the string. 
 * It's possible to have repetitive characters in the string, for example: "AAC" */


public class StringPermutationWithDuplicateChars {
	
	public static void main(String args[]) {
		
		permute("", " ");
		System.out.println("_____________________________________");
		
		permute("", "A");
		System.out.println("_____________________________________");
		
		permute("", "AAA");
		System.out.println("_____________________________________");
		
		permute("", "ABC");
		System.out.println("_____________________________________");
		
		permute("", "ABB");
		System.out.println("_____________________________________");
		
		permute("", "here");
		System.out.println("_____________________________________");
	}
	
	public static void permute(String prefix, String sample){
		
		int length = sample.length();
		if (length == 0){
			System.out.println(prefix);
		}
		else {
			HashSet<Character> charSet = new HashSet<Character>();
			for (int i=0; i<sample.length(); i++){
				if (charSet.contains(sample.charAt(i))){
					continue;
				}
				else {
					charSet.add(sample.charAt(i));
					permute(prefix+sample.charAt(i), sample.substring(0, i)+sample.substring(i+1, sample.length()));
				}
				
			}
		}
	}
}
