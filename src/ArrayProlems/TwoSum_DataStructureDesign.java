package ArrayProlems;

import java.util.HashMap;

/* Design and implement a TwoSum class. It should support the following operations: 
 * add and find.
 * add - Add the number to an internal data structure.
 * find - Find if there exists any pair of numbers which sum is equal to the value.
 * For example,
 * add(1); add(3); add(5);
 * find(4) -> true
 * find(7) -> false */

public class TwoSum_DataStructureDesign {

	public class TwoSum {
		private HashMap<Integer, Integer> elements = new HashMap<Integer, Integer>();

		public void add(int a) {
			if (elements.containsKey(a)) {
				elements.put(a, elements.get(a) + 1);
			} else {
				elements.put(a, 1);
			}
		}

		public boolean find(int target) {
			for (Integer i : elements.keySet()) {
				int possibleValue = target - i;
				if (elements.containsKey(possibleValue)) {
					// for example 2+2=4, must ensure there are two 2s
					if (i == possibleValue && elements.get(possibleValue) < 2) {
						continue;
					}
					return true;
				}
			}
			return false;
		}
	}
}
