package ArrayProlems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* Given a collection of intervals, merge all overlapping intervals.
 * For example, Given [1,3],[2,6],[8,10],[15,18], 
 * return [1,6],[8,10],[15,18]. */

public class MergeIntervals {

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

	// Define comparator by comparing interval start index
	class IntervalComparator implements Comparator<Interval> {
		@Override
		public int compare(Interval i1, Interval i2) {
			return i1.start - i2.start;
		}
	}

	public List<Interval> merge(List<Interval> intervals) {
		if (intervals == null || intervals.size() <= 1)
			return intervals;
		// sort intervals by self-defined comparator
		Collections.sort(intervals, new IntervalComparator());

		ArrayList<Interval> result = new ArrayList<Interval>();
		Interval prev = intervals.get(0);
		for (int i = 1; i < intervals.size(); i++) {
			Interval current = intervals.get(i);
			if (prev.end >= current.start) {
				// merge
				Interval merged = new Interval(prev.start, Math.max(prev.end, current.end));
				prev = merged;
			} else {
				result.add(prev);
				prev = current;
			}
		}
		result.add(prev);
		return result;
	}
}
