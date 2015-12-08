package ArrayProlems;

import java.util.ArrayList;
import java.util.HashMap;

public class IdenticalPairs {

	public int solution(int[] A) {
		// write your code in Java SE 8
		HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
		int count = 0;
		for (int i = 0; i < A.length; i++) {
			int current = A[i];
			// New value
			if (map.get(current) == null) {
				ArrayList<Integer> list = new ArrayList<Integer>();
				list.add(i);
				map.put(current, list);
			} else {
				ArrayList<Integer> list = map.get(current);
				count += list.size();
				list.add(i);
				map.put(current, list);
			}
		}
		if (count>1000000000){
			return 1000000000;
		}
		else {
			return count;
		}

	}

}
