package leetcode.stack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Stack;

/*
 * Merge Intervals 
 * 
 * Given a collection of intervals, merge all overlapping intervals.
 * For example,
 * Given [1,3],[2,6],[8,10],[15,18],
 * return [1,6],[8,10],[15,18].
 * 
 * http://oj.leetcode.com/problems/merge-intervals/
 * 
 * Hint: First, sort the interval. If the stack is not able to merge push that into stack, else modify the peek's end
 * 
 */
public class MergeIntervals {
	public class Interval {
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
		public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
			// Note: The Solution object is instantiated only once and is reused
			// by each test case.
			Collections.sort(intervals, new Comparator<Interval>() {
				public int compare(Interval l1, Interval l2) {
					if (l1.start < l2.start)
						return -1;
					else if (l1.start > l2.start)
						return 1;
					else {
						if (l1.end < l2.end)
							return -1;
						else if (l1.end == l2.end)
							return 0;
						else
							return 1;
					}
				}
			});
			Stack<Interval> stack = new Stack<Interval>();
			for (Interval in : intervals) {
				if (stack.isEmpty() || (in.start > stack.peek().end)) {
					stack.push(in);
				} else {
					stack.peek().end = Math.max(stack.peek().end, in.end);
				}
			}
			ArrayList<Interval> res = new ArrayList<Interval>();
			while (!stack.isEmpty()) {
				res.add(0, stack.pop());
			}
			return res;
		}
	}
}
