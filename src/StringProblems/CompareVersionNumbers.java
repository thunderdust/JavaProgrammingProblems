package StringProblems;

/* Compare two version numbers version1 and version2. If version1 > version2 return 1,
 *  if version1 < version2 return -1, otherwise return 0. You may assume that the version
 *  strings are non-empty and contain only digits and the . character. The . character 
 *  does not represent a decimal point and is used to separate number sequences. Here is 
 *  an example of version numbers ordering:
 *  0.1 < 1.1 < 1.2 < 13.37 
 *  Note there can be more than one . for example 1.2.24*/

public class CompareVersionNumbers {

	public static void main(String args[]) {
		String version1 = "1.2.3.4";
		String version2 = "1.2.3.5";
		int result = compareVersion(version1, version2);
		System.out.println("RESULT: " + result);

	}

	public static int compareVersion(String version1, String version2) {

		/* Notice how to split . by using DOUBLE BACKSLASH */
		String[] arr1 = version1.split("\\.");
		String[] arr2 = version2.split("\\.");
		int i = 0;
		while (i < arr1.length || i < arr2.length) {
			System.out.println("arr1: " + arr1[i]);
			System.out.println("arr2: " + arr2[i]);
			if (i < arr1.length && i < arr2.length) {
				if (Integer.parseInt(arr1[i]) < Integer.parseInt(arr2[i])) {
					return -1;
				} else if (Integer.parseInt(arr1[i]) > Integer.parseInt(arr2[i])) {
					return 1;
				}
			} else if (i < arr1.length) {
				if (Integer.parseInt(arr1[i]) != 0) {
					return 1;
				}
			} else if (i < arr2.length) {
				if (Integer.parseInt(arr2[i]) != 0) {
					return -1;
				}
			}
			i++;
		}
		return 0;
	}
}
