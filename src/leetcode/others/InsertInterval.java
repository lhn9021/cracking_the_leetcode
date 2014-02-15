package leetcode.others;

import java.util.ArrayList;

/*
 * Insert Interval
 * 
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
 * You may assume that the intervals were initially sorted according to their start times.
 * Example 1:
 * Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].
 * Example 2:
 * Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].
 * This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
 * 
 * http://oj.leetcode.com/problems/insert-interval/
 * 
 * Hint: Find the start and end of the new interval,then clear and add the new interval
 */
public class InsertInterval {
	class Interval {
		int start;
		int end;

		Interval() {
			start = 0;
			end = 0;
		}

		Interval(int s, int e) {
			start = s;
			end = e;
		}
	}

	public class Solution {
		public ArrayList<Interval> insert(ArrayList<Interval> intervals,
				Interval newInterval) {
			int s = -1, e = -1; // the start and end index of the intervals to
								// be removed
			// search for overlap intervals
			for (int i = 0; i < intervals.size(); i++) {
				if (intervals.get(i).end >= newInterval.start && s == -1)
					s = i;
				if (intervals.get(i).start <= newInterval.end)
					e = i;
			}
			if (s == -1) {
				intervals.add(newInterval);
				return intervals;
			}
			if (e == -1) {
				intervals.add(0, newInterval);
				return intervals;
			}
			// get the new interval's start and end
			int start = Math.min(newInterval.start, intervals.get(s).start);
			int end = Math.max(newInterval.end, intervals.get(e).end);
			intervals.subList(s, e + 1).clear();
			intervals.add(s, new Interval(start, end));
			return intervals;
		}
	}
}
