package ArrayProlems;

import java.util.ArrayList;

/* Given a set of non-overlapping & sorted intervals, insert a new interval 
 * into the intervals (merge if necessary).
 * Example 1: Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].
 * Example 2: Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as 
 * [1,2],[3,10],[12,16].
 * This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10]. */

public class InsertInterval {

	class Interval {
		int start;
		int end;

		Interval() {
			start = 0;
			end = 0;
		}

		Interval(int a, int b) {
			start = a;
			end = b;
		}
	}

	public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {

		ArrayList<Interval> result = new ArrayList<Interval>();
		for (Interval interval : intervals) {
			// No overlapping, new interval after current
			if (interval.end < newInterval.start) {
				result.add(interval);
			}
			// No overlapping, new interval before current
			else if (interval.start > newInterval.end) {
				result.add(newInterval);
				newInterval = interval;
			}
			// Overlapping
			else if (interval.end >= newInterval.start || interval.start <= newInterval.end) {
				// merge
				newInterval = new Interval(Math.min(interval.start, newInterval.start),
						Math.max(interval.end, newInterval.end));
			}
		}
		result.add(newInterval);
		return result;
	}
}
